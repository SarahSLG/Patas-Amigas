import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

import modelo.Adotante;
import modelo.Funcionario;
import modelo.Tutor;
import view.FormularioCriarObjeto;
import view.Menu;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        Menu menu = new Menu(teclado);
        List<Funcionario> funcionarios = new LinkedList<>();
        List<Adotante> adotantes = new LinkedList<>();
        List<Tutor> tutores = new LinkedList<>();

        Supplier<Object> criarFuncionario = () -> {
            Funcionario funcionario = FormularioCriarObjeto.criarObjeto(teclado, Funcionario.class);
            funcionarios.add(funcionario);

            return funcionario;
        };

        Supplier<Object> criarAdotante = () -> {
            Adotante adotante = FormularioCriarObjeto.criarObjeto(teclado, Adotante.class);
            adotantes.add(adotante);

            return adotante;
        };

        Supplier<Object> criarTutor = () -> {
            Tutor tutor = FormularioCriarObjeto.criarObjeto(teclado, Tutor.class);
            tutores.add(tutor);

            return tutor;
        };

        Supplier<Object> listarPessoas = () -> {
            // Exibir todos os usuários por method reference
            System.out.println("\tTODOS OS USUÁRIOS CADASTRADOS\t");
            funcionarios.forEach(System.out::println);
            adotantes.forEach(System.out::println);
            tutores.forEach(System.out::println);

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