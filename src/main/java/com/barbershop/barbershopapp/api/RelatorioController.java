package com.trimtime.app.controller;

import com.trimtime.app.domain.RelatorioColaborador;
import com.trimtime.app.service.RelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RelatorioController {

    @Autowired
    private RelatorioService relatorioService;

    // Endpoint para obter relatórios de todos os barbeiros do dia atual
    @GetMapping("/admin/relatorios")
    public List<RelatorioColaborador> getRelatorios(@RequestParam double porcentagemDesconto) {
        return relatorioService.gerarRelatorioDoDia(porcentagemDesconto);
    }

    // Endpoint para obter o relatório de um barbeiro específico
    @GetMapping("/admin/relatorio")
    public RelatorioColaborador getRelatorio(@RequestParam String barbeiroNome, @RequestParam double porcentagemDesconto) {
        return relatorioService.gerarRelatorioColaborador(barbeiroNome, porcentagemDesconto);
    }
}
