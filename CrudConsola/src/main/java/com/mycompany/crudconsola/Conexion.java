package com.mycompany.crudconsola;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Conexion {
     Connection con;
     String url="jdbc:mysql://localhost:3306/colegio";
     String user="root";
     String pass="";
     PreparedStatement ps,ps2;
     ResultSet rs;
     Scanner s= new Scanner(System.in);
        public Connection Conectar(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(url,user,pass);
            System.out.println("Conexion realizada");
        }catch (Exception e){
            System.out.println("Conexion fallida");
            System.out.println(e);
        }
        return con;
    }
    
    public void Select(){
        try{       
        ps=con.prepareStatement("SELECT *FROM ALUMNO;");
        rs=ps.executeQuery();
        while(rs.next()){
            System.out.println(rs.getInt(1));
            System.out.println(rs.getString(2));
            System.out.println(rs.getString(3));
            System.out.println(rs.getString(4) + "\n");
        }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    
    public void Insert(){
        try{
            System.out.println("Ingresa el codigo");
            String a=s.nextLine();
            ps=con.prepareStatement("SELECT *FROM ALUMNO WHERE CODIGO=" + a);
            rs=ps.executeQuery();
            int e=0;
            while(rs.next()){
            e++;
            }
            if(e<1){
            System.out.println("Ingresa el nombre");
            String b=s.nextLine();
            System.out.println("Ingresa la direccion");
            String c=s.nextLine();
            System.out.println("Ingresa el telefono");
            String d=s.nextLine();
            ps2=con.prepareStatement("INSERT INTO ALUMNO VALUES(" + a + ",'" + b + "','" + c + "','" + d + "');");
            ps2.executeUpdate();
            System.out.println("Registro ingresado exitosamente");
            }else{
            System.out.println("Registro ya existe");    
            }
        }catch (Exception e){
            System.out.println("Ha ocurrido un error");
            System.out.println(e);
        }
    }
    
    public void Update(){
        try{
            System.out.println("Ingresa el codigo");
            String a=s.nextLine();
            ps=con.prepareStatement("SELECT *FROM ALUMNO WHERE CODIGO=" + a);
            rs=ps.executeQuery();
            int e=0;
            while(rs.next()){
            e++;
            }
            if(e>=1){
            System.out.println("Ingresa el nuevo nombre del alumno");
            String b=s.nextLine();
            System.out.println("Ingresa la nueva direccion del alumno");
            String c=s.nextLine();
            System.out.println("Ingresa el nuevo telefono del alumno");
            String d=s.nextLine();
            ps2=con.prepareStatement("UPDATE ALUMNO SET NOMBRE='" + b + "', DIRECCION='" + c + "', TELEFONO='" + d + "' WHERE CODIGO=" + a);
            ps2.executeUpdate();
            System.out.println("Registro modificado exitosamente");
            }else{
            System.out.println("Registro no encontrado");    
            }
        }catch (Exception e){
            System.out.println("Ha ocurrido un error");
            System.out.println(e);
        }
    }
    
        public void Delete(){
        try{
            System.out.println("Ingresa el codigo");
            String a=s.nextLine();
            ps=con.prepareStatement("SELECT *FROM ALUMNO WHERE CODIGO=" + a);
            rs=ps.executeQuery();
            int e=0;
            while(rs.next()){
            e++;
            }
            if(e>=1){
            ps2=con.prepareStatement("DELETE FROM ALUMNO WHERE CODIGO=" + a);
            ps2.executeUpdate();
            System.out.println("Registro eliminado exitosamente");
            }else{
            System.out.println("Registro no encontrado");    
            }
        }catch (Exception e){
            System.out.println("Ha ocurrido un error");
            System.out.println(e);
        }
    }
}
