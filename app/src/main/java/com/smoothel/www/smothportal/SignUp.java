package com.smoothel.www.smothportal;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by WAINAH on 2/6/2016.
 */
public class SignUp extends Activity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
    }

    public void onSignUpClick (View v)
    {
        if (v.getId() == R.id.Bregister)
        {
            EditText fname = (EditText)findViewById(R.id.Tfname);
            EditText lname = (EditText)findViewById(R.id.Tflname);
            EditText uname = (EditText)findViewById(R.id.Tfuname);
            EditText pass1 = (EditText)findViewById(R.id.Tfpass1);
            EditText pass2 = (EditText)findViewById(R.id.Tfpass2);
            EditText phoneno = (EditText)findViewById(R.id.Tfphoneno);
            EditText county = (EditText)findViewById(R.id.Tfemail);





            String fnamestr = fname.getText().toString();
            String lnamestr = lname.getText().toString();
            String unamestr = uname.getText().toString();
            String pass1str = pass1.getText().toString();
            String pass2str = pass2.getText().toString();
            String phonenostr = phoneno.getText().toString();
            String countystr = county.getText().toString();


            if (!pass1str.equals(pass2str))
            {
                //popup message
                Toast pass = Toast.makeText(SignUp.this ,"Passwords don't match!" , Toast.LENGTH_SHORT);
                pass.show();
            }
            else
            {
                //insert the details in database
                contact c = new contact();
                c.setFname(fnamestr);
                c.setLname(lnamestr);
                c.setUname(unamestr);
                c.setPass(pass1str);
                c.setPhoneno(phonenostr);
                c.setEmail(countystr);


                helper.insertContact(c);

            }
            Toast.makeText(SignUp.this,"You have registered successfully", Toast.LENGTH_LONG).show();







        }
    }


}
