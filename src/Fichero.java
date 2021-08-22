import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;

public class Fichero {
	// Datos y rutas del fichero
	private static String fechaNomFich = String.valueOf(LocalDateTime.now().getYear()
			+ String.valueOf(LocalDateTime.now().getMonthValue()) + String.valueOf(LocalDateTime.now().getDayOfMonth()) + "_"
			+ String.valueOf(LocalDateTime.now().getHour()) + String.valueOf(LocalDateTime.now().getMinute())
			+ String.valueOf(LocalDateTime.now().getSecond()));
	
	static private String path = "C:/Users/Rosi/Documents";
	static private String nomFich = "FicheroProv_" + fechaNomFich;
	
	public void montaFicheroF(int id) throws SQLException, IOException {
		if(validaID(id)){ // si el id esta en el rango
			ArrayList<Proveedor> registros = new ArrayList<Proveedor>();
			getRegistros(id, registros);
		}
	}
	
	public boolean validaID(int id) {
		if(id > 0 && id < 1000) {
			return true;
		}
		return false;
	}
	
	public void getRegistros(int id, ArrayList<Proveedor> listadoPr) throws SQLException, IOException {
		String[] args = {String.valueOf(id)};
		listadoPr = ProveedoresBBDD.main(args); // Obtengo Array de proveedores
		
		if(listadoPr.size() > 0) {
		File archivo=new File(path, nomFich);
		archivo.createNewFile();
		BufferedWriter writer = null;
		writer = new BufferedWriter(new FileWriter(archivo));
		
		montaCabecera(writer);
		montaCuerpo(writer, listadoPr);
		System.out.println("***********************************************");
		System.out.println("*** Fichero generado corretamente con datos ***");
		System.out.println("***********************************************");
		} else {
			System.out.println("*********************************************************");
			System.out.println("*** AVISO. El cliente no tiene proveedorees asignados. No se genera Fichero. ***");
			System.out.println("*********************************************************");
		}
	}
	
	public StringBuilder montaCabecera(BufferedWriter writer) throws IOException {
        StringBuilder fila = new StringBuilder(315);
        fila.insert(0, "                                                                "); //Hay que marcar
        //un límite de caracteres por línea. Para que cuadren los registros con sus cabeceras
		fila.replace(0, 11, "IDPROVEEDOR");
		fila.replace(14, 30, "NOMBRE");
		fila.replace(35, 45, "FECHALTA");
		fila.replace(50, 60, "IDCLIENTE");
        writer.write(fila.toString());
        
        return fila;
    }
	
	public void montaCuerpo(BufferedWriter writer,  ArrayList<Proveedor> listadoPr) throws IOException {
		for (int i=0; i<listadoPr.size(); i++) {
			Proveedor item = listadoPr.get(i);
			StringBuilder fila = new StringBuilder(315);
			writer.newLine();
			fila.insert(0, "                                                                                           ");
			fila.replace(0, 11, String.valueOf(item.getId_proveedor()));
			fila.replace(14, 30, item.getNombre());
			// Inicio formateo Fecha
			Calendar calendar = Calendar.getInstance(); 
			calendar.setTime(item.getFecha_alta());
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
			// Fin formateo fecha
	        fila.replace(35, 45, String.valueOf(formato.format(calendar.getTime())));
	        fila.replace(50, 60, String.valueOf(item.getId_cliente()));
	        writer.write(fila.toString());
		}
        
        writer.close();
	}

}
