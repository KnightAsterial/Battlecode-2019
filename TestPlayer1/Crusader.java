package bc19;

public class Crusader extends GeneralRobot {

	Robot me = gc.me;
    
    public void onAwake(){
        
        gc.log("I am a Crusader! #" + me.id);
    }

    public Action doTurn(){
        return randomMove();
    }
    
}
