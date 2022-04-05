package br.com.letscode.movies_battle.repository;

import br.com.letscode.movies_battle.model.Jogada;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogadaRepository extends JpaRepository<Jogada, Long> {
}
