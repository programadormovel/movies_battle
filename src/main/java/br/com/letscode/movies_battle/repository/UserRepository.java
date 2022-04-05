package br.com.letscode.movies_battle.repository;

import br.com.letscode.movies_battle.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <User, Long> {
    User findByUsername(String username);

}
