package br.cefetmg.inf.regbook.model.dao.impl;

import br.cefetmg.inf.regbook.model.domain.Livro;
import br.cefetmg.inf.regbook.model.dao.LivroDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import br.cefetmg.inf.util.db.ConnectionManager;
import br.cefetmg.inf.util.db.exception.PersistenciaException;

public class ILivroDAO implements LivroDAO{
    @Override
    public Long inserir(Livro livro) throws PersistenciaException {

        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO livro (nome, autor_id, isbn, volume, "
                    + "data, editora_id, paginas) VALUES(?,?,?,?,?,?,?) RETURNING id";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, livro.getNome());
            pstmt.setLong(2, livro.getAutor().getId());
            pstmt.setString(3, livro.getIsbn());
            pstmt.setString(4, livro.getVolume());
            pstmt.setDate(5, new java.sql.Date(livro.getData().getTime()));
            pstmt.setLong(6, livro.getEditora().getId());
            pstmt.setInt(7, livro.getPaginas());
            ResultSet rs = pstmt.executeQuery();

            Long id = null;
            if (rs.next()) {
                id = new Long(rs.getLong("id"));
                livro.setId(id);
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
}
