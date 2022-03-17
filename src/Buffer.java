// Imports

public class Buffer{
    // Variables
    private int[] array;
    public static int size = 0;
    public static int index;
    private final int capacity;
    private int head = 0;
    private int tail = -1;

    // Constructor
    public Buffer(int capacity){
        this.capacity = capacity;
        array = new int[capacity];
    }

    // Adding of elements
    public synchronized void add(int x){
        int index = (tail+1) % capacity;
        while(size == capacity){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        array[index] = x;
        tail++;
        size++;
        notify();
    }
    
    // Deletion the elemetns
    public synchronized int delete(){
        while(size == 0){  
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        index  = head % capacity;
        int x = array[index];
        size--;
        head++;
        notify();
        return x;
    }
}