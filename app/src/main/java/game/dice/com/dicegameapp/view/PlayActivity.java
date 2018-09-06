package game.dice.com.dicegameapp.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import org.w3c.dom.Text;

import game.dice.com.dicegameapp.R;
import game.dice.com.dicegameapp.application.Controller.GameController;
import game.dice.com.dicegameapp.domain.Game;

public class PlayActivity extends Activity {

    Button tirarDados, salir;
    TextView dado1, dado2, dadoResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play);

        GameController gameController = new GameController();
        dado1=(TextView)findViewById(R.id.textDado1);
        dado2=(TextView)findViewById(R.id.textDado2);
        dadoResultado=(TextView)findViewById(R.id.textDadoResultado);
        tirarDados=(Button)findViewById(R.id.buttonTirar);
        salir=(Button)findViewById(R.id.buttonSalir);

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tirarDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameController.playGame()
            }
        });
    }



}
