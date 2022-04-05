package br.com.letscode.movies_battle.repository;

import br.com.letscode.movies_battle.model.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface PartidaRepository extends JpaRepository<Partida, Long> {

//    @Modifying
//    @Transactional
//    @Query("insert into Partida (data_partida, usuario_id) values (?1,?2)")
//    int insertPartida(LocalDate data_partida, Long usuario_id);

    @Modifying
    @Transactional
    @Query("update Partida p set p.pontuacao = ?1 where p.id = ?2")
    int updatePontuacao(double pontuacao, Long id);
}
