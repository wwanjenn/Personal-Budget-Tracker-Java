import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridLayout; 

public class TrackerView extends JFrame{
    private JTextField nameField;
    private JTextField amountField;
    private JComboBox<Object> categoryBox;
    private JComboBox<String> typeBox;
    private JButton submitButton;
    private JPanel entriesPanel;

    public TrackerView(){
        setTitle("Personal Budget Tracker");
        setSize(1080, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        entriesPanel = new JPanel();
        entriesPanel.setLayout(new BoxLayout(entriesPanel, BoxLayout.Y_AXIS));
        add(entriesPanel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(5, 2, 10, 10));

        nameField = new JTextField();
        amountField = new JTextField();

        typeBox = new JComboBox<>(new String[]{"Expense", "Income"});
        typeBox.setSelectedIndex(0);

        categoryBox = new JComboBox<>();

        typeBox.addActionListener(e -> {
            String selectedType = (String) typeBox.getSelectedItem();
            categoryBox.removeAllItems();
            if(selectedType.equals("Income")){
                for(IncomeCategory c: IncomeCategory.values()){
                    categoryBox.addItem(c);
                }
            } else {
                for(ExpenseCategory c: ExpenseCategory.values()){
                    categoryBox.addItem(c);
                }
            }
        }); 

        submitButton = new JButton("Submit");

        formPanel.add(new JLabel("Name: "));
        formPanel.add(nameField);

        formPanel.add(new JLabel("Amount: "));
        formPanel.add(amountField);

        formPanel.add(new JLabel("Type: "));
        formPanel.add(typeBox);

        formPanel.add(new JLabel("Category: "));
        formPanel.add(categoryBox);
        
        formPanel.add(new JLabel(""));
        formPanel.add(submitButton);

        add(formPanel);

        setVisible(true);

    }

    public String getNameInput(){
        return nameField.getText();
    }

    public int getAmountInput(){
        return Integer.parseInt(amountField.getText());
    }

    public Object getExpenseIncomeCategory(){
        return (Object) categoryBox.getSelectedItem();
    }

    public String getTypeCategory(){
        return (String )typeBox.getSelectedItem();
    }

    public JButton getSubmitButton(){
        return submitButton;
    }
}