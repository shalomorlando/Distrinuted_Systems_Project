import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient {
    public static void main(String[] args) throws IOException {

        String hostName = "localhost";
        int portNumber = 4444;


        try (
            //client opens socket connected to the server running on the specified host + port
            Socket socket = new Socket(hostName, portNumber);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()))
        )
        {

            String fromServer;
            ClientProtocal cp = new ClientProtocal();
            String fromUser;
            String[] allInfo = new String[5];
            int counter = 0;

            while ((fromServer = in.readLine()) != null) {
                JFrame frame = new JFrame();
                if (fromServer.equals("Bye!")){
                    String all_student_info = String.join(", ", allInfo);
                    JOptionPane.showMessageDialog(frame,
                            fromServer + ": " + all_student_info,
                            "DS",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
                fromUser = cp.processServerResponse(frame, fromServer);
                if (fromUser != null) {
                    allInfo[counter] = fromUser;
                    out.println(fromUser);
                    counter++;
                }
            }
        }
        catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        }
    }
}
