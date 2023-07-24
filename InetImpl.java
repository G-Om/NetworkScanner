import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.Callable;

public class InetImpl implements Callable<String> {
    private final int start;
    private final int end;

    public InetImpl(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public synchronized String call() throws Exception {
        String baseIp = "192.168.0.";
        System.out.println(baseIp+start+"-"+baseIp+end);
        for (int i = start; i <= end; i++) {
            String host = baseIp + i;
            if (isReachable(host)) {
                System.out.println(host + " is reachable.");
            }
        }
        return baseIp;
    }

    public boolean isReachable(String host) {
        try {
            InetAddress address = InetAddress.getByName(host);
            return address.isReachable(3000); // timeout 3s
        } catch (UnknownHostException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
    }

}
