import java.io.File;
import java.io.FileNotFoundException;
import java.util.*; 

public class Users {
    
    private Scanner scannedFile;
    private ArrayList<ArrayList<String>> twitterUsers = new ArrayList<ArrayList<String>>();

    Users(File fileName){
        try {
            scannedFile = new Scanner(fileName);            
		} catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        }
        
        readFromFile();
    }  
 
    public ArrayList<ArrayList<String>> getTwitterUsers(){
        return twitterUsers;
    }

    private void checkIfUserExists(String nextLine, int lineNumber){
        try {
            if(nextLine.equals("")){
                throw new Exception("There exists no user on line: "+ lineNumber +".");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(0);
        }
    }
    
    private void checkIfFollowsExists(String nextLine, int lineNumber){
        try {
            if(nextLine.indexOf("follows") == -1 ){
                throw new Exception("The format of the content on line: "+ lineNumber +" is incorrect.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(0);
        }
    }

    private void checkIfUserIsFollowingAnyone(String nextLine, int lineNumber){
        try {
            if(nextLine.equals("")){
                throw new Exception("The user on line: "+ lineNumber +" is following no one.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(0);
        }
    }

    private void readFromFile(){
        
        int lineNumber = 0;
        int userCount = 0;
        while (scannedFile.hasNextLine()){
            

            String nextLine = scannedFile.nextLine();
            checkIfFollowsExists(nextLine, lineNumber);

            String userName = nextLine.substring(0, nextLine.indexOf("follows")).replaceAll("\\s+","");
            checkIfUserExists(userName, lineNumber);

            boolean exists = false;
            int existingLineNumber = 0;

            for(int i = 0; i < twitterUsers.size();i++){
                if(twitterUsers.get(i).get(0).equals(userName)){
                    exists=true;
                    existingLineNumber = i;
                        
                    break;
                }
                
            }

            String listOfPeopleFollowing = nextLine.substring(nextLine.indexOf("follows")+7,nextLine.length()).replaceAll("\\s+","");
            checkIfUserIsFollowingAnyone(listOfPeopleFollowing, lineNumber);

            String [] following = listOfPeopleFollowing.split(",");
            
            if(!exists){
                twitterUsers.add(new ArrayList<String>());
                twitterUsers.get(userCount).add(userName.replaceAll("\\s+",""));
                for(int i = 0; i < following.length; i++){
                    twitterUsers.get(userCount).add(following[i].replaceAll("\\s+",""));
                }
                userCount++;
            }else{
                for(int i = 0; i < following.length; i++){
                    if(!twitterUsers.get(existingLineNumber).contains(following[i])){
                        twitterUsers.get(existingLineNumber).add(following[i].replaceAll("\\s+",""));
                    }    
                }            
            }
            lineNumber++;
        }      
    }
    
}
