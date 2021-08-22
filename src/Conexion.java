import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
	
	public static final String CONTROLADOR = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/bd_ibm";
	public static final String USUARIO = "root";
	public static final String PASS = "root";

	public  Connection conectar() {
		Connection c = null;
		try {
			System.out.println("Conectando a BBDD ...");
			Class.forName(CONTROLADOR);
			
			c = DriverManager.getConnection(URL, USUARIO, PASS);
			
			System.out.println("Conexión a BBDD OK");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al cargar el controlador de conexión a BBDD");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error de conexión a BBDD");
			e.printStackTrace();
		}
		return c;
	}
	

}
