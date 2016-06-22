import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class SurveyWizard extends JPanel implements ActionListener{
    int currentCard=0;
    CardLayout cards=new CardLayout();
    SurveyPanel[] ask=new SurveyPanel[3];

    SurveyWizard(){
        super();
        setSize(240,140);
        setLayout(cards);
        String question1="What is your gender?";
        String[] response1={"female","male","not telling"};
        ask[0]=new SurveyPanel(question1,response1,2);
        String question2="What is your age?";
        String[] response2={"Under 25","25-34","35-54","Over 55"};
        ask[1]=new SurveyPanel(question2,response2,3);
        String question3="How often do you exercise each week?";
        String[] response3={"Never","1-3 times","More than 3"};
        ask[2]=new SurveyPanel(question3,response3,1);
        ask[2].setFinalQuestion(true);
        addListeners();
    }

    private void addListeners(){
        for(int i=0;i<ask.length;i++){
            ask[i].nextButton.addActionListener(this);
            ask[i].finalButton.addActionListener(this);
            add(ask[i],"Card"+i);
        }
    }

    public void actionPerformed(ActionEvent e){
        currentCard++;
        if(currentCard>=ask.length){
            System.exit(0);
        }
        cards.show(this, "Card"+currentCard);
    }
}

class SurveyPanel extends JPanel{
    JLabel question;
    JRadioButton[] response;
    JButton nextButton=new JButton("Next");
    JButton finalButton=new JButton("Final");

    SurveyPanel(String que,String[] res,int def){
        super();
        setSize(160,110);
        question=new JLabel(que);
        response=new JRadioButton[res.length];
        JPanel sub1=new JPanel();
        ButtonGroup group=new ButtonGroup();
        JLabel questionLabel=new JLabel(que);
        sub1.add(questionLabel);
        JPanel sub2=new JPanel();
        for(int i=0;i<res.length;i++){
            if(def==i){
                response[i]=new JRadioButton(res[i],true);
            }else{
                response[i]=new JRadioButton(res[i],false);
            }
            group.add(response[i]);
            sub2.add(response[i]);
        }
        JPanel sub3=new JPanel();
        nextButton.setEnabled(true);
        sub3.add(nextButton);
        finalButton.setEnabled(false);
        sub3.add(finalButton);
        GridLayout grid=new GridLayout(3,1);
        setLayout(grid);
        add(sub1);
        add(sub2);
        add(sub3);
    }

    void setFinalQuestion(boolean finalQuestion){
        if(finalQuestion){
            nextButton.setEnabled(false);
            finalButton.setEnabled(true);
        }
    }
}