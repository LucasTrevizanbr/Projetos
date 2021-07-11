package factory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/*Classe com o método de conexão com o banco de dados*/
public class ConexaoFactory {

    //construtor privado, evitando criar instâncias da fábrica de conexão
    private ConexaoFactory() {
    }

    public static Connection criarConexao(){

        //Declarando objeto de conexão
        Connection conexao = null;

        //Pegando as variáveis de conexão com um inputStream vindo do properties
        try(InputStream entrada = ConexaoFactory.class.getClassLoader()
                .getResourceAsStream("conexao.properties")) {

            //Carregando os dados de entrada do arquivo de properties
            Properties propriedades = new Properties();
            propriedades.load(entrada);

            //definindo parâmetros da conexão, pegando dos dados carregados e atribuindo a variáveis
            String driver = propriedades.getProperty("jdbc.driver");
            String enderecoDoBancoDeDados = propriedades.getProperty("db.address");
            String nomeDoBancoDeDados = propriedades.getProperty("db.name");
            String timeZone = propriedades.getProperty("db.timezone");
            String usuario = propriedades.getProperty("db.user.login");
            String senha = propriedades.getProperty("db.user.password");

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
            try{
                conexao = DriverManager.getConnection(urlDeConexao,usuario,senha);
            }catch (SQLException throwables) {
                throwables.printStackTrace();
            }


        }catch (IOException exception) {
            exception.printStackTrace();
            System.out.println("Falha ao tentar carregar arquivo de propriedades");
        }

        return conexao;

    }


}
