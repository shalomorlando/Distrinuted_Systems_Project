import java.util.regex.Pattern;

public class ServerProtocal {
    private static final int INITIALSTATE = 0;
    private static final int REQUESTSTUDENTNUMBER = 1;
    private static final int REQUESTSTUDENTNAME = 2;
    private static final int REQUESTSTUDENTDETAILS = 3;
    private static final int REQUESTPERSONALCODE = 4;
    private static final int REQUESTALLINFO = 5;

    private int state = INITIALSTATE;

    public String processInput(String theInput) {
        String theOutput = null;

        if (state == INITIALSTATE) {
            theOutput = "What is your student number? (enter a 6 digit numeric value like 111531)";
            state = REQUESTSTUDENTNUMBER;
        }
        else if (state == REQUESTSTUDENTNUMBER) {
            //check for the input's validity - valid 6 digit student number
            theOutput = "What is your firstname and surname (whitespace separated)?";
            state = REQUESTSTUDENTNAME;
        }
        else if (state == REQUESTSTUDENTNAME) {
            theOutput = "What is your Faculty  and course (whitespace separated)?";
            state = REQUESTSTUDENTDETAILS;
        }
        else if (state == REQUESTSTUDENTDETAILS){
            theOutput = "What is your Personal Code?";
            state = REQUESTPERSONALCODE;
        } else if (state == REQUESTPERSONALCODE) {
            theOutput = "Send all your information!";
            state = REQUESTALLINFO;
        } else if (state == REQUESTALLINFO) {
            theOutput = "Bye!";
            state = INITIALSTATE;
        }
        return theOutput;
    }
}
