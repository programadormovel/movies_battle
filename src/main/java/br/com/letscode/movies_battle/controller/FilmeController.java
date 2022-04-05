package br.com.letscode.movies_battle.controller;

import br.com.letscode.movies_battle.controller.dto.BuscaDto;
import br.com.letscode.movies_battle.controller.dto.FilmeDetalheDto;
import br.com.letscode.movies_battle.controller.dto.FilmeDto;
import br.com.letscode.movies_battle.model.Filme;
import br.com.letscode.movies_battle.service.FilmeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FilmeController {

    @Autowired
    FilmeService filmeService;
    private Object body;
    RestTemplate template = new RestTemplate();

    @RequestMapping("/carregar_filmes")
    public List<Filme> carregarFilmes() throws Exception {
        ResponseEntity<BuscaDto> dadosResponse = template.exchange(
                "https://www.omdbapi.com/?apikey=d8a44ab&type=movie&r=json&page=1&s=war",
                HttpMethod.GET, null, new ParameterizedTypeReference<BuscaDto>() {
                });
        BuscaDto obj = dadosResponse.getBody();
        System.out.println(obj);
        System.out.println(obj.getSearch().get(0));
        List<FilmeDto> filmesDtos = obj.getSearch().stream().toList();

        if (ResponseEntity.status(HttpStatus.NO_CONTENT).equals("NO_CONTECT")) {
            ResponseEntity.status(HttpStatus.NO_CONTENT).body("ERRO: Filmes não encontrados");
            return null;
        }
        List<Filme> filmes = new ArrayList<>();
        for (FilmeDto filmeDto : filmesDtos) {
            Filme filme = new Filme();
            BeanUtils.copyProperties(filmeDto, filme);
            // TODO - Buscar dados que faltam
            ResponseEntity<FilmeDetalheDto> dadosResponse1 = template.exchange(
                    "https://www.omdbapi.com/?apikey=d8a44ab&t="+filme.getTitle(),
                    HttpMethod.GET, null, new ParameterizedTypeReference<FilmeDetalheDto>() {
                    });
            FilmeDetalheDto obj2 = dadosResponse1.getBody();
            filme.setImdbRating(obj2.getImdbRating());
            filme.setImdbVotes(obj2.getImdbVotes());
            filme.setMetascore(obj2.getMetascore());
            filmes.add(filme);
        }
        return filmes;
    }


}
