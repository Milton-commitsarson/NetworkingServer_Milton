import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class NetworkingServer {
    public static void main(String [] args){
        ServerSocket server =  null;
        Socket client;

        int portnummer = 1234;
        if(args.length>= 1){
            portnummer = Integer.parseInt(args[0]);
        }

        try {
server = new ServerSocket(portnummer);
        } catch (Exception e) {
            System.out.println("Cannot open socket." + ie);
            System.exit(1);
        }
        System.out.println("Server socket is created "+ server);
        while (true){
            try {
                System.out.println("Wating for connect request...");
                client = server.accept();

                System.out.println("Connect request accepted...");
                String clientHost =
                        client.getInetAddress().getHostAddress();
                int clientPort = client.getPort();
                System.out.println("client host="  + clientHost +"Client port ="+clientPort);
                InputStream
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
