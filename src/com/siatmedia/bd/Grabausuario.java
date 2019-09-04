package com.siatmedia.bd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Grabausuario {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
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
			String nombre=null;
			String clave=null;
			
			PreparedStatement ps = con.prepareStatement("INSERT INTO usuarios(nombre_usu,clave) VALUES(?,?)");
			Statement stmt;			
			stmt = con.createStatement();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			do {
				System.out.println("Ingrese nombre : ");
				nombre = br.readLine();
				System.out.println("Ingrese clave : ");
				clave = br.readLine();
				
				ps.setString(1, nombre);
				ps.setString(2, clave);
				
				int i = ps.executeUpdate();
				System.out.println("Registro guardado....!!!!");
				System.out.println("Desea continuar [S-N] : ");
				String r = br.readLine();
				if (r.startsWith("n")) {
					break;
				}
			}while(true);
			int c1=0;
			String c2=null;
			String c3=null;
			String query="SELECT * FROM usuarios";
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
