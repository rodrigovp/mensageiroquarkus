package br.com.rodnet;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@ApplicationScoped
public class MensagemRepository {

    @Inject
    private ConnectionFactory connectionFactory;

    public Mensagem obterMensagem() {
        Mensagem mensagem = null;
        try(Connection conexao = connectionFactory.getConexao();
            PreparedStatement ps = conexao.prepareStatement("select * from mensagem where rownum <= 1");
            ResultSet resultSet = ps.executeQuery();){
            while(resultSet.next()){
                mensagem = new Mensagem(resultSet.getString("TEXTO"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return mensagem;
    }
}
