package br.com.letscode.movies_battle.controller.dto;

import br.com.letscode.movies_battle.model.Filme;

import java.io.Serializable;

public class JogadaDto implements Serializable {
    private static final long serialVersionID = 1L;

    private long id;
    private boolean acertou;
    private long partidaID;
    private Filme filme1;
    private Filme filme2;

    public JogadaDto() {
    }

    public JogadaDto(boolean acertou, long partidaID, Filme filme1, Filme filme2) {
        this.acertou = acertou;
        this.partidaID = partidaID;
        this.filme1 = filme1;
        this.filme2 = filme2;
    }

    public JogadaDto(long id, boolean acertou, long partidaID, Filme filme1, Filme filme2) {
        this.id = id;
        this.acertou = acertou;
        this.partidaID = partidaID;
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

    public long getPartidaID() {
        return partidaID;
    }

    public void setPartidaID(long partidaID) {
        this.partidaID = partidaID;
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
