package br.com.letscode.movies_battle.controller;

import br.com.letscode.movies_battle.model.*;
import br.com.letscode.movies_battle.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Controller
public class PartidaController {

    double errosJogador = 0;
    double pontuacao = 0;
    int primeiraJogada = 0;
    double acertos = 0;
    double contador = 0;
    int logout = 0;

    Filme filme1;
    Filme filme2;
    List<Filme> listaAnterior1;
    List<Filme> listaAnterior2;
    Partida partidaModel;
    Jogada jogada;
    List<Partida> partidasJogadas;
    List<Jogada> jogadasRealizadas;

    @Autowired
    FilmeService filmeService;
    @Autowired
    PartidaService partidaService;
    @Autowired
    JogadaService jogadaService;
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String login() {
        logout = 0;
        return "login";
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/admin")
    public String admin() {
        return "admin";
    }

    @RequestMapping("/ranking")
    public String ranking(Model model) {

        model.addAttribute("partidas", partidaService.pesquisarPartidas());

        return "ranking";
    }

    @RequestMapping("/resultadoFinal")
    public String resultadoFinal(Model model) {
        model.addAttribute("pontuacao", new DecimalFormat("######.##").format(pontuacao));

        errosJogador = 0;
        pontuacao = 0;
        acertos = 0;
        pontuacao = 0;
        contador = 0;
        primeiraJogada = 0;

        return "resultadoFinal";
    }

    @RequestMapping("/partida")
    public String partida(Model model) {
        if(logout==1) return "redirect:/logout";

        long f1 = (long) Math.ceil(Math.random() * 10);
        filme1 = filmeService.pesquisarFilme(f1);

        long f2 = (long) Math.ceil(Math.random() * 10);
        filme2 = filmeService.pesquisarFilme(f2);

        if(!filme1.equals(filme2)){
            List<Filme> filmes = List.of(new Filme[]{filme1, filme2});

            if (primeiraJogada == 0) {
                listaAnterior1 = List.of(new Filme[]{filme1, filme2});
                listaAnterior2 = List.of(new Filme[]{filme2, filme1});
                primeiraJogada++;
                model.addAttribute("filmes", filmes);
                // Gravar partida deste usuário
                long idContaLogada = userService
                        .getByUsername(SecurityContextHolder
                                .getContext().getAuthentication().getName()).getId();
                String contaLogada = userService
                        .getByUsername(SecurityContextHolder
                                .getContext().getAuthentication().getName()).getUsername();
                System.out.println(idContaLogada);
                System.out.println(contaLogada);
                partidaModel = new Partida();
                partidaModel.setPontuacao(0.0);
                partidaModel.setDataPartida(LocalDate.now(ZoneId.of("UTC")));
                partidaModel.setUsuario(new User(idContaLogada, contaLogada));
                partidaService.save(partidaModel);

            } else {
                if (!listaAnterior1.equals(filmes) && !listaAnterior2.equals(filmes) && !filme1.equals(filme2)) {
                    listaAnterior1 = List.of(new Filme[]{filme1, filme2});
                    listaAnterior2 = List.of(new Filme[]{filme2, filme1});
                    model.addAttribute("filmes", filmes);
                } else {
                    partida(model);
                }
            }
        }else {
            partida(model);
        }

        return "partida";
    }

    @RequestMapping(value = "/resultado/{id}", method = RequestMethod.GET)
    public String resultado(@PathVariable("id") Long id,
                            Model model) {
        contador++;
        if (Double.parseDouble(filme1.getImdbRating()) > Double.parseDouble(filme2.getImdbRating())) {
            model.addAttribute("filmePopular", filmeService.pesquisarFilme(filme1.getId()));
            if (filme1.getId() != id) {
                errosJogador++;
            } else {
                acertos++;
                jogada = new Jogada(Math.round(contador),true, partidaModel, filme1, filme2);
                if (partidaModel != null)
                    jogadaService.save(jogada);
            }
        } else if (Double.parseDouble(filme1.getImdbRating()) < Double.parseDouble(filme2.getImdbRating())) {
            model.addAttribute("filmePopular", filmeService.pesquisarFilme(filme2.getId()));
            if (filme2.getId() != id) {
                errosJogador++;
            } else {
                acertos++;
                jogada = new Jogada(Math.round(contador),true, partidaModel, filme1, filme2);
                if (partidaModel != null)
                    jogadaService.save(jogada);
            }
        } else {
            model.addAttribute("filmePopular", filmeService.pesquisarFilme(id));
            acertos++;
            jogada = new Jogada(Math.round(contador),true, partidaModel, filme1, filme2);
            if (partidaModel != null)
                jogadaService.save(jogada);
        }

        model.addAttribute("filmeEscolhido", filmeService.pesquisarFilme(id));
        model.addAttribute("pontuacao", acertos);
        model.addAttribute("errosJogador", errosJogador);

        if (errosJogador == 3) {
            //TODO - GRAVAR PONTUAÇÃO DO JOGADOR
            pontuacao = (acertos/contador)*contador;
            partidaModel.setPontuacao(pontuacao);
            partidaService.updatePontuacao(pontuacao, partidaModel.getId());

            logout = 1;
            return "redirect:/resultadoFinal";
        }

        return "resultado";
    }

    @PostMapping("/process")
    public String processForm(@Valid Filme filme, BindingResult result) {
        if (result.hasErrors()) {
            return "partida";
        }
        return "redirect:/";
    }

    @PostMapping("/processarResultado")
    public String resultadoForm(@Valid Filme filme, BindingResult result) {
        if (result.hasErrors()) {
            return "resultado";
        }
        return "redirect:/partida";
    }
}
