package game.dice.com.dicegameapp.view;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import org.w3c.dom.Text;

import game.dice.com.dicegameapp.R;
import game.dice.com.dicegameapp.application.Controller.GameController;
import game.dice.com.dicegameapp.application.Controller.PlayerController;
import game.dice.com.dicegameapp.application.DTO.GameDTO;
import game.dice.com.dicegameapp.application.DTO.PlayerDTO;

import static game.dice.com.dicegameapp.R.layout.play;

public class PlayActivity extends Activity {

    Button tirarDados, atras;
    TextView dado1, dado2, dadoResultado, hasGanado, userLoged2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(play);

        final GameController gameController = new GameController();
        final PlayerController playerController = new PlayerController();
        final PlayerDTO playerDTO= new PlayerDTO(playerController.getPlayerById(getIntent().getExtras().getInt("idPlayer")));

        userLoged2 = (TextView)findViewById(R.id.userLoged2);
        userLoged2.setText("Estás logueado como: " + playerDTO.getName());
        dado1=(TextView)findViewById(R.id.textDado1);
        dado2=(TextView)findViewById(R.id.textDado2);
        dadoResultado=(TextView)findViewById(R.id.textDadoResultado);
        hasGanado=(TextView)findViewById(R.id.hasGanado);
        tirarDados=(Button)findViewById(R.id.buttonTirar);
        atras=(Button)findViewById(R.id.buttonAtras);

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tirarDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gameController.playGame(playerController.getPlayerById(playerDTO.getId()))){
                    hasGanado.setText("Has Ganado!");
                    hasGanado.setTextColor(Color.GREEN);
                    dadoResultado.setTextColor(Color.GREEN);
                }else{
                    hasGanado.setText("Has Perdido!");
                    hasGanado.setTextColor(Color.RED);
                    dadoResultado.setTextColor(Color.RED);
                }
                GameDTO gameDTO= new GameDTO(gameController.getLastGame(playerController.getPlayerById(playerDTO.getId())));

                dado1.setText(Integer.toString(gameDTO.getDice1()));
                dado2.setText(Integer.toString(gameDTO.getDice2()));
                dadoResultado.setText(Integer.toString(gameDTO.getDice1() + gameDTO.getDice2()));
            }
        });
    }



}
