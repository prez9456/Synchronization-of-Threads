// Imports
import java.lang.Exception;
import java.util.Random;
import java.time.Instant;
import java.time.Clock;
import java.time.Duration;

class Coordinator {
	public static void main(String[] args) {
		// Variables
		int buffSize = 0, totalProd = 0, totalCon = 0,  items = 0, consumerNum = 0, producerNum = 0, seed = 0;

		// Set variables 
		if(args.length == 5){
			buffSize = Integer.parseInt(args[0]);
			items = Integer.parseInt(args[1]);
			consumerNum = Integer.parseInt(args[2]);
			producerNum = Integer.parseInt(args[3]);
			seed = Integer.parseInt(args[4]);
		}
		else{
			System.err.println("All FIVE aruguments must be integers.");
			System.exit(0);
		}
		
		// Instantiate classes
		Buffer buff = new Buffer(buffSize);
		Producer[] prod = new Producer[producerNum];
		Consumer[] con = new Consumer[consumerNum];
		// Instantiate arrays. This is used to evenly divise the work among producers/consumers
		int[] eachProd = new int[producerNum];
		int[] eachCon = new int[consumerNum];
		
		// Decide how many items in each producer/comsumer will have
		for(int i = 0; i < producerNum; i++){
			if(items % producerNum == 0){
				eachProd[i] = items/producerNum;
			}
			else{
				if(i == producerNum-1){
					eachProd[i] = items - (eachProd[0] * (producerNum-1));
				}
				else{
					eachProd[i] = (items/producerNum);
				}
			}
		}
		for(int i = 0; i < consumerNum; i++){
			if(items % consumerNum == 0){
				eachCon[i] = items/consumerNum;
			}
			else{
				if(i == consumerNum-1){
					eachCon[i] = items - ( eachCon[0] * (consumerNum - 1));
				}
				else{
					eachCon[i] = (items/consumerNum) + 1;
				}
			}
		}
		
		// Start Producer Threads
		for(int p = 0; p < producerNum; p++){
			prod[p] = new Producer(buff, eachProd[p], p+1, seed);
			prod[p].start();
		}
		// Start Consumer Threads
		for(int c = 0; c < consumerNum; c++){
			con[c] = new Consumer(buff, eachCon[c], c+1);
			con[c].start();
		}
		// Joins
		for(int i = 0; i < producerNum; i++){
			try {
				prod[i].join();
				totalProd += prod[i].getCheckSum(0);
			} catch (InterruptedException e) { e.printStackTrace(); }
		}
		for(int c = 0; c < consumerNum; c++){
			try {
				con[c].join();
				totalCon += con[c].getCheckSum(0);
			} catch (InterruptedException e) { e.printStackTrace(); }
		}

		// Final Print Statements
		System.out.println();
		System.out.format("Producer(s): Finished producing %d items with checksum being %d%n", items, totalProd);
		System.out.format("\033[0;4mConsumer(s): Finished consuming %d items with checksum being %d%n\033[0;0m", items, totalCon);
	}

	//Call this function from your producer or your consumer to get the time stamp to be displayed
	public static String getTime() {
		Clock offsetClock = Clock.offset(Clock.systemUTC(), Duration.ofHours(-9));
		Instant time = Instant.now(offsetClock);
		String timeString = time.toString();
		timeString = timeString.replace('T', ' ');
		timeString = timeString.replace('Z', ' ');
		return(timeString);
	}
}