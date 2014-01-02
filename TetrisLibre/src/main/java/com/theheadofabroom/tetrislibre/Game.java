package com.theheadofabroom.tetrislibre;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import com.theheadofabroom.tetrislibre.pieces.*;
import com.theheadofabroom.tetrislibre.*;

public class Game extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_main);
        GameState.Connect(this);
    }

    public void Tick(View view)
    {
        GameState.Tick();
    }

    public void Down(View view)
    {
        GameState.Down();
    }

    public void Rotate(View view)
    {
        GameState.Rotate();
    }

    public void Left(View view)
    {
        GameState.Left();
    }

    public void Right(View view)
    {
        GameState.Right();
    }
}
