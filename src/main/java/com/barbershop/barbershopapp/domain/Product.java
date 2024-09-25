package com.barbershop.barbershopapp.domain;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class Product {

    private ProductType productType;

    public String getName() {
        return productType.getName();
    }

    public double getPrice() {
        return productType.getPrice();
    }

}
