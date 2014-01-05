package com.theheadofabroom.tetrislibre;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

@SuppressWarnings("ALL")
public class Game extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_main);
        GameState.Connect(this);
    }
    @Override
    protected void onStop() {
        super.onStop();
        GameLoop.StopTick();
    }
    @Override
    protected void onPause() {
        super.onPause();
        GameLoop.StopTick();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Board.ForceFullRedraw();
        GameLoop.StartTick();
    }
    @Override
    protected void onStart() {
        super.onStart();
        GameLoop.StartTick();
    }
    public void Down(View view)
    {
        if (GameLoop.active())
            GameState.Down();
    }

    public void Rotate(View view)
    {
        if (GameLoop.active())
            GameState.Rotate();
    }

    public void Left(View view)
    {
        if (GameLoop.active())
            GameState.Left();
    }

    public void Right(View view)
    {
        if (GameLoop.active())
            GameState.Right();
    }
}

