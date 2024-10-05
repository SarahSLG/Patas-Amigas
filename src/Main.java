import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

import modelo.Adotante;
import modelo.Funcionario;
import modelo.Pessoa;
import modelo.Tutor;
import view.FormularioCriarObjeto;
import view.Menu;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        Menu menu = new Menu(teclado);
        List<Pessoa> usuarios = new LinkedList<>();

        Supplier<Object> criarFuncionario = () -> {
            Funcionario funcionario = FormularioCriarObjeto.criarObjeto(teclado, Funcionario.class);
            usuarios.add(funcionario);

            return funcionario;
        };

        Supplier<Object> criarAdotante = () -> {
            Adotante adotante = FormularioCriarObjeto.criarObjeto(teclado, Adotante.class);
            usuarios.add(adotante);

            return adotante;
        };

        Supplier<Object> criarTutor = () -> {
            Tutor tutor = FormularioCriarObjeto.criarObjeto(teclado, Tutor.class);
            usuarios.add(tutor);

            return tutor;
        };

        Supplier<Object> listarPessoas = () -> {
            // Exibir todos os usuários por method reference
            System.out.println("\tTODOS OS USUÁRIOS CADASTRADOS\t");
            usuarios.forEach(System.out::println);

            return null;
        };

        menu.adicionarOpcao(criarFuncionario, "Criar funcionário.");
        menu.adicionarOpcao(criarAdotante, "Criar adotante.");
        menu.adicionarOpcao(criarTutor, "Criar tutor.");

        menu.adicionarOpcao(listarPessoas, "Listar pessoas.");

        menu.exibir();

        teclado.close();
    }
}