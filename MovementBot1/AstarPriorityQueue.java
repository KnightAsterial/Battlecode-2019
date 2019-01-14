package bc19;

import java.util.LinkedList;

public class AstarPriorityQueue{
	private LinkedList<AstarQElement> queue;

	public AstarPriorityQueue(){
		queue = new LinkedList<AstarQElement>();
	}

	public void add(int x, int y, int priority){
		AstarQElement element = new AstarQElement(x,y,priority);
		boolean contains = false;
		for(int i = 0; i < queue.size(); i++){
			if(queue.get(i).priority > priority){
				queue.add(i, element);
				contains = true;
				break;
			}
		}

		if(!contains){
			queue.add(element);
		}
	}

	/**
	* @return first element in queue (lowest priority)
	*/
	public AstarQElement peek(){
		return queue.get(0);
	}


	public AstarQElement poll(){
		AstarQElement blah = queue.get(0);
		queue.remove(0);
		return blah;
	}

	public int size(){
		return queue.size();
	}
}