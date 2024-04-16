import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
public class GUI{

    JFrame frame;
    JPanel panel1;
    JPanel panel2;
    JPanel panel3;
    JLabel greet;
    JLabel message;

    JLabel bank;
    JLabel wallet;
    JLabel e1;
    JTextField housing;

    JLabel e2;
    JTextField transportation;

    JLabel e3;
    JTextField food;

    JLabel e4;
    JTextField utilities;

    JLabel e5;
    JTextField insurance;

    JLabel e6;
    JTextField medicalHealthCare;

    JLabel e7;
    JTextField savingsDebtInvest;

    JLabel e8;
    JTextField personalSpending;

    JLabel e9;
    JTextField totalIncome;
    //putting in array to loop through and add elements
    JTextField[] expenses = {housing, transportation, food, utilities,insurance, medicalHealthCare, savingsDebtInvest, personalSpending};
    JLabel m1;
    JLabel m2;
    JLabel m3;
    JLabel m4;
    JLabel m5;
    JLabel m6;
    JLabel m7;
    JLabel m8;
    JLabel m9;

    JButton submit;

    public GUI(){
        //making frames and panels as well as creating images for header
        frame = new JFrame();
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        bank = new JLabel();
        bank.setIcon(new ImageIcon(new ImageIcon("src/bankImg.jpg").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
        wallet = new JLabel();
        wallet.setIcon(new ImageIcon(new ImageIcon("src/wallet.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));

        panel1.setLayout(new GridBagLayout());
        panel1.setBackground(Color.GRAY);
        panel1.setBorder(BorderFactory.createEmptyBorder(10,30,10,0));

        panel2.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();


        //making header
        greet = new JLabel("Welcome!");
        greet.setFont(new Font("Verdana", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel1.add(greet,gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0,10,0,10);
        panel1.add(bank,gbc);
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.insets = new Insets(0,0,0,0);
        panel1.add(wallet,gbc);

        //creating all the prompts
        message = new JLabel("Enter Your expenses below:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel2.add(message,gbc);

        e1 = new JLabel("Housing:");
        e2 = new JLabel("Transportation:");
        e3 = new JLabel("Food:");
        e4 = new JLabel("Utilities:");
        e5 = new JLabel("Insurance:");
        e6 = new JLabel("Medical/Health Care:");
        e7 = new JLabel("Monthly debt/loan payment:");
        e8 = new JLabel("Personal Spending:");

        //putting in array to loop through and add elements
        JLabel[] messages = {e1,e2,e3,e4,e5,e6,e7,e8};

        //Making money signs to make format look nice
        m1 = new JLabel("$");
        m2= new JLabel("$");
        m3 = new JLabel("$");
        m4 = new JLabel("$");
        m5 = new JLabel("$");
        m6 = new JLabel("$");
        m7 = new JLabel("$");
        m8 = new JLabel("$");
        m9 = new JLabel("$");

        //putting in array to loop through and add elements
        JLabel[] moneySigns = {m1,m2,m3,m4,m5,m6,m7,m8,m9};


        //using for loops to implement elements
        //Adding anchors to make text aligned
        for(int i = 0; i < messages.length; i++){
            gbc.gridx = 0;
            gbc.gridy = 1 + i;
            gbc.anchor = GridBagConstraints.WEST;
            panel2.add(messages[i],gbc);
        }
        for(int i = 0; i < moneySigns.length; i++){
            gbc.gridx = 1;
            gbc.gridy = 1 + i;
            gbc.anchor = GridBagConstraints.EAST;
            panel2.add(moneySigns[i],gbc);
        }
        for(int i = 0; i < expenses.length; i++){
            expenses[i] = new JTextField();
            gbc.gridx = 2;
            gbc.gridy = 1 + i;
            gbc.ipadx = 35;
            panel2.add(expenses[i],gbc);
        }

        e9 = new JLabel("Total Monthly Income:");
        totalIncome = new JTextField();

        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.WEST;
        panel2.add(e9,gbc);

        gbc.gridx = 2;
        gbc.gridy = 9;
        panel2.add(totalIncome,gbc);


        //Adding submit button to create a pie chart
        submit = new JButton("See My Expenses");
        submit.addActionListener(this::ActionListener);
        gbc.gridx = 0;
        gbc.gridy = 10;
        panel2.add(submit,gbc);






        //Default operations for window
        frame.add(panel1, BorderLayout.NORTH);
        frame.add(panel2, BorderLayout.CENTER);
        frame.setSize(350,350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Expense Tracker");
        frame.setVisible(true);


    }

    public void ActionListener(ActionEvent e){


        //making frame for piechart display
        JFrame f = new JFrame("Piechart");
        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        panel.setBackground(Color.GRAY);
        panel.setBorder(BorderFactory.createEmptyBorder(20,20,10,20));
        panel2.setBackground(Color.GRAY);
        panel4.setBackground(Color.GRAY);

        //setting layouts
        panel.setLayout(new GridBagLayout());
        panel2.setLayout(new GridBagLayout());
        panel3.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        String[] values  = new String[8];

        int total = 0;
        //need both of these to create piechart and see if spending/saving more in the month

        //Put code in try block to not produce errors
        try {
            for (int i = 0; i < expenses.length; i++) {
                total = total + Integer.parseInt(expenses[i].getText());
            }
            for(int i = 0; i < expenses.length; i++){
                values[i] = String.valueOf(Math.round((Double.parseDouble(expenses[i].getText())*360)/total));
        }
            int monthIncome = Integer.parseInt(totalIncome.getText());
            monthIncome = monthIncome - total;

            pieChart p = new pieChart(values);

            JLabel key1 = new JLabel("Housing %" + (double)Math.round((Double.parseDouble(values[0])/360)*10000)/100);
            key1.setForeground(p.c1);
            key1.setFont(new Font("Roboto", Font.PLAIN, 18));
            JLabel key2 = new JLabel("Transportation %"+ (double)Math.round((Double.parseDouble(values[1])/360)*10000)/100);
            key2.setForeground(p.c2);
            key2.setFont(new Font("Roboto", Font.PLAIN, 18));

            JLabel key3 = new JLabel("Food %"+ (double)Math.round((Double.parseDouble(values[2])/360)*10000)/100);
            key3.setForeground(p.c3);
            key3.setFont(new Font("Roboto", Font.PLAIN, 18));

            JLabel key4 = new JLabel("Utilities %"+  (double)Math.round((Double.parseDouble(values[3])/360)*10000)/100);
            key4.setForeground(p.c4);
            key4.setFont(new Font("Roboto", Font.PLAIN, 18));

            JLabel key5 = new JLabel("Insurance %"+  (double)Math.round((Double.parseDouble(values[4])/360)*10000)/100);
            key5.setForeground(p.c5);
            key5.setFont(new Font("Roboto", Font.PLAIN, 18));

            JLabel key6 = new JLabel("Medical/Health Care %"+ (double)Math.round((Double.parseDouble(values[5])/360)*10000)/100);
            key6.setForeground(p.c6);
            key6.setFont(new Font("Roboto", Font.PLAIN, 18));

            JLabel key7 = new JLabel("Monthly debt/loan payment %"+  (double)Math.round((Double.parseDouble(values[6])/360)*10000)/100);
            key7.setForeground(p.c7);
            key7.setFont(new Font("Roboto", Font.PLAIN, 18));

            JLabel key8 = new JLabel("Personal Spending %"+ (double)Math.round((Double.parseDouble(values[7])/360)*10000)/100);
            key8.setForeground(p.c8);
            key8.setFont(new Font("Roboto", Font.PLAIN, 18));


            //Adding key to first panel on the left
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.WEST;
            panel.add(key1,gbc);

            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.anchor = GridBagConstraints.WEST;
            panel.add(key2,gbc);
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.anchor = GridBagConstraints.WEST;
            panel.add(key3,gbc);

            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.anchor = GridBagConstraints.WEST;
            panel.add(key4,gbc);

            gbc.gridx = 0;
            gbc.gridy = 4;
            gbc.anchor = GridBagConstraints.WEST;
            panel.add(key5,gbc);

            gbc.gridx = 0;
            gbc.gridy = 5;
            gbc.anchor = GridBagConstraints.WEST;
            panel.add(key6,gbc);

            gbc.gridx = 0;
            gbc.gridy = 6;
            gbc.anchor = GridBagConstraints.WEST;
            panel.add(key7,gbc);

            gbc.gridx = 0;
            gbc.gridy = 7;
            gbc.anchor = GridBagConstraints.WEST;
            panel.add(key8,gbc);

            //Header
            JLabel m1 = new JLabel("My Expenses");
            m1.setFont(new Font("Lemon Milk", Font.BOLD, 25));
            m1.setForeground(Color.orange);

            gbc.gridx = 0;
            gbc.gridy = 0;
            panel2.add(m1,gbc);

            //Pie Chart
            gbc.gridx = 0;
            gbc.gridy = 0;
            panel3.add(p,gbc);

            //Total spending on the bottom
            JLabel m2 = new JLabel();
            if(monthIncome < 0) {
                m2.setText("You are $" + Math.abs(monthIncome)+" Over your income.");
                m2.setFont(new Font("Lemon Milk", Font.BOLD, 20));
                m2.setForeground(Color.RED);
            }else if(monthIncome > 0){
                m2.setText("You are $" + monthIncome + " under your income!");
                m2.setFont(new Font("Lemon Milk", Font.BOLD, 20));
                m2.setForeground(Color.GREEN);
            }else{
                m2.setText("You are breaking even.");
                m2.setFont(new Font("Lemon Milk", Font.BOLD, 20));
                m2.setForeground(Color.YELLOW);
            }
            gbc.gridx = 0;
            gbc.gridy = 0;
            panel4.add(m2,gbc);

            f.add(panel, BorderLayout.WEST);
            f.add(panel2, BorderLayout.NORTH);
            f.add(panel3, BorderLayout.CENTER);
            f.add(panel4, BorderLayout.SOUTH);
            p.setPreferredSize(new Dimension(500, 400));
            f.pack();
            f.setLocationRelativeTo(null);
            f.setVisible(true);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            f.repaint();

            //catches empty fields or incorrect fields and displays error message
        }catch(Exception a){
            JOptionPane.showMessageDialog(frame, "Incorrect field submission.","Error", JOptionPane.ERROR_MESSAGE);
            panel1.revalidate();
        }


    }
}
