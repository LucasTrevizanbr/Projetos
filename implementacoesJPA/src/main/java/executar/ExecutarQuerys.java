package executar;

import model.Quadra;
import model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class ExecutarQuerys {
    public static void main(String[] args) {
        // Cria uma fábrica de conexão passando os metadados do arquivo persistence
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("part-2");

        //Criando um EntityManager com um método da fábrica de entity manager(EntityManagerFactory)
        EntityManager gerenciadorEntidade = entityManagerFactory.createEntityManager();

        /*
        //Instâncias de quadra para serem inseridas no banco de dados
        Quadra quadra1 = new Quadra("Quadra Ramos","Basquete","muito legal",12);
        Quadra quadra2 = new Quadra("Quadra Miguel","Volei","legal",12);
        List<Quadra> quadras = new ArrayList<>();
        quadras.add(quadra1);
        quadras.add(quadra2);

        //Instância de usuario para ser inserido no banco de dados
        Usuario dono = new Usuario("Jose","Jose@Jose.com","wwww");

         //Adicionando lista de quadras encontradas ao usuario encontrado
        for(Quadra quadra : quadras){
            quadra.setProprietarioQuadra(dono);
        }
        dono.setQuadrasDoUsuario(quadras);


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
         */

        //Buscando no banco de dados e atribuindo aos objetos
        Usuario donoDaQuadra = gerenciadorEntidade.find(Usuario.class,1L);
        Quadra quadraEncontrada1 = gerenciadorEntidade.find(Quadra.class, 1L);
        Quadra quadraEncontrada2 = gerenciadorEntidade.find(Quadra.class, 2L);
        System.out.println("dono: "+donoDaQuadra);
        System.out.println("quadra1: "+quadraEncontrada2);
        System.out.println("quadra2: "+quadraEncontrada1);


        //Deletando um registro
        gerenciadorEntidade.getTransaction().begin();

        gerenciadorEntidade.remove(donoDaQuadra);

        gerenciadorEntidade.getTransaction().commit();
        gerenciadorEntidade.close();
        entityManagerFactory.close();


    }
}
