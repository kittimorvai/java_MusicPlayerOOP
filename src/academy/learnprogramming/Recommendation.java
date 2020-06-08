package academy.learnprogramming;

import java.util.ArrayList;

public class Recommendation {
    private ArrayList<User> userList;

    public Recommendation() {
        this.userList = new ArrayList<>();
    }
    private boolean check (String name){
        for (int i = 0; i < userList.size(); i++){
            if(userList.get(i).getNickname().equals(name)){
                return true;
            }
        }
        return false;
    }
    public void printOutLiked(){
        for (int i = 0; i < userList.size(); i++){
            System.out.println("\n" + userList.get(i).getNickname() + " likes: ");
            for (int j = 0; j < userList.get(i).getLikedMusic().size(); j++){
                System.out.println("\t" + userList.get(i).getLikedMusic().get(j).getTitle() + ", " + userList.get(i).getLikedMusic().get(j).getPerformer());
            }
        }
    }
    public void printOutHated(){
        for (int i = 0; i < userList.size(); i++){
            System.out.println("\n" + userList.get(i).getNickname() + " hates: ");
            for (int j = 0; j < userList.get(i).getHatedMusic().size(); j++){
                System.out.println("\t" + userList.get(i).getHatedMusic().get(j).getTitle() + ", " + userList.get(i).getHatedMusic().get(j).getPerformer());
            }
        }
    }
    private int findUser (String nameOfUser){
        for (int i = 0; i < userList.size(); i++){
            if(userList.get(i).getNickname().equals(nameOfUser)){
                return i;
            }
        }
        return -1;
    }
    public void registerUser(User newUser){
        if(!check(newUser.getNickname())){
            userList.add(newUser);
            System.out.println("User " + newUser.getNickname() + " has been registered successfully.");
        } else {
            System.out.println(newUser.getNickname() + " has been registered already.");
        }
    }
    public void addToLikes (String nameOfUser, String titleOfTrack, String performer){
        int position = findUser(nameOfUser);
        userList.get(position).getLikedMusic().add(Music.createMusic(titleOfTrack, performer));
    }
    public void addToHated (String nameOfUser, String titleOfTrack, String performer){
        int position = findUser(nameOfUser);
        userList.get(position).getHatedMusic().add(Music.createMusic(titleOfTrack, performer));
    }

    public boolean isTasteSimilar (String firstUser, String secondUser){
        int conditionOfSimilarity = 0;
        int positionFirst = findUser(firstUser);
        int positionSecond = findUser(secondUser);
        for (int i = 0; i < userList.get(positionFirst).getLikedMusic().size(); i++){
            for (int j = 0; j < userList.get(positionSecond).getLikedMusic().size();j++){
                if(userList.get(positionFirst).getLikedMusic().get(i).getTitle().equals(userList.get(positionSecond).getLikedMusic().get(j).getTitle())){
                    conditionOfSimilarity += 1;
                }
            }
        }
        for (int i = 0; i < userList.get(positionFirst).getHatedMusic().size(); i++){
            for (int j = 0; j < userList.get(positionSecond).getHatedMusic().size();j++){
                if(userList.get(positionFirst).getHatedMusic().get(i).getTitle().equals(userList.get(positionSecond).getHatedMusic().get(j).getTitle())){
                    conditionOfSimilarity += 1;
                }
            }
        }
        for (int i = 0; i < userList.get(positionFirst).getHatedMusic().size(); i++){
            for (int j = 0; j < userList.get(positionSecond).getLikedMusic().size();j++){
                if(!(userList.get(positionFirst).getHatedMusic().get(i).getTitle().equals(userList.get(positionSecond).getLikedMusic().get(j).getTitle()))){
                    conditionOfSimilarity += 1;
                }
            }
        }
        for (int i = 0; i < userList.get(positionFirst).getLikedMusic().size(); i++){
            for (int j = 0; j < userList.get(positionSecond).getHatedMusic().size();j++){
                if(!(userList.get(positionFirst).getLikedMusic().get(i).getTitle().equals(userList.get(positionSecond).getHatedMusic().get(j).getTitle()))){
                    conditionOfSimilarity += 1;
                }
            }
        }
        if(conditionOfSimilarity >= 3){
            System.out.println("\nSimilar taste");
            return true;
        } else {
            System.out.println("\nNot a similar taste");
            return false;
        }

    }



}
