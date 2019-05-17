package awt_swing.JPA.Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import awt_swing.JPA.Ejercicio_curso.modelo.Estudiante;
import awt_swing.JPA.Ejercicio_curso.modelo.Profesor;
import awt_swing.JPA.Ejercicio_curso.modelo.controladores.EstudianteControlador;
import awt_swing.JPA.Ejercicio_curso.modelo.controladores.ProfesorControlador;



/**
 * Servlet implementation class PrimerServlet
 */
@WebServlet(description = "Primer Servlet", urlPatterns = { "/FichaEstudiante" })
public class Serv04_01_FichaEstudiante extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Serv04_01_FichaEstudiante() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Para plasmar la informaci�n de un profesor determinado utilizaremos un par�metro, que debe llegar a este Servlet obligatoriamente
		// El par�metro se llama "idProfesor" y gracias a �l podremos obtener la informaci�n del profesor y mostrar sus datos en pantalla
		Estudiante estudiante = null;
		if (request.getParameter("idEstudiante") != null) { // comparar con "null" es la forma de comprobar si el par�metro est� en la petici�n web
			String strIdEstudiante = request.getParameter("idEstudiante");
			try {
				estudiante = (Estudiante) EstudianteControlador.getControlador().find(Integer.parseInt(strIdEstudiante));
			} catch (Exception e) {
				System.out.println("Estudiante no encontrado para el id: " + strIdEstudiante);
			}
		}
		
		// Ahora muestro la pantalla de respuesta al usuario
		response.getWriter().append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n" + 
				"<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n" + 
				"<head>\r\n" + 
				"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\" />\r\n" + 
				"<title>Documento sin t�tulo</title>\r\n" + 
				"</head>\r\n" + 
				"\r\n" + 
				"<body>\r\n" + 
				"<h1>Ficha de estudiante</h1>\r\n" + 
				"<form id=\"form1\" name=\"form1\" method=\"post\" action=\"\">\r\n" + 
				" <img src=\"Serv05_DownloadImagenDesdeBBDD?idProfesor=1\" width='100px' height='100px'/>" +
				" <input type=\"hidden\" name=\"id\" value=\"" + ((estudiante != null)? estudiante.getId() : "") + "\"\\>" +
				"  <p>\r\n" + 
				"    <label for=\"nombre\">Nombre:</label>\r\n" + 
				"    <input name=\"nombre\" type=\"text\" id=\"nombre\"  value=\"" + ((estudiante != null)? estudiante.getNombre() : "") + "\" />\r\n" + 
				"  </p>\r\n" + 
				"  <p>\r\n" + 
				"    <label for=\"primerApellido\">Primer apellido:</label>\r\n" + 
				"    <input name=\"primerApellido\" type=\"text\" id=\"primerApellido\" value=\"" + ((estudiante != null)? estudiante.getPrimerApellido() : "") + "\" />\r\n" + 
				"  </p>\r\n" + 
				"  <p>\r\n" + 
				"    <label for=\"segundoApellido\">Segundo apellido:</label>\r\n" + 
				"    <input name=\"segundoApellido\" type=\"text\" id=\"segundoApellido\" value='" + ((estudiante != null)? estudiante.getSegundoApellido() : "") + "'/>\r\n" + 
				"  </p>\r\n" + 
				"  <p>\r\n" + 
				"    <label for=\"dni\">DNI:</label>\r\n" + 
				"    <input name=\"dni\" type=\"text\" id=\"dni\" value='" + ((estudiante != null)? estudiante.getDni() : "") + "' />\r\n" + 
				"  </p>\r\n" + 
				"  <p>\r\n" + 
				"    <label for=\"direccion\">Direccion:</label>\r\n" + 
				"    <input name=\"direccion\" type=\"text\" id=\"direccion\" value='" + ((estudiante != null)? estudiante.getDireccion() : "") + "' />\r\n" + 
				"  </p>\r\n" + 
				"  <p>\r\n" + 
				"    <label for=\"email\">Email:</label>\r\n" + 
				"    <input name=\"email\" type=\"text\" id=\"email\" value='" + ((estudiante != null)? estudiante.getEmail() : "") + "'/>\r\n" + 
				"  </p>\r\n" + 
				"  <p>\r\n" + 
				"    <label for=\"telefono\">Telefono:</label>\r\n" + 
				"    <input name=\"telefono\" type=\"text\" id=\"telefono\" value='" + ((estudiante != null)? estudiante.getTelefono() : "") + "'/>\r\n" + 
				"  </p>\r\n" + 
				"  <p>\r\n" + 
				"    <label for=\"colorPreferido\">Color preferido:</label>\r\n" + 
				"    <input name=\"colorPreferido\" type=\"text\" id=\"colorPreferido\" value='" + ((estudiante != null)? estudiante.getColorPreferido() : "") + "'/>\r\n" + 
				"  </p>\r\n" + 
				"</form>" + 
				"</body>\r\n" + 
				"</html>\r\n" + 
				"");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
