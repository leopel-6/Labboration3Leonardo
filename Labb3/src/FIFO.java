import java.util.ArrayList;
import java.util.NoSuchElementException;

public class FIFO implements Queue{
	ArrayList<Object> list = new ArrayList<Object>();
	int max= 0;
	
	
	public void add(Object item) {
		list.add(item);
		if(list.size()> max){
			max = list.size();
		}
	}
	
	public void removeFirst(){
		if(!isEmpty()){
			list.remove(0);
		}else{
			throw new NoSuchElementException();
		}
	}

	public Object first(){
		if(!isEmpty()){
			return list.get(0);
		}else{
			throw new NoSuchElementException();
		}
	}
	
	public int maxSize() {
		return max;
	}

	public boolean isEmpty() {
		if(list.size() == 0){
			return true;
		}
		return false;
	}

	public int size() {
		if(!isEmpty()){
			return list.size();
		}else{
			throw new NoSuchElementException();
		}
	}
	
	public String toString(){
		if(!isEmpty()){
			String queue = "Queue:";
			for(int i=0; i< list.size(); i++){
				queue += " (" + String.valueOf(list.get(i)) + ")";
			}
			return queue + " ";
		}else{
			throw new NoSuchElementException();
		}
	}
	
	public boolean equals(Object f) throws ClassCastException{
		System.out.println("f " + f + " list " + list);
		if(!isEmpty()){
			if(this.size() == ((FIFO) f).size()){
				for(int i = 0; i<this.list.size(); i++){
					if((this.list.get(i) == null && ((FIFO) f).list.get(i) == null) ||
						this.list.get(i) != null && ((FIFO) f).list.get(i) != null &&
						this.list.get(i).equals(((FIFO)f).list.get(i))){
						return true;
					}
				}
				return true;
			}else{
				return false;
			}
		}else{
			throw new NoSuchElementException();
		}
	}

}
