package com.gyj.henpin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.gyj.henpin.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private int currentIndex=0;
    private ActivityMainBinding binding;
    private List<Question> questionLists= Arrays.asList(
            new Question(R.string.question1,true),
            new Question(R.string.question2,true),
            new Question(R.string.question3,false),
            new Question(R.string.question4,true),
            new Question(R.string.question5,false),
            new Question(R.string.question6,true)

    );


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.true1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true);
            }
        });
        binding.false1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);
            }
        });
        binding.textView1.setText(questionLists.get(currentIndex).getTextResId());
        binding.next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentIndex = (currentIndex + 1)%questionLists.size();
                updateQuestion();
            }
        });
    }
    private  void checkAnswer(boolean userAnswer){
        final boolean correntAnswer = questionLists.get(currentIndex).isAnswer();
        int msgId = correntAnswer ==userAnswer ? R.string.corrcet : R.string.incorrect;
        Toast.makeText(this,msgId,Toast.LENGTH_SHORT).show();
    }
    private void updateQuestion(){
        int resId = questionLists.get(currentIndex).getTextResId();
        binding.textView1.setText(resId);
    }
}