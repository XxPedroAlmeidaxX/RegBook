package br.cefetmg.inf.regbook.model.dao.impl;

import br.cefetmg.inf.regbook.model.domain.Editora;
import br.cefetmg.inf.regbook.model.dao.EditoraDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import br.cefetmg.inf.util.db.ConnectionManager;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.util.ArrayList;

public class IEditoraDAO implements EditoraDAO{
    @Override
    public Long inserir(Editora editora) throws PersistenciaException {

        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO editora (nome) VALUES(?) RETURNING id";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, editora.getNome());
            ResultSet rs = pstmt.executeQuery();

            Long id = null;
            if (rs.next()) {
                id = new Long(rs.getLong("id"));
                editora.setId(id);
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
    public ArrayList<Editora> listarTodos() throws PersistenciaException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM editora ORDER BY nome";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            ArrayList<Editora> listAll = null;
            if (rs.next()) {
                listAll = new ArrayList<>();
                do {
                    Editora editora = new Editora();
                    editora.setId(rs.getLong("id"));
                    editora.setNome(rs.getString("nome"));
                    listAll.add(editora);
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
    public Editora consultarPorId(Long id) throws PersistenciaException {

        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM editora WHERE id = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();

            Editora editora = null;
            if (rs.next()) {
                editora = new Editora();
                editora.setId(rs.getLong("id"));
                editora.setNome(rs.getString("nome"));
            }

            rs.close();
            pstmt.close();
            connection.close();

            return editora;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }
    }
}
