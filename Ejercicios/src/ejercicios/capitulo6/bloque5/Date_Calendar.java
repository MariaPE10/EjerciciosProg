package ejercicios.capitulo6.bloque5;

import javax.swing.JOptionPane;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Date_Calendar {

	/* Ejercicio 1: Crea un programa en Java que pida al usuario la introducción de una fecha a través de JOptionPane. 
	 * El usuario te especificará un dato de tipo String y tú debes convertirlo a un objeto de 
	 * tipo java.util.Date utilizando SimpleDateFormat. A continuación realiza las siguientes acciones:
	 * 	- Con el objeto java.util.Date, crea un objeto de tipo Calendar y que represente la misma fecha 
	 * 	que ha introducido el usuario.
	 * 	- Obtén en pantalla los siguientes campos: año, mes, día, hora, minuto y segundo. 
	 * 	Cada campo debe aparecer en una línea de la consola. Debes obtener cada campo desde el objeto java.util.Date 
	 * 	y desde el objeto Calendar. Es decir, cada campo debe ser obtenido dos veces en pantalla.
	 * 	- Utiliza el objeto de tipo Calendar para obtener nuevas fechas e imprimirlas en pantalla: suma 3 días, resta 
	 * 	2 semanas, suma 300 días, suma 4 años.
	 */
      
	/**
	 * Ejercicio 1
	 */
	public static Date pedirFecha() {
		Date fechaUsuario = null;
		SimpleDateFormat sdf2 = new SimpleDateFormat ("dd/MM/yyyy HH:mm:ss");
		try {
			fechaUsuario = sdf2.parse(JOptionPane.showInputDialog("Introduzca una fecha en formato: dd/mm/aaaa hh:mm:ss"));
		} catch (ParseException e) {
			System.out.println ("Error en el parseo de la fecha");
			e.printStackTrace();
		}
		System.out.println("Fecha parseada: " + sdf2.format(fechaUsuario));
		return fechaUsuario;
	}
	
	/**
	 * 
	 * @param fechaUsuario
	 */
	public static void creaCalendar (Date fechaUsuario) {
		Locale locale = Locale.getDefault();
		Calendar fechaCalendar = Calendar.getInstance();
		fechaCalendar.setTime(fechaUsuario);
		System.out.println("Fecha Calendar: " + fechaCalendar.get(Calendar.DAY_OF_MONTH) +
				"/" + (fechaCalendar.get(Calendar.MONTH)+1) + "/" + fechaCalendar.get(Calendar.YEAR) + "\n");
		
		System.out.println("Anio Calendar: " + fechaCalendar.get(Calendar.YEAR));
		SimpleDateFormat sdf2 = new SimpleDateFormat ("yyyy");
		System.out.println("Anio Date: " + sdf2.format(fechaUsuario) + "\n");
		
		System.out.println("Mes Calendar: " + fechaCalendar.get(Calendar.MONTH));
		System.out.println("Mes (String): " + fechaCalendar.getDisplayName(Calendar.MONTH, Calendar.SHORT, locale));
		sdf2 = new SimpleDateFormat ("MM");
		System.out.println("Mes Date: " + sdf2.format(fechaUsuario) + "\n");
		
		System.out.println("Dia Calendar: " + fechaCalendar.get(Calendar.DAY_OF_MONTH));
		sdf2 = new SimpleDateFormat ("dd");
		System.out.println("Dia Date: " + sdf2.format(fechaUsuario) + "\n");
		
		System.out.println("Hora Calendar: " + fechaCalendar.get(Calendar.HOUR_OF_DAY));
		sdf2 = new SimpleDateFormat ("HH");
		System.out.println("Hora Date: " + sdf2.format(fechaUsuario) + "\n");
		
		System.out.println("Minutos Calendar: " + fechaCalendar.get(Calendar.MINUTE));
		sdf2 = new SimpleDateFormat ("mm");
		System.out.println("Minutos Date: " + sdf2.format(fechaUsuario) + "\n");
		
		System.out.println("Segundos Calendar: " + fechaCalendar.get(Calendar.SECOND));
		sdf2 = new SimpleDateFormat ("ss");
		System.out.println("Segundos Date: " + sdf2.format(fechaUsuario) + "\n");
	}
	
	/**
	 * 
	 */
	public static void sumaRestaFechas() {
		Calendar fecha = Calendar.getInstance();
		fecha.add(Calendar.DAY_OF_MONTH, 3);
		System.out.println("Suma 3 días: " + fecha.getTime());
		fecha = Calendar.getInstance();
		fecha.add(Calendar.DAY_OF_MONTH, -14);
		System.out.println("Resta 2 semanas: " + fecha.getTime());
		fecha = Calendar.getInstance();
		fecha.add(Calendar.DAY_OF_MONTH, 300);
		System.out.println("Suma 300 dias: " + fecha.getTime());
		fecha = Calendar.getInstance();
		fecha.add(Calendar.YEAR, 4);
		System.out.println("Suma 4 anios: " + fecha.getTime());
	}
	
	/* Ejercicio 2: Obtén la hora actual en Roma (Italia), también la hora actual 
	 * en Sidney (Australia) y calcula la diferencia horaria entre las 
	 * dos ciudades.
	 */
	
	public static void zonasHorarias() {
		Calendar fechaRoma = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"));
		Calendar fechaTokyo = Calendar.getInstance(TimeZone.getTimeZone("Asia/Tokyo"));
		
		System.out.println("Hora en Roma: " + fechaRoma.get(Calendar.HOUR_OF_DAY));
		System.out.println("Hora en Tokyo: " + fechaTokyo.get(Calendar.HOUR_OF_DAY));
		
		System.out.println("Diferencia horaria: " + Math.abs(fechaRoma.get(Calendar.HOUR_OF_DAY)-fechaTokyo.get(Calendar.HOUR_OF_DAY)) + " horas");
		
//		long milistokyo = fechaTokyo.getTimeInMillis();
//		long milisroma = fechaRoma.getTimeInMillis();
//		long milis = fechaTokyo.getTimeInMillis()-fechaRoma.getTimeInMillis();
//		long horasEntreFechas = milis/1000/60;
		
		//System.out.println("Diferencia horaria: " + horasEntreFechas);
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
//		Date fecha = pedirFecha();
//		creaCalendar(fecha);
//		sumaRestaFechas();
		zonasHorarias();
	}
	
}
