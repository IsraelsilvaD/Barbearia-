package com.barbershop.barbershopapp.repository;

import com.barbershop.barbershopapp.domain.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    List<Agendamento> findByBarbeiroIdAndDataAgendamento(Long barbeiroId, LocalDateTime dataAgendamento);
}
