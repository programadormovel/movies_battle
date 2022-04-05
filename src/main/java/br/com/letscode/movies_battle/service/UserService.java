package br.com.letscode.movies_battle.service;

import br.com.letscode.movies_battle.model.User;
import br.com.letscode.movies_battle.repository.UserRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository2 userRepository;

    public UserService(UserRepository2 userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User save(User user){
        return userRepository.save(user);
    }

    @Transactional
    public List<User> saveAll(List<User> lista){
        return userRepository.saveAll(lista);
    }

    public List<User> pesquisarUsers(){
        return (List<User>) userRepository.findAll();
    }
    public User pesquisarUser(long id) {
        return userRepository.getById(id);
    }

    public User getByUsername(String username) {
        return userRepository.getByUsername(username);
    }
}
