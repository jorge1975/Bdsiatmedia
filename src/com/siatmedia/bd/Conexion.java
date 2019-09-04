package com.siatmedia.bd;

import java.sql.*;

public class Conexion {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException  {
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
		}finally {
			try {
				if(con != null)
					con.close();
			}catch(Exception e) {
				
			}
		}
	}

}
