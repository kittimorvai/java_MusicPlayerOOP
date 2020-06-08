package academy.learnprogramming;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class User extends Recommendation {
    private String nickname;
    private ArrayList<Music> likedMusic;
    private ArrayList<Music> hatedMusic;

    public User(String nickname) {
        this.nickname = nickname;
        this.likedMusic = new ArrayList<Music>();
        this.hatedMusic = new ArrayList<Music>();
    }
    public User(){                  ///?????????Jana

    }
    public static User createUser (String name){
        return new User(name);
    }
    public String getNickname() {
        return nickname;
    }
    public ArrayList<Music> getLikedMusic() {
        return likedMusic;
    }
    public ArrayList<Music> getHatedMusic() {
        return hatedMusic;
    }



}
