README
======

This package includes the following files.

|-- Coordinator.java [This is the driver program which will be used to create an instance of the Circular buffer, and create and wait for one thread of producer and one or more threads of and consumer.] (Skeleton Code provided)
|-- Producer.java [Each instance of a producer generates a single number between 0 and 99 (both inclusive) randomly and inserts into the buffer, and reports the location and the time the number was inserted into the buffer] (Skeleton Code provided)
|-- Consumer.java [Each instance of a consumer reads a number from the buffer and reports the location and the time the number was read from the buffer.]
|-- Buffer.java [Creates a circular buffer whose size is passed as an argument to it.]
|-- Makefile [For compiling, and cleaning]
|-- README.txt [This file]


Questions:

1. The problem of producer consumer is solved using ________. - 1 point
	- Semaphores

2. What two functions defined in Java are used for synchronization between producer and consumers in your program? - 2 points
	- wait() and notify().

3. In which function do you override the body to define the new body of a thread in java? - 1 point
	- run()

4. Which function is used to wait for a thread to finish and come back to calling program i.e. for a thread to die? - 1 point
	- join() function.

NOTE:

Lab systems by default use Java 11 which supports nanosecond timestamp. If after logging in and running 'java -version', it doesn't output version 11, use the following two commands:

	$ export PATH=/usr/lib/jvm/jre-11-openjdk/bin/:$PATH

	$ export LD_LIBRARY_PATH=/usr/lib/jvm/jre-11-openjdk/lib/:$LD_LIBRARY_PATH

Example Outputs:
maggot:~/cs370/hw5$ java Coordinator 10 18 3 1 4 (UNDERLINE COULD NOT BE COPIED OVER)
Producer   1 inserted  62  at  index   0 at time 2021-03-25 16:07:03.979238 
Producer   1 inserted  52  at  index   1 at time 2021-03-25 16:07:03.988904 
Producer   1 inserted   3  at  index   2 at time 2021-03-25 16:07:03.989254 
Producer   1 inserted  58  at  index   3 at time 2021-03-25 16:07:03.989582 
Producer   1 inserted  67  at  index   4 at time 2021-03-25 16:07:03.989902 
Producer   1 inserted   5  at  index   5 at time 2021-03-25 16:07:03.990439 
Producer   1 inserted  11  at  index   6 at time 2021-03-25 16:07:03.990851 
Producer   1 inserted  46  at  index   7 at time 2021-03-25 16:07:03.991178 
Producer   1 inserted  62  at  index   8 at time 2021-03-25 16:07:03.991544 
Producer   1 inserted  27  at  index   9 at time 2021-03-25 16:07:03.991908 
Consumer   3 consumed  62 from index   0 at time 2021-03-25 16:07:03.992297 
Consumer   3 consumed  52 from index   1 at time 2021-03-25 16:07:03.992653 
Consumer   3 consumed   3 from index   2 at time 2021-03-25 16:07:03.992998 
Consumer   3 consumed  58 from index   3 at time 2021-03-25 16:07:03.993341 
Consumer   3 consumed  67 from index   4 at time 2021-03-25 16:07:03.993580 
Consumer   3 consumed   5 from index   5 at time 2021-03-25 16:07:03.993795 
Consumer   2 consumed  11 from index   6 at time 2021-03-25 16:07:03.994295 
Consumer   2 consumed  46 from index   7 at time 2021-03-25 16:07:03.994655 
Consumer   2 consumed  62 from index   8 at time 2021-03-25 16:07:03.994918 
Consumer   2 consumed  27 from index   9 at time 2021-03-25 16:07:03.995345 
Producer   1 inserted  92  at  index   0 at time 2021-03-25 16:07:03.995679 
Producer   1 inserted   8  at  index   1 at time 2021-03-25 16:07:03.995955 
Producer   1 inserted  52  at  index   2 at time 2021-03-25 16:07:03.996219 
Producer   1 inserted  60  at  index   3 at time 2021-03-25 16:07:03.996631 
Producer   1 inserted  62  at  index   4 at time 2021-03-25 16:07:03.996964 
Producer   1 inserted  52  at  index   5 at time 2021-03-25 16:07:03.997440 
Producer   1 inserted  69  at  index   6 at time 2021-03-25 16:07:03.997711 
Producer   1 inserted  76  at  index   7 at time 2021-03-25 16:07:03.997953 
Consumer   2 consumed  92 from index   0 at time 2021-03-25 16:07:03.998434 
Consumer   2 consumed   8 from index   1 at time 2021-03-25 16:07:03.998612 
Consumer   1 consumed  52 from index   2 at time 2021-03-25 16:07:03.998840 
Consumer   1 consumed  60 from index   3 at time 2021-03-25 16:07:03.999144 
Consumer   1 consumed  62 from index   4 at time 2021-03-25 16:07:03.999374 
Consumer   1 consumed  52 from index   5 at time 2021-03-25 16:07:03.999687 
Consumer   1 consumed  69 from index   6 at time 2021-03-25 16:07:03.999836 
Consumer   1 consumed  76 from index   7 at time 2021-03-25 16:07:04.000020 

Producer(s): Finished producing 18 items with checksum being 864
Consumer(s): Finished consuming 18 items with checksum being 864

maggot:~/cs370/hw5$ java Coordinator 7 21 3 3 7 (UNDERLINE COULD NOT BE COPIED OVER)
Producer   1 inserted  36  at  index   0 at time 2021-03-25 16:08:09.545321 
Producer   1 inserted  64  at  index   1 at time 2021-03-25 16:08:09.555187 
Producer   1 inserted  85  at  index   2 at time 2021-03-25 16:08:09.555677 
Producer   1 inserted  44  at  index   3 at time 2021-03-25 16:08:09.556273 
Producer   1 inserted  80  at  index   4 at time 2021-03-25 16:08:09.556681 
Producer   1 inserted  54  at  index   5 at time 2021-03-25 16:08:09.557093 
Producer   1 inserted  68  at  index   6 at time 2021-03-25 16:08:09.557605 
Consumer   3 consumed  36 from index   0 at time 2021-03-25 16:08:09.558104 
Consumer   3 consumed  64 from index   1 at time 2021-03-25 16:08:09.558437 
Consumer   3 consumed  85 from index   2 at time 2021-03-25 16:08:09.558697 
Consumer   3 consumed  44 from index   3 at time 2021-03-25 16:08:09.559011 
Consumer   3 consumed  80 from index   4 at time 2021-03-25 16:08:09.559319 
Consumer   3 consumed  54 from index   5 at time 2021-03-25 16:08:09.559570 
Consumer   3 consumed  68 from index   6 at time 2021-03-25 16:08:09.559821 
Producer   3 inserted  36  at  index   0 at time 2021-03-25 16:08:09.560438 
Producer   3 inserted  64  at  index   1 at time 2021-03-25 16:08:09.560887 
Producer   3 inserted  85  at  index   2 at time 2021-03-25 16:08:09.561283 
Producer   3 inserted  44  at  index   3 at time 2021-03-25 16:08:09.561649 
Producer   3 inserted  80  at  index   4 at time 2021-03-25 16:08:09.562024 
Producer   3 inserted  54  at  index   5 at time 2021-03-25 16:08:09.562346 
Producer   3 inserted  68  at  index   6 at time 2021-03-25 16:08:09.562741 
Consumer   1 consumed  36 from index   0 at time 2021-03-25 16:08:09.563228 
Consumer   1 consumed  64 from index   1 at time 2021-03-25 16:08:09.563451 
Consumer   1 consumed  85 from index   2 at time 2021-03-25 16:08:09.563772 
Consumer   1 consumed  44 from index   3 at time 2021-03-25 16:08:09.564007 
Consumer   1 consumed  80 from index   4 at time 2021-03-25 16:08:09.564287 
Consumer   1 consumed  54 from index   5 at time 2021-03-25 16:08:09.564607 
Consumer   1 consumed  68 from index   6 at time 2021-03-25 16:08:09.564802 
Producer   2 inserted  36  at  index   0 at time 2021-03-25 16:08:09.565051 
Producer   2 inserted  64  at  index   1 at time 2021-03-25 16:08:09.565359 
Producer   2 inserted  85  at  index   2 at time 2021-03-25 16:08:09.565569 
Producer   2 inserted  44  at  index   3 at time 2021-03-25 16:08:09.565772 
Producer   2 inserted  80  at  index   4 at time 2021-03-25 16:08:09.565980 
Producer   2 inserted  54  at  index   5 at time 2021-03-25 16:08:09.566253 
Producer   2 inserted  68  at  index   6 at time 2021-03-25 16:08:09.566446 
Consumer   2 consumed  36 from index   0 at time 2021-03-25 16:08:09.566639 
Consumer   2 consumed  64 from index   1 at time 2021-03-25 16:08:09.566791 
Consumer   2 consumed  85 from index   2 at time 2021-03-25 16:08:09.567007 
Consumer   2 consumed  44 from index   3 at time 2021-03-25 16:08:09.567216 
Consumer   2 consumed  80 from index   4 at time 2021-03-25 16:08:09.567397 
Consumer   2 consumed  54 from index   5 at time 2021-03-25 16:08:09.567620 
Consumer   2 consumed  68 from index   6 at time 2021-03-25 16:08:09.567737 

Producer(s): Finished producing 21 items with checksum being 1293
Consumer(s): Finished consuming 21 items with checksum being 1293