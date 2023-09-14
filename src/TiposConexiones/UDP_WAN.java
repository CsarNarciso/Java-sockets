package TiposConexiones;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDP_WAN {

	
	public static void main(String[] args) {

		final int PUERTO = 5000; //Puerto del servidor

		try {
			
			//Creamos socket UDP Server. Funciona como puente y 
			//puerta de acceso a los datos enviados por el cliente
			DatagramSocket puenteEntrada = new DatagramSocket( PUERTO );

			while(true) {  //Estara continuamente atento a peticiones del cliente
				
				byte[] paqueteRecivido = new byte[9999]; //Almacenara en bytes el mensaje recivido
				
				//Paquete que almacena en bytes el mensaje entrante.
				//Al recivirlo, de él se obtienen dichos datos
				DatagramPacket carroPaqueteEntrada = new DatagramPacket( paqueteRecivido, paqueteRecivido.length );
				
				//El socket "abre la puerta de entrada" para que el paquete (DatagramPacket) 
				//pueda recivir los datos entrantes del cliente
				puenteEntrada.receive(carroPaqueteEntrada);
				
				//Una vez el paquete lleno (el DatagramPacket ), obtenemos su contenido recivido
				String mensaje = new String( carroPaqueteEntrada.getData() );

				//Y lo mostramos en consola
				System.out.println("Cliente: " + mensaje);
				
			}
		
		}
		catch (SocketException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		} 
		
		
	}
	
}





//import java.io.IOException;
//import java.net.DatagramPacket;
//import java.net.DatagramSocket;
//import java.net.InetAddress;
//import java.net.SocketException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
// 
//public class UDP_WAN {
// 
//    public static void main(String[] args) {
// 
//        final int PUERTO = 5000;
//        byte[] buffer = new byte[1024];
// 
//        try {
//            System.out.println("Iniciado el servidor UDP");
//            //Creacion del socket
//            DatagramSocket socketUDP = new DatagramSocket(PUERTO);
// 
//            //Siempre atendera peticiones
//            while (true) {
//                 
//                //Preparo la respuesta
//                DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);
//                 
//                //Recibo el datagrama
//                socketUDP.receive(peticion);
//                System.out.println("Recibo la informacion del cliente");
//                 
//                //Convierto lo recibido y mostrar el mensaje
//                String mensaje = new String(peticion.getData());
//                System.out.println(mensaje);
// 
//                //Obtengo el puerto y la direccion de origen
//                //Sino se quiere responder, no es necesario
//                int puertoCliente = peticion.getPort();
//                InetAddress direccion = peticion.getAddress();
// 
//                mensaje = "¡Hola mundo desde el servidor!";
//                buffer = mensaje.getBytes();
// 
//                //creo el datagrama
//                DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length, direccion, puertoCliente);
// 
//                //Envio la información
//                System.out.println("Envio la informacion del cliente");
//                socketUDP.send(respuesta);
//                 
//            }
// 
//        } catch (SocketException ex) {
//            Logger.getLogger(UDP_WAN.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(UDP_WAN.class.getName()).log(Level.SEVERE, null, ex);
//        }
// 
//    }
// 
//}
