package br.com.letscode.movies_battle.service;

import br.com.letscode.movies_battle.model.Filme;
import br.com.letscode.movies_battle.repository.FilmeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FilmeService {

    final FilmeRepository filmeRepository;

    public FilmeService(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    @Transactional
    public Filme save(Filme filme){
        return filmeRepository.save(filme);
    }

    @Transactional
    public List<Filme> saveAll(List<Filme> lista){
        return filmeRepository.saveAll(lista);
    }

    public List<Filme> pesquisarFilmes(){
        return filmeRepository.findAll();
    }
    public Filme pesquisarFilme(long id) {
        return filmeRepository.getById(id);
    }
}
