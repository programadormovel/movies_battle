package br.com.letscode.movies_battle.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;

public class FilmeDetalheDto implements Serializable {
    private static final long serialVersionID = 1L;

    private String Title;
    private String Year;
    private String Rated;
    private String Released;
    private String Runtime;
    private String Genre;
    private String Director;
    private String Writer;
    private String Actors;
    private String Plot;
    private String Language;
    private String Country;
    private String Awards;
    private String Poster;
    private ArrayList<RatingDto> Ratings;
    private String Metascore;
    private String imdbRating;
    private String imdbVotes;
    private String imdbID;
    private String Type;
    private String DVD;
    private String BoxOffice;
    private String Production;
    private String Website;
    private String Response;

    public FilmeDetalheDto() {
    }

    public FilmeDetalheDto(@JsonProperty("Title") String title,
                           @JsonProperty("Year") String year,
                           @JsonProperty("Rated") String rated,
                           @JsonProperty("Released") String released,
                           @JsonProperty("Runtime") String runtime,
                           @JsonProperty("Genre") String genre,
                           @JsonProperty("Director") String director,
                           @JsonProperty("Writer") String writer,
                           @JsonProperty("Actors") String actors,
                           @JsonProperty("Plot") String plot,
                           @JsonProperty("Language") String language,
                           @JsonProperty("Country") String country,
                           @JsonProperty("Awards") String awards,
                           @JsonProperty("Poster") String poster,
                           @JsonProperty("Ratings") ArrayList<RatingDto> ratings,
                           @JsonProperty("Metascore") String metascore,
                           @JsonProperty("imdbRating") String imdbRating,
                           @JsonProperty("imdbVotes") String imdbVotes,
                           @JsonProperty("imdbID") String imdbID,
                           @JsonProperty("Type") String type,
                           @JsonProperty("DVD") String DVD,
                           @JsonProperty("BoxOffice") String boxOffice,
                           @JsonProperty("Production") String production,
                           @JsonProperty("Website") String website,
                           @JsonProperty("Response") String response) {
        Title = title;
        Year = year;
        Rated = rated;
        Released = released;
        Runtime = runtime;
        Genre = genre;
        Director = director;
        Writer = writer;
        Actors = actors;
        Plot = plot;
        Language = language;
        Country = country;
        Awards = awards;
        Poster = poster;
        Ratings = ratings;
        Metascore = metascore;
        this.imdbRating = imdbRating;
        this.imdbVotes = imdbVotes;
        this.imdbID = imdbID;
        Type = type;
        this.DVD = DVD;
        BoxOffice = boxOffice;
        Production = production;
        Website = website;
        Response = response;
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

    public String getRated() {
        return Rated;
    }

    public void setRated(String rated) {
        Rated = rated;
    }

    public String getReleased() {
        return Released;
    }

    public void setReleased(String released) {
        Released = released;
    }

    public String getRuntime() {
        return Runtime;
    }

    public void setRuntime(String runtime) {
        Runtime = runtime;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public String getWriter() {
        return Writer;
    }

    public void setWriter(String writer) {
        Writer = writer;
    }

    public String getActors() {
        return Actors;
    }

    public void setActors(String actors) {
        Actors = actors;
    }

    public String getPlot() {
        return Plot;
    }

    public void setPlot(String plot) {
        Plot = plot;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getAwards() {
        return Awards;
    }

    public void setAwards(String awards) {
        Awards = awards;
    }

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String poster) {
        Poster = poster;
    }

    public ArrayList<RatingDto> getRatings() {
        return Ratings;
    }

    public void setRatings(ArrayList<RatingDto> ratings) {
        Ratings = ratings;
    }

    public String getMetascore() {
        return Metascore;
    }

    public void setMetascore(String metascore) {
        Metascore = metascore;
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

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getDVD() {
        return DVD;
    }

    public void setDVD(String DVD) {
        this.DVD = DVD;
    }

    public String getBoxOffice() {
        return BoxOffice;
    }

    public void setBoxOffice(String boxOffice) {
        BoxOffice = boxOffice;
    }

    public String getProduction() {
        return Production;
    }

    public void setProduction(String production) {
        Production = production;
    }

    public String getWebsite() {
        return Website;
    }

    public void setWebsite(String website) {
        Website = website;
    }

    public String getResponse() {
        return Response;
    }

    public void setResponse(String response) {
        Response = response;
    }
}
