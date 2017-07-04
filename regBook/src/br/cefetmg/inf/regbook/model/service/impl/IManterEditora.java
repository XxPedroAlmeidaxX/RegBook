package br.cefetmg.inf.regbook.model.service.impl;

import br.cefetmg.inf.regbook.model.dao.EditoraDAO;
import br.cefetmg.inf.regbook.model.dao.impl.IEditoraDAO;
import br.cefetmg.inf.regbook.model.domain.Editora;
import br.cefetmg.inf.regbook.model.service.ManterEditora;
import br.cefetmg.inf.util.db.exception.NegocioException;
import br.cefetmg.inf.util.db.exception.PersistenciaException;
import java.util.List;

public class IManterEditora implements ManterEditora{
    private EditoraDAO editoraDAO;
    
    public IManterEditora() {
        editoraDAO = new IEditoraDAO();
    }
    
    @Override
    public Long cadastrar(Editora editora) throws PersistenciaException, NegocioException {    
        if((editora.getNome() == null) || (editora.getNome().isEmpty()))
            throw new NegocioException("Obrigatório ter nome");            
        Long result = editoraDAO.inserir(editora);
        return result;
    }
    
    @Override
    public List<Editora> pesquisarTodos() throws PersistenciaException {
        List<Editora> result = editoraDAO.listarTodos();
        return result;       
    }

    @Override
    public Editora pesquisarPorId(Long id) throws PersistenciaException {
        Editora result = editoraDAO.consultarPorId(id);
        return result;
    }
}
