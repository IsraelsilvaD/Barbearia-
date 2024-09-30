package com.trimtime.app.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

public class Agendamento {
    private Long id;
    private Long clienteId; // Novo campo para associar o cliente
    private Long servicoId; // Novo campo para associar o serviço
    private String profissional; // Nome do profissional
    private LocalDate data;
    private LocalTime horario;
    private String status;

    // Construtor
    public Agendamento(Long clienteId, String profissional, Long servicoId, LocalDate data, LocalTime horario) {
        this.clienteId = clienteId;
        this.servicoId = servicoId;
        this.profissional = profissional;
        this.data = data;
        this.horario = horario;
        this.status = "Pendente"; // Status inicial do agendamento
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getServicoId() {
        return servicoId;
    }

    public void setServicoId(Long servicoId) {
        this.servicoId = servicoId;
    }

    public String getProfissional() {
        return profissional;
    }

    public void setProfissional(String profissional) {
        this.profissional = profissional;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Método para confirmar o agendamento
    public void confirmarAgendamento() {
        this.status = "Confirmado"; // Atualiza o status do agendamento para "Confirmado"
        System.out.println("Agendamento confirmado com o profissional " + profissional
                + " na data " + data + " às " + horario);
    }

    // Método auxiliar para retornar a data e hora completa (caso necessário)
    public LocalDateTime getDataHoraAgendamento() {
        return LocalDateTime.of(data, horario);
    }
}
