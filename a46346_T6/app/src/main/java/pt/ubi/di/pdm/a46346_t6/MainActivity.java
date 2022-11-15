package pt.ubi.di.pdm.a46346_t6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button oButtonNiv;
    Button oButtonClas;
    Button oButtonSair;
    Button oButtonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oButtonNiv = (Button) findViewById(R.id.niveis);
        oButtonClas = (Button) findViewById(R.id.classific);
        oButtonSair = (Button) findViewById(R.id.sair);
        oButtonLogin = (Button) findViewById(R.id.loginHome);

        oButtonNiv.setOnClickListener(this);
        oButtonClas.setOnClickListener(this);
        oButtonSair.setOnClickListener(this);
        oButtonLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.niveis:
                startNiveis(v);
                finish();
                break;
            case R.id.classific:

                break;
            case R.id.loginHome:
                startLogin(v);
                break;
            case R.id.sair:
                finish();
                System.exit(0);
                break;
            default:
                break;
        }
    }

    public void startNiveis ( View v ) {
        Intent iActivity =
                new Intent ( this , Niveis.class) ;
        startActivity ( iActivity ) ;
    }

    public void startLogin ( View v ) {
        Intent iActivity =
                new Intent ( this , Register.class) ;
        startActivity ( iActivity ) ;
    }
}