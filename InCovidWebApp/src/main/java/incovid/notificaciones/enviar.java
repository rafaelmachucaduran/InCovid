package incovid.notificaciones;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;



public class enviar {

    public  void enviarCorreo(String html, String correo) {

        // Datos del gmail que envia
        String remitente = "incoviduma@gmail.com";
        String clave = "YPhOOFtfh4";
        String destino = correo; //ajustesUsuario.getCorreo();


        // Indica las propiedades de la conexión que se establecen con el servidor
        // asigno mediante put las propiedades

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        // 587 es el puerto que da gmail para conectar

        props.put("mail.smth.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.user", remitente);
        props.put("mail.smtp.clave", clave);

        Session session = Session.getDefaultInstance(props);

        // Inicializo mensaje para formarlo

        MimeMessage mensaje = new MimeMessage(session);

        try {
            // paso como parametro el tipo de receptor y el destino
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(destino));
            // asignación del asunto
            mensaje.setSubject("Notificación InCovid");
            // Envio de contenido html
            mensaje.setContent(html, "text/html");
            Transport transport = session.getTransport("smtp");
            // Establece conexion con el servidor , mediante los datos pasados como parametros
            transport.connect("smtp.gmail.com" , remitente , clave);
            transport.sendMessage(mensaje, mensaje.getAllRecipients());
            transport.close();
            //cierre de conexión
            System.out.println("Correo Enviado");
        }catch(Exception e) {
            e.printStackTrace();

        }
    }

}
