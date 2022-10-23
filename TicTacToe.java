import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe implements ActionListener //implementing an interface
{
    //determine whose turn is it randomly
    //instance of the random class
    Random random=new Random();
    JFrame frame=new JFrame();
    JPanel title_panel=new JPanel();
    JPanel button_panel=new JPanel();
    JLabel textfield=new JLabel();
    JButton[] buttons=new JButton[9];
    boolean player1_turn;//true if player 1 turn false if player 2 turn


    TicTacToe()
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,900);
        frame.getContentPane().setBackground(new Color(0,0,255));
        frame.setLayout(new BorderLayout());
        //to set the frames visibillity to true
        frame.setVisible(true);

        textfield.setBackground(new Color(255,0,0));
        textfield.setForeground(new Color(25,100,0));
        textfield.setFont(new Font("Raleway Regular",Font.BOLD,80));
        textfield.setHorizontalAlignment(JLabel.CENTER);//we are not using layout manager we are using border layout
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);
        //adding title panel
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,900,200);
      button_panel.setLayout(new GridLayout(3,3));
      button_panel.setBackground(new Color(25,30,100));
         for(int i=0;i<9;i++)
         {
             buttons[i]=new JButton();
         button_panel.add(buttons[i]);
         buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
         buttons[i].setFocusable(false);
         buttons[i].addActionListener(this);
         }
        title_panel.add(textfield);
        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(button_panel);
        firstTurn();
    }
    //we need to use action performed method since we are implementing actionlistener interface


    @Override
    public void actionPerformed(ActionEvent e) {
       for(int i=0;i<9;i++)
       { //check each nine buttons
           if(e.getSource()==buttons[i])
           {
               //check whose turn
               if(player1_turn){
                   if(buttons[i].getText()==""){
                       buttons[i].setForeground(new Color(25,0,60));
                       buttons[i].setText("X");
                       player1_turn=false;
                       textfield.setText("O turn");
                       check();
                   }
               }
               else {
                   if(buttons[i].getText()==""){
                       buttons[i].setForeground(new Color(100,0,100));
                       buttons[i].setText("O");
                       player1_turn=true;
                       textfield.setText("X turn");
                       check();

               }
           }
       }
    }
    }
    //method to determine whose turn will be first
    public void firstTurn(){
        try
        {
        Thread.sleep(2500);}
        catch(InterruptedException e){
            e.printStackTrace();
        }
       //just have a random class to pick a random integer maybe between 0 and 1
        // if 0 player 1s turn
        if(random.nextInt(2)==0) {
            player1_turn=true;
            textfield.setText("X turn");
        }
        else {
            player1_turn=false;
            textfield.setText("O Turn");

        }

    }

    public void xWins(int a,int b,int c){//gonna receive winning conditions of buttons {
       buttons[a].setBackground(Color.GREEN);
       buttons[b].setBackground(Color.GREEN);
       buttons[c].setBackground(Color.GREEN);
       for(int i=0;i<9;i++){
           buttons[i].setEnabled(false);
       }
       textfield.setText("X Wins");
    }
        public void oWins(int a,int b,int c) {
            buttons[a].setBackground(Color.GREEN);
            buttons[b].setBackground(Color.GREEN);
            buttons[c].setBackground(Color.GREEN);
            for(int i=0;i<9;i++){
                buttons[i].setEnabled(false);
            }
            textfield.setText("O Wins");
        }
        public void check() {
            //chech x win
            if ((buttons[0].getText() == "X") && (buttons[1].getText() == "X") && (buttons[2].getText() == "X")) {
                xWins(0, 1, 2);
            }
            if ((buttons[6].getText() == "X") && (buttons[7].getText() == "X") && (buttons[8].getText() == "X")) {
                xWins(6, 7, 8);
            }
            if ((buttons[3].getText() == "X") && (buttons[4].getText() == "X") && (buttons[5].getText() == "X")) {
                xWins(3, 4, 5);
            }
            if ((buttons[0].getText() == "X") && (buttons[3].getText() == "X") && (buttons[6].getText() == "X")) {
                xWins(0, 3, 6);
            }
            if ((buttons[1].getText() == "X") && (buttons[4].getText() == "X") && (buttons[7].getText() == "X")) {
                xWins(1, 4, 7);
            }
            if ((buttons[2].getText() == "X") && (buttons[5].getText() == "X") && (buttons[8].getText() == "X")) {
                xWins(2, 5, 8);
            }
            if ((buttons[0].getText() == "X") && (buttons[4].getText() == "X") && (buttons[8].getText() == "X")) {
                xWins(0, 4, 8);
            }
            if ((buttons[2].getText() == "X") && (buttons[4].getText() == "X") && (buttons[6].getText() == "X")) {
                xWins(2, 4, 6);
            }
            //check o wins
            if ((buttons[0].getText() == "O") && (buttons[1].getText() == "O") && (buttons[2].getText() == "O")) {
                oWins(0, 1, 2);
            }
            if ((buttons[6].getText() == "O") && (buttons[7].getText() == "O") && (buttons[8].getText() == "O")) {
                oWins(6, 7, 8);
            }
            if ((buttons[3].getText() == "O") && (buttons[4].getText() == "O") && (buttons[5].getText() == "O")) {
                oWins(3, 4, 5);
            }
            if ((buttons[0].getText() == "O") && (buttons[3].getText() == "O") && (buttons[6].getText() == "O")) {
                oWins(0, 3, 6);
            }
            if ((buttons[1].getText() == "O") && (buttons[4].getText() == "O") && (buttons[7].getText() == "O")) {
                oWins(1, 4, 7);
            }
            if ((buttons[2].getText() == "O") && (buttons[5].getText() == "O") && (buttons[8].getText() == "O")) {
                oWins(2, 5, 8);
            }
            if ((buttons[0].getText() == "O") && (buttons[4].getText() == "O") && (buttons[8].getText() == "O")) {
                oWins(0, 4, 8);
            }
            if ((buttons[2].getText() == "O") && (buttons[4].getText() == "O") && (buttons[6].getText() == "O")) {
                oWins(2, 4, 6);
            }
        }



    }


