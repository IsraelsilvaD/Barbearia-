package com.trimtime.app.repository;

import com.trimtime.app.domain.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    
    // Método para encontrar agendamentos de um barbeiro em um horário específico
    List<Agendamento> findByBarbeiroIdAndDataAgendamento(Long barbeiroId, LocalDateTime dataAgendamento);

    // Método para encontrar agendamentos de um cliente
    List<Agendamento> findByClienteId(Long clienteId);
}
