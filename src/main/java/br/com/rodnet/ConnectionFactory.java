package br.com.rodnet;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@ApplicationScoped
public class ConnectionFactory {

    @ConfigProperty(name = "banco.usuario")
    private String usuario;

    @ConfigProperty(name = "banco.senha")
    private String senha;

    public Connection getConexao() {
        System.out.println(usuario);
        System.out.println(senha);
        try {
            return DriverManager.getConnection(
                "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL",
                usuario,
                senha
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
