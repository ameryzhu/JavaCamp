import java.util.concurrent.*;

public class MyThread {

    public static void main(String[] args) {
        method1();
    }

    public static void method1() {
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                CalculateResult c = new CalculateResult();
                Thread.sleep(1000);
                return c.getResult();
            }
        };
        try {
            System.out.println("get future result:" + callable.call());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
