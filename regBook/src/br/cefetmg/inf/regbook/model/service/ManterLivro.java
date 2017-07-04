package br.cefetmg.inf.regbook.model.service;

import br.cefetmg.inf.regbook.model.domain.Livro;
import br.cefetmg.inf.util.db.exception.NegocioException;
import br.cefetmg.inf.util.db.exception.PersistenciaException;

public interface ManterLivro {
    public Long cadastrar(Livro livro) throws PersistenciaException, NegocioException;
}
