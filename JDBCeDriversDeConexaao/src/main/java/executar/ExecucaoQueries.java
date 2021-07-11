package executar;

import dao.UsuarioDAO;
import model.Usuario;

import java.util.List;


public class ExecucaoQueries {
    public static void main(String[] args) {

        UsuarioDAO usarioDao = new UsuarioDAO();

       /* List<Usuario> listaAlunos = usarioDao.listarUsuarios();
        listaAlunos.forEach(System.out::println);*/


        Usuario usuarioBuscadoPorId;
        usuarioBuscadoPorId = usarioDao.buscarPorId(7);
        System.out.println(usuarioBuscadoPorId);

        /*
        Usuario usuarioParaInsercao = new Usuario(true,
                "Lucas",
                "n/a",
                "Lucão",
                "lucasevizan@hotmail.com",
                "tazmania");

        Usuario usuarioParaInsercao2 = new Usuario(true,
                "Jorge",
                "n/a",
                "Jorgelito",
                "jarja@hotmail.com",
                "abudabuda");
        
        usarioDao.criarUsuario(usuarioParaInsercao);
        usarioDao.criarUsuario(usuarioParaInsercao2);
        */

        /*
        usuarioBuscadoPorId.setApelido("jorginho");
        usarioDao.atualizarUsuario(usuarioBuscadoPorId);
        System.out.println(usarioDao.buscarPorId(7));*/


        usarioDao.deletarUsuario(2);
        usarioDao.deletarUsuario(3);
        usarioDao.deletarUsuario(4);
        usarioDao.deletarUsuario(5);
        usarioDao.deletarUsuario(6);
        usarioDao.listarUsuarios().forEach(System.out::println);


    }
}
