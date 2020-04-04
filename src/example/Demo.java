package example;

import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import javax.swing.ButtonGroup;
        import javax.swing.JFrame;
        import javax.swing.JPanel;
        import javax.swing.JRadioButton;
        import javax.swing.SwingUtilities;

public class Demo{
    private JPanel jPanel;
    private JRadioButton  ja;
    private JRadioButton  jb;
    private JRadioButton  jc;
    private JRadioButton  jd;
    private ButtonGroup buttonGroup= new ButtonGroup();
    private String saveValue=null;
    private RadioButtonListener radioButtonListener=new RadioButtonListener();
    public  Demo() {
        JFrame jf=new JFrame();
        ja=new JRadioButton("A");
        ja.addActionListener(radioButtonListener);
        jb=new JRadioButton("B");
        jb.addActionListener(radioButtonListener);
        jc=new JRadioButton("C");
        jc.addActionListener(radioButtonListener);
        jd=new JRadioButton("D");
        jd.addActionListener(radioButtonListener);
        buttonGroup.add(ja);
        buttonGroup.add(jb);
        buttonGroup.add(jc);
        buttonGroup.add(jd);
        jPanel=new  JPanel();
        jPanel.add(ja);
        jPanel.add(jb);
        jPanel.add(jc);
        jPanel.add(jd);
        jf.add(jPanel);
        jf.setVisible(true);
        jf.setSize(363,213);
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                new Demo();
            }

        });
    }

    public static class RadioButtonListener implements ActionListener
    {
        private String saveValue;

        @Override
        public void actionPerformed(ActionEvent arg0) {
            JRadioButton temp=(JRadioButton)arg0.getSource();
            if(temp.isSelected()){
                saveValue=temp.getText();
                System.out.println(temp.getText());
            }

        }

    }
}