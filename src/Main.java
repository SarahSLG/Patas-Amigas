import java.time.LocalDate;
import java.util.Date;
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

        menu.adicionarOpcao(() -> {
            Funcionario funcionario1 = new Funcionario("João da Silva", LocalDate.of(1990, 5, 15), "Masculino", "123.456.789-00", "Rua A, 123", "(11) 98765-4321", "joao@email.com", "senha123", "hashJoao", 1, new Date(), "Desenvolvedor", 5000.0f, "Tecnologia");
            Funcionario funcionario2 = new Funcionario("Maria Oliveira", LocalDate.of(1985, 8, 22), "Feminino", "987.654.321-00", "Rua B, 456", "(11) 91234-5678", "maria@email.com", "senha456", "hashMaria", 2, new Date(), "Analista", 6000.0f, "Financeiro");

            Tutor tutor1 = new Tutor("Ana Souza", LocalDate.of(1988, 3, 12), "Feminino", "123.456.789-01", "Rua C, 789", "(11) 99876-5432", "ana@email.com", "senhaAna", "hashAna", 1, 2, "Experiência com cães e gatos", "Ativo");
            Tutor tutor2 = new Tutor("Carlos Lima", LocalDate.of(1985, 7, 25), "Masculino", "987.654.321-09", "Avenida D, 101", "(11) 91234-5678", "carlos@email.com", "senhaCarlos", "hashCarlos", 2, 3, "Resgate de animais", "Inativo");

            Adotante adotante1 = new Adotante("Lucas Mendes", LocalDate.of(1992, 4, 20), "Masculino", "111.222.333-44", "Rua E, 456", "(11) 99876-5432", "lucas@email.com", "senhaLucas", "hashLucas", 1, "Cães", "Nenhuma adoção anterior", "Ativo");
            Adotante adotante2 = new Adotante("Fernanda Ribeiro", LocalDate.of(1987, 11, 5), "Feminino", "555.666.777-88", "Avenida F, 789", "(11) 91234-5678", "fernanda@email.com", "senhaFernanda", "hashFernanda", 2, "Gatos", "Adotou 1 gato", "Inativo");

            usuarios.add(funcionario1);
            usuarios.add(funcionario2);
            usuarios.add(tutor1);
            usuarios.add(tutor2);
            usuarios.add(adotante1);
            usuarios.add(adotante2);

            return null;
        }, "DEBUG : ADICIONAR USUARIOS DE TESTE.");

        menu.exibir();

        teclado.close();
    }
}
