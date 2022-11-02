package simple;

public interface X<T,U> {
    U f0(T t);

    void f1(T t, U u);

    U f2(T t, U u);

    T f3(T t, U u);

    X<T,U> f4(T t, U u);
}
