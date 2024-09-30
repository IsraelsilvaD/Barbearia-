package com.trimtime.app.repository;

import com.trimtime.app.domain.BarbeiroDiasOff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BarbeiroDiasOffRepository extends JpaRepository<BarbeiroDiasOff, Long> {
    // Buscar dias off por barbeiro
    List<BarbeiroDiasOff> findByBarbeiroId(Long barbeiroId);

    // Verificar se o dia é off para o barbeiro
    boolean existsByBarbeiroIdAndDiaOff(Long barbeiroId, LocalDate diaOff);
}
