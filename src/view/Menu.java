package view;

import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Supplier;

/**
 * Um menu é um objeto composto por uma lista de opções que será exibida no
 * terminal. O menu lida com adicionar a lista de opções, controlar a resposta
 * do usuário e verificá-la, e executar a ação daquela opção.
 * 
 * @author Fernando Freitas
 */
public class Menu {
    private static Integer idBase = 1;

    private HashMap<Supplier<Object>, String> opcoes = new HashMap<>();

    private Scanner scanner;

    /**
     * Instancia um objeto Menu novo, à partir de um scanner de entrada
     * 
     * @param scanner O objeto scanner para receber valores de entrada no terminal
     */
    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Adiciona uma opção na lista de opções no menu.
     * 
     * @param opcao     O objeto representado pela função. Ex:
     *                  {@code Consumer<String> [opcao] = () -> [codigo]}
     * @param descricao A descrição da opção para ser exibida
     */
    public void adicionarOpcao(Supplier<Object> opcao, String descricao) {
        this.opcoes.put(opcao, descricao);
    }

    /**
     * Exibe o menu criado
     */
    public void exibir() {
        String resposta = "";

        boolean continuarExibindo = !resposta.equalsIgnoreCase("Sair");

        while (continuarExibindo) {
            exibirOpcoes();
            System.out.println("Digite \"sair\" para Sair.");

            resposta = obterResposta();

            calcularResposta(resposta);
        }
    }

    private void exibirOpcoes() {
        idBase = 1;
        opcoes.forEach((opcao, descricao) -> {
            System.out.printf("%d. %s\n", idBase, descricao);
            idBase += 1;
        });
    }

    private String obterResposta() {
        return scanner.nextLine();
    }

    private void calcularResposta(String resposta) {
        idBase = 1;

        opcoes.forEach((opcao, descricao) -> {
            if (resposta.equals(idBase.toString())) {
                opcao.get();
            }

            idBase += 1;
        });
    }

    public HashMap<Supplier<Object>, String> getOpcoes() {
        return opcoes;
    }
}
