package br.cefetmg.inf.regbook.model.service;

import br.cefetmg.inf.regbook.model.domain.Editora;
import br.cefetmg.inf.util.db.exception.NegocioException;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.util.List;

public interface ManterEditora {
    public Long cadastrar(Editora editora) throws PersistenciaException, NegocioException;
    public List<Editora> pesquisarTodos() throws PersistenciaException;
    public Editora pesquisarPorId(Long id) throws PersistenciaException;
}
