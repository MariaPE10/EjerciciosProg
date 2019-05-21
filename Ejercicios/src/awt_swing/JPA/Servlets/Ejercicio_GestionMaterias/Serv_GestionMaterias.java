package awt_swing.JPA.Servlets.Ejercicio_GestionMaterias;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import awt_swing.JPA.Ejercicio_curso.modelo.Estudiante;
import awt_swing.JPA.Ejercicio_curso.modelo.Materia;
import awt_swing.JPA.Ejercicio_curso.modelo.Profesor;
import awt_swing.JPA.Ejercicio_curso.modelo.ValoracionMateria;
import awt_swing.JPA.Ejercicio_curso.modelo.controladores.EstudianteControlador;
import awt_swing.JPA.Ejercicio_curso.modelo.controladores.MateriaControlador;
import awt_swing.JPA.Ejercicio_curso.modelo.controladores.ProfesorControlador;
import awt_swing.JPA.Ejercicio_curso.modelo.controladores.ValoracionMateriaControlador;
import awt_swing.JPA.Servlets.FormularioIncorrectoRecibidoException;



/**
 * Servlet implementation class PrimerServlet
 */
@WebServlet(description = "Primer Servlet", urlPatterns = { "/GestionValoracion" })
public class Serv_GestionMaterias extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Serv_GestionMaterias() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mensajeAlUsuario = "";
		List<Estudiante> estudiantes = EstudianteControlador.getControlador().findAllEstudiantes();
		int idMateria = 0, idProfesor = 0;
		try {
			idMateria = getIntParameter(request, "idMateria");
			idProfesor = getIntParameter(request, "idProfesor");
		} catch (FormularioIncorrectoRecibidoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if (request.getParameter("guardar") != null) {
			
			for (int i = 0; i < estudiantes.size(); i++) {
				Estudiante estudiante = estudiantes.get(i);
				ValoracionMateria valoracion = new ValoracionMateria();
				
				valoracion.setEstudiante((Estudiante) EstudianteControlador.getControlador().find(estudiante.getId()));
				valoracion.setProfesor((Profesor) ProfesorControlador.getControlador().find(idProfesor));
				valoracion.setMateria((Materia) MateriaControlador.getControlador().find(idMateria)); 
				valoracion.setValoracion(Float.parseFloat(request.getParameter("nota"+estudiante.getId())));
				
				ValoracionMateria valoracionAlmacenada = ValoracionMateriaControlador.getControlador().findByProfesorAndMateriaAndEstudiante(valoracion);
				if (valoracionAlmacenada != null) {
					valoracionAlmacenada.setValoracion(valoracion.getValoracion());
					ValoracionMateriaControlador.getControlador().merge(valoracionAlmacenada);
				}
				else {
					valoracion.setId(0);
					ValoracionMateriaControlador.getControlador().persist(valoracion);
				}
			
			}
			mensajeAlUsuario = "Guardado correctamente";
			
		}
		
		response.getWriter().append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n" + 
				"<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n" + 
				"<head>\r\n" + 
				"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\" />\r\n" + 
				"<title>Documento sin titulo</title>\r\n" + 
				"</head>\r\n" + 
				"\r\n" + 
				"<body " +((mensajeAlUsuario != null && mensajeAlUsuario != "")? "onLoad=\"alert('" + mensajeAlUsuario + "');\"" : "")  + " >\r\n" + 
				"<h1>Gestion de Valoracion de Materias</h1>\r\n" + 
				"<form id=\"form1\" name=\"form1\" method=\"post\" action=\"GestionValoracion\">\r\n" + 
				"    <label for=\"idMateria\">Materia:</label>\r\n" + 
				"    <select name=\"idMateria\" id=\"idMateria\">\r\n");
				
				List<Materia> materias = MateriaControlador.getControlador().findAllMaterias();
				for (Materia materia : materias) {
					response.getWriter().append("<option value=\"" + materia.getId() + "\" " + ((idMateria == materia.getId())? "selected='selected'" : "" )  + ">" + materia.getAcronimo() + "</option>");
				}
				response.getWriter().append("    </select>\r\n" + 
				"  </p>\r\n" + 
				"  <p>\r\n" + 
				"    <label for=\"idProfesor\">Profesor:</label>\r\n" + 
				"    <select name=\"idProfesor\" id=\"idProfesor\">\r\n");
				
				List<Profesor> profesores = ProfesorControlador.getControlador().findAllProfesores();
				for (Profesor profesor : profesores) {
					response.getWriter().append("<option value=\"" + profesor.getId() + "\" " + ((idProfesor == profesor.getId())? "selected='selected'" : "" )  + ">" + profesor.getNombre() + "</option>");
				}
				response.getWriter().append("    </select>\r\n" + 
				"  </p>\r\n" + 
				"  <p>\r\n" +
				"    <input type=\"submit\" name=\"actualizar\" value=\"Actualizar\" />\r\n" + 
				"  </p>\r\n");
				
				if (request.getParameter("actualizar") != null) {
					
					for (int i = 0; i < estudiantes.size(); i++) {
						Estudiante estudiante = estudiantes.get(i);
					
						response.getWriter().append(" <input type=\"hidden\" name=\"idEstudiante\" value=\"" + ((estudiante != null)? estudiante.getId() : "") + "\"\\>" +
								"  <p>\r\n" + 
								"    <label for=\"nombre\">"+((estudiante != null)? estudiante.getNombre() + " " + estudiante.getPrimerApellido() + " " + estudiante.getSegundoApellido() : "") + ":</label>\r\n" + 
								"    <input name=\"nota"+estudiante.getId()+"\" type=\"text\" id=\"nota"+estudiante.getId()+"\"  value=\"" + ((estudiante != null)? getNota(estudiante, request) : "") + "\" />\r\n" + 
								"  </p>\r\n" + 
								"  <p>\r\n");
					}
					response.getWriter().append("<input type=\"submit\" name=\"guardar\" value=\"Guardar\" />\r\n" + 
					"  </p>\r\n" + 
					"</form>" + 
					"</body>\r\n" + 
					"</html>\r\n" + 
					"");
				}

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

	private float getNota(Estudiante estudiante, HttpServletRequest request) throws ServletException, IOException {
		float nota = 0f;
		try {
			ValoracionMateria valoracion = new ValoracionMateria();
			
			valoracion.setEstudiante(estudiante);
			valoracion.setProfesor((Profesor) ProfesorControlador.getControlador().find(getIntParameter(request, "idProfesor")));
			valoracion.setMateria((Materia) MateriaControlador.getControlador().find(getIntParameter(request, "idMateria"))); 
			
			ValoracionMateria valoracionAlmacenada = ValoracionMateriaControlador.getControlador().findByProfesorAndMateriaAndEstudiante(valoracion);
			if (valoracionAlmacenada != null) {
				nota = valoracionAlmacenada.getValoracion();
			}
			else {
				nota = 0f;
			}
		} catch (FormularioIncorrectoRecibidoException e) {
			throw new ServletException(e);
		}
		return nota;
	}
}
