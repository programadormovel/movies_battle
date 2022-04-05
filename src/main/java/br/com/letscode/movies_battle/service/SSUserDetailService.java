package br.com.letscode.movies_battle.service;

import br.com.letscode.movies_battle.model.Role;
import br.com.letscode.movies_battle.model.User;
import br.com.letscode.movies_battle.repository.RoleRepository;
import br.com.letscode.movies_battle.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Transactional
@Service
public class SSUserDetailService implements UserDetailsService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public SSUserDetailService(UserRepository userRepository, RoleRepository roleRepository){
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User user = userRepository.findByUsername(username);
            if(user == null){
                user = adicionaUsuario(username);
            }
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                    getAuthories(user));        }
        catch (Exception e){
            throw new UsernameNotFoundException("Usuário não encontrado!");
        }
    }

    private Set<GrantedAuthority> getAuthories(User user){
        
        Set<GrantedAuthority> authorities = new HashSet<>();
        for(Role role: user.getRoles()){
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRole());
            authorities.add(grantedAuthority);
        }
        return authorities;
    }

    public User adicionaUsuario(String username){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hasSenha = passwordEncoder.encode("123456");
        User user = new User();
        user.setUsername(username);
        Role userRole = roleRepository.findByRole("USER");
        user.setRoles(Arrays.asList(userRole));
        user.setPassword(hasSenha);
        return userRepository.save(user);
    }
}
