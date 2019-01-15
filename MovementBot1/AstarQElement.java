package bc19;

public class AstarQElement{
	public AstarPoint point;
	public int priority;

	public AstarQElement(int x, int y, int priority){
		point = new AstarPoint(x,y);
		this.priority = priority;
	}

	public AstarQElement(AstarPoint p, int priority){
		point = p;
		this.priority = priority;
	}
}
