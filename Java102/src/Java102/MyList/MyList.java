package Java102.MyList;

import java.util.Arrays;



public class MyList<T>{
    T[] list ;
	public  MyList(){
		this.list =(T[]) new Object[10];
	}
	public  MyList(int capacity){
		
		this.list = (T[]) new Object[capacity];
	}
	
	public int size() {
		int count = 0;
		
		for(T key :this.list) {
			if(key!=null) {
				count++;
			}
		}
		return count;
	}
	
	public  int getCapacity() {
		return this.list.length;
	}
	public  void add(T data) {
		for (int i = 0; i < list.length; i++) {
           if (list[i] == null) {
               list[i] = data;
               break;
           } else if (list[i] != null && i == list.length - 1) {
           	list = Arrays.copyOf(list, list.length * 2);
           	list[list.length / 2] = data;
               break;
           }
       }
		
		
	}
	
	public T get(int index) {
		if(index<0 || index >this.getCapacity()) {
			return null;
		}
		return this.list[index];
	}
	
	public T remove(int index) {
		if(index<0 || index >this.getCapacity()) {
			return null;
		}
		T data = this.list[index];
		for(int i = index ;i<this.getCapacity();i++) {
			
			this.list[index]=this.list[index+1];
		}
		return data;
	}
	
	public T set(int index, T data) {
		if(index<0 || index >this.getCapacity()) {
			return null;
		}
		this.list[index]=data;
		return this.list[index];
	}
	
	public String toString() {
		String result = "[ ";
		for(T key :this.list) {
			if(key==null) {
				break;
			}
			result+=key+",";
			
		}
		result = result.substring(0,result.length()-1)+" ]";
		return result;
	}
	
	public int indexOf(T data) {
		for(int i=0 ;i<this.getCapacity();i++) {
			if(this.list[i]==data) {
				return i;
			}
		}
		return -1;
	}
	
	public int lastIndexOf(T data) {
		for(int i=this.getCapacity()-1;i>=0;i--) {
			if(this.list[i]==data) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean isEmpty() {
		if(this.size()==0) {
			return true;
		}
		return false;
	}
	
	public T[] toArray() {
		return Arrays.copyOfRange(list, 0, this.size());
	}
	
	public MyList<T> subList(int start, int end){
		MyList<T> newList = new MyList<>((end-start+1));
		for(int i=start;i<=end;i++) {
			newList.add(this.list[i]);
		}
		return newList;
	}
	 public void clear() {
	        this.list = (T[]) new Object[10];
	    }
	public boolean contains(T data) {
		
		for(int i=0;i<this.size();i++) {
			if(list[i]==data) {
				return true;
			}
		}
		return false;
	}
	

}
