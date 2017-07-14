package com.jcodee.mod3class5;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.rbMusica1)
    RadioButton rbMusica1;
    @BindView(R.id.rbMusica2)
    RadioButton rbMusica2;
    @BindView(R.id.rbMusica3)
    RadioButton rbMusica3;
    private MediaPlayer mediaPlayer;

    private int musica = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        rbMusica1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stop();
                musica = R.raw.developers;
                play();
            }
        });
        rbMusica2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stop();
                musica = R.raw.danny;
                play();
            }
        });
        rbMusica3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stop();
                musica = R.raw.piso;
                play();
            }
        });
    }

    @OnClick(R.id.btnPlay)
    public void onBtnPlayClicked() {
        if (musica > 0) {
            if (mediaPlayer == null) {
                mediaPlayer = MediaPlayer.create(MainActivity.this, musica);
            }
            if (!mediaPlayer.isPlaying()) {
                mediaPlayer.start();
            }
        } else {
            Toast.makeText(this, "Seleccione música", Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.btnPause)
    public void onBtnPauseClicked() {
        if (mediaPlayer != null) {
            mediaPlayer.pause();
        }
    }

    @OnClick(R.id.btnStop)
    public void onBtnStopClicked() {
        stop();
    }

    private void stop() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer = null;
        }
    }

    private void play() {
        mediaPlayer = MediaPlayer.create(MainActivity.this, musica);
        mediaPlayer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mediaPlayer != null) {
            mediaPlayer.pause();
        }
    }
}
