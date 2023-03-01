public class Task {
    public int taskId;
    public int userId;
    public String title;
    public boolean completed;

    public Task(int taskId, int userId, String title, boolean completed){
        this.taskId = taskId;
        this.userId = userId;
        this.title = title;
        this.completed = completed;
    }



    // 2: Walk (✔)
    // 3: Shopping ( )
    @Override
    public String toString(){
        String completedCheck = completed ? "✔" : " ";
        return taskId + ": " + title + " (" + completedCheck + ")";
    }
}
