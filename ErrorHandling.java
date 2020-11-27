import java.io.File;

public class ErrorHandling {

    public boolean checkIfArgsLengthValid(int len){
        if(len != 2){
            return false;
        }else{
            return true;
        }
          
    }

    public void inputFileTypeChecker(String usersFile,String tweetsFile ) throws Exception{
        if(usersFile.indexOf(".") == -1 || !usersFile.substring(usersFile.lastIndexOf("."), usersFile.length()).equals(".txt")){
            throw new Exception(ValidationCodes.invalidUserFileType.toString("",0));
        }else if(tweetsFile.indexOf(".") == -1 || !tweetsFile.substring(tweetsFile.lastIndexOf("."), tweetsFile.length()).equals(".txt")){
            throw new Exception(ValidationCodes.invalidTweetFileType.toString("",0));
        } 
    }

    public void checkIfFilesExist(File userFileDir,File tweetsFileDir) throws Exception{
        if(!userFileDir.exists()){
            throw new Exception(ValidationCodes.userFileNotExist.toString("",0));
        }else if(!tweetsFileDir.exists()){
            throw new Exception(ValidationCodes.tweetsFileNotExist.toString("",0));
        }
        
    }
    
    public void checkForGreaterSign(String nextLine, int lineNumber) throws Exception{
        if(nextLine.indexOf(">") == -1 ){
            throw new Exception(ValidationCodes.greaterNotSignExists.toString(nextLine,lineNumber));
        }

    }

    public void checkIfUserExists(String nextLine, int lineNumber)  throws Exception{
    
        if(nextLine.equals("")){
            throw new Exception(ValidationCodes.userNotExists.toString(nextLine,lineNumber));
        }
       
    }

    public void checkIfTweetExists(String nextLine, int lineNumber)  throws Exception{
        
        if(nextLine.replaceAll("\\s+","").equals("") ){
            throw new Exception(ValidationCodes.tweetNotExist.toString(nextLine,lineNumber));
        }

    }

    public void checkTweetLength(String nextLine, int lineNumber)  throws Exception{
        if(nextLine.length() > 280){
            throw new Exception(ValidationCodes.tweetLengthTooLong.toString(nextLine,lineNumber));

        }
    }

    public void checkIfFollowsExists(String nextLine, int lineNumber)  throws Exception{
        if(nextLine.indexOf("follows") == -1 ){
            throw new Exception(ValidationCodes.followsNotExist.toString(nextLine,lineNumber));
        }
    }

    public void checkIfUserIsFollowingAnyone(String nextLine, int lineNumber)  throws Exception{
        if(nextLine.equals("")){
            throw new Exception(ValidationCodes.followingPeopleNotExist.toString(nextLine,lineNumber));
        }
    }

}