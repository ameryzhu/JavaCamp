public class MyThread3 {
    public volatile String result;

    public static void main(String[] args) {
        MyThread3 t3 = new MyThread3();
        t3.startThread();
    }

    public void startThread() {
        try {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    CalculateResult mResult = new CalculateResult();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    result = mResult.getResult();
                }
            });
            t.start();
            t.join();
            System.out.println("final result:" + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
