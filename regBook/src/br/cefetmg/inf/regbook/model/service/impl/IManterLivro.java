package br.cefetmg.inf.regbook.model.service.impl;

import br.cefetmg.inf.regbook.model.dao.LivroDAO;
import br.cefetmg.inf.regbook.model.dao.impl.ILivroDAO;
import br.cefetmg.inf.regbook.model.domain.Livro;
import br.cefetmg.inf.regbook.model.service.ManterLivro;
import br.cefetmg.inf.util.db.exception.NegocioException;
import br.cefetmg.inf.util.db.exception.PersistenciaException;

public class IManterLivro implements ManterLivro{
    private LivroDAO livroDAO;
    
    public IManterLivro() {
        livroDAO = new ILivroDAO();
    }
    
    @Override
    public Long cadastrar(Livro livro) throws PersistenciaException, NegocioException {    
        if((livro.getNome() == null) || (livro.getNome().isEmpty()))
            throw new NegocioException("Obrigatório ter nome");
        if((livro.getAutor() == null) || (livro.getAutor().getNome() == null) ||
            (livro.getAutor().getNome().isEmpty()))
            throw new NegocioException("Obrigatório ter autor");
        if((livro.getIsbn() == null) || (livro.getIsbn().isEmpty()))
            throw new NegocioException("Obrigatório ter isbn");
        if((livro.getVolume() == null) || (livro.getVolume().isEmpty()))
            throw new NegocioException("Obrigatório ter volume");
        if(livro.getData() == null)
            throw new NegocioException("Obrigatório ter data");
        if((livro.getEditora() == null) || (livro.getEditora().getNome() == null) ||
            (livro.getEditora().getNome().isEmpty()))
            throw new NegocioException("Obrigatório ter editora");
        if(livro.getPaginas() == 0)
            throw new NegocioException("Obrigatório ter páginas");        
        Long result = livroDAO.inserir(livro);
        return result;
    }
}
