package br.com.letscode.movies_battle.repository;

import br.com.letscode.movies_battle.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
}
