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

}
