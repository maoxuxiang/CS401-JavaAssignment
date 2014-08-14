package a1;
public class MyStack<C> {
	double[] arr;
	private int currentSize;//Will index to ONE ABOVE the top of the stack
	public MyStack(int n){
//******Java Specific!! -- assigning memory for generics
//		arr = new C[n]; //Assign memory -- ERROR! -- "Cannot create a generic array of C"
//		Integer[] arr = new Integer[n]; -- although this would be OK...
		//arr = (C[]) new Object[n]; //Assign memory
		arr = new double[n];
    	currentSize = 0; 
	}
	public boolean isFull(){return currentSize == arr.length;}
	public boolean isEmpty(){return currentSize == 0;}
	public void push(int d){//PRE: not full
		arr[currentSize] = d;
		currentSize+=1;
		}
	public double pop(){//PRE: not empty
		currentSize -=1;
		return arr[currentSize];

	}
	public double peek(){//PRE: not empty
		return arr[currentSize-1];
	}
}