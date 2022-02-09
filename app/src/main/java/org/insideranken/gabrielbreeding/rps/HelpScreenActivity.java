package org.insideranken.gabrielbreeding.rps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class HelpScreenActivity extends AppCompatActivity {
    Button btnHelpToHomePage;
    ImageView ivRules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_screen);

        btnHelpToHomePage = findViewById(R.id.btnHelpToHomePage);
        ivRules           = findViewById(R.id.ivRules);

        ivRules.setImageDrawable(getResources().getDrawable((R.drawable.rules)));

        btnHelpToHomePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}