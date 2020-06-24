package com.e.firebasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Update extends AppCompatActivity implements View.OnClickListener{
EditText edtfn,edtln;
Button btnupdate,btndelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        edtfn=findViewById(R.id.etFirstName);
        edtfn=findViewById(R.id.etLastname);
        btnupdate=findViewById(R.id.btn_u);
        btndelete=findViewById(R.id.btn_d);
        Intent i=getIntent();
        String fn=i.getStringExtra("FN");
        String ln=i.getStringExtra("LN");
        String strId =i.getStringExtra("ID");
        edtfn.setText(fn);
        edtln.setText(ln);
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strfn=edtfn.getText().toString();
                String strln=edtln.getText().toString();

                UserModel userModel=new UserModel();
                userModel.setFirstName(strfn);
                userModel.setLastName(strln);
                userModel.setID(strId);
                Intent i=new Intent();

            }
        });
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}
