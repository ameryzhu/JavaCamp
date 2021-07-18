import java.util.concurrent.*;

public class MyThread4 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                CalculateResult calculateResult =new CalculateResult();
                return calculateResult.getResult();
            }
        };
        Future<String> future = executorService.submit(callable);
        try {
            System.out.println("MyThread4: "+future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }



}


