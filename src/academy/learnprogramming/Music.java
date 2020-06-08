package academy.learnprogramming;

public class Music extends User {
    private String title;
    private String performer;

    public Music(){}        //??????Jana
    public Music(String nickname, String title, String performer) {
        super(nickname);
        this.title = title;
        this.performer = performer;
    }
    public Music (String title, String performer){
        this.title = title;
        this.performer = performer;
    }
    public static Music createMusic (String title, String performer){
        return new Music (title, performer);
    }


    public String getTitle() {
        return title;
    }

    public String getPerformer() {
        return performer;
    }
}
