package br.com.letscode.movies_battle;

import br.com.letscode.movies_battle.model.Role;
import br.com.letscode.movies_battle.model.User;
import br.com.letscode.movies_battle.repository.RoleRepository;
import br.com.letscode.movies_battle.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    UserRepository usuarioRepository;
    @Autowired
    RoleRepository permissaoRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        permissaoRepository.save(new Role("USER"));
        permissaoRepository.save(new Role("ADMIN"));

        Role adminPermissao = permissaoRepository.findByRole("ADMIN");
        Role usuarioPermissao = permissaoRepository.findByRole("USER");

        User usuario = new User("admin@letscode.com",
                passwordEncoder.encode("123456"), "Admin", "admin");
        usuario.setRoles(Arrays.asList(adminPermissao));
        usuarioRepository.save(usuario);

        usuario = new User("usuario@letscode.com",
                passwordEncoder.encode("123456"), "User", "user");
        usuario.setRoles(Arrays.asList(usuarioPermissao));
        usuarioRepository.save(usuario);
    }
}
