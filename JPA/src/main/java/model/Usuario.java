package model;



import javax.persistence.*;
import java.util.ArrayList;


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
    private ArrayList<Quadra> quadrasDoUsuario = new ArrayList<>();

    public Usuario(long id, String nome, String email, String senha, ArrayList<Quadra> quadrasDoUsuario) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.quadrasDoUsuario = quadrasDoUsuario;
    }

    public Usuario(long id, String nome, String email,  ArrayList<Quadra> quadrasDoUsuario) {
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


}
