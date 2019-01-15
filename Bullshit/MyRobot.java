package bc19;

import java.util.Set;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;


public class MyRobot extends BCAbstractRobot{

    static int numTurnSinceBirth = 0;
    static GeneralRobot unit = null;

    public Action turn() {

        int i = 1;
        while (true){
            log(i + "");
            i++;
        }

        try{
            //initial commands
            if (numTurnSinceBirth == 0){
            	log("Got this far");
                GeneralRobot.init(this);

                unit = new Castle();
                unit.onAwake();
            }



            numTurnSinceBirth += 1;
            return unit.doTurn();

        }
        catch (Exception e){
            log(e.getMessage());
        }
    }
}
