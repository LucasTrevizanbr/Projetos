package executar;

import model.Quadra;
import model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ExecutarEntityQuerys {
    public static void main(String[] args) {

        // Cria uma fábrica de conexão passando os metadados do arquivo persistence
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("part-1");

        //Criando um EntityManager com um método da fábrica de entity manager(EntityManagerFactory)
        EntityManager gerenciadorEntidade = entityManagerFactory.createEntityManager();

        //Instâncias de quadra para serem inseridas no banco de dados
        Quadra quadra1 = new Quadra("Quadra Ramos","Basquete","muito legal",12);
        Quadra quadra2 = new Quadra("Quadra Miguel","Volei","legal",12);

        //Instância de usuario para ser inserido no banco de dados
        Usuario dono = new Usuario("Jose","Jose@Jose.com","wwww");

        //Pegamos uma transação através do EntityManager e iniciamos ela
        gerenciadorEntidade.getTransaction().begin();

        //Persistimos os dados
        gerenciadorEntidade.persist(quadra1);
        gerenciadorEntidade.persist(quadra2);
        gerenciadorEntidade.persist(dono);

        //Pegamos a transação e fazemos um commit para finaliza-la
        gerenciadorEntidade.getTransaction().commit();

        //Encerramos o gerenciador de entidade  e a fabrica de EntityManager
        gerenciadorEntidade.close();
        entityManagerFactory.close();


    }


}
