package ge.faketorch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;

public class TorchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_torch);

        Button onButton = (Button) findViewById(R.id.on_btn);
        onButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewDissapear(view);
            }
        });
    }
    private void viewDissapear(final View view) {
        Animation alphaAnim = new AlphaAnimation(1f, 0f);
        alphaAnim.setDuration(300);

        view.startAnimation(alphaAnim);
        view.postOnAnimation(new Runnable() {
            @Override
            public void run() {
                view.setVisibility(View.GONE);
            }
        });
    }
}
