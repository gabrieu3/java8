import simple.X;
import simple.XImpl;
import util.U;

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
        //ThreadLambda.test();
        //MethodReferences.test();
        //MainFunctionalInterface.test();
        X<String,Integer> x = new XImpl();
        X<String,Integer> y = x.f4("Gabriel",34);
        Boolean equal = false;
        U.print(x.toString());
        U.print(y.toString());
        if(x.equals(y)){
            equal = true;
        }
        U.print(equal.toString());
    }
}
