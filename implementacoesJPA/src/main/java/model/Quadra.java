package model;



import javax.persistence.*;


@Entity//Anotação para dizer que a classe é uma entidade
public class Quadra {

    @Id//Dizendo que esse atributo é uma coluna do tipo id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Estratégia de geração do ID
    private long id;


    @Column//dizendo que é uma coluna
    private String nome;

    @Column
    private String modalidade;

    @Column
    private String descricao;

    @Column
    private int qtdJogadoresMax;

    //Eager automaticamente carrega a quadra quando pegar um get do usuario
    //Lazy quand ocarrega usuario n carrega quadra, precisa dar um get
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario proprietarioQuadra;

    public Quadra(long id, String nome, String modalidade, String descricao, int qtdJogadoresMax, Usuario proprietarioQuadra) {
        this.id = id;
        this.nome = nome;
        this.modalidade = modalidade;
        this.descricao = descricao;
        this.qtdJogadoresMax = qtdJogadoresMax;
        this.proprietarioQuadra = proprietarioQuadra;
    }

    public Quadra(String nome, String modalidade, String descricao, int qtdJogadoresMax) {
        this.nome = nome;
        this.modalidade = modalidade;
        this.descricao = descricao;
        this.qtdJogadoresMax = qtdJogadoresMax;
    }

    public Quadra(String nome, String modalidade, String descricao, int qtdJogadoresMax, Usuario proprietarioQuadra) {
        this.nome = nome;
        this.modalidade = modalidade;
        this.descricao = descricao;
        this.qtdJogadoresMax = qtdJogadoresMax;
        this.proprietarioQuadra = proprietarioQuadra;
    }

    public Quadra(){}

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

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQtdJogadoresMax() {
        return qtdJogadoresMax;
    }

    public void setQtdJogadoresMax(int qtdJogadoresMax) {
        this.qtdJogadoresMax = qtdJogadoresMax;
    }

    public Usuario getProprietarioQuadra() {
        return proprietarioQuadra;
    }

    public void setProprietarioQuadra(Usuario proprietarioQuadra) {
        this.proprietarioQuadra = proprietarioQuadra;
    }

    @Override
    public String toString() {
        return "Quadra{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", modalidade='" + modalidade + '\'' +
                ", descricao='" + descricao + '\'' +
                ", qtdJogadoresMax=" + qtdJogadoresMax +
                '}';
    }
}
