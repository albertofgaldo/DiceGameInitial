package game.dice.com.dicegameapp.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import game.dice.com.dicegameapp.R;
import game.dice.com.dicegameapp.application.Controller.GameController;
import game.dice.com.dicegameapp.application.Controller.PlayerController;
import game.dice.com.dicegameapp.application.DTO.GameDTO;
import game.dice.com.dicegameapp.application.DTO.PlayerDTO;
import game.dice.com.dicegameapp.domain.Player;
import game.dice.com.dicegameapp.utilities.ExceptionPlayerNull;

public class LoginActivity extends Activity {

    private static PlayerController playerController = new PlayerController();
    private static GameController gameController = new GameController();
    TextView usuario;
    Button go;

    PlayerDTO playerDTO;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        usuario =(TextView)findViewById(R.id.userText);
        go = (Button) findViewById(R.id.buttonGo);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                if(usuario.getText().toString().equalsIgnoreCase("")){
                   // mensajeToast("Inserta un jugador");
                    Toast.makeText(getApplicationContext(), "Inserta un usuario", Toast.LENGTH_SHORT).show();
                }else{
                    //comprobamos si existe o hay que crearlo
                    if(playerController.existPlayer(usuario.getText().toString())) {
                        playerDTO = new PlayerDTO (playerController.getPlayer(usuario.getText().toString()));
                        Toast.makeText(getApplicationContext(), "Bienvenido " + playerDTO.getName().toString(), Toast.LENGTH_SHORT).show();
                    }else{
                        playerDTO = new PlayerDTO (playerController.createPlayer(usuario.getText().toString()));
                        Toast.makeText(getApplicationContext(), "Usuario " + playerDTO.getName().toString() + " creado", Toast.LENGTH_SHORT).show();
                    }
                    Intent menu = new Intent(LoginActivity.this, MenuActivity.class);
                    menu.putExtra("idPlayer",playerDTO.getId());
                    startActivity(menu);
                }
            }
        });

    }
}
