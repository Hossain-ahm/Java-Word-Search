import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class Gui extends JFrame{

    

    ArrayList<String> list;
    Search search;
   
    public Gui() {
    search = new Search();
    list = new ArrayList<String>();
  
    JPanel panel = new JPanel();   
    panel.setBackground(new Color(42, 157, 143)); 
    panel.setLayout(new GridBagLayout());
        
    GridBagConstraints constraints = new GridBagConstraints();
    add(panel, BorderLayout.CENTER);  


    JLabel label=new JLabel("Word finder");
    label.setFont(new Font("Arial", Font.BOLD, 40)); 
    label.setForeground(new Color(38, 70, 83));
        
    JTextField textField=new JTextField(25);

    JTextArea output = new JTextArea(10,36);
    JScrollPane outputScrollBar = new JScrollPane(output);

    outputScrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    output.setEditable(false);
        
    JToggleButton combine = new JToggleButton("Combine");

    JButton prefix = new JButton("Prefix");

    prefix.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            output.setEditable(true);
            output.setText("");
            
            if( combine.isSelected()) {
                setList(search.combine(list, search.prefix(textField.getText())));
                for (String string: list){
                    output.append(string + "\n");
                }
            }
            else{
                
                setList(search.prefix(textField.getText()));
                for (String string : list){
                    output.append(string + "\n");
            }
        }
            output.setEditable(false);
        }
    });

    JButton suffix = new JButton("Suffix");

    suffix.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            output.setEditable(true);
            output.setText("");
            if( combine.isSelected()) {
                setList(search.combine(list, search.suffix(textField.getText())));
                for (String string: list){
                    output.append(string + "\n");
                }
            }
            else{
                
                setList(search.suffix(textField.getText()));
                for (String string : list){
                    output.append(string + "\n");
            }
        }
            output.setEditable(false);
        }
    });

    JButton contains = new JButton("Contains");

    contains.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            output.setEditable(true);
            output.setText("");
            if( combine.isSelected()) {
                setList(search.combine(list, search.contains(textField.getText())));
                for (String string: list){
                    output.append(string + "\n");
                }
            }
            else{
                
                setList(search.contains(textField.getText()));
                for (String string : list){
                    output.append(string + "\n");
            }
        }
            output.setEditable(false);
        }
    });

    JButton containsInOrder = new JButton("Contains In Order");
    containsInOrder.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            output.setEditable(true);
            output.setText("");
            if( combine.isSelected()) {
                setList(search.combine(list, search.containsInOrder(textField.getText())));
                for (String string: list){
                    output.append(string + "\n");
                }
            }
            else{
                
                setList(search.containsInOrder(textField.getText()));
                for (String string : list){
                    output.append(string + "\n");
            }
        }
            output.setEditable(false);
        }
    });

    JButton pool = new JButton("Pool");
    pool.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            setList(search.pool(textField.getText()));
            output.setEditable(true);
            output.setText("");
            if( combine.isSelected()) {
                setList(search.combine(list, search.pool(textField.getText())));
                for (String string: list){
                    output.append(string + "\n");
                }
            }
            else{
                
                setList(search.pool(textField.getText()));
                for (String string : list){
                    output.append(string + "\n");
            }
        }
            output.setEditable(false);
        }
    });


    JButton[] buttons = {prefix, suffix, contains, containsInOrder,pool}; 

    constraints.anchor = GridBagConstraints.CENTER;
    constraints.weightx = 0.5;
    constraints.weighty = 0.5;

    constraints.gridx = 0;
    constraints.gridy = 0;

    constraints.gridwidth = 5;

    panel.add(label, constraints);

    constraints.gridx = 0;
    constraints.gridy = 1;
    panel.add(textField, constraints);

    constraints.gridwidth = 1;

    constraints.gridy = 2;
    for (int i = 0; i < 5; i++){
        constraints.gridx = i;
        panel.add(buttons[i], constraints);
    }

    constraints.gridwidth = 5;

    constraints.gridy = 3;
    constraints.gridx = 0;

    panel.add(outputScrollBar, constraints);

    JPanel bottomPanel = new JPanel();
    bottomPanel.setBackground(new Color(42, 157, 143)); 
    bottomPanel.setLayout(new FlowLayout());

    add(bottomPanel, BorderLayout.SOUTH);


    bottomPanel.add(combine);

    JButton clear = new JButton("Clear");

    bottomPanel.add(clear);
    clear.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            output.setEditable(true);
            output.setText("");
            output.setEditable(false);
        }
    });


    setSize(600, 500);  
    setLocationRelativeTo(null);  
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    setVisible(true); 
    }

    public void setList (ArrayList<String> newList) {
        list = newList;
    }
    
}
