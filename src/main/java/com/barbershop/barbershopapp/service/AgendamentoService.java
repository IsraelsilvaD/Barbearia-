package com.barbershop.barbershopapp.service;

import com.barbershop.barbershopapp.domain.Agendamento;
import com.barbershop.barbershopapp.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    // Método para verificar se o horário está disponível
    public boolean isHorarioDisponivel(Long barbeiroId, LocalDateTime dataAgendamento) {
        List<Agendamento> agendamentos = agendamentoRepository.findByBarbeiroIdAndDataAgendamento(barbeiroId, dataAgendamento);
        return agendamentos.isEmpty(); // Retorna true se não houver agendamento para o horário
    }

    // Método para salvar o agendamento
    public Agendamento salvarAgendamento(Long clienteId, Long barbeiroId, LocalDateTime dataAgendamento, Long servicoId) {
        if (isHorarioDisponivel(barbeiroId, dataAgendamento)) {
            Agendamento agendamento = new Agendamento(clienteId, barbeiroId, dataAgendamento, servicoId);
            return agendamentoRepository.save(agendamento);
        } else {
            throw new RuntimeException("Horário não disponível");
        }
    }
}
