package pt.ubi.di.pdm.a46346_t6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class gameOver extends AppCompatActivity implements View.OnClickListener {
    private TextView tvscore;
    private TextView lstGame;

    private Button btnmenu;
    private Button btnshare;
    private Button btnclassific;

    private String score_gm;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameover_layout);

        Intent ilevel = getIntent();
        score_gm = ilevel.getStringExtra("score");

        tvscore = findViewById(R.id.scoreGo);
        lstGame = findViewById(R.id.lstgame);


        btnmenu = (Button) findViewById(R.id.menu);
        btnshare = (Button) findViewById(R.id.share);
        btnclassific = (Button) findViewById(R.id.classifica);

        btnmenu.setOnClickListener(this);
        btnshare.setOnClickListener(this);
        btnclassific.setOnClickListener(this);

        tvscore.setText("score: "+score_gm);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.menu:
                Intent iActivity =
                        new Intent ( this , MainActivity.class) ;
                startActivity ( iActivity ) ;
                break;
            case R.id.share:

                break;
            case R.id.classifica:

                break;
            default:
                break;
        }
    }
}
