package com.example.intent_implicit;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Google Button
        Button googleButton = findViewById(R.id.openGoogleButton);
        googleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an implicit intent to open a URL
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.google.com"));
                startActivity(intent);
            }
        });

        // Stack Overflow Button
        Button stackOverflowButton = findViewById(R.id.openStackOverflowButton);
        stackOverflowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an implicit intent to open a URL
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://stackoverflow.com"));
                startActivity(intent);
            }
        });

        // GitHub Button
        Button gitHubButton = findViewById(R.id.openGitHubButton);
        gitHubButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an implicit intent to open a URL
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.github.com"));
                startActivity(intent);
            }
        });
    }
}
