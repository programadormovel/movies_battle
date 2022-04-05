package br.com.letscode.movies_battle.controller.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class PartidaDto implements Serializable {
    private static final long serialVersionID = 1L;

    private long id;
    private LocalDate dataPartida;
    private long pontuacao;
    private long usuarioID;

    public PartidaDto() {
    }

    public PartidaDto(LocalDate dataPartida, long pontuacao, long usuarioID) {
        this.dataPartida = dataPartida;
        this.pontuacao = pontuacao;
        this.usuarioID = usuarioID;
    }

    public PartidaDto(LocalDate dataPartida, long usuarioID) {
        this.dataPartida = dataPartida;
        this.usuarioID = usuarioID;
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

    public long getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(long pontuacao) {
        this.pontuacao = pontuacao;
    }

    public long getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(long usuarioID) {
        this.usuarioID = usuarioID;
    }
}
