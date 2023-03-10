import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TasksDatabase extends DatabaseManager{

    public List<Task> getTasksByUser(int userId){
        List<Task> tasks = new ArrayList<>();

        try{
            String query = "SELECT * FROM tasks WHERE user_id = ?;";

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, userId);

            stmt.execute();

            ResultSet result = stmt.getResultSet();

            while(result.next()){
                var taskId = result.getInt("task_id");
                var title = result.getString("title");
                var completed = result.getBoolean("completed");

                var task = new Task(taskId, userId, title, completed);

                tasks.add(task);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return tasks;
    }

    public void insertTask(int userId, String title){

        String query = "INSERT INTO tasks (user_id, title) VALUES (?, ?);";

        try{
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, userId);
            stmt.setString(2, title);

            stmt.execute();

            stmt.close();


        }catch(SQLException e){
            e.printStackTrace();
        }

    }
}
