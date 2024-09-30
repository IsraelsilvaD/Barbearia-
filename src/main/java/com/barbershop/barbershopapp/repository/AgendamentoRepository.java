package com.trimtime.app.repository;

import com.trimtime.app.domain.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    // Método para pegar agendamentos de um barbeiro em uma data específica
    List<Agendamento> findByBarbeiroNomeAndData(String barbeiroNome, LocalDate data);

    // Método para pegar todos os barbeiros distintos (nomes)
    List<String> findDistinctBarbeiros();

    // Método para encontrar agendamentos de um barbeiro em um horário específico
    List<Agendamento> findByBarbeiroIdAndDataAgendamento(Long barbeiroId, LocalDateTime dataAgendamento);

    // Método para encontrar agendamentos de um cliente
    List<Agendamento> findByClienteId(Long clienteId);
}
