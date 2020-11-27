public enum ValidationCodes{
    invalidUserFileType,
    invalidTweetFileType,
    userFileNotExist,
    tweetsFileNotExist,
    greaterNotSignExists,
    userNotExists,
    tweetNotExist,
    tweetLengthTooLong,
    followsNotExist,
    followingPeopleNotExist,
    valid;



    public String toString(String nextLine, int lineNumber) {
        switch(this){
            case invalidUserFileType: return "The input user file provided needs to be of type .txt";
            case invalidTweetFileType: return "The input tweets file provided needs to be of type .txt";
            case userFileNotExist: return "The input user file does not exist. Please provide a valid file name.";
            case tweetsFileNotExist: return "The input tweets file does not exist. Please provide a valid file name.";
            case greaterNotSignExists: return "The format of the content on line: "+ lineNumber +" is incorrect.";
            case userNotExists: return "There exists a tweet with no user on line: "+ lineNumber +".";
            case tweetNotExist: return "The user on line: "+ lineNumber +" has not tweeted anything.";
            case tweetLengthTooLong: return "The tweet on line: "+ lineNumber +" has more than 280 characters.";
            case followsNotExist: return "The format of the content on line: "+ lineNumber +" is incorrect.";
            case followingPeopleNotExist: return "The user on line: "+ lineNumber +" is following no one.";
            case valid: return "";
            default: return "";
        }
    }
}