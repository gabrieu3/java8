import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        /**
         * Por que o LIST passou a ter o método sort a partir do Java 8?
         * @InterfaceFunctional - Melhoria nas interfaces,
         * as interfaces passam a ter métodos funcionais com o prefixo "default".
         * Interface Funcional é a interface que só tem um método, por isso é possivel utilizar o lambda
         */
        //SortStrings.test();
        //LoopLambda.test();
        ThreadLambda.test();
    }
}
