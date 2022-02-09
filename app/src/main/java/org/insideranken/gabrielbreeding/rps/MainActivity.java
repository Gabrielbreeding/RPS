package org.insideranken.gabrielbreeding.rps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    // Widgets
    ImageView ivUser;
    ImageView ivComp;
    TextView tvResult;
    Button btnRock;
    Button btnPaper;
    Button btnScissors;
    Button btnRules;
    Button btnTotals;

    // Global Variables
    Integer totalWins   = 0;
    Integer totalLosses = 0;
    Integer totalTies   = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivUser      = findViewById(R.id.ivUser);
        ivComp      = findViewById(R.id.ivComp);
        tvResult    = findViewById(R.id.tvResult);
        btnRock     = findViewById(R.id.btnRock);
        btnPaper    = findViewById(R.id.btnPaper);
        btnScissors = findViewById(R.id.btnScissors);
        btnRules    = findViewById(R.id.btnRules);
        btnTotals   = findViewById(R.id.btnTotals);

        btnRock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shoot("Rock");
            }
        });
        btnPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shoot("Paper");
            }
        });
        btnScissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shoot("Scissors");
            }
        });
        btnRules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rulesIntent = new Intent(getApplicationContext(), HelpScreenActivity.class);
                startActivity(rulesIntent);
            }
        });
        btnTotals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras = new Bundle();
                extras.putInt("wins", totalWins);
                extras.putInt("losses", totalLosses);
                extras.putInt("ties", totalTies);
                Intent totalsIntent = new Intent(getApplicationContext(), TotalsActivity.class);
                totalsIntent.putExtras(extras);
                startActivity(totalsIntent);
            }
        });
    }

    protected void shoot (String userRPS) {
        String comp = compRPS();   // get computer decision
        if     (userRPS == "Rock" && comp == "Scissors" ||  // rock beats scissors
                userRPS == "Scissors" && comp == "Paper" || // scissors beats paper
                userRPS == "Paper" && comp == "Rock") {     // paper beats rock

            userWin(userRPS, comp);
        } else if (userRPS == comp) {
            userTie(userRPS, comp);
        } else {  // any other result is a loss.
            userLoss(userRPS, comp);
        }

        setImages(userRPS, comp);
    }

    protected void setImages (String u, String c){
        if (u == "Rock") {
            ivUser.setImageDrawable(getResources().getDrawable(R.drawable.rock));
        } else if (u == "Paper") {
            ivUser.setImageDrawable(getResources().getDrawable(R.drawable.paper));
        } else if (u == "Scissors") {
            ivUser.setImageDrawable(getResources().getDrawable(R.drawable.scissors));
        }

        if (c == "Rock") {
            ivComp.setImageDrawable(getResources().getDrawable(R.drawable.rock));
        } else if (c == "Paper") {
            ivComp.setImageDrawable(getResources().getDrawable(R.drawable.paper));
        } else if (c == "Scissors") {
            ivComp.setImageDrawable(getResources().getDrawable(R.drawable.scissors));
        }
    }

    protected void userWin (String u, String c) {
        totalWins++;
        tvResult.setText("You Win! (" + u + " beats " + c + ")");
    }

    protected void userTie (String u, String c) {
        totalTies++;
        tvResult.setText("You Tied! (" + u + " ties with " + c + ")");
    }

    protected void userLoss (String u, String c) {
        totalLosses++;
        tvResult.setText("You Lost! (" + c + " beats " + u + ")");
    }

    protected String compRPS () {
        Integer computer = (int)(Math.random() * 3);
        if (computer.equals(0)) {
            return "Rock";
        } else if (computer.equals(1)) {
            return "Paper";
        } else if (computer.equals(2)) {
            return "Scissors";
        }
        return computer.toString();
    }
}