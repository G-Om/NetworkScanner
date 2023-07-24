import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class NetworkScanner {
    public static void main(String[] args) throws InterruptedException {
        int noOftasks = 3;
        ExecutorService executor = Executors.newFixedThreadPool(noOftasks);
        System.out.println("Thread Ranges: " );
        for (int i =0; i < noOftasks;i++){
            int start = i*85 + 1;
            int end = (i+1)*85;
            if(end == 255){ end --;}
            InetImpl task = new InetImpl(start, end);
            executor.submit(task);
        }
        executor.shutdown();
	System.out.println("Tasks Done");
    }
}


