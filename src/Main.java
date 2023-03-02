import java.util.Scanner;

public class Main {
    private static User selectedUser = null;
    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        var menuOption = 1;

        while (menuOption != 0){
            menuOption = mainMenu();

            switch (menuOption){
                case 1 -> selectUser();
                case 2 -> showTasks();
                case 3 -> addTask();
            }
        }
    }

    private static int mainMenu(){
        String selectedUsername = selectedUser == null ? "NONE" : selectedUser.username;

        for (int i = 0; i < 10; i++) {
            System.out.println();
        }

        int selection = 0;

        while (true){
            try{
                System.out.println("------- Main menu! -------");
                System.out.println("Selected user: " + selectedUsername);
                System.out.println("1: Select user");
                System.out.println("2: Show tasks");
                System.out.println("3: Add task");
                System.out.println("0: Exit");

                System.out.print("Select option: ");
                String input = scanner.next();

                selection = Integer.parseInt(input);
                break;
            }
            catch (Exception e){
                System.out.println("######################");
                System.out.println("### ENTER A NUMBER ###");
                System.out.println("######################");
            }
        }


        return selection;
    }

    private static void selectUser(){
        var usersDb = new UsersDatabase();
        var users = usersDb.getUsers();

        for(var user : users){
            System.out.println(user);
        }

        System.out.print("Select user: ");
        var userId =  scanner.nextInt();

        for(var user : users){
            if (userId == user.userId){
                selectedUser = user;
                break;
            }
        }
    }

    private static void showTasks(){
        var taskDb = new TasksDatabase();
        var tasks = taskDb.getTasksByUser(selectedUser.userId);

        for(var task : tasks){
            System.out.println(task);
        }

        pauseForInput();
    }

    private static void pauseForInput(){
        System.out.println("Press enter to continue...");

        try {
            System.in.read();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void addTask(){
        System.out.print("Enter task title: ");
        var title = scanner.next();

        var tasksDb = new TasksDatabase();

        tasksDb.insertTask(selectedUser.userId, title);

        System.out.println("Task created");

        pauseForInput();
    }
}