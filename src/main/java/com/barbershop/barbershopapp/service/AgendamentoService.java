package com.trimtime.app.service;

import com.trimtime.app.domain.Agendamento;
import com.trimtime.app.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    // Método para verificar se o horário está disponível para um barbeiro específico
    public boolean isHorarioDisponivel(Long barbeiroId, LocalDateTime dataAgendamento) {
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
}
