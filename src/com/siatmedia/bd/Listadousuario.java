package com.siatmedia.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Listadousuario {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			String servidor = "jdbc:mysql://localhost:3306/siatmedia";
			String usuario = "root";
			String clave = "";
			con = DriverManager.getConnection(servidor,usuario,clave);
			if (!con.isClosed()) {
				System.out.println("Conexion exitosa");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Excepcion: " + e.getMessage());
		}
		
		try {
			int c1=0;
			String c2=null;
			String c3=null;
			String query="SELECT * FROM usuarios";
			Statement stmt;
			stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery(query);
			System.out.println("\n\n\tID \t NOMBRE \t CLAVE");
			while(rs.next()) {
				c1 = rs.getInt(1);
				c2 = rs.getString(2);
				c3 = rs.getString(3);
				System.out.println("\t" + c1 + "\t" + c2 + "\t\t" + c3);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
