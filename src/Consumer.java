// Imports

public class Consumer extends java.lang.Thread{
    // Variables
    private Buffer buff;
    private int consume;
    private int id;
    public  int sum = 0;

    // Constructor
    public Consumer(Buffer buff, int consume, int id){
        this.buff = buff;
        this.consume = consume;
        this.id = id;
    }
    
    // The sum of deletions needed for Main.java
    public int getCheckSum(int num){
        sum += num;
		return sum;
	}
    
    @Override
	public void run() {
        synchronized(this.buff){
            for(int i = 0; i < consume; i++){
                int deletedItem = buff.delete();
                System.out.format("\033[0;4mConsumer %3d consumed %3d from index %3d at time\033[0;0m %3s\n",id, deletedItem, Buffer.index, Coordinator.getTime());           
                System.out.flush();
                getCheckSum(deletedItem);
            }
		}
    }
}