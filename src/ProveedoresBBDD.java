import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class ProveedoresBBDD {
	

	public static ArrayList<Proveedor> main(String[] args) throws SQLException {
		int id = Integer.parseInt(args[0]);
		
		Conexion conexion = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		cn = conexion.conectar();
		stm = cn.createStatement();
		rs = stm.executeQuery("SELECT * FROM proveedores WHERE id_cliente= " + id); // filtramos por el ID Cliente
		
		ArrayList<Proveedor> listadoPr = new ArrayList<Proveedor>();
		while(rs.next()) {
			Proveedor pr = new Proveedor();
			pr.setId_proveedor(rs.getInt(1));
			pr.setNombre(rs.getString(2));
			pr.setFecha_alta(rs.getDate(3));
			pr.setId_cliente(rs.getInt(4));
			listadoPr.add(pr);
		}
		return listadoPr;
	}
	
}
