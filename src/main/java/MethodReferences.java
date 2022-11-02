import org.apache.maven.shared.utils.StringUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class MethodReferences {

    public static void test(){
        //Lista de Nomes
        List<String> list = new ArrayList<>();
        list.add("João");
        list.add("Carlos");
        list.add("Maria");
        list.add("Madalena");
        list.add("Jesus");
        list.add("Matheus");
        list.add("Vaz");

        System.out.println("OLD SCHOOL:");
        sortComparatorWithoutLambda2(list);
        printList(list, StringUtils.rightPad("sortComparatorWithoutLambda",30) );

        /**
         * Factoring de comparator já informando a classe Anonima/Lambda que deve ser usada para comparar
         */
        System.out.println("NEW SCHOOL:");
        sortComparatorWithLambda1(list);
        printList(list, StringUtils.rightPad("sortComparatorWithLambda1",30) );

        System.out.println("NEW SCHOOL 2:");
        sortComparatorWithLambda2(list);
        printList(list, StringUtils.rightPad("sortComparatorWithLambda2",30) );
     }

    private static void sortComparatorWithoutLambda1(List<String> list){
        /**
         * Recebe uma String
         * Retorna um Inteiro
         */
        Function<String, Integer> function = new SortBySize();
        /**
         * Factory de Comparator
         */
        Comparator<String> comparator = Comparator.comparing(function);

        list.sort(comparator);
    }

    private static class SortBySize implements Function<String, Integer>{

        @Override
        public Integer apply(String s) {
            return s.length();

        }
    }


    private static void sortComparatorWithoutLambda2(List<String> list){
        /**
         * Recebe uma String
         * Retorna um Inteiro
         */
        Function<String, Integer> function = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };
        /**
         * Factory de Comparator
         */
        Comparator<String> comparator = Comparator.comparing(function);

        list.sort(comparator);
    }

    private static void sortComparatorWithLambda1(List<String> list){
        list.sort(Comparator.comparing(s -> s.length()));
    }

    private static void sortComparatorWithLambda2(List<String> list){
        /**
         * String::lenght pode ser entendido como uma uma função que recebe uma string e retorna o lenght
         * Mas na verdade é uma classe que implementa uma interface e essa interface tem um método abstrato que precisa ser implementado
         */
        list.sort(Comparator.comparing(String::length));
    }

    private static void printList(List<String> list, String messageBefore){
        System.out.println(messageBefore+":");
        System.out.println(list.toString()+"\n");
        /**
         * LAMBDA
         */
        Consumer<String> consumer1 = s -> System.out.println(s);
        /**
         * Reference Method - USADO SOMENTE PARA Interfaces com um único método abstrado.
         * Se a interface possuir mais de um método não vai funcionar.
         */
        Consumer<String> consumer2 = System.out::println;
        list.forEach(consumer2);

        //list.forEach(System.out::println);

    }

}
