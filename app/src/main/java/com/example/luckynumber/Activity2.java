package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;
import com.example.luckynumber.MainActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {
    TextView textView4;
    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        button2 = findViewById(R.id.button2);
        textView4=findViewById(R.id.textview4);
        Bundle bundle = getIntent().getExtras();
        MainActivity m= new MainActivity();
        int x = m.getRandomInteger(100,1000);
        String num = String.valueOf(x);
        Intent i = getIntent();
        String username= i.getStringExtra("name");
        Toast.makeText(this, username, Toast.LENGTH_SHORT).show();
//        String num =getIntent().getStringExtra("Random Number",s);
        textView4.setText(" "+num);

        //for onclick button
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData(username,num);
            }
        });

//
    }

    public void sendData(String username,String num){
        //implicit intent
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT ,username+" got lucky today");
        intent.putExtra(Intent.EXTRA_TEXT ,username+" got lucky today");
        intent.putExtra(Intent.EXTRA_TEXT,"The lucky number is "+num);
        startActivity(intent.createChooser(intent,"Please select how to share your data"));

    }
}