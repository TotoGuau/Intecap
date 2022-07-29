package com.mycompany.crudconsola2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CrudConsola2 extends JFrame{
    
    public static void mostrarPanel(){
    JFrame f = new JFrame();
    JPanel p = new JPanel();
    JLabel l1= new JLabel();
    JTextField t1 = new JTextField();
    JLabel l2= new JLabel();
    JTextField t2 = new JTextField();
    JLabel l3= new JLabel();
    JFormattedTextField t3= new JFormattedTextField(new Integer(0));
    JLabel l4= new JLabel();
    JTextField t4 = new JTextField();
    JButton b1 = new JButton();
    
    f.setTitle("");
    
    f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    f.setLocationRelativeTo(null);
    
    f.setVisible(true);
    
    p.setLayout(null);
    
    l1.setText("Ingresa el codigo");
    l2.setText("Ingresa el nombre");
    l3.setText("Ingresa la cantidad");
    l4.setText("Ingresa el lugar");
    b1.setText("Ingresar datos");
    
    f.setBounds(10,10,200,190);
    l1.setBounds(10,5,150,15);
    t1.setBounds(10,20,100,15);
    l2.setBounds(10,35,150,15);
    t2.setBounds(10,50,100,15);
    l3.setBounds(10,65,150,15);
    t3.setBounds(10,80,100,15);
    l4.setBounds(10,95,150,15);
    t4.setBounds(10,110,100,15);
    b1.setBounds(10,125,150,15);
    
    f.add(p);
    p.add(l1);
    p.add(t1);
    p.add(l2);
    p.add(t2);
    p.add(l3);
    p.add(t3);
    p.add(l4);
    p.add(t4);
    p.add(b1);
    
    ActionListener guardar= new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            Conexion2 c = new Conexion2();
            c.Conectar();
            c.Insert(Integer.parseInt(t1.getText()),t2.getText(),Integer.parseInt(t3.getText()),t4.getText());
        }
    };
        
    b1.addActionListener(guardar);
    
    }
    
    public static void main(String[] args) {
       mostrarPanel();
    }
}