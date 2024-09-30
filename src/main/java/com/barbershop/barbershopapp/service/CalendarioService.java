package com.trimtime.app.service;

import com.trimtime.app.repository.BarbeiroDiasOffRepository;
import com.trimtime.app.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CalendarioService {

    @Autowired
    private BarbeiroDiasOffRepository barbeiroDiasOffRepository;

    // Método para verificar os dias off e bloquear no calendário do cliente
    public List<LocalDate> getDiasOff(Long barbeiroId) {
        return barbeiroDiasOffRepository.findByBarbeiroId(barbeiroId)
            .stream()
            .map(BarbeiroDiasOff::getDiaOff)
            .toList();
    }
}
