package game.dice.com.dicegameapp.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.nio.BufferUnderflowException;
import java.util.List;

import game.dice.com.dicegameapp.R;
import game.dice.com.dicegameapp.application.Controller.GameController;
import game.dice.com.dicegameapp.application.DTO.GameDTO;
import game.dice.com.dicegameapp.application.DTO.PlayerDTO;

import static game.dice.com.dicegameapp.R.layout.main_menu;

public class MenuActivity extends Activity {

    Button play, scores, salir;
    TextView userLoged;
    private GameController gameController= new GameController();
    Bundle bundle=getIntent().getExtras();
    PlayerDTO playerDTO= (PlayerDTO) bundle.getSerializable("playerDTO");

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(main_menu);

        play = (Button)findViewById(R.id.buttonPlay);
        scores = (Button)findViewById(R.id.buttonScores);
        salir = (Button)findViewById(R.id.buttonSalir);
        userLoged = (TextView)findViewById(R.id.userLoged);
        userLoged.setText("Estás logueado como: " + playerDTO.getName());

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
                //comprobar que el jugador tiene partidas previas.
                if(gameController.getPlayerGamesToString(gameController.getPlayerActual()).equalsIgnoreCase("")){
                    AlertDialog.Builder builder=new AlertDialog.Builder(MenuActivity.this);
                    builder.setCancelable(false);
                    builder.setPositiveButton("OK", null);
                    builder.setTitle("No has jugado ninguna partida");
                    builder.show();
                }else {
                    Intent scores = new Intent(MenuActivity.this, ScoresActivity.class);
                    startActivity(scores);
                }
            }
        });

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent salir = new Intent(MenuActivity.this, LoginActivity.class);
                startActivity(salir);
            }
        });

    }
}
