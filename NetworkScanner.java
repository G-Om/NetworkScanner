import java.net.InetAddress; import java.net.InetSocketAddress; import java.net.UnknownHostException;
import javax.sound.midi.Soundbank;

public class NetworkScanner {
    public static void main(String[] args) {
        String baseIp = "192.168.0."; // Local Subnet address
        int startRange = 1;
        int endRange = 254;
        for(int i = 0; i<= endRange;i++){
            String host = baseIp + i;
            if(isReachable(host)){
                System.out.println(host + " is reachable.");
            }
        }
    }

    private static boolean isReachable(String host) {
        try {
            InetAddress address = InetAddress.getByName(host);
            return address.isReachable(3000); // timeout 3s
        }catch (UnknownHostException e){
            return false;
        }catch (Exception e){
            return false;
        }
    }
}

