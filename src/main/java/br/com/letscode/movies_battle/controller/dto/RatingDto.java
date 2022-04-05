package br.com.letscode.movies_battle.controller.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class RatingDto implements Serializable {
    private static final long serialVersionID = 1L;

    private String Source;
    private String Value;

    public RatingDto() {
    }

    @JsonCreator
    public RatingDto(@JsonProperty("Title") String Source,
                     @JsonProperty("Year")String Value) {
        this.Source = Source;
        this.Value = Value;
    }
}
