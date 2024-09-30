package com.trimtime.app.service;

import com.trimtime.app.domain.Agendamento;
import com.trimtime.app.domain.BarbeiroDiasOff;
import com.trimtime.app.repository.AgendamentoRepository;
import com.trimtime.app.repository.BarbeiroDiasOffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private BarbeiroDiasOffRepository barbeiroDiasOffRepository;

    // Método para verificar se o horário está disponível para um barbeiro específico
    public boolean isHorarioDisponivel(Long barbeiroId, LocalDateTime dataAgendamento) {
        // Verifica se o dia é "off" para o barbeiro
        if (isDiaOff(barbeiroId, dataAgendamento.toLocalDate())) {
            throw new RuntimeException("Barbeiro está indisponível nessa data");
        }

        // Verifica se já existe um agendamento para o horário específico
        List<Agendamento> agendamentos = agendamentoRepository.findByBarbeiroIdAndDataAgendamento(barbeiroId, dataAgendamento);
        return agendamentos.isEmpty(); // Retorna true se não houver agendamento para o horário
    }

    // Método para salvar o agendamento
    public Agendamento salvarAgendamento(Long clienteId, Long barbeiroId, Long servicoId, LocalDateTime dataAgendamento, String profissional) {
        if (isHorarioDisponivel(barbeiroId, dataAgendamento)) {
            Agendamento agendamento = new Agendamento(clienteId, barbeiroId, profissional, servicoId, dataAgendamento.toLocalDate(), dataAgendamento.toLocalTime());
            return agendamentoRepository.save(agendamento);
        } else {
            throw new RuntimeException("Horário não disponível");
        }
    }

    // Método para listar todos os agendamentos de um cliente
    public List<Agendamento> listarAgendamentosPorCliente(Long clienteId) {
        return agendamentoRepository.findByClienteId(clienteId);
    }

    // Método para listar todos os agendamentos de um colaborador (barbeiro)
    public List<Agendamento> listarAgendamentosPorBarbeiro(String barbeiroNome) {
        return agendamentoRepository.findByBarbeiroNomeAndData(barbeiroNome, LocalDate.now());
    }

    // Método para salvar dias "off" de um colaborador
    public void salvarDiasOff(Long barbeiroId, List<LocalDate> diasOff) {
        // Limpa os dias "off" anteriores do barbeiro
        barbeiroDiasOffRepository.deleteByBarbeiroId(barbeiroId);

        // Adiciona os novos dias "off"
        for (LocalDate diaOff : diasOff) {
            BarbeiroDiasOff barbeiroDiasOff = new BarbeiroDiasOff();
            barbeiroDiasOff.setBarbeiroId(barbeiroId);
            barbeiroDiasOff.setDiaOff(diaOff);
            barbeiroDiasOffRepository.save(barbeiroDiasOff);
        }
    }

    // Método para verificar se o dia é "off" para o barbeiro
    public boolean isDiaOff(Long barbeiroId, LocalDate data) {
        return barbeiroDiasOffRepository.existsByBarbeiroIdAndDiaOff(barbeiroId, data);
    }

    // Método para listar os dias "off" de um barbeiro
    public List<LocalDate> getDiasOff(Long barbeiroId) {
        return barbeiroDiasOffRepository.findByBarbeiroId(barbeiroId)
                .stream()
                .map(BarbeiroDiasOff::getDiaOff)
                .toList();
    }
}

