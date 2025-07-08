import java.util.List;
import java.util.ArrayList;

class TrackerController {
    private  TrackerView view;
    private List<Object> entries;

    public TrackerController(TrackerView view){
        this.view = view;
        this.entries = new ArrayList<>();

        view.getSubmitButton().addActionListener(e->{
            String name = view.getNameInput();
            int amount = view.getAmountInput();
            String type = view.getTypeCategory();
            Object category = view.getExpenseIncomeCategory();

            if(type.equals("Income")){
                Income income = new Income(name, amount, (IncomeCategory) category);
                entries.add(income);
            } else {
                Expense expense = new Expense(name, amount, (ExpenseCategory)category);
                entries.add(expense);
            }

            System.out.println("Entry added: " + name + " - " + amount + " - " + category);
            String display = String.format("[%s] %s - ₱%d - %s", type, name, amount, category);
            view.addEntriesDisplay(display);
        });

    }

        
}