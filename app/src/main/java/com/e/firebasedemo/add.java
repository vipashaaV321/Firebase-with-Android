package com.e.firebasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class add extends AppCompatActivity {
EditText edtfn;
EditText edtln;
Button btn;
Button btn1;
private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        edtfn=findViewById(R.id.etFirstName);
        edtln=findViewById(R.id.etLastname);
        btn=findViewById(R.id.btn_add);
btn1=findViewById(R.id.btn_display);
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference("People");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strfn=edtfn.getText().toString();
                String strln=edtln.getText().toString();
                String strkey=databaseReference.push().getKey();
                UserModel userModel=new UserModel();
                userModel.setFirstName(strfn);
                userModel.setLastName(strln);
                userModel.setID(strkey);
                databaseReference.child(strkey).setValue(userModel);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), display.class);
                startActivity(i);
            }
        });

    }
}
