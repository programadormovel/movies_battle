package br.com.letscode.movies_battle.controller.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;

public class BuscaDto implements Serializable {
    private static final long serialVersionID = 1L;

    private ArrayList<FilmeDto> Search;
    private String totalResults;
    private String Response;

    public BuscaDto() {
    }

    @JsonCreator
    public BuscaDto(@JsonProperty("Search") ArrayList<FilmeDto> Search,
                    @JsonProperty("totalResults")String totalResults,
                    @JsonProperty("Response")String Response) {
        this.Search = Search;
        this.totalResults = totalResults;
        this.Response = Response;
    }

    public ArrayList<FilmeDto> getSearch() {
        return Search;
    }

    public void setSearch(ArrayList<FilmeDto> search) {
        Search = search;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public String getResponse() {
        return Response;
    }

    public void setResponse(String response) {
        Response = response;
    }
}
