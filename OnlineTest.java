import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;
import java.util.Timer;
import java.util.TimerTask;
class signin extends JFrame implements ActionListener
{
    JButton b1;
    JPanel newPanel;
    JLabel userLabel, passLabel;
    final JTextField  textField1, textField2;
    signin()
    {
        userLabel = new JLabel();
        userLabel.setText("    Username :");
        textField1 = new JTextField(13);
        passLabel = new JLabel();
        passLabel.setText("    Password :");
        textField2 = new JPasswordField(8);
        b1 = new JButton("   SUBMIT   ");
        newPanel = new JPanel(new GridLayout(3, 1));
        newPanel.add(userLabel);
        newPanel.add(textField1);
        newPanel.add(passLabel);
        newPanel.add(textField2);
        newPanel.add(b1);
        add(newPanel, BorderLayout.CENTER);
        b1.addActionListener(this);
        setTitle("Signin Form ");
    }
    public void actionPerformed(ActionEvent ae)
    {
        String userValue = textField1.getText();
        String passValue = textField2.getText();
        if(!passValue.equals(""))
            new OnlineTeststart(userValue);
        else{
            textField2.setText("Please Enter The Password");
            actionPerformed(ae);
        }
    }
}
class OnlineTeststart extends JFrame implements ActionListener
{
    JLabel l;
    JLabel l1;
    JRadioButton jb[]=new JRadioButton[6];
    JButton b1,b2,log;
    ButtonGroup bg;
    int count=0,current=0,x=1,y=1,now=0;
    int m[]=new int[10];
    Timer timer = new Timer();
    OnlineTeststart(String s)
    {
        super(s);
        l=new JLabel();
        l1 = new JLabel();
        add(l);
        add(l1);
        bg=new ButtonGroup();
        for(int i=0;i<5;i++)
        {
            jb[i]=new JRadioButton();
            add(jb[i]);
            bg.add(jb[i]);
        }
        b1=new JButton("Save and Next");
        b2=new JButton("Save for later");
        b1.addActionListener(this);
        b2.addActionListener(this);
        add(b1);add(b2);
        set();
        l.setBounds(20,30,440,10);
        l1.setBounds(10,10,440,10);
        jb[0].setBounds(40,70,90,10);
        jb[1].setBounds(40,100,90,10);
        jb[2].setBounds(40,130,90,10);
        jb[3].setBounds(40,160,90,10);
        b1.setBounds(85,230,130,20);
        b2.setBounds(260,230,140,20);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(240,90);
        setVisible(true);
        setSize(590,340);
        timer.scheduleAtFixedRate(new TimerTask() {
            int i = 590;
            public void run() {
                l1.setText("Time left: " + i);
                i--;
                if (i < 0) {
                    timer.cancel();
                    l1.setText("Time Out");
                }
            }
        }, 0, 1000);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            if(check())
                count=count+1;
            current++;
            set();
            if(current==9)
            {
                b1.setEnabled(false);
                b2.setText("Result");
            }
        }
        if(e.getActionCommand().equals("Save for later"))
        {
            JButton bk=new JButton("Review"+x);
            bk.setBounds(480,20+30*x,100,30);
            add(bk);
            bk.addActionListener(this);
            m[x]=current;
            x++;
            current++;
            set();
            if(current==9)
                b2.setText("Result");
            setVisible(false);
            setVisible(true);
        }
        for(int i=0,y=1;i<x;i++,y++)
        {
            if(e.getActionCommand().equals("Review"+y))
            {
                if(check())
                    count=count+1;
                now=current;
                current=m[y];
                set();
                ((JButton)e.getSource()).setEnabled(false);
                current=now;
            }
        }
        if(e.getActionCommand().equals("Result"))
        {
            if(check())
                count=count+1;
            current++;
            JOptionPane.showMessageDialog(this,"Score ="+count);
            System.exit(0);
        }
    }
    void set()
    {
        jb[4].setSelected(true);
        if(current==0)
        {
            l.setText("Q.1: Which one of the following is not a prime number?");
            jb[0].setText("31");jb[1].setText("61");jb[2].setText("71");jb[3].setText("91");
        }
        if(current==1)
        {
            l.setText("Q.2: (112 x 54) = ?");
            jb[0].setText("67000");jb[1].setText("70000");jb[2].setText("76500");jb[3].setText("77200");
        }
        if(current==2)
        {
            l.setText("Q.3:To end in smoke");
            jb[0].setText("To make completely understand");jb[1].setText(" To ruin oneself");jb[2].setText("To overcome someone");jb[3].setText("None of these");
        }
        if(current==3)
        {
            l.setText("Q.4: 1397 x 1397 = ?");
            jb[0].setText("1951609");jb[1].setText("1981709");jb[2].setText("18362619");jb[3].setText("None of these");
        }
        if(current==4)
        {
            l.setText("Q.5: To make clean breast of");
            jb[0].setText("To gain prominence");jb[1].setText("To praise oneself");jb[2].setText("To confess without of reserve");jb[3].setText("\n" +
                "None of these");
        }
        if(current==5)
        {
            l.setText("Q.6: To keeps one's temper");
            jb[0].setText("To become hungry");jb[1].setText("To be in good mood");jb[2].setText("To be aloof from");jb[3].setText("None of these");
        }
        if(current==6)
        {
            l.setText("Q.7: To catch a tartar ");
            jb[0].setText("To trap wanted criminal with great difficulty");jb[1].setText("To catch a dangerous person");jb[2].setText("To meet with disaster");
            jb[3].setText("None of these");
        }
        if(current==7)
        {
            l.setText("Q.8: To drive home");
            jb[0].setText("To find one's roots");jb[1].setText("Back to original position");jb[2].setText("\n" +
                "To emphasise");
            jb[3].setText("None of these");
        }
        if(current==8)
        {
            l.setText("Q.9: To have an axe to grind");
            jb[0].setText("A private end to serve");jb[1].setText("To have no result");jb[2].setText("To work for both sides");jb[3].setText("\n" +
                "None of these");
        }
        if(current==9)
        {
            l.setText("Q.10:To cry wolf ");
            jb[0].setText("To listen eagerly");jb[1].setText("To give false alarm");jb[2].setText("To turn pale");
            jb[3].setText("None of these");
        }
        l.setBounds(30,40,450,20);
        for(int i=0,j=0;i<=90;i+=30,j++)
            jb[j].setBounds(50,80+i,200,20);
    }
    boolean check()
    {
        if(current==0)
            return(jb[3].isSelected());
        if(current==1)
            return(jb[1].isSelected());
        if(current==2)
            return(jb[1].isSelected());
        if(current==3)
            return(jb[0].isSelected());
        if(current==4)
            return(jb[2].isSelected());
        if(current==5)
            return(jb[1].isSelected());
        if(current==6)
            return(jb[1].isSelected());
        if(current==7)
            return(jb[2].isSelected());
        if(current==8)
            return(jb[0].isSelected());
        if(current==9)
            return(jb[1].isSelected());
        return false;
    }
}
class OnlineTest
{
    public static void main(String args[])
    {
        try
        {
            signin form = new signin();
            form.setSize(300,140);
            form.setVisible(true);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}