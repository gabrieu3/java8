public class ThreadLambda {

    public static void test(){
        threadType1(1);
        threadType1(2);
        threadType1(3);
        threadType1(4);
        threadType1(5);
        threadType2(1);
        threadType2(2);
        threadType2(3);
        threadType2(4);
        threadType2(5);

    }

    private static void threadType1(Integer code){
        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("Executando um Runnable " + code);
            }

        }).start();
    }

    private static void threadType2(Integer code){
        new Thread(() -> System.out.println("Executando um Runnable type 2 " + code)).start();
    }

}
