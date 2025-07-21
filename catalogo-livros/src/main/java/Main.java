
import model.Livro;
import repository.LivroRepository;
import service.LivroService;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LivroService livroService = new LivroService();
        LivroRepository livroRepository = new LivroRepository();

        int opcao;
        do {
            System.out.println("===== Catálogo de Livros =====");
            System.out.println("1. Buscar livros por título (API)");
            System.out.println("2. Salvar livro encontrado");
            System.out.println("3. Listar livros do banco");
            System.out.println("4. Consultar livro por ISBN");
            System.out.println("5. Remover livro por ID");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Digite o título para buscar: ");
                    String titulo = scanner.nextLine();
                    List<Livro> livros = livroService.buscarLivros(titulo);
                    livros.forEach(System.out::println);
                }
                case 2 -> {
                    System.out.print("Digite o título para buscar e salvar: ");
                    String titulo = scanner.nextLine();
                    List<Livro> livros = livroService.buscarLivros(titulo);
                    livros.forEach(System.out::println);
                    if (!livros.isEmpty()) {
                        livroRepository.salvarLivro(livros.get(0));
                        System.out.println("Livro salvo!");
                    }
                }
                case 3 -> livroRepository.listarLivros().forEach(System.out::println);
                case 4 -> {
                    System.out.print("Digite o ISBN para consultar: ");
                    String isbn = scanner.nextLine();
                    Livro livro = livroRepository.buscarPorISBN(isbn);
                    System.out.println(livro);
                }
                case 5 -> {
                    System.out.print("Digite o ID do livro para remover: ");
                    int id = scanner.nextInt();
                    livroRepository.removerLivro(id);
                    System.out.println("Livro removido.");
                }
                case 6 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 6);

        scanner.close();
    }
}
