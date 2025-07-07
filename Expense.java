import java.time.LocalDate;

class Expense{
    private String name;
    private int amount;
    private ExpenseCategory category;
    private LocalDate date;

    public Expense(String name, int amount, ExpenseCategory category){
        this.name = name;
        this.amount = amount;
        this.category = category;
        this.date = LocalDate.now();
    }

    public String getName(){
        return name;
    }

    public int getAmount(){
        return amount;
    }

    public ExpenseCategory getCategory(){
        return category;
    }

}