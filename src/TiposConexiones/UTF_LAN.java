package TiposConexiones;
import java.net.*;
import java.io.*;

public class UTF_LAN {

	
	public static void main(String[] args) {
		
		try {
			ServerSocket puenteEntradaServidor = new ServerSocket(9090);

			while(true) {
				
				Socket puertaAbiertaEntradaServidor = puenteEntradaServidor.accept();
				ObjectInputStream carroEntradaServidor = new ObjectInputStream( puertaAbiertaEntradaServidor.getInputStream());

				System.out.println( "Mensaje: " + carroEntradaServidor.readObject() );
				carroEntradaServidor.close();
				puertaAbiertaEntradaServidor.close();
			}
		
		}catch(Exception ec) {
			ec.printStackTrace();
		}
		
		
	}
	
}


