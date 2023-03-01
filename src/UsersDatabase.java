import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsersDatabase extends DatabaseManager {
    public List<User> getUsers(){
        List<User> users = new ArrayList<>();

        try{
            String query = "SELECT * FROM users;";

            Statement stmt = conn.createStatement();

            ResultSet result = stmt.executeQuery(query);

            while (result.next()){
                int userId = result.getInt("user_id");
                String username = result.getString("username");
                String company = result.getString("company");

                User user = new User(userId, username, company);

                users.add(user);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

        return users;
    }
}
