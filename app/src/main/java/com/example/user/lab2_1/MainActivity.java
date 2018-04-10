package com.example.user.lab2_1;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText Url;
    Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Url = findViewById(R.id.editText);
        nextBtn = findViewById(R.id.nextBtn);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String myUrl = Url.getText().toString();  //change editText to string

                Intent intent = new Intent(getApplicationContext(), NewActivity.class); //intent to NewActivity class
                intent.putExtra("Url", myUrl);  //pass the url by the name "Url"
                startActivity(intent);
            }
        });
    }
}
