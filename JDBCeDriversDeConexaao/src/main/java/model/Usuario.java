package model;

/*Classe espelho do banco de dados, será usada para criar objetos que pegarmos do banco ou objetos
para inserção*/
public class Usuario {

    private long id;
    private boolean disponibilizadorDeQuadra;
    private String nome;
    private String avatar;
    private String apelido;
    private String email;
    private String senha;

    public Usuario(long id, boolean disponibilizadorDeQuadra, String nome,
                   String avatar, String apelido, String email) {
        this.id = id;
        this.disponibilizadorDeQuadra = disponibilizadorDeQuadra;
        this.nome = nome;
        this.avatar = avatar;
        this.apelido = apelido;
        this.email = email;
    }

    public Usuario(boolean disponibilizadorDeQuadra, String nome,
                   String avatar, String apelido, String email, String senha) {
        this.disponibilizadorDeQuadra = disponibilizadorDeQuadra;
        this.nome = nome;
        this.avatar = avatar;
        this.apelido = apelido;
        this.email = email;
        this.senha = senha;
    }

    public Usuario(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isDisponibilizadorDeQuadra() {
        return disponibilizadorDeQuadra;
    }

    public void setDisponibilizadorDeQuadra(boolean disponibilizadorDeQuadra) {
        this.disponibilizadorDeQuadra = disponibilizadorDeQuadra;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", disponibilizadorDeQuadra=" + disponibilizadorDeQuadra +
                ", nome='" + nome + '\'' +
                ", avatar='" + avatar + '\'' +
                ", apelido='" + apelido + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
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
}
