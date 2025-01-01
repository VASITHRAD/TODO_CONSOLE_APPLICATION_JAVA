import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class functions {
    static ArrayList<todo> arr = new ArrayList<>();

    public static void readFile(){
        
        try (BufferedReader rd = new BufferedReader(new FileReader("output.txt"))) {
            String line = "";
            String fTitle = "";
            String fCategory = "";
            String fDate = "";
            String fStatus = "";
            while((line = rd.readLine())!=null){
                todo existing = new todo("","","");
                // System.out.println(line);
                String[] fArray = line.split(" ");
                fTitle = fArray[2];
                fCategory = fArray[6];
                fDate = fArray [10];
                fStatus = fArray[14];
                existing.setCategory(fCategory);
                existing.setDate(fDate);
                existing.setTitle(fTitle);
                existing.updateStatus(fStatus);
                arr.add(existing);
            }
            System.out.println("Loaded the existing todos from file");
            }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addtodo(todo todo){
        arr.add(todo);
        System.out.println("New Task added successfully");
    }

    public static void update(String title){
        boolean found = false;
        for(todo i : arr){
            if(i.getTitle().equals(title)){
                found = true;
                i.updateStatus("Completed");
            }
        }
        if(found==false){
            System.out.println("No title exists in the name of "+" "+title);
        }
    }

    public static void deleteTodo(String delete){
        for(todo i : arr){
            if(i.getTitle().equals(delete)){
                System.out.println(i.toString()+" DELETED SUCCESSFULLY");
                arr.remove(i);
            }
        }
    }
    
    public static void searchCat(String categoryString){
        for(todo i : arr){
            if(i.getCategory().equals(categoryString)){
                System.out.println(i.toString());
                System.out.println("-----------------------------------------------------------------");
            }
        }
    }

    public static void searchtitle(String titleSearch){
        for(todo i : arr){
            if(i.getTitle().equals(titleSearch)){
                System.out.println(i.toString());
                System.out.println("-----------------------------------------------------------------");
            }
        }
    }

    public static void searchStatus(String statusSearch){
        for(todo i : arr){
            if(i.getStatus().equals(statusSearch)){
                System.out.println(i.toString());
                System.out.println("-----------------------------------------------------------------");
            }
        }
    }

    public static void display(){
        for(todo i : arr){
            System.out.println(i);
            System.out.println("-----------------------------------------------------------------------");
        }
    }

    public static void file() throws IOException{
        FileWriter fw=new FileWriter("output.txt", true); 
        for (todo  i : arr)
            try {
                fw.write(i.toString()+" \n");
            } catch (IOException e) {
                e.printStackTrace();
            } 
            System.out.println("Writing successful"); 
            fw.close(); 
    }

}
