package view;

import java.util.Scanner;
import java.lang.reflect.Field;

public class FormularioCriarObjeto {
    /**
     * Inicia uma série de procedimentos para criar um objeto de uma classe {@code T}
     * 
     * @param <T> O Tipo do objeto a ser criado
     * @param scanner O objeto scanner a receber a entrada do usuário
     * @param classe A classe do objeto a ser criado
     * @return O Objeto
     */
    public static <T> T criarObjeto(Scanner scanner, Class<T> classe) {
        T obj = null;

        try {
            obj = classe.getConstructor().newInstance();

            for (Field f : classe.getDeclaredFields()) {
                // Torna o atributo acessível para alterar
                f.setAccessible(true);

                String nomeAtributo = f.getName();

                System.out.println("Digite o valor para " + nomeAtributo);
                Object valor = scanner.nextLine();

                if (valor.equals("")) {
                    valor = null;
                } else {
                    valor = f.getType().cast(valor);
                }

                f.set(obj, valor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return obj;
    }
}
