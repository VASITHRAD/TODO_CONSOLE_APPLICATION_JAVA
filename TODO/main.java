import java.io.IOException;
import java.util.Scanner;

public class main{
    public static void main(String[] args) throws IOException {
        while(true){
            System.out.println("TO -DO APPLICATION");
            System.out.println("Please select one option below");
            System.out.println("1. Create a new todo");
            System.out.println("2. Update Task process");
            System.out.println("3. Delete Task");
            System.out.println("4. Search task");
            System.out.println("5. Display task");
            System.out.println("6. Exit");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    functions.readFile();
                    System.out.println("Enter the title for todo : ");
                    String tit = sc.next();
                    System.out.println("Enter category : ");
                    String cat = sc.next();
                    System.out.println("Enter the date (DD-MM-YYYY) : ");
                    String dat = sc.next();
                    todo todo = new todo("", "", "");
                    todo.setCategory(cat);
                    todo.setTitle(tit);
                    todo.setDate(dat);
                    functions.addtodo(todo);
                    break;
                case 2:
                    System.out.println("Enter the title of the task to update :");
                    String title = sc.next();
                    functions.update(title);
                    System.out.println("Status Updated");
                    break;
                case 3:
                    System.out.println("Enter the title of the todo to be delete : ");
                    String delete = sc.next();
                    functions.deleteTodo(delete);
                    break;
                case 4:
                    System.out.println("Search item by \n 1. Status (On_Process or Completed) \n 2. Title \n 3. Category");
                    int ch = sc.nextInt();
                    switch (ch) {
                        case 3:
                            System.out.println("Enter the category to be searched : ");
                            String categortSearch = sc.next();
                            functions.searchCat(categortSearch);
                            break;
                        case 2:
                            System.out.println("Enter the Title to be searched");
                            String titleSearch = sc.next();
                            functions.searchtitle(titleSearch);
                            break;
                        case 1:
                            System.out.println("Enter the status to be searched : ");
                            String statusSearch = sc.next();
                            functions.searchStatus(statusSearch);
                            break;
                        default:
                            break;
                    }
                    break;
                case 5 :
                    System.out.println("DISPLAYING YOUR TODO : ");
                    functions.display();
                    break;
                case 6:
                    functions.file();
                    System.out.println("EXITING");
                    System.exit(0);
                default:
                    System.out.println("Invalid input");
                
            }
        }
    }
}