import java.util.Random;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class CallCenter {
    public final int ACTION_TIME = 2000;
    public final int QUANTITY_CALLS = 8;

    private final TransferQueue<String> callQueue;
    private int counter;
    private boolean flag = true;

    public CallCenter() {
        callQueue = new LinkedTransferQueue<>();
    }

    public void call(){
        String call;
        try {
            for (counter = 1; counter <= QUANTITY_CALLS; counter++) {
                call = "Звонок " + counter;
                System.out.println(call + " поступил в Колл-центр");
                callQueue.put(call);
                Thread.sleep(ACTION_TIME);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (counter > QUANTITY_CALLS) {
                flag = false;
            }
        }
    }

    public void takeTheCall(){
        Random random = new Random();
        try {
            Thread.sleep(ACTION_TIME);
            while (flag) {
                Thread.sleep(ACTION_TIME);
                System.out.println(Thread.currentThread().getName() + " ответил на " + callQueue.take());
                Thread.sleep(ACTION_TIME + random.nextInt(5 * 1000));
                System.out.println(Thread.currentThread().getName() + " освободился");
                Thread.sleep(ACTION_TIME);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
