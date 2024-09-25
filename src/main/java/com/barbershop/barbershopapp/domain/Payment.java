package com.barbershop.barbershopapp.domain;

public class Payment {
    private Double valorServico;
    private Double comissao;
    private Double saldoBarbearia;

    public Payment(Double valorServico, Double comissao, Double saldoBarbearia) {
        this.valorServico = valorServico;
        this.comissao = comissao;
        this.saldoBarbearia = saldoBarbearia;
    }
    // Método para caucular o valor da comissão do colaborador
    public Double calcularComissao() {
        return valorServico * (comissao / 100);
    }

    //Método para confirmar o pagamento e adicionar o saldo à barbearia
    public void confirmarPagamento() {
        Double comissaoColabirador = calcularComissao();
        Double valorFinalBarbearia = valorServico - comissaoColabirador; // Valor qye vai para a barbearia

        //Adiciona o valor final ao saldo da barbearia
        this.saldoBarbearia += valorFinalBarbearia;

        System.out.println("Pagamento confirmado");
        System.out.println("Comissão do colaborador: R$ " + comissaoColabirador);
        System.out.println("Valor adicionado ao saldo da barbearia: R$ " + valorFinalBarbearia);
        System.out.println("Saldo total da barbearia: R$" + this.saldoBarbearia);
    }

    // Getters e Setters
    public Double getValorServico() {
        return valorServico;
    }

    public void setValorServico(Double valorServico) {
        this.valorServico = valorServico;
    }

    public Double getComissao() {
        return comissao;
    }
    public void setComissao(Double comissao) {
        this.comissao = comissao;
    }

    public Double getSaldoBarbearia() {
        return saldoBarbearia;
    }

    public void setSaldoBarbearia(Double saldoBarbearia) {
        this.saldoBarbearia = saldoBarbearia;
    }
}

