import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
public class Tic_Tac_Toe implements ActionListener
{
    //Instantiation
    Random rand = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel buttons_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];//Array of 9 buttons
    boolean Player1_turn;


    //Tic-Tac-Toe Constructor
    Tic_Tac_Toe() {   //Frame Characteristics
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setBackground(new Color(25, 25, 25));
        textfield.setForeground(new Color(25, 255, 0));
        textfield.setFont(new Font("Arial", Font.BOLD, 75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic Tac Toe");
        textfield.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 800, 100);

        buttons_panel.setLayout(new GridLayout(3, 3));
        buttons_panel.setBackground(new Color(150, 150, 150));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttons_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title_panel.add(textfield);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(buttons_panel);

        firstTurn();

    }


        public void actionPerformed(java.awt.event.ActionEvent e)
        {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (Player1_turn) {
                    //Player 1
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        Player1_turn = false;
                        textfield.setText("O Turn");
                        Check();

                    }
                } else {
                    //Player 2
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("O");
                        Player1_turn = true;
                        textfield.setText("X Turn");
                        Check();
                    }
                }

            }
        }
    }
        //Method Checks who's turn is first
        public void firstTurn ()
        {
            try {
                Thread.sleep(2000);//REQUIRED TO SURROUND IN TRY,CATCH
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (rand.nextInt(2) == 0) {
                Player1_turn = true;
                textfield.setText("X Turn");

            } else {
                Player1_turn = false;
                textfield.setText("O Turn");
            }

        }

        public void xWins ( int a, int b, int c)
        {
           buttons[a].setBackground(Color.GREEN);
           buttons[b].setBackground(Color.GREEN);
           buttons[c].setBackground(Color.GREEN);

            for (int i = 0; i < 9; i++)
            {
                buttons[i].setEnabled(false);
            }
            textfield.setText("X Wins");

        }
        public void oWins ( int a, int b, int c)
        {
            buttons[a].setBackground(Color.GREEN);
            buttons[b].setBackground(Color.GREEN);
            buttons[c].setBackground(Color.GREEN);

            for (int i = 0; i < 9; i++)
            {
                buttons[i].setEnabled(false);
            }
            textfield.setText("O Wins");

        }

        public void Check()
        {
            //Check if X wins
            //
            if      ((buttons[0].getText()=="X") &&
                    (buttons[1].getText()=="X")&&
                    (buttons[2].getText()=="X"))
            {
                xWins(0,1,2);
            }

            if      ((buttons[3].getText()=="X") &&
                    (buttons[4].getText()=="X")&&
                    (buttons[5].getText()=="X"))
            {
                xWins(3,4,5);
            }

            if      ((buttons[6].getText()=="X") &&
                    (buttons[7].getText()=="X")&&
                    (buttons[8].getText()=="X"))
            {
                xWins(6,7,8);
            }

            if      ((buttons[0].getText()=="X") &&
                    (buttons[3].getText()=="X")&&
                    (buttons[6].getText()=="X"))
            {
                xWins(0,3,6);
            }

            if      ((buttons[1].getText()=="X") &&
                    (buttons[4].getText()=="X")&&
                    (buttons[7].getText()=="X"))
            {
                xWins(1,4,7);
            }

            if      ((buttons[2].getText()=="X") &&
                    (buttons[5].getText()=="X")&&
                    (buttons[8].getText()=="X"))
            {
                xWins(2,5,8);
            }

            if      ((buttons[0].getText()=="X") &&
                    (buttons[4].getText()=="X")&&
                    (buttons[8].getText()=="X"))
            {
                xWins(0,4,8);
            }

            if      ((buttons[2].getText()=="X") &&
                    (buttons[4].getText()=="X")&&
                    (buttons[8].getText()=="X"))
            {
                xWins(2,4,6);
            }

            if      ((buttons[3].getText()=="X") &&
                    (buttons[5].getText()=="X")&&
                    (buttons[7].getText()=="X"))
            {
                xWins(3,5,7);
            }

            //Check if O wins
            if      ((buttons[0].getText()=="O") &&
                    (buttons[1].getText()=="O")&&
                    (buttons[2].getText()=="O"))
            {
                oWins(0,1,2);
            }

            if      ((buttons[3].getText()=="O") &&
                    (buttons[4].getText()=="O")&&
                    (buttons[5].getText()=="O"))
            {
                oWins(3,4,5);
            }

            if      ((buttons[6].getText()=="O") &&
                    (buttons[7].getText()=="O")&&
                    (buttons[8].getText()=="O"))
            {
                oWins(6,7,8);
            }

            if      ((buttons[0].getText()=="O") &&
                    (buttons[3].getText()=="O")&&
                    (buttons[6].getText()=="O"))
            {
                oWins(0,3,6);
            }

            if      ((buttons[1].getText()=="O") &&
                    (buttons[4].getText()=="O")&&
                    (buttons[7].getText()=="O"))
            {
                oWins(1,4,7);
            }

            if      ((buttons[2].getText()=="O") &&
                    (buttons[5].getText()=="O")&&
                    (buttons[8].getText()=="O"))
            {
                oWins(2,5,8);
            }

            if      ((buttons[0].getText()=="O") &&
                    (buttons[4].getText()=="O")&&
                    (buttons[8].getText()=="O"))
            {
                oWins(0,4,8);
            }

            if      ((buttons[2].getText()=="O") &&
                    (buttons[4].getText()=="O")&&
                    (buttons[8].getText()=="O"))
            {
                xWins(2,4,6);
            }

            if      ((buttons[3].getText()=="O") &&
                    (buttons[5].getText()=="O")&&
                    (buttons[7].getText()=="0"))
            {
                oWins(3,5,7);
            }

        }

    }
