package com.example.asuspc.medmyths;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import com.example.asuspc.medmyths.MainActivity;
import com.example.asuspc.medmyths.R;

public class SettingsActivity extends AppCompatActivity{

    private SeekBar volumeSeekbar = null;
    private AudioManager audioManager = null;
    MediaPlayer music;
    SoundPool sound;
    int sfxID;
    TextView tv1, tv2, tvNama;
    Typeface tf1, tf2, tfu;
    AlertDialog dialog;
    EditText editText;
    Button logoutBtn;
    ImageView kembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        setContentView(R.layout.activity_settings);
        initControls();

        logoutBtn = (Button) findViewById(R.id.btnLogout);
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        tvNama = (TextView) findViewById(R.id.txtNama);
        dialog = new AlertDialog.Builder(this).create();
        editText = new EditText(this);

        dialog.setTitle(" Change your name ");
        dialog.setView(editText);

        dialog.setButton(DialogInterface.BUTTON_POSITIVE, "SAVE TEXT", new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                tvNama.setText(editText.getText());
            }
        });

        tvNama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(tvNama.getText());
                dialog.show();
            }
        });

        tv1 = (TextView) findViewById(R.id.txtSettings);
        tv2 = (TextView) findViewById(R.id.txtMusic);

        tfu = Typeface.createFromAsset(getAssets(), "fonts/alittlepot.ttf");
        tf1 = tfu;
        tf2 = tfu;

        tv1.setTypeface(tfu);
        tv2.setTypeface(tfu);

        sound = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        sfxID = sound.load(this, R.raw.soundeffects, 1);

        music = MediaPlayer.create(SettingsActivity.this, R.raw.bgm);
        music.setLooping(true);
        music.start();

        kembali = (ImageView) findViewById(R.id.kembali);
        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SettingsActivity.this, MainActivity.class));
            }
        });
    }


    @Override
    protected void onPause(){
        super.onPause();
        music.release();
        finish();
    }

    private void initControls()
    {
        try
        {
            volumeSeekbar = (SeekBar)findViewById(R.id.seekMusic);
            audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
            volumeSeekbar.setMax(audioManager
                    .getStreamMaxVolume(AudioManager.STREAM_MUSIC));
            volumeSeekbar.setProgress(audioManager
                    .getStreamVolume(AudioManager.STREAM_MUSIC));


            volumeSeekbar.setOnSeekBarChangeListener(new OnSeekBarChangeListener()
            {
                @Override
                public void onStopTrackingTouch(SeekBar arg0)
                {
                }

                @Override
                public void onStartTrackingTouch(SeekBar arg0)
                {
                }

                @Override
                public void onProgressChanged(SeekBar arg0, int progress, boolean arg2)
                {
                    audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,
                            progress, 0);
                }
            });
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void playsfx(View view) {
        sound.play(sfxID,1, 1, 1,0, 1);
    }
}
