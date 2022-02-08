import java.util.Scanner;

public class Duke {
    private static Task[] tasks = new Task[100];
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        System.out.println("================================================");

        int i = 0;
        int taskStartIndex;
        String userInput;
        Scanner in = new Scanner(System.in);
        do{
            userInput = in.nextLine();

            if(userInput.startsWith("mark")){
                taskStartIndex = Integer.parseInt(userInput.substring(5));
                tasks[taskStartIndex-1].markAsDone();
                System.out.println(tasks[taskStartIndex-1].printTask());
            }else if(userInput.startsWith("unmark")){
                taskStartIndex = Integer.parseInt(userInput.substring(7));
                tasks[taskStartIndex-1].markAsUndone();
                System.out.println(tasks[taskStartIndex-1].printTask());
            }else{
                switch(userInput){
                case "bye":
                    System.out.println("================================================");
                    break;
                case "list":
                    listTasks(i);
                    break;
                default:
                    System.out.println("================================================");
                    tasks[i] = addTask(userInput);
                    System.out.println(tasks[i].printTask());
                    System.out.println("Now you have " + (i+1) + " tasks in the list.");
                    System.out.println("================================================");
                    i++;
                    break;
                }
            }
        }while(!userInput.equals("bye"));

        System.out.println("Bye. Hope to see you again soon!");
    }

    public static Task addTask(String userInput){
        if (userInput.startsWith("todo")) {
            return new Todo(userInput.substring(5));
        } else if (userInput.startsWith("deadline")) {
            return new Deadline(userInput.substring(9));
        }else{
            return new Event(userInput.substring(6));
        }
    }

    public static void listTasks(int numOfTasks){
        System.out.println("================================================");
        System.out.println("Here are the tasks in your list:");
        for(int j=0; j<numOfTasks; j++){
            System.out.println((j+1) + "." + tasks[j].printTask());
        }
        System.out.println("================================================");
    }
}
