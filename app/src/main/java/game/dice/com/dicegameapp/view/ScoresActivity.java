package game.dice.com.dicegameapp.view;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.TextView;

import game.dice.com.dicegameapp.R;
import game.dice.com.dicegameapp.application.Controller.GameController;
import game.dice.com.dicegameapp.application.Controller.PlayerController;
import game.dice.com.dicegameapp.application.DTO.PlayerDTO;

import static game.dice.com.dicegameapp.R.layout.scores;

public class ScoresActivity extends Activity {

    TextView scoresList, userLoged3, userRanking;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(scores);
        Bundle bundle=getIntent().getExtras();

        GameController gameController = new GameController();
        PlayerController playerController = new PlayerController();
        final PlayerDTO playerDTO= new PlayerDTO(playerController.getPlayerById(bundle.getInt("idPlayer")));

        userLoged3 = (TextView)findViewById(R.id.userLoged3);
        scoresList=(TextView)findViewById(R.id.scoresList);
        userRanking=(TextView)findViewById(R.id.userRanking);

        //devolver el usuario a través de activity
        userLoged3.setText("Estás logueado como: " + playerDTO.getName());
        scoresList.setText((gameController.getPlayerGamesToString(playerController.getPlayerById(playerDTO.getId()))));
        userRanking.setText("El porcentaje de victorias es: " + Double.toString(gameController.getPlayerRanking(playerController.getPlayerById(playerDTO.getId()))));
    }
}

