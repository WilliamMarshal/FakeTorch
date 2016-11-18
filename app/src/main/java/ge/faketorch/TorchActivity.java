package ge.faketorch;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

public class TorchActivity extends AppCompatActivity {

    private View mContainer;
    private TextView mTimerLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torch);

        findViewById(R.id.on_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewDisappear(view);
            }
        });

        mContainer = findViewById(R.id.container);
        mTimerLabel = (TextView) findViewById(R.id.timer_lbl);
    }


    private void viewDisappear(final View view) {
        Animation alphaAnim = new AlphaAnimation(1f, 0f);
        alphaAnim.setDuration(300);

        view.startAnimation(alphaAnim);
        view.postOnAnimation(new Runnable() {
            @Override
            public void run() {
                view.setVisibility(View.GONE);
                startTimer();
            }
        });
    }

    private void startTimer() {
        new CountDownTimer(Integer.MAX_VALUE, 1000) {
            int counter = 5;

            @Override
            public void onTick(long l) {
                mTimerLabel.setText(counter + "");
                if (counter == 0) {
                    mTimerLabel.setVisibility(View.GONE);
                    Terminator.terminate(this);
                }
                counter--;
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }
}
