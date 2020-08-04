public class MinHealp {
	private int[] array;
	private int size; // eager computation 

	public MinHeap(int[] array){
		if (array == null || array.length == 0) {
			throw new IllegalArgumentException("input array cannot be null or empty");
		}
		this.array = array; 
		size = array.length; 
		heapify();
	}

	public MinHeap(int cap){
		if (cap <= 0) {
			throw new IllegalArgumentException("capacity cannot be <= 0");
		}
		array = new int[cap];
		size = 0; 
	}

	private void heapify(){

	}

	private void percolateUp(int index){
		// while loop 进入条件：index < 1， 即index为root

	}
	
	private void percolateDown(int index){

	}

	public int peek(){

	}

	public int poll(){

	}

	public void offer(int ele){

	}

	public void update(int index, int ele){

	}

	public int size(){
		return size; 
	}

	public boolean isEmpty(){
		return size == 0; 
	}

	public boolean isFull(){
		return size == array.length; 
	}

	private void swap(int l, int r){

	}


}