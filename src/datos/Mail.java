package datos;

import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import funciones.Funciones;

public class Mail {
	private Properties mailServerProperties;
	private Session getMailSession;
	private MimeMessage generateMailMessage;
	private String login = "emacervecero.qac@gmail.com";
	private String password = "35094291azul";
	private String subject = "estado de su cuenta";
	private String body;
	private String to;

	public Boolean send(Cliente cliente, String to) throws AddressException, MessagingException {
		Boolean success = false;
		// propiedades conec
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.host", "smtp.gmail.com");
		mailServerProperties.put("mail.smtp.socketFactory.port", "465");
		mailServerProperties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.port", "465");
		// login pw
		if (login == null || password == null) {
			return success;
		}
		Session getMailSession = Session.getDefaultInstance(mailServerProperties, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(login, password);
			}
		});
		body="Sr "+cliente.getNombre()+" "+cliente.getApellido() +" Cuenta con La/s Estadia/s: </br>";
		for (Estadia e: cliente.getEstadia()) 
			
			 body+= "</br>"
					+"<html><tr>"
					+ "Precio  "+e.getPrecio()+"</br></td>"
					+"<td>"+ "Senia "+e.getSenia()+"</br></td>"
					+"<td>"+ "Estado "+e.getEstado().getEstado()+"</br></td>"
					+"<td>"+ "Fecha Reserva "+Funciones.SOLOobtenerFecha(e.getFechaReserva())+"</br></td>"
					+"<td>"+ "Fecha Desde "+Funciones.SOLOobtenerFecha(e.getFechaDesde())+"</br></td>"
					+"<td>"+ "Fecha Hasta "+Funciones.SOLOobtenerFecha(e.getFechaHasta())+"</br></td>"
					+"</br>"
					+"</html>";
			
					
			
				

			
			
		// enviand
		
 
		generateMailMessage = new MimeMessage(getMailSession);

		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

		generateMailMessage.setSubject(subject);

		generateMailMessage.setContent(body, "text/html");
		javax.mail.Transport.send(generateMailMessage);
		return success;

	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

}