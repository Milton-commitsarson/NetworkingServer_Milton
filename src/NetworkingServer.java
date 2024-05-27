import java.net.*;
import java.io.*;


public class NetworkingServer {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket client;

        int portnummer = 60000;
        if (args.length >= 1) {
            portnummer = Integer.parseInt(args[0]);
        }

        try {
            server = new ServerSocket(portnummer);
        } catch (Exception ie) {
            System.out.println("Cannot open socket." + ie);
            System.exit(1);
        }
        System.out.println("Server socket is created " + server);
        while (true) {
            try {
                System.out.println("Wating for connect request...");
                client = server.accept();

                System.out.println("Connect request accepted...");
                String clientHost =
                        client.getInetAddress().getHostAddress();
                int clientPort = client.getPort();
                System.out.println("client host=" + clientHost + "Client port =" + clientPort);

                InputStream clientIn = client.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(clientIn));

                String msgFromClient = br.readLine();
                System.out.println("Message received from client = " + msgFromClient);
                if (msgFromClient != null && !msgFromClient.equalsIgnoreCase("bye")) {

                    OutputStream clientOut = client.getOutputStream();
                    PrintWriter pw = new PrintWriter(clientOut, true);
                    String ansMsg = "Hello, " + msgFromClient;
                    pw.println(ansMsg);
                }
                if (msgFromClient != null && msgFromClient.equalsIgnoreCase("bye")) {
                    server.close();
                    client.close();
                    break;
                }
            } catch (IOException ie) {
            }
        }
    }
}

