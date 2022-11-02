import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortStrings {

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
        SortStrings.sortOldSchool(list);

        System.out.println("NEW SCHOOL:");
        SortStrings.sortNewSchool(list);

        System.out.println("SORT LAMBDA:");
        sortLambda(list);

    }
    private static void sortOldSchool(List<String> list){

        //Ordena usando a ordem alfabética
        Collections.sort(list);
        printList(list,"Ordem Alfabética");

        //Ordena pelo tamanho do nome
        Comparator comparator = new OrderByStringSize();
        Collections.sort(list, comparator);
        printList(list,"Ordem Tamanho");

        //Ordena pela última letra do nome
        comparator = new OrderByLastCharAlpha();
        Collections.sort(list, comparator);
        printList(list,"Ordem Última Letra");

    }
    private static void sortNewSchool(List<String> list){

        list.sort(new OrderByStringSize());
        printList(list,"Ordem Tamanho");

        list.sort(new OrderByLastCharAlpha());
        printList(list,"Ordem Última Letra");

    }

    private static void sortLambda(List<String> list){

        list.sort((s1,s2) -> Integer.compare(s1.length(),s2.length()));
        printList(list,"Ordem Tamanho Lambda");

    }
    private static void printList(List<String> list, String messageBefore){
        System.out.println(messageBefore+":");
        System.out.println(list.toString()+"\n");
    }
    private static class OrderByStringSize implements Comparator<String>{

        @Override
        public int compare(String string1, String string2) {
            //String1 é menor que a String2 portanto retornar -1
            if(string1.length() < string2.length())
                return -1;
            //String1 é maior que a String2 portanto retornar 1
            if(string1.length() < string2.length())
                return 1;
            //Igual retornar 0
            return 0;
        }
    }
    private static class OrderByLastCharAlpha implements Comparator<String>{

        @Override
        public int compare(String string1, String string2) {
            Integer position1 = string1.length() -1;
            Integer position2 = string2.length() -1;
            //A última letra é menor
            if(string1.charAt(position1) < string2.charAt(position2))
                return -1;
            //A primeira letra é menor
            if(string1.charAt(position1) > string2.charAt(position2))
                return 1;
            //Igual retornar 0
            return 0;
        }
    }
}
