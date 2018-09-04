package game.dice.com.dicegameapp.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;

import game.dice.com.dicegameapp.R;
import game.dice.com.dicegameapp.application.GameController;

public class LoginActivity extends Activity {

    GameController gameController= new GameController();
    TextView usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        usuario=(TextView)findViewById(R.id.userText);
    }

    public void checkLogin(View vista)throws Exception{
        final Intent i = new Intent(this,MenuActivity.class);

        AlertDialog.Builder builder=new AlertDialog.Builder(LoginActivity.this);
        builder.setCancelable(false);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //mostramos la activity menu al pulsar OK
                startActivity(i);
            }
        });

        if (gameController.existPlayer(usuario.getText().toString())){
            builder.setTitle("Bienvenido " +  usuario.getText().toString());
        }else{
            gameController.createPlayer(usuario.getText().toString());
            builder.setTitle("Usuario " +  usuario.getText().toString() +" creado");
        }

        builder.show();

    }
}
