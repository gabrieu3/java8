
@FunctionalInterface
public interface IFunctionalInterface {

    default void print(String s){
        System.out.println(s);
    }

    public void printAbstract(String s);
}
