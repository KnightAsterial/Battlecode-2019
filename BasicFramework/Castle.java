package bc19;

public class Castle extends GeneralRobot {

	Robot me = gc.me;
    
    public void onAwake(){
        
        gc.log("I am a Castle! #" + me.id);
    }

    public Action doTurn(){
        return gc.buildUnit(2, 1, 1);
    }
    
}
