/**
 * Класс который отображает окно интерфейса
 */
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.util.Formatter;

public class Window extends JFrame {

    static Formatter form;
    JTextField name;
    JTextField grupp;
    JTextField p1;
    JTextField p2;
    JTextField p3;
    JTextField p4;
    JTextField p5;
    JButton ok;
    JButton cancel;
    double d1, d2, d3, d4, d5, itogo;
    String famil, grup;
    listener l1 = new listener();

    public Window() {
        super("Programma Laboratorka 1.0");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel pa = new JPanel(new GridLayout(0, 1));
// Створюємо перший блок віконець для вводу тексту
        Box box1 = Box.createHorizontalBox();
        JLabel nameLable = new JLabel("Name:");
        nameLable.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        name = new JTextField(18);

        box1.add(nameLable);
        box1.add(Box.createHorizontalStrut(15));
        box1.add(name);

        Box box8 = Box.createHorizontalBox();
        JLabel gruppLable = new JLabel("Gruppa/Fakultet:");
        grupp = new JTextField(18);

        box8.add(gruppLable);
        box8.add(Box.createHorizontalStrut(15));
        box8.add(grupp);
// Створюємо блоки для отримання оцінок за певні категорії
        Box box2 = Box.createHorizontalBox();
        JLabel punkt1 = new JLabel("Parametr ohrenet 1");
        p1 = new JTextField(5);
        box2.add(punkt1);
        box2.add(Box.createHorizontalStrut(6));
        box2.add(p1);

        Box box3 = Box.createHorizontalBox();
        JLabel punkt2 = new JLabel("Parametr superpuper 2:");
        p2 = new JTextField(5);
        box3.add(punkt2);
        box3.add(Box.createHorizontalStrut(6));
        box3.add(p2);

        Box box4 = Box.createHorizontalBox();
        JLabel punkt3 = new JLabel("Parametr 3:");
        p3 = new JTextField(5);
        box4.add(punkt3);
        box4.add(Box.createHorizontalStrut(6));
        box4.add(p3);

        Box box5 = Box.createHorizontalBox();
        JLabel punkt4 = new JLabel("Parametr 4:");
        p4 = new JTextField(5);
        box5.add(punkt4);
        box5.add(Box.createHorizontalStrut(6));
        box5.add(p4);

        Box box6 = Box.createHorizontalBox();
        JLabel punkt5 = new JLabel("Parametr 5:");
        p5 = new JTextField(5);
        box6.add(punkt5);
        box6.add(Box.createHorizontalStrut(6));
        box6.add(p5);


// Настраиваем третью горизонтальную панель (с кнопками)
        Box box7 = Box.createHorizontalBox();
        ok = new JButton("OK");
        cancel = new JButton("Clear");
        box7.add(Box.createHorizontalGlue());
        box7.add(ok);
        box7.add(Box.createHorizontalStrut(12));
        box7.add(cancel);
        ok.addActionListener(l1);
        cancel.addActionListener(l1);

// Уточняем размеры компонентов
//            nameLable.setPreferredSize(gruppLable.getPreferredSize());
//            p2.setPreferredSize(p3.getPreferredSize());
//            p4.setPreferredSize(p3.getPreferredSize());
//            p5.setPreferredSize(p3.getPreferredSize());
//            p1.setPreferredSize(p3.getPreferredSize());
// Размещаем три горизонтальные панели на одной вертикальной
        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(75, 70, 100, 100));
        mainBox.add(box1);
        mainBox.add(Box.createVerticalStrut(15));
        mainBox.add(box8);
        mainBox.add(Box.createVerticalStrut(15));
        mainBox.add(box2);
        mainBox.add(Box.createVerticalStrut(15));
        mainBox.add(box3);
        mainBox.add(Box.createVerticalStrut(15));
        mainBox.add(box4);
        mainBox.add(Box.createVerticalStrut(15));
        mainBox.add(box5);
        mainBox.add(Box.createVerticalStrut(15));
        mainBox.add(box6);
        mainBox.add(Box.createVerticalStrut(15));
        mainBox.add(box7);
        mainBox.add(Box.createVerticalStrut(15));
        setContentPane(mainBox);
        pack();
        setResizable(false);
    }

    public class listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (e.getSource() == ok) {
                    d1 = Double.parseDouble(p1.getText());
                    d2 = Double.parseDouble(p2.getText());
                    d3 = Double.parseDouble(p3.getText());
                    d4 = Double.parseDouble(p4.getText());
                    d5 = Double.parseDouble(p5.getText());
                    itogo = (d1 + d2 + d3 + d4 + d5) / 5;
                    famil = name.getText();
                    grup = grupp.getText();

                    try {
                        form = new Formatter("d:/student.txt");
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    }
                    form.format("STUDENT %s   %s, ball: %f (%f, %f, %f, %f, %f)", famil, grup, itogo, d1, d2, d3, d4, d5);
                    //%s студент %s, балли за роботу: %f : %f : %f : %f : %f : оцінка : %f", famil, grup, d1, d2, d3, d4, d5, itogo);
                    form.close();

                    JOptionPane.showMessageDialog(null, famil + " get " + itogo + " Do next.");

                }
                if (e.getSource() == cancel) {
                    p1.setText(null);
                    p2.setText(null);
                    p3.setText(null);
                    p4.setText(null);
                    p5.setText(null);
                    name.setText(null);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Ne tupim, vvodim cifri!");


            }
        }
    }
}



