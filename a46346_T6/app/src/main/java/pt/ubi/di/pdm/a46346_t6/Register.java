package pt.ubi.di.pdm.a46346_t6;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {

    EditText username,password,repassword;
    Button singup,singin;
    gameDbHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        repassword = findViewById(R.id.repassword);
        singup = findViewById(R.id.singup);
        singin = findViewById(R.id.singin);
        DB = new gameDbHelper(this);

        singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user= username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if(user.isEmpty() || pass.isEmpty() || repass.isEmpty())
                    Toast.makeText(Register.this, "All fields Required",Toast.LENGTH_SHORT).show();
                else{
                    if (pass.equals(repass)){
                        Boolean checkuser = DB.chechusername(user);
                        if (checkuser == false){
                            Boolean insert = DB.insertData(user, pass);
                            if (insert == true){
                                Toast.makeText(Register.this, "Registered successfully",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                            }else {
                                Toast.makeText(Register.this, "Registration Failed",Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(Register.this, "User already registered",Toast.LENGTH_SHORT).show();
                        }

                    }else {
                        Toast.makeText(Register.this, "Passwords do not match",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        singin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });
    }
}
