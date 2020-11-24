import java.io.File;

class Main{

    public static void checkIfArgsLengthValid(int len){
        try {
            if(len != 2){
                throw new Exception("There needs to be two arguments passed in when running the program.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(0);
        }
    }

    public static void inputFileTypeChecker(String usersFile,String tweetsFile ){

        try {
            if(usersFile.indexOf(".") == -1 || !usersFile.substring(usersFile.lastIndexOf("."), usersFile.length()).equals(".txt")){
                throw new Exception("The input user file provided needs to be of type .txt");
            }else if(tweetsFile.indexOf(".") == -1 || !tweetsFile.substring(tweetsFile.lastIndexOf("."), tweetsFile.length()).equals(".txt")){
                throw new Exception("The input tweets file provided needs to be of type txt");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(0);
        }
    }

    public static void checkIfFilesExist(File userFileDir,File tweetsFileDir){
        try {

            if(!userFileDir.exists()){
                throw new Exception("The input user file does not exist. Please provide a valid file name.");
            }else if(!tweetsFileDir.exists()){
                throw new Exception("The input tweets file does not exist. Please provide a valid file name.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(0);        
        }
    }
    
    public static void main(String[] args) {
        
        checkIfArgsLengthValid(args.length);

        inputFileTypeChecker(args[0], args[1]);

        File userFileDir = new File(args[0]);
        File tweetsFileDir = new File(args[1]);
        checkIfFilesExist(userFileDir,tweetsFileDir);

        Users users = new Users(userFileDir);
        Tweets tweets = new Tweets(tweetsFileDir);
        Display display = new Display(users, tweets);

    }
}