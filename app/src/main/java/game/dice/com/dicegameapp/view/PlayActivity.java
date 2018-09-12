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
import static game.dice.com.dicegameapp.R.layout.play;

public class PlayActivity extends Activity {

    Button tirarDados, atras;
    TextView dado1, dado2, dadoResultado, hasGanado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(play);

        final GameController gameController = new GameController();
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
                if(gameController.playGame(gameController.getPlayerActual())){
                    hasGanado.setText("Has Ganado!");
                    hasGanado.setTextColor(Color.GREEN);
                    dadoResultado.setTextColor(Color.GREEN);
                }else{
                    hasGanado.setText("Has Perdido!");
                    hasGanado.setTextColor(Color.RED);
                    dadoResultado.setTextColor(Color.RED);
                }
                dado1.setText(Integer.toString(gameController.getGameActual().getDice1().getValue()));
                dado2.setText(Integer.toString(gameController.getGameActual().getDice2().getValue()));
                dadoResultado.setText(Integer.toString(gameController.getGameActual().getSumDices()));

            }
        });
    }



}
