
package repository;

import model.Livro;
import java.util.ArrayList;
import java.util.List;

public class LivroRepository {
    private List<Livro> livros = new ArrayList<>();
    private int contadorId = 1;

    public void salvarLivro(Livro livro) {
        livro.setId(contadorId++);
        livros.add(livro);
    }

    public List<Livro> listarLivros() {
        return livros;
    }

    public Livro buscarPorISBN(String isbn) {
        return livros.stream()
                .filter(l -> l.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
    }

    public void removerLivro(int id) {
        livros.removeIf(l -> l.getId() == id);
    }
}
