import org.apache.maven.shared.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class LoopLambda {

    public static void test() {
        //Lista de Nomes
        List<String> list = new ArrayList<>();
        list.add("João");
        list.add("Carlos");
        list.add("Maria");
        list.add("Madalena");
        list.add("Jesus");
        list.add("Matheus");
        list.add("Vaz");

        System.out.print(StringUtils.rightPad("loopOldOldSchool", 30) + "-> ");
        loopOldOldSchool(list);
        System.out.println(" ");

        System.out.print(StringUtils.rightPad("loopOldSchool", 30) + "-> ");
        loopOldSchool(list);
        System.out.println(" ");

        System.out.print(StringUtils.rightPad("loopNewSchool", 30) + "-> ");
        loopNewSchool(list);
        System.out.println(" ");

        System.out.print(StringUtils.rightPad("loopAnonymousClass1", 30) + "-> ");
        loopAnonymousClass1(list);
        System.out.println(" ");

        System.out.print(StringUtils.rightPad("loopAnonymousClass2", 30) + "-> ");
        loopAnonymousClass2(list);
        System.out.println(" ");

        System.out.print(StringUtils.rightPad("loopLambda1", 30) + "-> ");
        loopLambda1(list);
        System.out.println(" ");

        System.out.print(StringUtils.rightPad("loopLambda2 ", 30) + "-> ");
        loopLambda2(list);

    }

    private static void printList(List<String> list, String messageBefore) {
        System.out.println(messageBefore + ":");
        System.out.println(list.toString() + "\n");
    }

    private static void loopOldOldSchool(List<String> list) {

        //Loop a moda antiga
        for (int i = 0; i < list.size(); i++)
            System.out.print(list.get(i) + " ");

    }

    private static void loopOldSchool(List<String> list) {

        //Loop a moda antiga
        for (String name : list)
            System.out.print(name + " ");

    }

    private static void loopNewSchool(List<String> list) {
        list.forEach(new PrintNameOnTheLine());
    }

    private static void loopAnonymousClass1(List<String> list) {
        /**
         * Consumer é uma interface e não pode ser instânciada a menos que seja possível implementar os métodos abstratos
         */
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.print(s + " ");
            }
        };
        list.forEach(consumer);
    }

    private static void loopAnonymousClass2(List<String> list) {
        /**
         * Consumer é uma interface e não pode ser instânciada a menos que seja possível implementar os métodos abstratos
         */
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.print(s + " ");
            }
        });
    }

    private static void loopLambda1(List<String> list) {
        /**
         * Consumer é uma interface e não pode ser instânciada a menos que seja possível implementar os métodos abstratos
         */
        /**
         * list.forEach(new Consumer<String>() {
        @Override public void accept(String s) {
        System.out.print(s+" ");
        }
        });*/
        list.forEach((String s) -> {
            System.out.print(s + " ");
        });
    }

    /**
     * LAMBDA with TOP Sintaxe Sugar
     *
     * @param list
     */
    private static void loopLambda2(List<String> list) {
        list.forEach(s -> System.out.print(s + " "));
    }

    private static class PrintNameOnTheLine implements Consumer<String> {

        @Override
        public void accept(String s) {
            System.out.print(s + " ");
        }
    }
}
