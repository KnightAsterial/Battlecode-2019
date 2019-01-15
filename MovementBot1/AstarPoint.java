package bc19;

public class AstarPoint{
	public int x;
	public int y;

	public AstarPoint(int x, int y){
		this.x = x;
		this.y = y;
	}

    public AstarPoint getAbovePoint(){
        return new AstarPoint(x, y-1);
    }

    public AstarPoint getBelowPoint(){
        return new AstarPoint(x, y+1);
    }

    public AstarPoint getRightPoint(){
        return new AstarPoint(x+1, y);
    }

    public AstarPoint getLeftPoint(){
        return new AstarPoint(x-1, y);
    }

    @Override
    public boolean equals(Object o){
        if (o == this){
            return true;
        }
        if(!(o instanceof AstarPoint)){
            return false;
        }
        AstarPoint other = (AstarPoint)o;
        return (x == other.x && y == other.y);
    }

    @Override
    public int hashCode(){
        return x*1000+y;
    }

    @Override
    public String toString(){
        return "AstarPoint[" + x + "," + y + "]";
    }

}
