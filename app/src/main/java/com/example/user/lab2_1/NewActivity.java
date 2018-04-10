package com.example.user.lab2_1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {
    TextView textView;
    Button goButton;
    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        textView = findViewById(R.id.text);
        goButton = findViewById(R.id.goBtn);
        backButton = findViewById(R.id.backBtn);

        final Intent passedIntent = getIntent(); //get the MainActivity intent
        final String passedUrl = passedIntent.getStringExtra("Url"); //get the url by MainActivity
        textView.setText(passedUrl); //set the string to textView

        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView.getText() != null && !textView.getText().equals("")) { //if the text is not empty
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + textView.getText())); //go to the web site
                    startActivity(intent);
                }
                else { //if the text is empty
                    Toast.makeText(getApplicationContext(), "주소를 다시 입력해주세요", Toast.LENGTH_LONG).show(); //once again toast message
                }
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "뒤로가기 버튼을 눌렀습니다", Toast.LENGTH_LONG).show(); //back button toast message
                Intent intent = new Intent(getApplicationContext(), MainActivity.class); //go back to MainActivity
                startActivity(intent);
            }
        });
    }
}
