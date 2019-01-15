package bc19;

import java.util.ArrayList;

public class Castle extends GeneralRobot {

	Robot me = gc.me;

    public void onAwake(){

        gc.log("I am a Castle! #" + me.id);
		ArrayList<AstarPoint> path = generateAstarPath(new AstarPoint(me.x, me.y), new AstarPoint(16,16));
		if(path != null){
			for (AstarPoint p : path) {
				gc.log(p.toString());
			}
		}
    }

    public Action doTurn(){
        return gc.buildUnit(2, 1, 1);
    }

}
