package br.com.letscode.movies_battle.service;

import br.com.letscode.movies_battle.model.Partida;
import br.com.letscode.movies_battle.repository.PartidaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PartidaService {

    final PartidaRepository partidaRepository;

    public PartidaService(PartidaRepository partidaRepository) {
        this.partidaRepository = partidaRepository;
    }

    @Transactional
    public Partida save(Partida partida){
        return partidaRepository.save(partida);
    }

    @Transactional
    public List<Partida> saveAll(List<Partida> partidas){
        return partidaRepository.saveAll(partidas);
    }

    public List<Partida> pesquisarPartidas(){
        return partidaRepository.findAll();
    }

    @Transactional
    public Partida insert(Partida partida){
        return partidaRepository.saveAndFlush(partida);
    }

    @Transactional
    public int updatePontuacao(double pontuacao, long id){
        return partidaRepository.updatePontuacao(pontuacao, id);
    }
}
