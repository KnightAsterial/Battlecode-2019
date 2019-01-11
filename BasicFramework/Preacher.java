package bc19;

public class Preacher extends GeneralRobot {

	Robot me = gc.me;
    
    public void onAwake(){
        
        gc.log("I am a Preacher! #" + me.id);
    }

    public Action doTurn(){
        return randomMove();
    }
    
}
