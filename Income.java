import java.time.LocalDate;

class Income{
    private String name;
    private int amount;
    private IncomeCategory category;
    private LocalDate date;

    public Income(String name, int amount, IncomeCategory category){
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

    public IncomeCategory getCategory(){
        return category;
    }
}