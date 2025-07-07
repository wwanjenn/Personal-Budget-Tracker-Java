import javax.swing.*;

public class TrackerView extends JFrame{
    private JTextField nameField;
    private JTextField amountField;
    private JComboBox<ExpenseCategory> expenseBox;
    private JComboBox<IncomeCategory> incomeBox;
    private JComboBox<String> typeBox;
    private JButton sumbitButton;

    public TrackerView(){
        setTitle("Personal Budget Tracker");
        setSize(1080, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(5, 2, 10, 10));

        nameField = new JTextField();
        amountField = new JTextField();

        typeBox = new JComboBox<>(new String[]{"Expense", "Income"});

        expenseBox = new JComboBox<>(ExpenseCategory.values());
        incomeBox = new JComboBox<>(IncomeCategory.values());

        formPanel.add(new JLabel("Name: "));
        formPanel.add(nameField);

        formPanel.add(new JLabel("Amount: "));
        formPanel.add(amountField);

        formPanel.add(new JLabel("Type: "));
        formPanel.add(typeBox);

        formPanel.add(new JLabel("Expense Category: "));
        formPanel.add(expenseBox);

        formPanel.add(new JLabel("Income Category: "));
        formPanel.add(incomeBox);
        
        formPanel.add(new JLabel(""));
        formPanel.add(sumbitButton);

        add(formPanel);

        setVisible(true);

    }

}