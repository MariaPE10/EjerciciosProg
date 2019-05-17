package awt_swing.JPA.Servlets;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class PrimerServlet
 */
@WebServlet(description = "Primer Servlet", urlPatterns = { "/Serv02_ServletRecepcionParametrosDeFormulario" })
public class Serv02_ServletRecepcionParametrosDeFormulario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Serv02_ServletRecepcionParametrosDeFormulario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n" + 
				"<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n" + 
				"<head>\r\n" + 
				"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\" />\r\n" + 
				"<title>Documento sin t�tulo</title>\r\n" + 
				"</head>\r\n" + 
				"\r\n" + 
				"<body>\r\n" + 
				"<h1>Recepci�n de par�metros de un formulario:</h1>\r\n" +
				"<ul>\r\n");
		// Los par�metros recibidos en una petici�n web se obtienen a partir del objeto request, en el siguiente bucle
		// simplemente se recorren y se muestran en la salidad del Servlet
		Enumeration<String> enNombresDeParametros = request.getParameterNames();
		while (enNombresDeParametros.hasMoreElements()) {
			String nombreDeParametro = enNombresDeParametros.nextElement();
			response.getWriter().append("<li>Par�metro " + nombreDeParametro + ": " + request.getParameter(nombreDeParametro));
		}
			
		// Una vez he mostrado todos los nombres de par�metros en pantalla, simplemente cierro el HTML.
		response.getWriter().append("" + 
			"</ul>" + 
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
