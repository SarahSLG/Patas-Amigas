package view;

import java.util.Scanner;

import util.ReflectionUtils;

import java.lang.reflect.Field;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

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
            for (Field f : ReflectionUtils.getAllFields(classe)) {
                // Torna o atributo acessível para alterar
                f.setAccessible(true);

                // Obtém o nome do atributo
                String nomeAtributo = f.getName();

                // No caso de for umm atributo diferenciado, ele irá exibir uma informação
                // adicional de como deve ser preenchido
                String informacaoAdicional = "";

                if (f.getType().equals(LocalDate.class)) {
                    informacaoAdicional = "(Formato: \"dia/mês/ano\")";
                } else if (f.getType().equals(Boolean.class)) {
                    informacaoAdicional = "(Formato: S ou N)";
                }

                // Faz a pergunta do formulário
                System.out.println("Digite o valor para " + nomeAtributo + " " + informacaoAdicional);
                Object valor = scanner.nextLine();

                valor = verificarValor(f, valor);

                try {
                    // Define o valor do atributo do objeto
                    f.set(obj, valor);
                } catch (IllegalArgumentException e) {
                    // Caso o valor que foi assinalado a ele for inválido
                    System.err.println("Não é aceito esse tipo para esse atributo!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return obj;
    }

    private static Object verificarValor(Field f, Object entradaUsuario) {
        Object novoValor = null;

        boolean respostaVazia = entradaUsuario.equals("");

        // Uma resposta vazia indica um valor nulo
        if (respostaVazia) {
            novoValor = null;
        }

        // Verifica se o valor de entrada é um número, e se esse valor pode ser
        // assinalado ao atributo do objeto (se possuem o mesmo tipo), e daí assinala
        // esse valor como um número
        Integer tentarObterNumeroDeValor = tentarObterNumeroDeValor(f.getType(), entradaUsuario);

        boolean entradaUsuarioForNumero = tentarObterNumeroDeValor != null;

        if (entradaUsuarioForNumero) {
            return novoValor;
        }

        // Verifica se o valor de entrada é uma data, e se esse valor pode ser
        // assinalado para o atributo do objeto (se possuem o mesmo tipo), e daí
        // assinala esse valor como uma data
        entradaUsuario = tentarObterDataDeValor(entradaUsuario);

        // Verifica se o valor de entrada é um S ou N, e se o atributo é booleano e
        // assinala true para S, e false para N
        if (entradaUsuario != null) {
            return tentarObterBooleanDeValor(entradaUsuario);
        }

        return novoValor;
    }

    private static Boolean tentarObterBooleanDeValor(Object valor) {
        Boolean novoValor = null;

        if (valor.equals("S")) {
            novoValor = true;
        } else if (valor.equals("N")) {
            novoValor = false;
        }
        return novoValor;
    }

    /**
     * @param valor O valor
     * @return O valor de tipo {@code DateTime} se o valor assinalado a ele for uma
     *         data no formato 'dd/MM/yyyy'
     */
    private static Object tentarObterDataDeValor(Object valor) {
        // Tenta identificar se é uma data
        try {
            boolean valorValido = valor != null && !valor.equals("");

            // Usa um formatador para obter a data na string, e retorna a data presente nela
            if (valorValido) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                LocalDate localDate = LocalDate.parse((String) valor, dtf);

                valor = localDate;
            }
        } catch (ClassCastException ignorar) {
        } catch (DateTimeParseException ignorar) {
        }

        return valor;
    }

    /**
     * Tenta identificar se o valor digitado for um número
     * Se for, passa a entrada para o valor digitado
     * Se não, ignora e segue normalmente
     * 
     * @param <T>    O tipo da classe do objeto
     * @param classe A classe do objeto
     * @param valor  O valor
     * @return O valor de tipo número, se o valor assinalado a ele for um número
     */
    private static <T> Integer tentarObterNumeroDeValor(Class<T> classe, Object valor) {
        Integer novoNumero = null;

        try {
            boolean atributoInstanciaDeNumero = Number.class.isAssignableFrom(classe);
            boolean valorValido = valor != null && !valor.equals("");

            if (valorValido && atributoInstanciaDeNumero) {
                novoNumero = Integer.parseInt((String) valor);
            }
        } catch (NumberFormatException ignorar) {
        }

        return novoNumero;
    }
}
