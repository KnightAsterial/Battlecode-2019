package bc19;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

public abstract class GeneralRobot {
    //game controller
    static BCAbstractRobot gc;



    /**
    * Called once to set up everything
    */
    public static void init(BCAbstractRobot gameController){
        gc = gameController;
    }


    public void onAwake(){

    }

    public abstract Action doTurn();

    public Action randomMove(){
        int[][] possibleMoves = {
            {0,1},
            {1,1},
            {1,0},
            {1,-1},
            {0,-1},
            {-1,-1},
            {-1,0},
            {-1,1}
        };

        int blah = (int)(Math.random()*9);
        int[] move = possibleMoves[blah];
        return gc.move(move[0], move[1]);

    }

    public static boolean isPassable(int x, int y){

        if(x < 0 || x >= gc.map.length){
            return false;
        }
        else if(y < 0 || y >= gc.map.length){
            return false;
        }
        //returns true the geographical map says passable and
        //there is no unit visible there or it is not in sight
        else if(gc.map[y][x] == true && gc.getVisibleRobotMap()[y][x] <= 0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
    * Uses A* to generate a path to target
    * @return path, or null if destination unreachable
    */
    public static ArrayList<AstarPoint> generateAstarPath(AstarPoint source, AstarPoint destination){
        if(!isPassable(destination.x, destination.y)){
            return null;
        }

        AstarPriorityQueue frontier = new AstarPriorityQueue();
        frontier.add(source, 0);
        HashMap<AstarPoint, AstarPoint> cameFrom = new HashMap<AstarPoint, AstarPoint>();
        HashMap<AstarPoint, Integer> costSoFar = new HashMap<AstarPoint, Integer>();
        cameFrom.put(source, new AstarPoint(-1,-1));
        costSoFar.put(source, 0);

        AstarPoint current;
        AstarPoint next;
        int newCost;
        while(!frontier.isEmpty()){
            gc.log(frontier.size() + "<- frontier size");
            current = frontier.poll().point;

            if(current.x == destination.x && current.y == destination.y){
                break;
            }

            //finds neighbors of current such that i=0 (above), i=1 (right), i=2 (below), i=3 (left)
            for(int i = 0; i < 4; i++){
                if(i == 0){
                    next = current.getAbovePoint();
                    if(!isPassable(next.x, next.y)){
                        continue;
                    }
                }
                else if(i == 1){
                    next = current.getRightPoint();
                    if(!isPassable(next.x, next.y)){
                        continue;
                    }
                }
                else if (i == 2){
                    next = current.getBelowPoint();
                    if(!isPassable(next.x, next.y)){
                        continue;
                    }
                }
                else{
                    next = current.getLeftPoint();
                    if(!isPassable(next.x, next.y)){
                        continue;
                    }
                }

                newCost = costSoFar.get(next) + 1;
                if( !costSoFar.keySet().contains(next) || newCost < costSoFar.get(next)){
                    costSoFar.put(next, newCost);
                    int priority = newCost + getAstarHeuristic(next, destination);
                    frontier.add(next, priority);
                    cameFrom.put(next, current);
                }

            }
        }
        gc.log(frontier.size() + "<- frontier size");
        //reconstructs path
        if(current.x == destination.x && current.y == destination.y){
            ArrayList<AstarPoint> path = new ArrayList<AstarPoint>();
            AstarPoint temp = destination;
            while(temp.x != source.x && temp.y != source.y){
                path.add(temp);
                temp = cameFrom.get(temp);
            }
            Collections.reverse(path);

            return path;
        }
        else{
            return null;
        }
    }

    /**
    * @return distance from start to end in radius-squared units
    */
    public static int getAstarHeuristic(AstarPoint start, AstarPoint end){
        return (int)(Math.pow(end.x - start.x, 2) + Math.pow(end.y - start.y, 2));
    }

}
