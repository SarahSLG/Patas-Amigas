import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

import modelo.Pessoa;
import view.FormularioCriarObjeto;
import view.Menu;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        Menu menu = new Menu(teclado);
        List<Pessoa> pessoas = new LinkedList<>();

        Supplier<Object> criarPessoa = () -> {
            Pessoa pessoa = FormularioCriarObjeto.criarObjeto(teclado, Pessoa.class);
            pessoas.add(pessoa);

            return pessoa;
        };

        Supplier<Object> listarPessoas = () -> {
            pessoas.forEach(System.out::println);

            return null;
        };

        menu.adicionarOpcao(criarPessoa, "Criar pessoa.");
        menu.adicionarOpcao(listarPessoas, "Listar pessoas.");

        menu.exibir();

        teclado.close();
    }
}