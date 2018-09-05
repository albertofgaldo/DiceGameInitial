package game.dice.com.dicegameapp.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import game.dice.com.dicegameapp.R;

import static game.dice.com.dicegameapp.R.layout.main_menu;

public class MenuActivity extends Activity {

    Button play, scores, salir;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(main_menu);

        play = (Button)findViewById(R.id.buttonPlay);
        scores = (Button)findViewById(R.id.buttonScores);
        salir = (Button)findViewById(R.id.buttonSalir);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent play = new Intent(MenuActivity.this, PlayActivity.class);
                startActivity(play);
            }
        });

        scores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent scores = new Intent(MenuActivity.this, ScoresActivity.class);
                startActivity(scores);
            }
        });

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
