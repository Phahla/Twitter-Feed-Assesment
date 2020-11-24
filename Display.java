import java.util.*; 

public class Display {
    
    private Users users;
    private Tweets tweets;

    Display(Users users, Tweets tweets){
        this.users = users;
        this.tweets = tweets;

        printTweets();
    }

    private void printTweets(){
        ArrayList<ArrayList<String>> twitterUsers = users.getTwitterUsers();
        ArrayList<ArrayList<String>> userTweets = tweets.getTweets();

        for(int i = 0; i < twitterUsers.size(); i++){
            System.out.println(twitterUsers.get(i).get(0));
            for(int j = 0; j < userTweets.size(); j++){
                
                for(int k = 0; k < twitterUsers.get(i).size(); k++){
                    if(userTweets.get(j).get(0).equals(twitterUsers.get(i).get(k))){
                        System.out.println("\t @"+userTweets.get(j).get(0)+": "+userTweets.get(j).get(1));
                    }
                }
                
            }
        }
    }

}
