import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Tweets {
    
    private Scanner scannedFile;
    ErrorHandling errorHandling = new ErrorHandling();
    private ArrayList<ArrayList<String>> tweets = new ArrayList<ArrayList<String>>();

    Tweets(){}

    Tweets(File fileName){
        try {
            scannedFile = new Scanner(fileName);            
		} catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        }
        
        readFromFile();
    }  

    public ArrayList<ArrayList<String>> getTweets(){
        return tweets;
    }

    private void readFromFile(){
        int lineNumber = 0;

        try {
            while (scannedFile.hasNextLine()){
                tweets.add(new ArrayList<String>());
    
                String nextLine = scannedFile.nextLine();
                errorHandling.checkForGreaterSign(nextLine, lineNumber);
    
                String userName = nextLine.substring(0, nextLine.indexOf(">")).replaceAll("\\s+","");
                errorHandling.checkIfUserExists(userName, lineNumber);
    
                tweets.get(lineNumber).add(userName.replaceAll("\\s+",""));
                String tweet = nextLine.substring(nextLine.indexOf(">")+1,nextLine.length());
                errorHandling.checkIfTweetExists(tweet, lineNumber);
    
                errorHandling.checkTweetLength(tweet, lineNumber);
    
                tweets.get(lineNumber).add(tweet);
                lineNumber++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(0);        }
    }


}
