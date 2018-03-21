package com.example.asuspc.medmyths;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.example.asuspc.medmyths.Utils.SPManager;
import com.facebook.appevents.AppEventsLogger;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends BaseActivity {

    private TimerTask tt;
    private Timer timer;
    private final static int SPLASH_TIME = 850;
    private boolean isCancelled = false;

    @BindView(R.id.ivLogo)
    ImageView ivLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        final Boolean isRegister = SPManager.getIsRegister(this);
        ivLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isRegister) {
                    timer.cancel();
                    runApp();
                } else {
                    timer.cancel();
                    runNotLoggedInApp();
                }

            }
        });

    }

    @Override
    protected void onStart() {
        setupTimer();
        super.onStart();
    }

    private void setupTimer() {
        timer = new Timer();
        tt = new TimerTask() {
            @Override
            public void run() {
                runNotLoggedInApp();
            }
        };
        timer.schedule(tt, SPLASH_TIME);
    }

    private void runNotLoggedInApp() {
        if (!isCancelled) {
            Intent i = new Intent(this, LoginActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
            startActivity(i);
            overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
            finish();
        }
    }

    private void runApp() {
        if (!isCancelled) {
            Intent i = new Intent(this, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
            startActivity(i);
            overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
            finish();
        }
    }


    @Override
    public void onBackPressed() {
        isCancelled = true;
        timer.cancel();
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Logs 'install' and 'app activate' App Events.
        AppEventsLogger.activateApp(this);
    }

}
