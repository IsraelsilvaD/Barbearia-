package com.trimtime.app.controller;

import com.trimtime.app.domain.Agendamento;
import com.trimtime.app.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    // Endpoint para buscar todos os agendamentos de um cliente
    @GetMapping("/agendamentos")
    public List<Agendamento> getAgendamentosCliente(@RequestParam String clienteEmail) {
        return agendamentoService.getAgendamentosCliente(clienteEmail);
    }

    // Endpoint para popular os agendamentos (para testes)
    @GetMapping("/popularAgendamentos")
    public void popularAgendamentos() {
        agendamentoService.popularAgendamentos();
    }
}
