package br.cefetmg.inf.regbook.model.dao;

import br.cefetmg.inf.regbook.model.domain.Livro;
import br.cefetmg.inf.util.db.exception.PersistenciaException;

public interface LivroDAO {
    Long inserir(Livro livro) throws PersistenciaException;
}
