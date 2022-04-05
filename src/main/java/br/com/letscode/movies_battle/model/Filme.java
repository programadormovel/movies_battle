package br.com.letscode.movies_battle.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "filme")
public class Filme implements Serializable {
    private static final long serialVersionID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "imdbID", unique = true)
    private String imdbID;

    @Column(name = "title")
    private String title;

    @Column(name = "year")
    private String year;

    @Column(name = "type")
    private String type;

    @Column(name = "poster")
    private String poster;

    @Column(name = "metascore")
    private String metascore;

    @Column(name = "imdbRating")
    private String imdbRating;

    @Column(name = "imdbVotes")
    private String imdbVotes;

    @JsonIgnore
    @OneToMany
    private List<Jogada> jogadas;

    public Filme() {
    }

    public Filme(String title, String year, String imdbID, String type, String poster) {
        this.title = title;
        this.year = year;
        this.imdbID = imdbID;
        this.type = type;
        this.poster = poster;

    }

    public Filme(String title, String year, String type, String poster, String metascore, String imdbRating, String imdbVotes, String imdbID) {
        this.title = title;
        this.year = year;
        this.type = type;
        this.poster = poster;
        this.metascore = metascore;
        this.imdbRating = imdbRating;
        this.imdbVotes = imdbVotes;
        this.imdbID = imdbID;
    }

    public Filme(String title, String year, String type, String poster, String metascore, String imdbRating, String imdbVotes, String imdbID, List<Jogada> jogadas) {

        this.title = title;
        this.year = year;
        this.type = type;
        this.poster = poster;
        this.metascore = metascore;
        this.imdbRating = imdbRating;
        this.imdbVotes = imdbVotes;
        this.imdbID = imdbID;
        this.jogadas = jogadas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getMetascore() {
        return metascore;
    }

    public void setMetascore(String metascore) {
        this.metascore = metascore;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getImdbVotes() {
        return imdbVotes;
    }

    public void setImdbVotes(String imdbVotes) {
        this.imdbVotes = imdbVotes;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public List<Jogada> getJogadas() {
        return jogadas;
    }

    public void setJogadas(List<Jogada> jogadas) {
        this.jogadas = jogadas;
    }
}
