package bc19;

public class Church extends GeneralRobot {

	Robot me = gc.me;
    
    public void onAwake(){
        
        gc.log("I am a Church! #" + me.id);
    }

    public Action doTurn(){
        return randomMove();
    }
    
}
