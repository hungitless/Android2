package com.example.exe3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login_activity extends AppCompatActivity {
    EditText editName, editPass;
    Button btnNhap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setControl();
        setEvent();
    }
    private void setControl(){
        editName = (EditText) findViewById(R.id.editName);
        editPass = (EditText) findViewById(R.id.editPass);
        btnNhap = (Button) findViewById(R.id.btnLogin);
    }
    private void setEvent(){
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editName.getText().toString().equals("admin")&& editPass.getText().toString().equals("12345")){
                    Intent intent = new Intent(Login_activity.this, MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(Login_activity.this, "Đăng nhập không thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
