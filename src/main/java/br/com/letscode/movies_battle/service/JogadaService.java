package br.com.letscode.movies_battle.service;

import br.com.letscode.movies_battle.model.Jogada;
import br.com.letscode.movies_battle.repository.JogadaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JogadaService {

    final JogadaRepository jogadaRepository;

    public JogadaService(JogadaRepository jogadaRepository) {
        this.jogadaRepository = jogadaRepository;
    }

    @Transactional
    public Jogada save(Jogada jogada){
        return jogadaRepository.save(jogada);
    }

    @Transactional
    public List<Jogada> saveAll(List<Jogada> jogadas){
        return jogadaRepository.saveAll(jogadas);
    }

    public List<Jogada> pesquisarJogadas(){
        return jogadaRepository.findAll();
    }
}
