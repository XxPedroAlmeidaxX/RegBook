package br.cefetmg.inf.regbook.controller;

import br.cefetmg.inf.regbook.model.domain.Autor;
import br.cefetmg.inf.regbook.model.domain.Editora;
import br.cefetmg.inf.regbook.model.domain.Livro;
import br.cefetmg.inf.regbook.model.service.ManterAutor;
import br.cefetmg.inf.regbook.model.service.ManterEditora;
import br.cefetmg.inf.regbook.model.service.ManterLivro;
import br.cefetmg.inf.regbook.model.service.impl.IManterAutor;
import br.cefetmg.inf.regbook.model.service.impl.IManterEditora;
import br.cefetmg.inf.regbook.model.service.impl.IManterLivro;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;



public class Registrar {
    
    public static String execute(HttpServletRequest request) {
        
        String jsp = "index.jsp";

        try {
            String nome = request.getParameter("nome");
            String isbn = request.getParameter("isbn");
            String volume = request.getParameter("volume");
            
            String dataStr = request.getParameter("data");
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date data = formatter.parse(dataStr);
            
            String paginasStr = request.getParameter("paginas");
            int paginas = Integer.parseInt(paginasStr);

            String autorStr = request.getParameter("autor");
            Autor autor = new Autor();
            ManterAutor manterautor = new IManterAutor();
            List<Autor> listautor = manterautor.pesquisarTodos();
            
            for(int n=0; n<listautor.size(); n++) {
                if(listautor.get(n).getNome().equals(autorStr)) {
                    autor = listautor.get(n);
                    break;
                }
                else {
                    autor.setNome(autorStr);
                    autor.setId(manterautor.cadastrar(autor));
                }
            }
            
            String editoraStr = request.getParameter("editora");
            Editora editora = new Editora();
            ManterEditora mantereditora = new IManterEditora();
            List<Editora> listeditora = mantereditora.pesquisarTodos();
            
            for(int n=0; n<listeditora.size(); n++) {
                if(listeditora.get(n).getNome().equals(editoraStr)) {
                    editora = listeditora.get(n);
                    break;
                }
                else {
                    editora.setNome(editoraStr);
                    editora.setId(mantereditora.cadastrar(editora));
                }
            }

            Livro livro = new Livro();
            livro.setAutor(autor);
            livro.setData(data);
            livro.setEditora(editora);
            livro.setIsbn(isbn);
            livro.setNome(nome);
            livro.setPaginas(paginas);
            livro.setVolume(volume);
            
            ManterLivro manterlivro = new IManterLivro();
            livro.setId(manterlivro.cadastrar(livro));
            
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "erro.jsp";
        }
        return jsp;
    }
}
