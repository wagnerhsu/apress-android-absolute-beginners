package com.wagner.jsonfile;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.read_file_button).setOnClickListener(this);
    }

    void UpdateTextView(String content) {
        TextView textView = findViewById(R.id.textView);
        textView.setText(content);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.read_file_button:
                try {
                    String content = fileUtils.readFileFromAssets(this.getApplicationContext(), "tencent-asr.json");
                    UpdateTextView(content);
                } catch (IOException e) {
                    UpdateTextView(e.getLocalizedMessage());
                }
                break;
        }
    }
}