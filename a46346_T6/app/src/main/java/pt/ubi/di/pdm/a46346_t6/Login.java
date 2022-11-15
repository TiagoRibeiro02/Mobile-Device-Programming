package pt.ubi.di.pdm.a46346_t6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    EditText username, password;
    Button singin;
    gameDbHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        username = findViewById(R.id.username1);
        password = findViewById(R.id.password1);
        singin = findViewById(R.id.singin1);
        DB = new gameDbHelper(this);

        singin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (user.isEmpty() || pass.isEmpty())
                    Toast.makeText(Login.this, "All fields Required", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuserpass = DB.chechusernamepassword(user,pass);
                    if (checkuserpass==true){
                        Toast.makeText(Login.this, "Login successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(Login.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}
