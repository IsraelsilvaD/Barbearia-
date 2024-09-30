package com.trimtime.app.service;

import com.trimtime.app.domain.RelatorioColaborador;
import com.trimtime.app.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RelatorioService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    // Método para gerar o relatório de um colaborador específico
    public RelatorioColaborador gerarRelatorioColaborador(String barbeiroNome, double porcentagemDesconto) {
        RelatorioColaborador relatorio = new RelatorioColaborador(barbeiroNome);

        // Filtra os agendamentos do barbeiro para o dia atual
        List<Agendamento> agendamentosHoje = agendamentoRepository.findByBarbeiroNomeAndData(barbeiroNome, LocalDate.now());

        // Calcula o total de agendamentos e cancelamentos
        relatorio.setTotalAgendamentos((int) agendamentosHoje.stream().filter(a -> !a.getStatus().equals("Cancelado")).count());
        relatorio.setTotalCancelados((int) agendamentosHoje.stream().filter(a -> a.getStatus().equals("Cancelado")).count());

        // Calcula o valor bruto somando o valor de todos os agendamentos confirmados
        double valorBruto = agendamentosHoje.stream()
            .filter(a -> !a.getStatus().equals("Cancelado"))
            .mapToDouble(a -> a.getServico().getPreco()) // Supondo que o serviço tem um campo `preco`
            .sum();
        relatorio.setValorBruto(valorBruto);

        // Calcula o valor de desconto (porcentagem)
        double valorDesconto = valorBruto * (porcentagemDesconto / 100);
        relatorio.setDescontos(valorDesconto);

        // Calcula o valor líquido
        relatorio.calcularValorLiquido();

        return relatorio;
    }

    // Método para listar todos os barbeiros para o relatório do dia
    public List<RelatorioColaborador> gerarRelatorioDoDia(double porcentagemDesconto) {
        List<String> barbeiros = agendamentoRepository.findDistinctBarbeiros(); // Método para pegar os barbeiros distintos
        return barbeiros.stream()
            .map(b -> gerarRelatorioColaborador(b, porcentagemDesconto))
            .toList();
    }
}
