// Imports
import java.util.Random;

public class Producer extends java.lang.Thread {
	// Necessary variables and object declaration
	Random randomWithSeed;
	private Buffer buff;
	public  int sum = 0; // Total # of all numInsert
	private int items; // Number of elements that producer should generate
	private int id; // Number of producer threads

	// Constructor
	public Producer(Buffer buff, int items, int id, int seed) {
		// Assign values to the variables
		this.buff = buff;
		this.items = items;
		this.id = id;
		randomWithSeed = new Random(seed);
	}

	// The sum of inserts needed for Main.java
	public int getCheckSum(int num){
		sum += num;
		return sum;
	}
 
	@Override
	public void run() {
		String x = "at";
		synchronized(this.buff){
			for(int i = 0; i < items; i++){
				int numInsert = randomWithSeed.nextInt(100);
				buff.add(numInsert);
				System.out.format("Producer %3d inserted %3d %3s  index %3d at time %3s\n", id, numInsert, x, Buffer.size-1, Coordinator.getTime());
				getCheckSum(numInsert);
				System.out.flush();
			}
		}
	}
}