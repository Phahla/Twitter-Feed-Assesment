import java.io.File;
import java.io.FileNotFoundException;
import java.util.*; 

public class Users {
    
    private Scanner scannedFile;
    ErrorHandling errorHandling = new ErrorHandling();
    private ArrayList<ArrayList<String>> twitterUsers = new ArrayList<ArrayList<String>>();

    Users(){}

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

    private int indexOfuser(String userName){
        for(int i = 0; i < twitterUsers.size();i++){
            if(twitterUsers.get(i).get(0).equals(userName)){
                return i;   
            }
        }
        return -1;
    }

    private void addNewUserAndFollowers(String userName, ArrayList<String> twitterUser, String [] following){
        twitterUsers.add(twitterUser);
        twitterUser.add(userName);
        for(int i = 0; i < following.length; i++){
            twitterUsers.get(twitterUsers.size()-1).add(following[i]);
        }
    }

    private void appendUser(ArrayList<String> twitterUser, String [] following){
        for(int i = 0; i < following.length; i++){
            if(!twitterUser.contains(following[i])){
                twitterUser.add(following[i]);
            }    
        } 
    }

    private void readFromFile(){
        try {
                    
            int lineNumber = 0;
            
            while (scannedFile.hasNextLine()){
            
                String nextLine = scannedFile.nextLine();
                errorHandling.checkIfFollowsExists(nextLine, lineNumber);

                String userName = nextLine.substring(0, nextLine.indexOf("follows")).replaceAll("\\s+","");
                errorHandling.checkIfUserExists(userName, lineNumber);

                int existingLineNumber = indexOfuser(userName);

                String listOfPeopleFollowing = nextLine.substring(nextLine.indexOf("follows")+7,nextLine.length()).replaceAll("\\s+","");
                errorHandling.checkIfUserIsFollowingAnyone(listOfPeopleFollowing, lineNumber);

                String [] following = listOfPeopleFollowing.split(",");
                
                ArrayList<String> twitterUser = existingLineNumber == -1 ? new ArrayList<String> () : twitterUsers.get(existingLineNumber); 
                
                if(existingLineNumber == -1){
                    addNewUserAndFollowers(userName, twitterUser, following);
                }else{
                    appendUser(twitterUser, following);
                }
                lineNumber++;
            } 
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(0);        
        }   
    }
    
}
