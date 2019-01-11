package bc19;

public class Prophet extends GeneralRobot {

	Robot me = gc.me;
    
    public void onAwake(){
        
        gc.log("I am a Prophet! #" + me.id);
    }

    public Action doTurn(){
        return randomMove();
    }
    
}
