public class todo {
    private String title;
    private String category;
    private String date;
    private String status = "On_Process";

    public String getTitle(){
        return this.title;
    }
    public String getCategory(){
        return this.category;
    }
    public String date(){
        return this.date;
    }

    public String getStatus(){
        return this.status;
    }
    
    public void setTitle(String title){
        this.title = title;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public void setDate(String date){
        this.date = date;
    }



    @Override
    public String toString() {
        return "Title = " + getTitle() + " , Category = " + getCategory() + " , date = " + date()
                + " , Status = " + getStatus() ;
    }
    public void updateStatus(String status){
        this.status = status;
    }

    public todo(String title, String category, String date) {
        this.title = title;
        this.category = category;
        this.date = date;
    }

}
