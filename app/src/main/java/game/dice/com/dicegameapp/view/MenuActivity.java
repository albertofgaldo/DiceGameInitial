package game.dice.com.dicegameapp.view;

import android.app.Activity;
import android.os.Bundle;

import game.dice.com.dicegameapp.R;

import static game.dice.com.dicegameapp.R.layout.main_menu;

public class MenuActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(main_menu);
    }
}
