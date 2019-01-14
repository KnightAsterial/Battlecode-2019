package bc19;

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

}
