package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String nome;

    @Column
    private String email;

    @Column
    private String senha;

    /*Anotação de relacionamento, com atributos de relacionamento bidirecional(mappedBy)
    */
    @OneToMany(mappedBy = "proprietarioQuadra",
            cascade = CascadeType.ALL)
    private List<Quadra> quadrasDoUsuario = new ArrayList<>();

    public Usuario(long id, String nome, String email, String senha, ArrayList<Quadra> quadrasDoUsuario) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.quadrasDoUsuario = quadrasDoUsuario;
    }

    public Usuario(long id, String nome, String email, ArrayList<Quadra> quadrasDoUsuario) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.quadrasDoUsuario = quadrasDoUsuario;
    }

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.quadrasDoUsuario = quadrasDoUsuario;
    }
    public Usuario(){}


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Quadra> getQuadrasDoUsuario() {
        return quadrasDoUsuario;
    }

    public void setQuadrasDoUsuario(List<Quadra> quadrasDoUsuario) {
        this.quadrasDoUsuario = quadrasDoUsuario;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", \nquadrasDoUsuario=" + quadrasDoUsuario +
                '}';
    }
}
