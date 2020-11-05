package com.coursework.forhealth;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class TextContentActivity extends AppCompatActivity {
    private Typeface textFace;
    private TextView textContent;
    private ImageView imageContent;
    private int categoryIndex;
    private int positionIndex;
    private int[] array_exercises = {R.string.exercises_1, R.string.exercises_2, R.string.exercises_3, R.string.exercises_4};
    private int[] array_exercises_image = {R.drawable.exercises_1, R.drawable.exercises_2, R.drawable.exercises_3, R.drawable.exercises_4};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_content);
        init();
        receiveIntent();
    }

    private void receiveIntent() {
        Intent i = getIntent();
        if (i != null) {
            categoryIndex = i.getIntExtra("categoryIndex", 0);
            positionIndex = i.getIntExtra("positionIndex", 0);
        }
        switch (categoryIndex) {
            case 0:
                imageContent.setImageResource(array_exercises_image[positionIndex]);
                textContent.setText(array_exercises[positionIndex]);
                break;
            case 1:
                break;
            case 2:
                break;
        }
    }

    private void init() {
        textContent = findViewById(R.id.text_main_content);
        imageContent = findViewById(R.id.image_content);
        textFace = Typeface.createFromAsset(this.getAssets(),"font/Montserrat-Bold.ttf");
        textContent.setTypeface(textFace);
    }
}
