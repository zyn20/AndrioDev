package com.example.bscssectionabatch20.ServiceTask;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.bscssectionabatch20.R;

import java.util.ArrayList;

public class ServiceTaskMainActivity extends AppCompatActivity {
    ImageView play,prev,next,img;
    TextView musictitle;
    SeekBar seekbarTime,seekbarVol;
    public static MediaPlayer mp;
    private Runnable rn;
    private AudioManager audioManager;
    ArrayList<Integer> songs = new ArrayList<>();
    int position;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_task_main);
        play = findViewById(R.id.playbtn);
        prev=findViewById(R.id.prevbtn);
        img=findViewById(R.id.mainimg);
        next=findViewById(R.id.nextbtn);
        seekbarTime = findViewById(R.id.seekbartime);
        seekbarVol = findViewById(R.id.seekbartimeforVol);
        songs.add(0,R.raw.small);
        songs.add(1,R.raw.baapkishan);
        songs.add(2,R.raw.sarwareanbiya);
        mp = MediaPlayer.create(getApplicationContext(),songs.get(position));




        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp!= null && mp.isPlaying())
                {
                    mp.pause();
                    play.setImageResource(R.drawable.playbtn);

                }
                else
                {
                    mp.start();
                    play.setImageResource(R.drawable.pause);

                }
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp!=null)
                {
                    play.setImageResource(R.drawable.pause);
                }
                if(position < songs.size() -1)
                {
                    position = position +1;
                }
                else {
                    position=0;
                }
                if (mp.isPlaying())
                {
                    mp.stop();
                }
                mp=MediaPlayer.create(getApplicationContext(),songs.get(position));
                mp.start();
            }
        });
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp!=null)
                {
                    play.setImageResource(R.drawable.pause);
                }
                if(position > 0)
                {
                    position--;
                }
                else {
                    position = songs.size() -1;
                }
                if (mp.isPlaying())
                {
                    mp.stop();
                }
                mp=MediaPlayer.create(getApplicationContext(),songs.get(position));
                mp.start();

            }
        });

    }
    private void songNames()
    {
        if (position==0)
        {
            musictitle.setText("Indila - Ainsi Bas La Vida");
            img.setImageResource(R.drawable.posone);


        }
        if (position==1)
        {
            musictitle.setText("Sarwar e Anbiya");
            img.setImageResource(R.drawable.postwo);

        }
        if (position==2)
        {
            musictitle.setText("Naat e Nabi");
            img.setImageResource(R.drawable.postwo);

        }

    }
}