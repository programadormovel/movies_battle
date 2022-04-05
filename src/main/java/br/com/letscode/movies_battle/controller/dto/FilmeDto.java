package br.com.letscode.movies_battle.controller.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class FilmeDto implements Serializable {
    private static final long serialVersionID = 1L;

    private String imdbID;
    private String Title;
    private String Year;
    private String Type;
    private String Poster;
//    @JsonIgnore
//    private String metascore;
//    @JsonIgnore
//    private String imdbRating;
//    @JsonIgnore
//    private String imdbVotes;

//    @JsonIgnore
//    private List<Jogada> jogadas;

    public FilmeDto() {
    }

    @JsonCreator
    public FilmeDto(@JsonProperty("Title") String Title, @JsonProperty("Year")String Year,
                    @JsonProperty("imdbID")String imdbID, @JsonProperty("Type")String Type,
                    @JsonProperty("Poster")String Poster) {
        this.Title = Title;
        this.Year = Year;
        this.Type = Type;
        this.Poster = Poster;
        this.imdbID = imdbID;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String poster) {
        Poster = poster;
    }

//    public String getMetascore() {
//        return metascore;
//    }
//
//    public void setMetascore(String metascore) {
//        this.metascore = metascore;
//    }
//
//    public String getImdbRating() {
//        return imdbRating;
//    }
//
//    public void setImdbRating(String imdbRating) {
//        this.imdbRating = imdbRating;
//    }
//
//    public String getImdbVotes() {
//        return imdbVotes;
//    }
//
//    public void setImdbVotes(String imdbVotes) {
//        this.imdbVotes = imdbVotes;
//    }
//
//    public List<Jogada> getJogadas() {
//        return jogadas;
//    }
//
//    public void setJogadas(List<Jogada> jogadas) {
//        this.jogadas = jogadas;
//    }
}
