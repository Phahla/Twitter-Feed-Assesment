import java.io.File;

class Main{


    public static void main(String[] args) {
        
        try {
            ErrorHandling errorHandling = new ErrorHandling();
            errorHandling.checkIfArgsLengthValid(args.length);

            errorHandling.inputFileTypeChecker(args[0], args[1]);
    
            File userFileDir = new File(args[0]);
            File tweetsFileDir = new File(args[1]);
            errorHandling.checkIfFilesExist(userFileDir,tweetsFileDir);
    
            Users users = new Users(userFileDir);
            Tweets tweets = new Tweets(tweetsFileDir);
            Display display = new Display(users, tweets);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }

    }
}