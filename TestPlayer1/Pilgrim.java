package bc19;

public class Pilgrim extends GeneralRobot {

	Robot me = gc.me;
    
    public void onAwake(){
        gc.log("I am a Pilgrim! #" + me.id);
    }

    public Action doTurn(){
        return randomMove();
    }
    
}
