package br.com.fiap.dao;

import br.com.fiap.dto.Carro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CarroDAO {
    private Connection con;

    public CarroDAO(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    public String inserir(Carro carro){
        String sql = "INSERT INTO ddd_carro(placa, cor, descricao) VALUES(?,?,?)";
        try(PreparedStatement ps = getCon().prepareStatement(sql)) { // try-with-resources
            ps.setString(1, carro.getPlaca());
            ps.setString(2, carro.getCor());
            ps.setString(3, carro.getDescricao());
            if(ps.executeUpdate() > 0){ //se conseguiu preencher pelo menos uma linha
                return "Inserido com sucesso";
            }else{
                return "Erro ao inserir";
            }

        } catch (SQLException e) {
            return "Erro de SQL\n" + e.getMessage();
        }
    }

}
