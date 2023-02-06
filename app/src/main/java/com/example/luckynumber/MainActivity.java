package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    int x ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random random = new Random();
        editText=findViewById(R.id.edittext);
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=editText.getText().toString();
                    Intent i = new Intent(MainActivity.this,Activity2.class);
                    i.putExtra("name",name);
                    startActivity(i);
            }
        });

    }
    public int getRandomInteger(int min,int max){
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

}
