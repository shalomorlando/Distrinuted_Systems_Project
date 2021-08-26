import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.regex.Pattern;

public class ClientProtocal {
    private static final int INITIALSTATE = 0;
    private static final int SENTSTUDENTNUMBER = 1;
    private static final int SENTSTUDENTNAME = 2;
    private static final int SENTSTUDENTDETAILS = 3;
    private static final int SENTPERSONALCODE = 4;
    private static final int SENTALLINFO = 5;


    private int state = INITIALSTATE;
    BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

    public String processServerResponse() throws IOException {
        String theOutput = null;

        if (state == INITIALSTATE) {
            theOutput = stdIn.readLine();
            state = SENTSTUDENTNUMBER;
        }
        else if (state == SENTSTUDENTNUMBER) {
                theOutput = stdIn.readLine();
                state = SENTSTUDENTNAME;
        }
        else if (state == SENTSTUDENTNAME) {
                theOutput = stdIn.readLine();
                state = SENTSTUDENTDETAILS;
        }
        else if (state == SENTSTUDENTDETAILS){

            Random randomNoGenerator = new Random();
            int number = randomNoGenerator.nextInt(999999);
            theOutput = String.format("%06d", number);
            state = SENTPERSONALCODE;
        } else if (state == SENTPERSONALCODE) {
            theOutput = stdIn.readLine();
            state = SENTALLINFO;
        } else if (state == SENTALLINFO) {
            theOutput = "Bye!";
            state = INITIALSTATE;
        }
        return theOutput;
    }
}
