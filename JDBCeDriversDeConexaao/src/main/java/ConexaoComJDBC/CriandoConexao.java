package ConexaoComJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CriandoConexao {
    public static void main(String[] args) {

        //Por boa prática, definir parâmetros da conexão
        String driver ="mysql";
        String enderecoDoBancoDeDados = "localhost";
        String nomeDoBancoDeDados = "sharefields";
        String timeZone = "serverTimezone=UTC&useSSl=false";
        String usuario = "root";
        String senha ="luquinhas123";

        //StringBuilder permite criar e manipular dados de strings dinamicamente.
        //Usar os parâmetros definidos para construir uma String de conexão, concatenando os parâmetros
        StringBuilder criarUrlDeConexao = new StringBuilder("jdbc:")
                .append(driver).append("://")
                .append(enderecoDoBancoDeDados).append("/")
                .append(nomeDoBancoDeDados).append("?")
                .append(timeZone);

        //Convertendo o objeto StringBuilder em String
        String urlDeConexao = criarUrlDeConexao.toString();

        //Objeto de Connection recebe um DriverManager.getConnection com os argumentos
        try(Connection conexao = DriverManager.getConnection(urlDeConexao,usuario,senha)){
            System.out.println("Deu certo, conexão estabelecida");
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
