package com.mycompany.crudconsola2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Conexion2 {
     Connection con;
     String url="jdbc:mysql://localhost:3306/tienda";
     String user="root";
     String pass="";
     PreparedStatement ps,ps2;
     ResultSet rs;
     Scanner s= new Scanner(System.in);
        public Connection Conectar(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(url,user,pass);
            JOptionPane.showMessageDialog(null,"Conexion realizada");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Ha ocurrido un error");
            JOptionPane.showMessageDialog(null,e);
        }
        return con;
    }
    
    public void Insert(int a, String b, int c,  String d){
        try{
            ps=con.prepareStatement("SELECT *FROM PRODUCTOS WHERE CODIGO=" + a);
            rs=ps.executeQuery();
            int e=0;
            while(rs.next()){
            e++;
            }
            if(e<1){
            ps2=con.prepareStatement("INSERT INTO PRODUCTOS VALUES(" + a + ",'" + b + "'," + c + ",'" + d + "');");
            ps2.executeUpdate();
            JOptionPane.showMessageDialog(null,"Registro ingresado correctamente");
            }else{
            JOptionPane.showMessageDialog(null,"Registro ya existe");   
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Ha ocurrido un error");
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    
}
