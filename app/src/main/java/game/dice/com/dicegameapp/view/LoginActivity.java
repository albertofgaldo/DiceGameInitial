package game.dice.com.dicegameapp.view;

import android.app.Activity;
import android.app.AlertDialog;
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

        //EventoTeclado teclado=new EventoTeclado();
       // usuario.setOnEditorActionListener(teclado);

    }

    public void checkLogin(View vista)throws Exception{

        AlertDialog.Builder builder=new AlertDialog.Builder(LoginActivity.this);
        builder.setCancelable(false);

        if (gameController.existPlayer(usuario.getText().toString())){
            builder.setTitle("Usuario existente");
            //devolver el usuario del repositorio
            builder.setMessage("tu usuario ya existe, vas a acceder a tu menú");
        }else{
            gameController.createPlayer(usuario.getText().toString());
            builder.setTitle("Usuario creado");
            builder.setMessage("tu usuario ha sido creado");
        }
        builder.show();
        Intent i = new Intent(this,MenuActivity.class);
        startActivity(i);
    }
    //Cuando pulsamos en el teclado intro = GO!
    /*class EventoTeclado implements TextView.OnEditorActionListener{

        @Override
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent){

            if(i== EditorInfo.IME_ACTION_DONE){
                checkLogin(null);
            }
            return false;
        }
    }*/

}
