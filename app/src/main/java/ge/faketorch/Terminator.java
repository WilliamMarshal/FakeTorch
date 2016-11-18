package ge.faketorch;

import android.os.CountDownTimer;

/**
 * Created by akaki on 18.11.16.
 */

public class Terminator {
    public static void terminate(final CountDownTimer timer) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (timer) {
                    timer.cancel();
                }
            }
        }).start();
    }
}
