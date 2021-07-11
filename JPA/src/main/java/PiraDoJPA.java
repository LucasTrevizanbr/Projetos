public class PiraDoJPA {
    /*
        Os devs perceberam que muito tempo era gasto escrevendo consultas SQL apenas com o JDBC. Outro
        problema era ter que pensar no paradigma orientado a objetos e ao relacional que são paradigmas
        diferentes, exigindo duas soluções em um mesmo sistema.
               Como solução para esse problema foi proposto um modelo de mapeamento chamado ORM
        (Modelo Objeto Relacional) para representar tabelas de um banco de dados relacional em classes
        java. Objeto = Registro, Coluna = Atributo, Tabela = classe.
                Para padronizar os frameworks ORM(Hibernate, eclipselink), foi criado a especificação
        JPA(Java persistence API), os frameworks implementam a interface JPA e os desenvolvedores usam
        a interface JPA, podendo trocar de ORM quando quiser já que todos eles implementam a interface
        padronizada. Logo, a Interface JPA só funciona com frameworks RMA, não da pra usar ela sem uma
        implementação ORM. Podemos usar o JPA para mapear as classes com annotations.
                Depois de mapear as classes, manuseamos elas com o EntityManager que vai gerenciar
         o ciclo de vida das entidades. Os principais métodos do EntityManager são "find", "persist"
         e "remove". O código compila mas falha em tempo de execução, pois apenas estou usando a interface
         JPA mas nenhuma ORM por baixo dela.
     */
}
