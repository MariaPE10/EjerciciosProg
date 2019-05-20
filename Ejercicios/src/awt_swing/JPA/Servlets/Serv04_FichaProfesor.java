package awt_swing.JPA.Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import awt_swing.JPA.Ejercicio_curso.modelo.Profesor;
import awt_swing.JPA.Ejercicio_curso.modelo.controladores.ProfesorControlador;
import awt_swing.JPA.Ejercicio_curso.modelo.controladores.TipologiaSexoControlador;
import awt_swing.JPA.Ejercicio_curso.modelo.TipologiaSexo;

/**
 * Servlet implementation class PrimerServlet
 */
@WebServlet(description = "Primer Servlet", urlPatterns = { "/Serv04_FichaProfesor" })
public class Serv04_FichaProfesor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Serv04_FichaProfesor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Profesor profesor = new Profesor();
		try {
			int idProfesor = getIntParameter(request, "idProfesor"); // Necesito obtener el id del profesor que se quiere editar. En caso de un alta
			profesor = (Profesor) ProfesorControlador.getControlador().find(idProfesor);
		} catch (Exception e) { }
		
		String mensajeAlUsuario = "";
		
		if (request.getParameter("eliminar") != null) {
			try {
				ProfesorControlador.getControlador().remove(profesor);
				response.sendRedirect(request.getContextPath() + "/Serv03_ServletAccesoBBDD_ListadoProfesores"); // Redirecci�n del response hacia el listado
			}
			catch (Exception ex) {
				mensajeAlUsuario = "Imposible eliminar. Es posible que existan restricciones.";
			}
		}
		
		if (request.getParameter("guardar") != null) {
			try {
				profesor.setNombre(getStringParameter(request, "nombre"));
				profesor.setPrimerApellido(getStringParameter(request, "primerApellido"));
				profesor.setSegundoApellido(getStringParameter(request, "segundoApellido"));
				profesor.setTipologiaSexo((TipologiaSexo) TipologiaSexoControlador.getControlador().find(getIntParameter(request, "idTipologiaSexo")));
				profesor.setDni(getStringParameter(request, "dni"));
				profesor.setDireccion(getStringParameter(request, "direccion"));
				profesor.setEmail(getStringParameter(request, "email"));
				profesor.setTelefono(getStringParameter(request, "telefono"));
				profesor.setColorPreferido(getStringParameter(request, "colorPreferido"));
				
				ProfesorControlador.getControlador().save(profesor);
				mensajeAlUsuario = "Guardado correctamente";
			} catch (FormularioIncorrectoRecibidoException e) {
				throw new ServletException(e);
			}
		}
		
		response.getWriter().append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n" + 
				"<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n" + 
				"<head>\r\n" + 
				"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\" />\r\n" + 
				"<title>Documento sin t�tulo</title>\r\n" + 
				"</head>\r\n" + 
				"\r\n" + 
				"<body " +((mensajeAlUsuario != null && mensajeAlUsuario != "")? "onLoad=\"alert('" + mensajeAlUsuario + "');\"" : "")  + " >\r\n" + 
				"<h1>Ficha de profesor</h1>\r\n" + 
				"<a href=\"Serv03_ServletAccesoBBDD_ListadoProfesores\">Ir al listado de profesores</a>" +
				"<form id=\"form1\" name=\"form1\" method=\"post\" action=\"Serv04_FichaProfesor\">\r\n" + 
				" <img src=\"DownloadImagenProfesor?idProfesor=" + ((profesor != null)? profesor.getId() : "") + "\" width='100px' height='100px'/>" +
				" <input type=\"hidden\" name=\"idProfesor\" value=\"" + ((profesor != null)? profesor.getId() : "") + "\"\\>" +
				"  <p>\r\n" + 
				"    <label for=\"nombre\">Nombre:</label>\r\n" + 
				"    <input name=\"nombre\" type=\"text\" id=\"nombre\"  value=\"" + ((profesor != null)? profesor.getNombre() : "") + "\" />\r\n" + 
				"  </p>\r\n" + 
				"  <p>\r\n" + 
				"    <label for=\"primerApellido\">Primer apellido:</label>\r\n" + 
				"    <input name=\"primerApellido\" type=\"text\" id=\"primerApellido\" value=\"" + ((profesor != null)? profesor.getPrimerApellido() : "") + "\" />\r\n" + 
				"  </p>\r\n" + 
				"  <p>\r\n" + 
				"    <label for=\"segundoApellido\">Segundo apellido:</label>\r\n" + 
				"    <input name=\"segundoApellido\" type=\"text\" id=\"segundoApellido\" value='" + ((profesor != null)? profesor.getSegundoApellido() : "") + "'/>\r\n" + 
				"  </p>\r\n" + 
				"  <p>\r\n" + 
				"    <label for=\"idTipologiaSexo\">Sexo:</label>\r\n" + 
				"    <select name=\"idTipologiaSexo\" id=\"idTipologiaSexo\">\r\n");
				// Inserto los valores de la tipolog�a del sexo del profesor y, si el registro tiene un valor concreto, lo establezco
				List<TipologiaSexo> sexos = TipologiaSexoControlador.getControlador().findAllTipologiaSexos();
				for (TipologiaSexo sexo : sexos) {
					response.getWriter().append("<option value=\"" + sexo.getId() + "\" " + ((profesor != null && sexo.getId() == profesor.getTipologiaSexo().getId())? "selected=\"selected\"" : "") + ">" + sexo.getDescripcion() + "</option>");
				}
		response.getWriter().append("    </select>\r\n" + 
				"  </p>\r\n" + 
				"  <p>\r\n" + 
				"    <label for=\"dni\">DNI:</label>\r\n" + 
				"    <input name=\"dni\" type=\"text\" id=\"dni\" value='" + ((profesor != null)? profesor.getDni() : "") + "' />\r\n" + 
				"  </p>\r\n" + 
				"  <p>\r\n" + 
				"    <label for=\"direccion\">Direccion:</label>\r\n" + 
				"    <input name=\"direccion\" type=\"text\" id=\"direccion\" value='" + ((profesor != null)? profesor.getDireccion() : "") + "' />\r\n" + 
				"  </p>\r\n" + 
				"  <p>\r\n" + 
				"    <label for=\"email\">Email:</label>\r\n" + 
				"    <input name=\"email\" type=\"text\" id=\"email\" value='" + ((profesor != null)? profesor.getEmail() : "") + "'/>\r\n" + 
				"  </p>\r\n" + 
				"  <p>\r\n" + 
				"    <label for=\"telefono\">Telefono:</label>\r\n" + 
				"    <input name=\"telefono\" type=\"text\" id=\"telefono\" value='" + ((profesor != null)? profesor.getTelefono() : "") + "'/>\r\n" + 
				"  </p>\r\n" + 
				"  <p>\r\n" + 
				"    <label for=\"colorPreferido\">Color preferido:</label>\r\n" + 
				"    <input name=\"colorPreferido\" type=\"text\" id=\"colorPreferido\" value='" + ((profesor != null)? profesor.getColorPreferido() : "") + "'/>\r\n" + 
				"  </p>\r\n" + 
				"  <p>\r\n" + 
				"    <input type=\"submit\" name=\"guardar\" value=\"Guardar\" />\r\n" + 
				"    <input type=\"submit\" name=\"eliminar\" value=\"Eliminar\" />\r\n" + 
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
	
	/**
	 * 
	 * @param request
	 * @param nombreParametro
	 * @return
	 * @throws FormularioIncorrectoRecibidoException
	 */
	public int getIntParameter (HttpServletRequest request, String nombreParametro) throws FormularioIncorrectoRecibidoException {
		try {
			return Integer.parseInt(request.getParameter(nombreParametro));
		} catch (Exception e) {
			throw new FormularioIncorrectoRecibidoException("No se ha recibido valor entero para el par�metro " + nombreParametro);
		}
	}
	
	/**
	 * 
	 * @param request
	 * @param nombreParametro
	 * @return
	 * @throws FormularioIncorrectoRecibidoException
	 */
	public String getStringParameter (HttpServletRequest request, String nombreParametro) throws FormularioIncorrectoRecibidoException {
		if (request.getParameter(nombreParametro) != null) {
			return request.getParameter(nombreParametro);
		}
		throw new FormularioIncorrectoRecibidoException("No se ha recibido valor para el par�metro " + nombreParametro);
	}
	

}
