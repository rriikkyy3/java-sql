package net.codejava.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JavaConnect2SQL {

	public static void main(String[] args) {
		String url = "jdbc:sqlserver://goyaservidor.database.windows.net;databesName=Goya";
		String user = "pruebas2";
		String password = "1234567A%";
		
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			
			String sql = "SELECT * FROM GEN_LOCALIDAD";
			
			Statement statement = connection.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			while (result.next()) {
				int LOCALIDAD_ID = result.getInt("LOCALIDAD_ID");
				String CODIGO_DANE = result.getString("CODIGO_DANE");
				String NOMBRE = result.getString("NOMBRE");
				String DESCRIPCION = result.getString("DESCRIPCION");
				String TIPO = result.getString("TIPO");
				int LOCALIDAD_ORIGEN_ID = result.getInt("LOCALIDAD_ORIGEN_ID");
				String REGISTRADA_DANE = result.getString("REGISTRADA_DANE");
				String USUARIO_CREACION = result.getString("USUARIO_CREACION");
				String FECHA_CREACION = result.getString("FECHA_CREACION");
				String USUARIO_ULTIMA_MODIFICACION = result.getString("USUARIO_ULTIMA_MODIFICACION");
				String FECHA_ULTIMA_MODIFICACION = result.getString("FECHA_ULTIMA_MODIFICACION");
				
				System.out.printf("%d - %s - %s - %s - %s - %d - %s - %s - %s - %s - %s\n",
						LOCALIDAD_ID, CODIGO_DANE, NOMBRE, DESCRIPCION, TIPO, LOCALIDAD_ORIGEN_ID,
						REGISTRADA_DANE, USUARIO_CREACION, FECHA_CREACION, USUARIO_ULTIMA_MODIFICACION,
						FECHA_ULTIMA_MODIFICACION);
			}
			
			connection.close();			
		} catch (SQLException e) {
			System.out.println("Oops, there's an error: ");
			e.printStackTrace();
		}
	}

}
