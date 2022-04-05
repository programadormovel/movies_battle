package br.com.letscode.movies_battle.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="jogada")
public class Jogada {
    @Id
    private long id;

    @Column(name="acertou")
    private boolean acertou;

    @JsonIgnore
    @ManyToOne
    private Partida partida;

    @JsonIgnore
    @ManyToOne
    private Filme filme1;

    @JsonIgnore
    @ManyToOne
    private Filme filme2;

    public Jogada() {
    }

    public Jogada(boolean acertou, Partida partida, Filme filme1, Filme filme2) {
        this.acertou = acertou;
        this.partida = partida;
        this.filme1 = filme1;
        this.filme2 = filme2;
    }

    public Jogada(long id, boolean acertou, Partida partida) {
        this.id = id;
        this.acertou = acertou;
        this.partida = partida;
    }

    public Jogada(long id, boolean acertou, Partida partida, Filme filme1, Filme filme2) {
        this.id = id;
        this.acertou = acertou;
        this.partida = partida;
        this.filme1 = filme1;
        this.filme2 = filme2;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isAcertou() {
        return acertou;
    }

    public void setAcertou(boolean acertou) {
        this.acertou = acertou;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    public Filme getFilme1() {
        return filme1;
    }

    public void setFilme1(Filme filme1) {
        this.filme1 = filme1;
    }

    public Filme getFilme2() {
        return filme2;
    }

    public void setFilme2(Filme filme2) {
        this.filme2 = filme2;
    }
}
