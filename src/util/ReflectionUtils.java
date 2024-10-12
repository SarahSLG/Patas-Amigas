package util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Coleção de métodos úteis para uso da Reflection API
 * 
 * @author Fernando Freitas
 */
public class ReflectionUtils {
    /**
     * Obtém todos os atributos de uma classe que possui apenas uma superclasse
     * 
     * @param <T> O tipo da classe do objeto
     * @param cls A classe
     * @return A lista de todos os atributos juntos
     */
    public static <T> List<Field> getAllFields(Class<T> cls) {
        if (cls == null) {
            return new ArrayList<>();
        }

        List<Field> joinedFields = new ArrayList<>();

        List<Field> fieldsClass = Arrays.asList(cls.getDeclaredFields());
        List<Field> fieldsSuperClass = getAllFields(cls.getSuperclass());

        joinedFields.addAll(fieldsSuperClass);
        joinedFields.addAll(fieldsClass);

        return joinedFields;
    }
}
