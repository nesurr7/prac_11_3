package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPane extends JPanel {
        private JLabel label = new JLabel("Текст");
        private JTextArea textArea = new JTextArea();
        private JMenuBar jMenuBar = new JMenuBar();
        JMenu foreGroundColor = new JMenu("Text Color");
        JMenu textStyle = new JMenu("Text Style");
        public MyPane() {
            setLayout(null);
            textArea.setLineWrap(true);//перенос
            textArea.setWrapStyleWord(true);//стиль полного переноса
            /////////////
            JScrollPane jScrollPane = new JScrollPane(textArea);
            label.setBounds(MyWindow.SCRN_WIDTH/2-20,100, 40 ,50);
            jScrollPane.setBounds(MyWindow.SCRN_WIDTH/2-200,MyWindow.SCRN_HEIGHT/2-200 , 400 , 200);
            /////////////////
            jMenuBar.add(foreGroundColor);
            jMenuBar.add(textStyle);
            jMenuBar.setBounds(MyWindow.SCRN_WIDTH/2-200,0,400,50);
            ///////////
            foreGroundColor.add(new JMenuItem("Синий")).addActionListener(new ActionColor(Color.BLUE));
            foreGroundColor.add(new JMenuItem("Черный")).addActionListener(new ActionColor(Color.BLACK));
            foreGroundColor.add(new JMenuItem("Красный")).addActionListener(new ActionColor(Color.RED));
            textStyle.add(new JMenuItem("Times new Roman")).addActionListener(new ActionStyle("Times new Roman",0 ,20));
            textStyle.add(new JMenuItem("MS Sans Serif")).addActionListener(new ActionStyle("MS Sans Serif",0 ,20));
            textStyle.add(new JMenuItem("Courier new")).addActionListener(new ActionStyle("Courier new",0 ,20));

            ///////////
            add(label);
            add(jScrollPane);
            add(jMenuBar);
        }

        public class ActionColor implements ActionListener {
            Color color;
            ActionColor(Color color){
                this.color = color;
            }
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setForeground(color);
            }
        }
        public class ActionStyle implements  ActionListener {
            String style;
            int magicStyle;
            int size;
            ActionStyle(String style , int magicStyle , int size){
                this.style=style;
                this.magicStyle=magicStyle;
                this.size=size;
            }
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setFont(new Font(style, magicStyle , size));
            }
        }
}
