package com.theheadofabroom.tetrislibre;

import android.os.Handler;

public final class GameLoop
{
    static
    {
        Tick();
    }
    public static boolean active()
    {
        return shouldTick;
    }
    private static boolean shouldTick = false;
    private static boolean gameNotOver = true;

    public static void StartTick()
    {
        shouldTick = gameNotOver;
    }
    public static void StopTick()
    {
        shouldTick = false;
    }

    private static Handler handler = new Handler();
    private static Runnable enqueueNextTick = new Runnable() {
        @Override
        public void run() {
            Tick();
        }
    };

    private static int fall_rate = 10;
    private static int tick_num = 0;
    private static void Tick()
    {
        handler.postDelayed(enqueueNextTick, 100);

        if (!shouldTick) return;

        ++tick_num;
        if (tick_num % fall_rate == 0)
        {
            if (GameState.Down())
            {
                shouldTick = false;
                gameNotOver = false;
            }
        }


    }
}
