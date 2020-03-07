package com.example.flashy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.question).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.question).setVisibility(View.INVISIBLE);
                findViewById(R.id.answer).setVisibility((View.VISIBLE));
            }
        });

        findViewById(R.id.Add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityB.class);
                MainActivity.this.startActivityForResult(intent,111);
            }

        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if ((requestCode == 111) && (data != null)) {
            String Question = data.getExtras().getString("Question");
            String Answer = data.getExtras().getString("Answer");
            setContentView(R.layout.activity_main);

            ((TextView) findViewById(R.id.question)).setText(Question);
            ((TextView)findViewById(R.id.answer)).setText(Answer);

            findViewById(R.id.question).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    findViewById(R.id.question).setVisibility(View.INVISIBLE);
                    findViewById(R.id.answer).setVisibility((View.VISIBLE));
                }
            });

        }
    }
}
