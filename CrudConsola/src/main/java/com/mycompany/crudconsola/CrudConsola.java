package com.mycompany.crudconsola;
import java.util.Scanner;

public class CrudConsola {
    public static void main(String[] args) {
       Conexion con= new Conexion();
       System.out.println(con.Conectar());
       Scanner s= new Scanner(System.in);
       int a;
       do{
       System.out.println("Selecciona la opcion \n 1.Mostrar datos \n 2.Ingresar datos \n 3.Modificar datos \n 4.Eliminar datos");
       a= Integer.parseInt(s.nextLine());
       switch(a){
           case 1 -> {
               con.Select();
               }
           
           case 2 -> {
               con.Insert();
               }
           
           case 3 -> {
               con.Update();
               }
           
           case 4 -> {
               con.Delete();
               }
       }
       }while(a<=4);
       
    }
}