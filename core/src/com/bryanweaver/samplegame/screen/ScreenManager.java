package com.bryanweaver.samplegame.screen;

/**
 * Created by Bryan on 3/9/2015.
 */
public class ScreenManager {

    private static Screen currentScreen;

    public static void setScreen(Screen screen){
        if(currentScreen !=null) {
            currentScreen.dispose();
        }
        currentScreen = screen;
        currentScreen.create();
    }

    public static Screen getCurrentScreen(){
        return currentScreen;
    }
}
