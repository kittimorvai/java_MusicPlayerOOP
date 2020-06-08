package academy.learnprogramming;

public class Main {

    private static Recommendation recommendation = new Recommendation();

    public static void main(String[] args) {

        recommendation.registerUser(User.createUser("User1"));
        recommendation.registerUser(User.createUser("User2"));
       // System.out.println(recommendation.findUser("User2"));
        recommendation.addToLikes("User2", "Song1", "Performer1");
        recommendation.addToLikes("User2", "Song2", "Performer2");
        recommendation.addToLikes("User1", "Song3", "Performer3");
        recommendation.addToLikes("User2", "Song3", "Performer3");
        recommendation.addToHated("User2", "Song4", "Performer4");
        recommendation.addToHated("User1", "Song5", "Performer5");
        recommendation.addToHated("User1", "Song6", "Performer6");
        recommendation.addToHated("User2", "Song6", "Performer6");

        recommendation.printOutLiked();
        recommendation.printOutHated();
        recommendation.isTasteSimilar("User1", "User2");

    }
}
