package br.cefetmg.inf.regbook.model.dao;

import br.cefetmg.inf.regbook.model.domain.Editora;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.util.ArrayList;

public interface EditoraDAO {
    Long inserir(Editora editora) throws PersistenciaException;
    
    ArrayList<Editora> listarTodos() throws PersistenciaException;
    
    Editora consultarPorId(Long id) throws PersistenciaException;
}
