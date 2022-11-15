package pt.ubi.di.pdm.a46346_t6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Niveis extends AppCompatActivity implements View.OnClickListener {
    Button oButtonNiv1;
    Button oButtonNiv2;
    Button oButtonNiv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.niveis_layout);

        oButtonNiv1 = (Button) findViewById(R.id.nivel1);
        oButtonNiv2 = (Button) findViewById(R.id.nivel2);
        oButtonNiv3 = (Button) findViewById(R.id.nivel3);

        oButtonNiv1.setOnClickListener(this);
        oButtonNiv2.setOnClickListener(this);
        oButtonNiv3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.nivel1:
                startJogo(v, 1);
                break;
            case R.id.nivel2:
                startJogo(v, 2);
                break;
            case R.id.nivel3:
                startJogo(v, 3);
                break;
            default:
                break;
        }
    }

    public void endActivity(View v) {
        finish();
    }

    public void startJogo ( View v, int x ) {
        Intent iActivity =
                new Intent ( this , Jogo.class) ;
        iActivity.putExtra("x", x);
        startActivity ( iActivity ) ;
    }
}
