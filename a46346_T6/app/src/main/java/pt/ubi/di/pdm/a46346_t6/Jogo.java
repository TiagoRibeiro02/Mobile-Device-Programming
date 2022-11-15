package pt.ubi.di.pdm.a46346_t6;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Random;

public class Jogo extends AppCompatActivity {
    private static final long START_TIME_IN_MILLIS = 60000;

    private TextView count;
    private TextView score;
    private TextView mTextViewCountDown;

    private EditText result;

    private Button mButtonStart;
    private Button resultbtn;

    private CountDownTimer mCountDownTimer;

    private boolean mTimerRunning;

    public int level;

    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;



    Game g = new Game();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jogo_layout);
        Intent ilevel = getIntent();
        level = ilevel.getIntExtra("x", 0);

        result = findViewById(R.id.result);
        resultbtn= findViewById(R.id.submit);

        score = findViewById(R.id.score_2);

        mTextViewCountDown = findViewById(R.id.text_view_countdown);
        mButtonStart = findViewById(R.id.button_start_pause);
        count = findViewById(R.id.count);




        View.OnClickListener startButtonCL = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Button start_button = (Button) v;
                    startTimer();
                    result.setVisibility(v.VISIBLE);
                    resultbtn.setVisibility(v.VISIBLE);
                    count.setVisibility(v.VISIBLE);
                    mButtonStart.setVisibility(v.INVISIBLE);
                    nextTurn();
            }
        };

        View.OnClickListener answerButtonCL = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button answer_button = (Button) v;
                String a = result.getText().toString();


                if (!a.isEmpty()) {
                    int answer = Integer.parseInt(result.getText().toString());
                    if (g.checkAnswer(answer)) {
                        score.setText(Integer.toString(g.getScore()));
                        nextTurn();
                    } else {
                        Toast.makeText(getApplicationContext(), "Errou",
                                Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(getApplicationContext(), "Missing answer!",
                            Toast.LENGTH_SHORT).show();
                }


            }
        };
        mButtonStart.setOnClickListener(startButtonCL);
        resultbtn.setOnClickListener(answerButtonCL);



        updateCountDownText();
    }



    private void nextTurn(){
        if (level == 1){
            Random r = new Random();
            int c = r.nextInt(2);
            if (c == 1){
                g.makeNewQuestionPlus();
                count.setText(g.getCurrentQuestion().getQuestionPhrase());
            }
            else {
                g.makeNewQuestionMinus();
                count.setText(g.getCurrentQuestion().getQuestionPhrase());
            }
        }
        else if (level == 2){
            Random r1 = new Random();
            int c1 = r1.nextInt(4);

            if (c1 == 1){
                g.makeNewQuestionPlus();
                count.setText(g.getCurrentQuestion().getQuestionPhrase());
            }
            else if (c1 == 2){
                g.makeNewQuestionMinus();
                count.setText(g.getCurrentQuestion().getQuestionPhrase());
            }
            else if (c1 == 3){
                g.makeNewQuestionDivision();
                count.setText(g.getCurrentQuestion().getQuestionPhrase());
            }
            else {
                g.makeNewQuestionTimes();
                count.setText(g.getCurrentQuestion().getQuestionPhrase());
            }
        }
        else if (level == 3){
            Random r2 = new Random();
            int c2 = r2.nextInt(4);

            if (c2 == 1){
                g.makeNewQuestionPlus();
                count.setText(g.getCurrentQuestion().getQuestionPhrase());
            }
            else if (c2 == 2){
                g.makeNewQuestionMinus();
                count.setText(g.getCurrentQuestion().getQuestionPhrase());
            }
            else if (c2 == 3){
                g.makeNewQuestionDivision();
                count.setText(g.getCurrentQuestion().getQuestionPhrase());
            }
            else {
                g.makeNewQuestionTimes();
                count.setText(g.getCurrentQuestion().getQuestionPhrase());
            }
        }
        else{

        }

    }





    private void startTimer() {
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                mButtonStart.setVisibility(mTextViewCountDown.INVISIBLE);
                result.setVisibility(mTextViewCountDown.INVISIBLE);
                resultbtn.setVisibility(mTextViewCountDown.INVISIBLE);
                count.setVisibility(mTextViewCountDown.INVISIBLE);
                Intent iActivity =
                        new Intent ( Jogo.this , gameOver.class) ;
                iActivity.putExtra("score", score.getText().toString());
                startActivity ( iActivity ) ;
                finish();
            }

        }.start();

        mTimerRunning = true;
    }

    private void updateCountDownText() {
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        mTextViewCountDown.setText(timeLeftFormatted);
    }


}