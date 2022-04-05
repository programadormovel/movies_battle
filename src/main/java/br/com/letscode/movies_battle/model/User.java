package br.com.letscode.movies_battle.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="email", nullable = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "name", nullable = true)
    private String name;

    @Column(name = "last_name", nullable = true)
    private String last_name;

    @Column(name = "enable", nullable = true)
    private boolean enabled = true;

    @Column(name = "username")
    private String username;

    @Column(name = "dataRegistro", nullable = true)
    private LocalDate dataRegistro;

    @JsonIgnore
    @OneToMany
    private List<Partida> partidas;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(name= "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;

    public User(){

    }

    public User(String password, String username) {
        this.password = password;
        this.username = username;
    }

    public User(long id, String username) {
        this.id = id;
        this.username = username;
    }

    public User(String email, String password, String name, String username) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.username = username;
    }

    public User(String email, String password, String name, String last_name, boolean enabled, String username, LocalDate dataRegistro) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.last_name = last_name;
        this.enabled = enabled;
        this.username = username;
        this.dataRegistro = dataRegistro;
    }

    public User(long id, String email, String password, String name, String last_name, boolean enabled, String username, LocalDate dataRegistro, List<Partida> partidas, Collection<Role> roles) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.last_name = last_name;
        this.enabled = enabled;
        this.username = username;
        this.dataRegistro = dataRegistro;
        this.partidas = partidas;
        this.roles = roles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDate dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public List<Partida> getPartidas() {
        return partidas;
    }

    public void setPartidas(List<Partida> partidas) {
        this.partidas = partidas;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}
