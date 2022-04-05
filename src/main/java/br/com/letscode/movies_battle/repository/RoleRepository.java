package br.com.letscode.movies_battle.repository;

import br.com.letscode.movies_battle.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByRole(String role);

}
