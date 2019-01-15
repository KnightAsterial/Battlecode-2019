package bc19;

import java.util.HashMap;

public class MyRobot extends BCAbstractRobot{

    /*
    * Notes: Java.util.Random is not supported. Use Math.random() instead
    * map and robotmap are in the form map[y][x]
    *
    * Java.awt.Point is not supported
    *
    *
    * Java.util.LinkedList and Java.util.ArrayList are supported
    * java.util.PriorityQueue is not supported
    * Java.util.HashMap is supported!
    * Java.util.Set is supported
    * Java.util.Collections.reverse() is supported
    */

    static int numTurnSinceBirth = 0;
    static GeneralRobot unit = null;

    public Action turn() {

        try{
            //initial commands
            if (numTurnSinceBirth == 0){
            	log("Got this far");
                GeneralRobot.init(this);

                switch(me.unit){
                    case 0:
                        unit = new Castle();
                        unit.onAwake();
                        break;
                    case 1:
                        unit = new Church();
                        unit.onAwake();
                        break;
                    case 2:
                        unit = new Pilgrim();
                        unit.onAwake();
                        break;
                    case 3:
                        unit = new Crusader();
                        unit.onAwake();
                        break;
                    case 4:
                        unit = new Prophet();
                        unit.onAwake();
                        break;
                    case 5:
                        unit = new Preacher();
                        unit.onAwake();
                        break;
                }


            }



            numTurnSinceBirth += 1;
            return unit.doTurn();

        }
        catch (Exception e){
            log("Turn: " + numTurnSinceBirth + ": " + e.getMessage());
        }
    }
}
