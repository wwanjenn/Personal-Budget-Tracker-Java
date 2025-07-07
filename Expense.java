class Expense{
    private String name;
    private int amount;
    private String category;

    public String getName(){
        return name;
    }

    public int getAmount(){
        return amount;
    }

    public String getCategory(){
        return category;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAmount(int amount){
        this.amount = amount;
    }

    public void setCategory(String category){
        this.category = category;
    }
}