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
@WebServlet(description = "Primer Servlet", urlPatterns = { "/Serv03_ListadoEstudiantes" })
public class Serv03_01_ServletAccesoBBDD_ListadoEstudiantes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Serv03_01_ServletAccesoBBDD_ListadoEstudiantes() {
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
				"<h1>Listado de estudiantes</h1>\r\n" + 
				"<table width=\"95%\" border=\"1\">\r\n" + 
				"  <tr>\r\n" + 
				"    <th scope=\"col\">Nombre</th>\r\n" + 
				"    <th scope=\"col\">Primer apellido</th>\r\n" + 
				"    <th scope=\"col\">Segundo apellido</th>\r\n" + 
				"    <th scope=\"col\">DNI</th>\r\n" + 
				"    <th scope=\"col\">Direccion</th>\r\n" + 
				"    <th scope=\"col\">Email</th>\r\n" + 
				"    <th scope=\"col\">Telefono</th>\r\n" + 
				"    <th scope=\"col\">Color preferido</th>\r\n" + 
				"  </tr>\r\n");
		// Hasta la fila anterior ha llegado la primera fila de t�tulos de la tabla de profesores del centro educativo
		// En las siguietnes l�neas se crea una fila "elemento <tr>" por cada fila de la tabla de BBDD "profesor"
		List<Estudiante> estudiantes = EstudianteControlador.getControlador().findAllEstudiantes();
		for (Estudiante estudiante : estudiantes) {
			response.getWriter().append("" +
				"  <tr>\r\n" + 
				"    <td><a href=\"FichaEstudiante?idEstudiante=" + estudiante.getId() + "\">" + estudiante.getNombre() + "</a></td>\r\n" + 
				"    <td>" + estudiante.getPrimerApellido() + "</td>\r\n" + 
				"    <td>" + estudiante.getSegundoApellido() + "</td>\r\n" + 
				"    <td>" + estudiante.getDni() + "</td>\r\n" + 
				"    <td>" + estudiante.getDireccion() + "</td>\r\n" + 
				"    <td>" + estudiante.getEmail() + "</td>\r\n" + 
				"    <td>" + estudiante.getTelefono() + "</td>\r\n" + 
				"    <td>" + estudiante.getColorPreferido() + "</td>\r\n" + 
				"  </tr>\r\n");
		}
		// Al finalizar de exponer la lista de profesores termino la tabla y cierro el fichero HTML
		response.getWriter().append("" + 
		"</table>\r\n" + 
		"<p/><input type=\"submit\"  name=\"nuevo\" value=\"Nuevo\"  onclick=\"window.location='FichaEstudiante?idEstudiante=0'\"/>" + 
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
