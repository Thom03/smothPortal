package com.smoothel.www.smothportal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by WAINAH on 2/6/2016.
 */
public class Login extends Activity {
    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }

    public void onButtonClick(View v) {
        if (v.getId() == R.id.Blogin) {
            EditText a = (EditText) findViewById(R.id.Tfusername);
            String str = a.getText().toString();
            EditText b = (EditText) findViewById(R.id.Tfpassword);
            String pass = b.getText().toString();

            String password = helper.searchPass(str);
            if (pass.equals(password)) {
                Intent i = new Intent(Login.this, Display.class);
                i.putExtra("Username", str);
                startActivity(i);


            } else {
                Toast temp = Toast.makeText(Login.this, "Username or Passwords don't match!", Toast.LENGTH_SHORT);
                temp.show();

            }
        }
    }

    public void onClickRegister(View v){
        if (v.getId() == R.id.Bsignup){
            Intent t = new Intent(Login.this, SignUp.class);
            startActivity(t);
        }
    }

}
