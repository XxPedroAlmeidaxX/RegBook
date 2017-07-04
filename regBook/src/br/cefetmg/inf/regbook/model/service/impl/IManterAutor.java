package br.cefetmg.inf.regbook.model.service.impl;

import br.cefetmg.inf.regbook.model.dao.AutorDAO;
import br.cefetmg.inf.regbook.model.dao.impl.IAutorDAO;
import br.cefetmg.inf.regbook.model.domain.Autor;
import br.cefetmg.inf.regbook.model.service.ManterAutor;
import br.cefetmg.inf.util.db.exception.NegocioException;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.util.List;

public class IManterAutor implements ManterAutor{
    private AutorDAO autorDAO;
    
    public IManterAutor() {
        autorDAO = new IAutorDAO();
    }
    
    @Override
    public Long cadastrar(Autor autor) throws PersistenciaException, NegocioException {    
        if((autor.getNome() == null) || (autor.getNome().isEmpty()))
            throw new NegocioException("Obrigatório ter nome");            
        Long result = autorDAO.inserir(autor);
        return result;
    }
    
    @Override
    public List<Autor> pesquisarTodos() throws PersistenciaException {
        List<Autor> result = autorDAO.listarTodos();
        return result;       
    }

    @Override
    public Autor pesquisarPorId(Long id) throws PersistenciaException {
        Autor result = autorDAO.consultarPorId(id);
        return result;
    }
}
