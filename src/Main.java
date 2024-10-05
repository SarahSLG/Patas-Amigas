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

        Supplier<Object> permitirAdocao = () -> {
            if (usuarios.size() == 0) {
                System.out.println("Não há nenhum usuário cadastrado!");
                return null;
            }

            System.out.println("Digite o id do usuário que será permitido a adotar: ");
            int id = teclado.nextInt();

            // Verifica se um usuário do sistema possui aquele id e obtém ele
            List<Pessoa> listaUsuariosComId = usuarios.stream().filter(p -> p.getId() == id).toList();

            if (listaUsuariosComId.size() == 0) {
                System.out.println("Usuário não encontrado! Certifique-se de que o id foi digitado corretamente.");
                return null;
            }

            Pessoa pessoa = listaUsuariosComId.get(0);

            pessoa.setPodeAdotar(true);

            return null;
        };

        menu.adicionarOpcao(criarFuncionario, "Criar funcionário.");
        menu.adicionarOpcao(criarAdotante, "Criar adotante.");
        menu.adicionarOpcao(criarTutor, "Criar tutor.");
        menu.adicionarOpcao(permitirAdocao, "Permitir Adoção.");

        menu.adicionarOpcao(listarPessoas, "Listar pessoas.");

        menu.exibir();

        teclado.close();
    }
}