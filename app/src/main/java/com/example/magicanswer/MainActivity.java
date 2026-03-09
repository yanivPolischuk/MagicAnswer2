package com.example.magicanswer;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String[] answers = {"yes", "no", "maybe", "Ask again later", "I don't know"};
        //פשוט הלכתי לcolor picker ובחרתי צבעים שנראים לי נחמדים
        int[] colors = {
                Color.parseColor("#7fc982"),
                Color.parseColor("#42c9b7"),
                Color.parseColor("#9542c9"),
                Color.parseColor("#bf54ad"),
                Color.parseColor("#5e8abd")
        };
        float[] textSize = {18f, 24f, 30f, 36f, 42f};
        Button btn = findViewById(R.id.button);
        TextView txtv = findViewById(R.id.text);
        Random random = new Random();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number = random.nextInt(5); //0-4
                int color = random.nextInt(5);
                int size = random.nextInt(5);
                txtv.setText(answers[number]);
                btn.setBackgroundColor(colors[color]);
                txtv.setTextSize(textSize[size]);
            }
        });
    }
}