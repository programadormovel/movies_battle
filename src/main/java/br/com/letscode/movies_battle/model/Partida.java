package br.com.letscode.movies_battle.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="partida")
public class Partida {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "dataPartida", nullable = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataPartida;

    @Column(name = "pontuacao", nullable = true)
    private double pontuacao;

    @JsonIgnore
    @ManyToOne
    private User usuario;

    @JsonIgnore
    @OneToMany
    private List<Jogada> jogadas;

    public Partida() {
    }

    public Partida(LocalDate dataPartida, User usuario, List<Jogada> jogadas) {
        this.dataPartida = dataPartida;
        this.usuario = usuario;
        this.jogadas = jogadas;
    }

    public Partida(LocalDate dataPartida, User usuario) {
        this.dataPartida = dataPartida;
        this.usuario = usuario;
    }

    public Partida(long id, LocalDate dataPartida, User usuario) {
        this.id = id;
        this.dataPartida = dataPartida;
        this.usuario = usuario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDataPartida() {
        return dataPartida;
    }

    public void setDataPartida(LocalDate dataPartida) {
        this.dataPartida = dataPartida;
    }

    public double getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(double pontuacao) {
        this.pontuacao = pontuacao;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public List<Jogada> getJogadas() {
        return jogadas;
    }

    public void setJogadas(List<Jogada> jogadas) {
        this.jogadas = jogadas;
    }
}
