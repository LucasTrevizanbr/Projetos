package dao;

import factory.ConexaoFactory;
import model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*Classe para interação com o banco de dados*/
public class UsuarioDAO {

    public List<Usuario> listarUsuarios(){

        //Preparar lista que retornara o resultado
        List<Usuario> usuarios = new ArrayList<>();

        //Usando a fábrica de conexão para criar o objeto pronto.
        try(Connection conexao = ConexaoFactory.criarConexao()){

            //Através da conexão criar uma consulta sql e armazenar em um objeto PreparedStatement
            PreparedStatement consultaPreparada  = conexao.prepareStatement("SELECT * FROM usuario");

            //Executando a consulta que foi preparada e armazenando no ResultSet
            ResultSet resultadoConsulta = consultaPreparada.executeQuery();

            //next percorre os resultados do ResultSet, retornando true enquanto houver registros
            while(resultadoConsulta.next()){

                //A cada registro percorrido, instância um novo usuário e pega seus atributos um a um
                Usuario usuario = new Usuario(resultadoConsulta.getLong("id"),
                        resultadoConsulta.getBoolean("disponibilizadorDeQuadra"),
                        resultadoConsulta.getString("nome"),
                        resultadoConsulta.getString("avatar"),
                        resultadoConsulta.getString("apelido"),
                        resultadoConsulta.getString("email"));

                //Depois adiciona a lista de usuários.
                usuarios.add(usuario);
            };

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return usuarios;

    }

    public Usuario buscarPorId(long id){
        //preparando o objeto resultado da consulta
        Usuario usuario = new Usuario();

        //Usando a fábrica de conexão para criar o objeto pronto.
        try(Connection conexao = ConexaoFactory.criarConexao()){

            //Preparando a consulta
            String consultaPreparada = "SELECT * FROM usuario WHERE id = ?";
            //A "?" é o caractere que será parametrizado.

            /*Através da conexão criar uma consulta sql e armazenar em um objeto PreparedStatement*/
            PreparedStatement parametroDaConsulta = conexao.prepareStatement(consultaPreparada);

            //Setar parâmetros da consulta sql, passando argumento indice e argumento coluna
            parametroDaConsulta.setLong(1,id);//seta o parâmetro da "?"
            //esse 1 quer dizer a primeira "?"

            //Executando a consulta que foi setada e armazenando o resultado no ResultSet
            ResultSet resultadoConsulta = parametroDaConsulta.executeQuery();

            //Se existir o registro
            if(resultadoConsulta.next()){
                //Preencher os valores do usuário.
                usuario = new Usuario(resultadoConsulta.getLong("id"),
                        resultadoConsulta.getBoolean("disponibilizadorDeQuadra"),
                        resultadoConsulta.getString("nome"),
                        resultadoConsulta.getString("avatar"),
                        resultadoConsulta.getString("apelido"),
                        resultadoConsulta.getString("email"));
            };

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return usuario;
    }

    public void criarUsuario(Usuario usuario){
        try(Connection conexao = ConexaoFactory.criarConexao()){

            //Preparando a consulta
            String consultaPreparada = "INSERT INTO usuario(disponibilizadorDeQuadra,nome,avatar,apelido," +
                    "email,senha) VALUES (?,?,?,?,?,?)";
            //A "?" é o caractere que será parametrizado.

            /*Através da conexão criar uma consulta sql e armazenar em um objeto PreparedStatement*/
            PreparedStatement parametroDaConsulta = conexao.prepareStatement(consultaPreparada);

            //Setar parâmetros da consulta sql, passando argumento indice da "?" e argumento coluna
            parametroDaConsulta.setBoolean(1,usuario.isDisponibilizadorDeQuadra());
            parametroDaConsulta.setString(2,usuario.getNome());
            parametroDaConsulta.setString(3,usuario.getAvatar());
            parametroDaConsulta.setString(4,usuario.getApelido());
            parametroDaConsulta.setString(5,usuario.getEmail());
            parametroDaConsulta.setString(6,usuario.getSenha());

            //Executa a inserção e armazena o numero de linhas afetadas
            int linhasAfetadas = parametroDaConsulta.executeUpdate();

            System.out.println("Inserção Bem sucedida e "+linhasAfetadas+" linhas afetadas");

        } catch (SQLException throwables) {
            System.out.println("Inserção falhou");
            throwables.printStackTrace();
        }
    }

    public void atualizarUsuario(Usuario usuario){
        try(Connection conexao = ConexaoFactory.criarConexao()){

            //Preparando a consulta
            String consultaPreparada = "UPDATE usuario SET nome = ?, avatar = ?, apelido = ? WHERE id = ?";
            //A "?" é o caractere que será parametrizado.

            /*Através da conexão criar uma consulta sql e armazenar em um objeto PreparedStatement*/
            PreparedStatement parametroDaConsulta = conexao.prepareStatement(consultaPreparada);

            //Setar parâmetros da consulta sql, passando argumento indice da "?" e argumento coluna
            parametroDaConsulta.setString(1,usuario.getNome());
            parametroDaConsulta.setString(2,usuario.getAvatar());
            parametroDaConsulta.setString(3,usuario.getApelido());
            parametroDaConsulta.setLong(4,usuario.getId());


            //Executa a atualização e armazena o numero de linhas afetadas
            int linhasAfetadas = parametroDaConsulta.executeUpdate();

            System.out.println("Atualização Bem sucedida e "+linhasAfetadas+" linhas afetadas");

        } catch (SQLException throwables) {
            System.out.println("Atualização falhou");
            throwables.printStackTrace();
        }
    }

    public void deletarUsuario(long id){
        try(Connection conexao = ConexaoFactory.criarConexao()){

            //Preparando a consulta
            String consultaPreparada = "DELETE FROM usuario WHERE id = ?";
            //A "?" é o caractere que será parametrizado.

            /*Através da conexão criar uma consulta sql e armazenar em um objeto PreparedStatement*/
            PreparedStatement parametroDaConsulta = conexao.prepareStatement(consultaPreparada);

            //Setar parâmetros da consulta sql, passando argumento indice da "?" e argumento coluna
            parametroDaConsulta.setLong(1,id);

            //Executa a deleção e armazena o numero de linhas afetadas
            int linhasAfetadas = parametroDaConsulta.executeUpdate();

            System.out.println("Deleção Bem sucedida e "+linhasAfetadas+" linhas afetadas");

        } catch (SQLException throwables) {
            System.out.println("Deleção falhou");
            throwables.printStackTrace();
        }
    }
}
