package com.trimtime.app.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class BarbeiroDiasOff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "barbeiro_id")
    private Barbeiro barbeiro;

    private LocalDate diaOff;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Barbeiro getBarbeiro() {
        return barbeiro;
    }

    public void setBarbeiro(Barbeiro barbeiro) {
        this.barbeiro = barbeiro;
    }

    public LocalDate getDiaOff() {
        return diaOff;
    }

    public void setDiaOff(LocalDate diaOff) {
        this.diaOff = diaOff;
    }
}
