package org.insideranken.gabrielbreeding.rps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TotalsActivity extends AppCompatActivity {
    Button btnTotalsToHomePage;
    TextView tvUserWin;
    TextView tvCompWin;
    TextView tvTie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_totals);

        btnTotalsToHomePage = findViewById(R.id.btnTotalsToHomePage);
        tvUserWin           = findViewById(R.id.tvUserWin);
        tvCompWin           = findViewById(R.id.tvCompWin);
        tvTie               = findViewById(R.id.tvTies);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        if (extras != null) {
            if (extras.containsKey("wins")) {
                tvUserWin.setText("Total Amount of Your Wins: " + extras.getInt("wins"));
            }
            if (extras.containsKey("losses")) {
                tvCompWin.setText("Total Amount of The Computer's Wins: " + extras.getInt("losses"));
            }
            if (extras.containsKey("ties")) {
                tvTie.setText("Total Amount of Ties: " + extras.getInt("ties"));
            }
        }

        btnTotalsToHomePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}