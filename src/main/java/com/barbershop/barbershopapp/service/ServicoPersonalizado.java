package com.barbershop.barbershopapp.service;

import com.barbershop.barbershopapp.domain.ProductType;
import java.util.List;

public class ServicoPersonalizado {

    private double valorTotal;

    public ServicoPersonalizado() {
        this.valorTotal = 0.0;
    }

    public void adicionarServico(ProductType servico) {
        valorTotal += servico.getPrice();
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void confirmarServicos(List<ProductType> servicosSelecionados) {
        // Lógica para confirmar e passar para a próxima tela
        System.out.println("Serviços confirmados. Total: R$" + valorTotal);
    }
}
