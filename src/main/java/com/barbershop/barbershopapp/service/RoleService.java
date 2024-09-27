package com.barbershop.barbershopapp.service;

import com.barbershop.barbershopapp.domain.ProductType.Role;

public class RoleService {

    public void executarFuncaoPorRole(Role role) {
        switch (role) {
            case CUSTOMER:
                System.out.println("Acesso para cliente: Visualização de serviços.");
                break;
            case BARBER:
                System.out.println("Acesso para barbeiro: Confirmação de pagamentos.");
                break;
            case BARBERSHOP:
                System.out.println("Acesso completo: Gerenciamento da barbearia.");
                break;
            default:
                System.out.println("Acesso negado.");
        }
    }
}
