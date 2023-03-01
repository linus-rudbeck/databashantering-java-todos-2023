public class User {
    public int userId;
    public String username;
    public String company;

    public User(int userId, String username, String company){
        this.userId = userId;
        this.username = username;
        this.company = company;
    }

    @Override
    public String toString(){
        return userId + ": " + username + " ("+company+")";
    }
}
