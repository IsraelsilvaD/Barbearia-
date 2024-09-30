package com.trimtime.app.domain;

import java.time.LocalDate;
import java.util.List;

public class RelatorioColaborador {
    private String barbeiroNome;
    private LocalDate dataAtual;
    private int totalAgendamentos;
    private int totalCancelados;
    private double valorBruto;
    private double descontos;
    private double valorLiquido;

    // Construtor
    public RelatorioColaborador(String barbeiroNome) {
        this.barbeiroNome = barbeiroNome;
        this.dataAtual = LocalDate.now(); // Data atual é gerada automaticamente
    }

    // Getters e Setters
    public String getBarbeiroNome() {
        return barbeiroNome;
    }

    public void setBarbeiroNome(String barbeiroNome) {
        this.barbeiroNome = barbeiroNome;
    }

    public LocalDate getDataAtual() {
        return dataAtual;
    }

    public void setDataAtual(LocalDate dataAtual) {
        this.dataAtual = dataAtual;
    }

    public int getTotalAgendamentos() {
        return totalAgendamentos;
    }

    public void setTotalAgendamentos(int totalAgendamentos) {
        this.totalAgendamentos = totalAgendamentos;
    }

    public int getTotalCancelados() {
        return totalCancelados;
    }

    public void setTotalCancelados(int totalCancelados) {
        this.totalCancelados = totalCancelados;
    }

    public double getValorBruto() {
        return valorBruto;
    }

    public void setValorBruto(double valorBruto) {
        this.valorBruto = valorBruto;
    }

    public double getDescontos() {
        return descontos;
    }

    public void setDescontos(double descontos) {
        this.descontos = descontos;
    }

    public double getValorLiquido() {
        return valorLiquido;
    }

    public void setValorLiquido(double valorLiquido) {
        this.valorLiquido = valorLiquido;
    }

    // Método para calcular o valor líquido
    public void calcularValorLiquido() {
        this.valorLiquido = this.valorBruto - this.descontos;
    }

    @Override
    public String toString() {
        return "Relatório do Barbeiro: " + barbeiroNome + "\n" +
               "Data: " + dataAtual + "\n" +
               "Total de Agendamentos: " + totalAgendamentos + "\n" +
               "Total Cancelados: " + totalCancelados + "\n" +
               "Valor Bruto: R$ " + valorBruto + "\n" +
               "Descontos: R$ " + descontos + "\n" +
               "Valor Líquido: R$ " + valorLiquido + "\n";
    }
}
