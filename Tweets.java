import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Tweets {
    
    private Scanner scannedFile;
    private ArrayList<ArrayList<String>> tweets = new ArrayList<ArrayList<String>>();

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

        while (scannedFile.hasNextLine()){
            tweets.add(new ArrayList<String>());

            String nextLine = scannedFile.nextLine();
            checkForGreaterSign(nextLine, lineNumber);

            String userName = nextLine.substring(0, nextLine.indexOf(">")).replaceAll("\\s+","");
            checkIfUserExists(userName, lineNumber);

            tweets.get(lineNumber).add(userName.replaceAll("\\s+",""));
            String tweet = nextLine.substring(nextLine.indexOf(">")+1,nextLine.length());
            checkIfTweetExists(tweet, lineNumber);

            checkTweetLength(tweet, lineNumber);

            tweets.get(lineNumber).add(tweet);
            lineNumber++;
        }
    }

    private void checkForGreaterSign(String nextLine, int lineNumber){
        try {
            if(nextLine.indexOf(">") == -1 ){
                throw new Exception("The format of the content on line: "+ lineNumber +" is incorrect.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(0);
        }
    }

    private void checkIfUserExists(String nextLine, int lineNumber){
        try {
            if(nextLine.equals("")){
                throw new Exception("There exists a tweet with no user on line: "+ lineNumber +".");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(0);
        }
    }

    private void checkIfTweetExists(String nextLine, int lineNumber){
        try {
            if(nextLine.replaceAll("\\s+","").equals("") ){
                throw new Exception("The user on line: "+ lineNumber +" has not tweeted anything.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(0);
        }
    }

    private void checkTweetLength(String nextLine, int lineNumber){
        try {
            if(nextLine.replaceAll("\\s+","").length() > 280){
                throw new Exception("The tweet on line: "+ lineNumber +" has more than 280 characters.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(0);
        }
    }
}
