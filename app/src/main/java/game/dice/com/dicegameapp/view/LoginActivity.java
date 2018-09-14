package game.dice.com.dicegameapp.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import game.dice.com.dicegameapp.R;
import game.dice.com.dicegameapp.application.Controller.GameController;
import game.dice.com.dicegameapp.application.DTO.GameDTO;
import game.dice.com.dicegameapp.application.DTO.PlayerDTO;
import game.dice.com.dicegameapp.domain.Player;

public class LoginActivity extends Activity {

    GameController gameController;

    TextView usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        gameController= new GameController();
        usuario=(TextView)findViewById(R.id.userText);
    }

    public void checkLogin(View vista)throws Exception{
        final Intent i = new Intent(this,MenuActivity.class);

        AlertDialog.Builder builder=new AlertDialog.Builder(LoginActivity.this);
        builder.setCancelable(false);

        if(!usuario.getText().toString().isEmpty()) {
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    //mostramos la activity menu al pulsar OK

                    startActivity(i);
                }
            });
            Bundle bundle = new Bundle();
            if (gameController.existPlayer(usuario.getText().toString())){
                PlayerDTO playerDTO = gameController.getPlayer(usuario.getText().toString());
                builder.setTitle("Bienvenido " + playerDTO.getName());
                bundle.putSerializable("idPlayer", playerDTO.getId());
            } else {
                PlayerDTO playerDTO = gameController.createPlayer(usuario.getText().toString());
                builder.setTitle("Usuario " + playerDTO.getName().toString() + " creado");
                bundle.putSerializable("idPlayer", playerDTO.getId());
            }
            i.putExtras(bundle);
        }else{
                builder.setPositiveButton("OK", null);
                builder.setTitle("Debes escribir un usuario");
            }
        builder.show();

    }
}
