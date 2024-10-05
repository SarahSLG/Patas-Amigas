package view;

import java.util.Scanner;
import java.lang.reflect.Field;

public class FormularioCriarObjeto {
    /**
     * Inicia uma série de procedimentos para criar um objeto de uma classe
     * {@code T}. Obtém os atributos da classe do objeto e cria um formulário no
     * terminal para que o usuário preencha todas as informações.
     * 
     * @param <T>     O Tipo do objeto a ser criado
     * @param scanner O objeto scanner a receber a entrada do usuário
     * @param classe  A classe do objeto a ser criado
     * @return O Objeto
     */
    public static <T> T criarObjeto(Scanner scanner, Class<T> classe) {
        T obj = null;

        try {
            obj = classe.getConstructor().newInstance();

            // Para cada atributo da classe do objeto que será criado
            for (Field f : classe.getDeclaredFields()) {
                // Torna o atributo acessível para alterar
                f.setAccessible(true);

                // Obtém o nome do atributo
                String nomeAtributo = f.getName();

                // Faz a pergunta do formulário
                System.out.println("Digite o valor para " + nomeAtributo);
                Object valor = scanner.nextLine();

                boolean respostaVazia = valor.equals("");

                // Uma resposta vazia indica um valor nulo, do contrário ele faz um 'casting'
                // para que o tipo do atributo seja o mesmo do valor de entrada
                if (respostaVazia) {
                    valor = null;
                } else {
                    // valor = f.getType().cast(valor);
                }

                Integer valorNumero = null;

                // Tenta identificar se o valor digitado for um número
                // Se for, passa a entrada para o valor digitado
                // Se não, ignora e segue normalmente
                try {
                    if (valor != null) valorNumero = Integer.parseInt((String) valor);
                } catch (NumberFormatException ignorar) {}

                if (valorNumero != null) {
                    valor = valorNumero;
                }

                try {
                    // Define o valor do atributo do objeto
                    f.set(obj, valor);
                } catch (IllegalArgumentException e) {
                    System.err.println("Não é aceito esse tipo para esse atributo!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return obj;
    }
}
