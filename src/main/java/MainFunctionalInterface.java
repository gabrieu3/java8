import util.U;

import java.util.function.Function;

public class MainFunctionalInterface {
    public static void test() {
        oldSchool();
        newSchool();
        newSchool2();
        referenceMethodNew();
        function();
    }

    private static void oldSchool() {
        IFunctionalInterface functionalInterface = new FunctionalInterfaceImpl();
        functionalInterface.print("Gabriel");
        functionalInterface.printAbstract("Gabriel Abstrato");
    }

    private static void newSchool() {
        IFunctionalInterface functionalInterface = new IFunctionalInterface() {
            @Override
            public void printAbstract(String s) {
                System.out.println("Implementei a interface: " + s);
            }
        };
        functionalInterface.print("Gabriel");
        functionalInterface.printAbstract("Gabriel Abstrato");
    }

    private static void newSchool2() {
        IFunctionalInterface functionalInterface = s -> System.out.println("usei lambda: " + s);
        functionalInterface.print("Gabriel");
        functionalInterface.printAbstract("Gabriel Abstrato");
    }

    private static void referenceMethodNew() {
        IFunctionalInterface functionalInterface = System.out::println;
        functionalInterface.print("Gabriel");
        functionalInterface.printAbstract("Gabriel Abstrato");
    }

    private static void function(){
        Function<String, Integer> func = String::length;
        U.print(func.apply("Gabriel Balestrin").toString());
        U.print(U.rpad("Gabriel Balestrin -> ",100,"*"));
    }

}
