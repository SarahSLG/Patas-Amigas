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
    /**
     * Será utilizado para operações de obter o id de uma opção. Esse id será utilizado para obter o número de chamada dela.
     */
    private static Integer idBase = 1;

    /**
     * Um hashmap foi escolhido a fim de que possa ser armazenado o nome (ou descrição) da opção e sua ação a ser executada (função Supplier)
     * A função supplier foi escolhida a fim de que a função não necessite de nenhum argumento mas possa retornar algum valor. 
     */
    private HashMap<Supplier<Object>, String> opcoes = new HashMap<>();

    /**
     * O scanner será um campo da classe para que seja utilizado em vários métodos.
     */
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
     *                  {@code Consumer<String> [opcao] = () -> [codigo]}. A função
     *                  deve ter um return no final, mesmo que retorne null.
     * @param descricao A descrição da opção para ser exibida
     */
    public void adicionarOpcao(Supplier<Object> opcao, String descricao) {
        // Adiciona o objeto Supplier e sua descrição na lista de interna de opções
        this.opcoes.put(opcao, descricao);
    }

    /**
     * Exibe o menu criado
     */
    public void exibir() {
        String resposta = "";

        // O loop será executado repetidamente
        while (true) {
            exibirOpcoes();

            System.out.println("Digite \"sair\" para Sair.");

            resposta = obterResposta();

            // Se o usuário digitar 'sair', para a execução
            boolean saidaRequisitada = resposta.equalsIgnoreCase("sair");

            if (saidaRequisitada) {
                break;
            }

            calcularResposta(resposta);
        }
    }

    private void exibirOpcoes() {
        // Reinicia o idBase para ser utilizado para definir o número de cada opção
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
        // Reinicia o idBase para ser utilizado para obter o número da opção
        idBase = 1;

        opcoes.forEach((opcao, descricao) -> {
            boolean opcaoEscolhidaIgualAOpcaoLoop = resposta.equals(idBase.toString());

            // Se a opção escolhida for a atual do loop, executa a função dela.
            if (opcaoEscolhidaIgualAOpcaoLoop) {
                opcao.get();
            }

            idBase += 1;
        });
    }

    /**
     * Obtém a lista de opções já adicionadas.
     * 
     * @return O Hashmap das opções
     */
    public HashMap<Supplier<Object>, String> getOpcoes() {
        return opcoes;
    }
}
