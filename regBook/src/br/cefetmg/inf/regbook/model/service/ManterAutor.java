package br.cefetmg.inf.regbook.model.service;

import br.cefetmg.inf.regbook.model.domain.Autor;
import br.cefetmg.inf.util.db.exception.NegocioException;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.util.List;

public interface ManterAutor {
    public Long cadastrar(Autor autor) throws PersistenciaException, NegocioException;
    public List<Autor> pesquisarTodos() throws PersistenciaException;
    public Autor pesquisarPorId(Long id) throws PersistenciaException;
}
