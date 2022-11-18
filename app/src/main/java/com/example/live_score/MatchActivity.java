package com.example.live_score;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MatchActivity extends AppCompatActivity {

    private String hometeam;
    private String awayteam;
    private String winner;
    private Uri winnerImg;
    private int homescore;
    private int awayscore;
    private TextView scoreHome;
    private TextView scoreAway;
    private TextView homeText;
    private TextView awayText;
    private CircleImageView homeLogo;
    private CircleImageView awayLogo;
    private Button addHome1;
    private Button addHome2;
    private Button addHome3;
    private Button addAway1;
    private Button addAway2;
    private Button addAway3;
    private Button cekResult;
    private Button resetResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);
        homeText = findViewById(R.id.txt_home);
        awayText = findViewById(R.id.txt_away);
        scoreHome = findViewById(R.id.score_home);
        scoreAway = findViewById(R.id.score_away);
        homeLogo = findViewById(R.id.home_logo);
        awayLogo = findViewById(R.id.away_logo);
        addHome1 = findViewById(R.id.btn_add_home1);
        addHome2 = findViewById(R.id.btn_add_home2);
        addHome3 = findViewById(R.id.btn_add_home3);
        addAway1 = findViewById(R.id.btn_add_away);
        addAway2 = findViewById(R.id.btn_add_away2);
        addAway3 = findViewById(R.id.btn_add_away3);
        cekResult = findViewById(R.id.btn_result);
        resetResult = findViewById(R.id.btn_reset);

        homescore = 0;
        awayscore = 0;
        scoreHome.setText(String.valueOf(homescore));
        scoreAway.setText(String.valueOf(awayscore));

        Bundle bundle = getIntent().getExtras();
        hometeam = bundle.getString("namahome");
        homeText.setText(hometeam);
        awayteam = bundle.getString("namaaway");
        awayText.setText(awayteam);
        homeLogo.setImageURI(Uri.parse(bundle.getString("homeImg")));
        awayLogo.setImageURI(Uri.parse(bundle.getString("awayImg")));

        addHome1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homescore += 1;
                scoreHome.setText(String.valueOf(homescore));
            }
        });

        addHome2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homescore += 2;
                scoreHome.setText(String.valueOf(homescore));
            }
        });

        addHome3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homescore += 3;
                scoreHome.setText(String.valueOf(homescore));
            }
        });

        addAway1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                awayscore += 1;
                scoreAway.setText(String.valueOf(awayscore));
            }
        });

        addAway2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                awayscore += 2;
                scoreAway.setText(String.valueOf(awayscore));
            }
        });

        addAway3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                awayscore += 3;
                scoreAway.setText(String.valueOf(awayscore));
            }
        });

        cekResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                winner = "empty";
                if (homescore > awayscore){
                    winner = hometeam;
                    winnerImg = Uri.parse(bundle.getString("homeImg"));
                }else if(homescore == awayscore){
                    winner = "draw";
                }else{
                    winner = awayteam;
                    winnerImg = Uri.parse(bundle.getString("awayImg"));;
                }
                Intent Pindah = new Intent(MatchActivity.this, ResultActivity.class);
                Pindah.putExtra("winner",winner);
                Pindah.putExtra("winnerImg",winnerImg.toString());
                startActivity(Pindah);
            }
        });

        resetResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homescore = 0;
                awayscore = 0;
                scoreHome.setText(String.valueOf(homescore));
                scoreAway.setText(String.valueOf(awayscore));
            }
        });
    }
}