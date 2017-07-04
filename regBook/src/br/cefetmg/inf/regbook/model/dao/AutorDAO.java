package br.cefetmg.inf.regbook.model.dao;

import br.cefetmg.inf.regbook.model.domain.Autor;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.util.ArrayList;

public interface AutorDAO {
    Long inserir(Autor autor) throws PersistenciaException;
    
    ArrayList<Autor> listarTodos() throws PersistenciaException;

    Autor consultarPorId(Long id) throws PersistenciaException;
}
