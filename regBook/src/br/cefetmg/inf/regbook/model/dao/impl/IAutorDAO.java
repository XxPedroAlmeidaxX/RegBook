package br.cefetmg.inf.regbook.model.dao.impl;

import br.cefetmg.inf.regbook.model.domain.Autor;
import br.cefetmg.inf.regbook.model.dao.AutorDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import br.cefetmg.inf.util.db.ConnectionManager;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.util.ArrayList;

public class IAutorDAO implements AutorDAO{
    @Override
    public Long inserir(Autor autor) throws PersistenciaException {

        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO autor (nome) VALUES(?) RETURNING id";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, autor.getNome());
            ResultSet rs = pstmt.executeQuery();

            Long id = null;
            if (rs.next()) {
                id = new Long(rs.getLong("id"));
                autor.setId(id);
            }

            rs.close();
            pstmt.close();
            connection.close();
            
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }
    }

    @Override
    public ArrayList<Autor> listarTodos() throws PersistenciaException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM autor ORDER BY nome";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            ArrayList<Autor> listAll = null;
            if (rs.next()) {
                listAll = new ArrayList<>();
                do {
                    Autor autor = new Autor();
                    autor.setId(rs.getLong("id"));
                    autor.setNome(rs.getString("nome"));
                    listAll.add(autor);
                } while (rs.next());
            }

            rs.close();
            pstmt.close();
            connection.close();

            return listAll;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }
    }

    @Override
    public Autor consultarPorId(Long id) throws PersistenciaException {

        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM autor WHERE id = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();

            Autor autor = null;
            if (rs.next()) {
                autor = new Autor();
                autor.setId(rs.getLong("id"));
                autor.setNome(rs.getString("nome"));
            }

            rs.close();
            pstmt.close();
            connection.close();

            return autor;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }
    }
}
