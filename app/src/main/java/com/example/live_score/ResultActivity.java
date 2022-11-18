package com.example.live_score;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class ResultActivity extends AppCompatActivity {

    private TextView result;
    private CircleImageView logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        result = findViewById(R.id.textView3);
        result.setText(getIntent().getExtras().getString("winner") + " 🥇♥");
        logo = findViewById(R.id.logo);
        logo.setImageURI(Uri.parse(getIntent().getExtras().getString("winnerImg")));
    }
}