import javax.swing.*;
import javax.swing.border.Border;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout; 

public class TrackerView extends JFrame{
    private JTextField nameField;
    private JTextField amountField;
    private JComboBox<Object> categoryBox;
    private JComboBox<String> typeBox;
    private JButton submitButton;
    private JPanel entriesPanel;
    private JComboBox<String> filterTypeBox;
    private JButton filterButton;

    public TrackerView(){
        setTitle("Personal Budget Tracker");
        setSize(1080, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        entriesPanel = new JPanel();
        entriesPanel.setLayout(new BoxLayout(entriesPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(entriesPanel);
        scrollPane.setPreferredSize(new Dimension(1080, 200));
        add(scrollPane, BorderLayout.NORTH);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(5, 2, 10, 10));

        filterTypeBox = new JComboBox<>(new String[]{"All", "Expense", "Income"});
        filterButton = new JButton("Filter");

        JPanel filterPanel = new JPanel();
        filterPanel.add(new JLabel("Filter by Type: "));
        filterPanel.add(filterTypeBox);
        filterPanel.add(filterButton);
        add(filterPanel, BorderLayout.SOUTH);

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

    public void addEntriesDisplay(String displayText){
        JPanel card = new JPanel();
        card.setLayout(new BorderLayout());
        card.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        card.add(new JLabel(displayText), BorderLayout.CENTER);
        entriesPanel.add(card);
        entriesPanel.revalidate();
        entriesPanel.repaint();
    }

    public void clearEntriesDisplay(){
        entriesPanel.removeAll();
        entriesPanel.revalidate();
        entriesPanel.repaint();
    }

    public String getFilterType(){
        return (String) filterTypeBox.getSelectedItem();
    }

    public JButton getFilterButton(){
        return filterButton;
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