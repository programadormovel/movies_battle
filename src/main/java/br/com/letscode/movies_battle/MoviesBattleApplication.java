package br.com.letscode.movies_battle;

import br.com.letscode.movies_battle.controller.FilmeController;
import br.com.letscode.movies_battle.service.FilmeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MoviesBattleApplication {

    public MoviesBattleApplication(FilmeController filmeController,
                                   FilmeService filmeService) {
        try {
            filmeService.saveAll(filmeController.carregarFilmes());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(MoviesBattleApplication.class, args);
    }

}
