/**
 * Класс который отображает окно интерфейса
 */
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;

public class Window2 extends JFrame {

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

    public Window2 (){
        super("What a fuck");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel pa = new JPanel(new GridLayout(0, 3));
// Створюємо перший блок віконець для вводу тексту
//        pa.add(new JLabel("getAllFonts"));
//        Font [] allFonts = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
//        pa.add(new JComboBox(allFonts));
//        pa.add(new JLabel("count fonts = "+ allFonts.length));
//        setContentPane(pa);
//        pack();


        Box box1 = Box.createHorizontalBox();
        JLabel nameLable = new JLabel("Name: ");
        //nameLable.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        name = new JTextField(12);

        box1.add(nameLable);
        box1.add(Box.createHorizontalStrut(15));
        box1.add(name);

        Box box8 = Box.createHorizontalBox();
        JLabel gruppLable = new JLabel("Gruppa:");
        grupp = new JTextField(12);

        box8.add(gruppLable);
        box8.add(Box.createHorizontalStrut(15));
        box8.add(grupp);
// Створюємо блоки для отримання оцінок за певні категорії
        Box box2 = Box.createHorizontalBox();
        JLabel punkt1 = new JLabel("Kriteriy 1");
        p1 = new JTextField(5);
        box2.add(punkt1);
        box2.add(Box.createHorizontalStrut(6));
        box2.add(p1);

        Box box3 = Box.createHorizontalBox();
        JLabel punkt2 = new JLabel("Kriteriy 2");
        p2 = new JTextField(5);
        box3.add(punkt2);
        box3.add(Box.createHorizontalStrut(6));
        box3.add(p2);

        Box box4 = Box.createHorizontalBox();
        JLabel punkt3 = new JLabel("Kriteriy 3");
        p3 = new JTextField(5);
        box4.add(punkt3);
        box4.add(Box.createHorizontalStrut(6));
        box4.add(p3);

        Box box5 = Box.createHorizontalBox();
        JLabel punkt4 = new JLabel("Kriteriy 4");
        p4 = new JTextField(5);
        box5.add(punkt4);
        box5.add(Box.createHorizontalStrut(6));
        box5.add(p4);

        Box box6 = Box.createHorizontalBox();
        JLabel punkt5 = new JLabel("Kriteriy 5");
        p5 = new JTextField(5);
        box6.add(punkt5);
        box6.add(Box.createHorizontalStrut(6));
        box6.add(p5);


// Настраиваем третью горизонтальную панель (с кнопками)
        Box box7 = Box.createHorizontalBox();
        ok = new JButton("OK");
        cancel = new JButton("Next");
        box7.add(Box.createHorizontalGlue());
        box7.add(ok);
        box7.add(Box.createHorizontalStrut(12));
        box7.add(cancel);
        ok.addActionListener(l1);
        cancel.addActionListener(l1);

// Уточняем размеры компонентов
//        nameLable.setPreferredSize(gruppLable.getPreferredSize());
//        p2.setPreferredSize(p3.getPreferredSize());
//        p4.setPreferredSize(p3.getPreferredSize());
//        p5.setPreferredSize(p3.getPreferredSize());
//        p1.setPreferredSize(p3.getPreferredSize());
// Размещаем три горизонтальные панели на одной вертикальной
        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(75, 70, 100, 100));
        pa.add(box1);
        pa.add(Box.createVerticalStrut(15));
        pa.add(box8);
        pa.add(Box.createVerticalStrut(15));
        pa.add(box2);
        pa.add(Box.createVerticalStrut(15));
        pa.add(box3);
        pa.add(Box.createVerticalStrut(15));
        pa.add(box4);
        pa.add(Box.createVerticalStrut(15));
        pa.add(box5);
        pa.add(Box.createVerticalStrut(15));
        pa.add(box6);
        pa.add(Box.createVerticalStrut(15));
        pa.add(box7);
        pa.add(Box.createVerticalStrut(15));
        setContentPane(pa);
        pack();
        setResizable(false);
    }

    public class listener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            //           try {
            if (e.getSource() == ok) {
                d1 = Double.parseDouble(p1.getText());
                d2 = Double.parseDouble(p2.getText());
                d3 = Double.parseDouble(p3.getText());
                d4 = Double.parseDouble(p4.getText());
                d5 = Double.parseDouble(p5.getText());
                itogo = (d1 + d2 + d3 + d4 + d5)/5;
                famil = name.getText();
                grup = grupp.getText();

                try {
                    FileWriter myfile = new FileWriter("d:/student2.txt");

                    String oll = "Student " + name + "  " + grupp + "  ball:  " + itogo;
                    myfile.write(oll);
                    myfile.close();
                    JOptionPane.showMessageDialog(null, "OK! Do next!");
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Halepa!");
                }


            }
//            }catch (Exception ex) {
//                JOptionPane.showMessageDialog(null, "Ne tupim, vvodim cifri!");


        }
    }
}

