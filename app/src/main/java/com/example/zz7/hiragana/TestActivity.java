package com.example.zz7.hiragana;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.zz7.hiragana.R;

import java.util.Random;

public class TestActivity extends AppCompatActivity {

    private String[] questions_array;
    private String[] answers_array;

    private String rightId = " ";

    private TextView question;
    private TextView correctTextView;
    private TextView wrongTextView;

    private RadioGroup selections;

    private RadioButton item1;
    private RadioButton item2;
    private RadioButton item3;
    private RadioButton item4;

    private RadioButton[] all = new RadioButton[4];

    int correct = 0;
    int wrong = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        questions_array = getResources().getStringArray(R.array.questions);
        answers_array = getResources().getStringArray(R.array.answers);

        all[0] = (RadioButton) findViewById(R.id.item1);
        all[1] = (RadioButton) findViewById(R.id.item2);
        all[2] = (RadioButton) findViewById(R.id.item3);
        all[3] = (RadioButton) findViewById(R.id.item4);


        question = (TextView) findViewById(R.id.question);
        correctTextView = (TextView) findViewById(R.id.correct);
        wrongTextView = (TextView) findViewById(R.id.wrong);
        selections= (RadioGroup) findViewById(R.id.selections);

        refreshQuestion();

        selections.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                String s=getResources().getResourceEntryName(checkedId);
                Log.e("checkid", s);

                if (rightId.equals(s))
                    correct++;
                else
                    wrong++;

                correctTextView.setText(String.valueOf(correct));
                wrongTextView.setText(String.valueOf(wrong));

               // selections.clearCheck();//bug

                refreshQuestion();

                RadioButton tmp= (RadioButton) findViewById(checkedId);
                tmp.setChecked(false);
            }
        });

    }

    public void refreshQuestion()

    {
        int idx = new Random().nextInt(questions_array.length);
        int buttonIdx = new Random().nextInt(4);

        RadioButton answer = all[buttonIdx];

        rightId = "item" + (buttonIdx + 1);
        Log.e("rightid", rightId);

        question.setText(questions_array[idx]);
        answer.setText(answers_array[idx]);

        for (int i = 0; i < 4; i++) {
            if (i != buttonIdx) {
                int index = (idx + (i+1)* 5) % answers_array.length;
                all[i].setText(answers_array[index]);
            }
        }
    }

}
