package br.com.letscode.movies_battle.repository;

import br.com.letscode.movies_battle.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository2 extends JpaRepository<User, Long> {
    User getByUsername(String username);
}
