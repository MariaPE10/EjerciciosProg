package Codigo;

import java.text.ParseException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class codigo01 {

	/* Ejercicio 1: Realiza un programa que pida al usuario tres numeros:
	 * uno de tipo entero, otro de tipo flotante y otro de tipo doble.
     * A continuacion se tienen que mostrar en pantalla los tres numeros 
	 * en una sola fila de la consola de salida
	 */ 
	public static void introduccionEj1 () {
	
		try {
			String str = JOptionPane.showInputDialog("Introduzca un numero entero: ");
			int var1 = Integer.parseInt(str);
	
			String str2 = JOptionPane.showInputDialog("Introduzca un numero flotante: ");
			float var2 = Float.parseFloat(str2);
			
			String str3 =JOptionPane.showInputDialog("Introduzca un numero doble: ");
			double var3 = Double.parseDouble(str3);
			
			System.out.println("Numeros introducidos: 1ro->" + var1 + " 2do->" + var2 + " 3ro->" + var3 );
		}
		catch (NumberFormatException ex) {
			System.out.println("Error no has introducido un numero");
		}
	}
	
	/* Ejercicio 2: Realiza un programa igual al anterior, con la particularidad 
	 * de que ahora se debe mostrar cada nï¿½mero justo a continuaciï¿½n del momento 
	 * en que ha sido introducido.
	 */
	public static void introduccionEj2 () {
	
		String str1 = JOptionPane.showInputDialog("Introduzca un numero entero: ");
		try {
			int var1 = Integer.parseInt(str1);
			System.out.println("Numero introducido:" + var1);
			}
		catch (NumberFormatException ex) {
			System.out.println("Error, no has introducido un numero entero");
		}
		
		String str2 = JOptionPane.showInputDialog("Introduzca un numero flotante: ");
		try {
			float var2 = Float.parseFloat(str2);
			System.out.println("Numero introducido: " + var2);
			}
		catch (NumberFormatException ex) {
			System.out.println("Error, no has introducido un numero flotante");
		}
		String str3 = JOptionPane.showInputDialog("Introduzca un numero doble: ");
		try {
			double var3 = Double.parseDouble(str3);
			System.out.println("Numero introducido: " + var3);
			}
		catch (NumberFormatException ex) {
			System.out.println("Error, no has introducido un numero doble");
		}
	}
		
	/*Ejercicio 3: Realiza un programa que pida al usuario tres nï¿½meros y calcule 
	 * y muestre en pantalla la suma de los tres.
	 */
	public static void introduccionEj3 () {
		try {
			String str1 = JOptionPane.showInputDialog("Introduzca un numero: ");
			double var1 = Double.parseDouble(str1);
			
			String str2 = JOptionPane.showInputDialog("Introduzca un numero: ");
			double var2 = Double.parseDouble(str2);
				
			String str3 = JOptionPane.showInputDialog("Introduzca un numero: ");
			double var3 = Double.parseDouble(str3);
				
			double suma = var1 + var2 + var3;
			System.out.println("La suma de los numeros es: " + suma);
		}
		catch (NumberFormatException ex) {
			System.out.println("Error, eso no es un numero");
		}
	}

	// Ejercicio 4: Realiza un programa que muestre la media de tres nï¿½meros introducidos.
	
	public static void introduccionEj4 () {
		
		try {
		
			String str1 = JOptionPane.showInputDialog("Introduzca un numero: ");
			double var1 = Double.parseDouble(str1);
			
			String str2 = JOptionPane.showInputDialog("Introduzca un numero: ");
			double var2 = Double.parseDouble(str2);
				
			String str3 = JOptionPane.showInputDialog("Introduzca un numero: ");
			double var3 = Double.parseDouble(str3);
			
			double suma = var1 + var2 + var3;
			double media = suma / 3;
			System.out.println("La media de los tres numeros es: " + media);
		}
		catch (NumberFormatException ex) {
			System.out.println("Error, eso no es un numero");
		}
	}
	
	/* Ejercicio 5: Realiza un programa que pida dos variables al usuario, 
	 * intercambie los valores de las dos variables y las muestre en pantalla 
	 * ANTES y DESPUï¿½S del intercambio de valores
	 */
	
	public static void introduccionEj5 () {
		
		String str1 = JOptionPane.showInputDialog("Introduzca el primer valor: ");
		String str2 = JOptionPane.showInputDialog("Introduzca el segundo valor: ");
		System.out.println("El primer valor es: " + str1 + ", el segundo valor es: " + str2 + ".");
		
		String str3 = str1;
		str1 = str2;
		str2 = str3;
		
		System.out.println("El nuevo primer valor es: " + str1 + ", y el segundo es: " + str2 + ".");
		
	}
	
	/* Ejercicio 6: Realiza un ejercicio para el cï¿½lculo de la cuota mensual de una hipï¿½teca 
	 * (tema tan importante hoy dï¿½a ;-)). La formula para la cuota mensual es: 
                                                             N
                                              Im * ( 1 + Im ) 
				Cuota Mensual = Capital * ---------------------
                                                     N
                                           ( 1 + Im )   -   1


                                                   Interï¿½s Anual 
                                                   -------------
                                                         12
                Donde: Im es el Interes mensual = ----------------
                                                        100

		Interï¿½s Anual = Euribor + Diferencial (Ganancia del banco o caja)
		Capital = Cantidad de unidades monetarias de la hipoteca
		N = Nï¿½mero de plazos mensuales de la hipoteca.
		
		Se deben pedir al usuario los datos de Euribor (float), Diferencial (float), Capital (float) y 
		Nï¿½mero de plazos mensuales para pagar la hipoteca (int). A partir de esos datos se debe calcular y 
		mostrar al usuario el importe de la cuota mensual.
	 */
	
	/**
	 * Esta funciï¿½n es maravillosa
	 *
	 * @author Marï¿½a Pï¿½rez
	 * 
	 */
	public static void introduccionEj6 () {
		
		float euribor = 0f;
		float diferencial = 0f;
		float capital = 0f;
		int plazos = 0;
		float cuotaMensual = 0f;
		float interesMensual =0f;
		float interesAnual =0f;
		float ecuacionArriba =0f; // Parte de la ecuacion del calculo de la cuota mensual (arriba)
		float ecuacionAbajo =0f;   // Parte de la ecuacion del calculo de la cuota mensual (abajo)
		float ecuacion =0f; // Resultado de la ecuacion
		
		try {
			String str1 = JOptionPane.showInputDialog("Introduzca el Euribor ");
			euribor = Float.parseFloat(str1);
			String str2 = JOptionPane.showInputDialog("Introduzca su diferencial ");
			diferencial = Float.parseFloat(str2);
			String str3 = JOptionPane.showInputDialog("Introduzca el capital ");
			capital = Float.parseFloat(str3);
			String str4 = JOptionPane.showInputDialog("Introduzca el nï¿½ de plazos mensuales: ");
			plazos = Integer.parseInt(str4);
		}
		catch (NumberFormatException ex) {
			System.out.println("Error, ha habido un error al insertar los datos: ");
			ex.printStackTrace();
		}
		
		interesAnual = euribor + diferencial;
		interesMensual = (interesAnual/12)/100;
		ecuacionArriba = interesMensual * ((float) Math.pow((1 + interesMensual), plazos));
		ecuacionAbajo = ((float) Math.pow((1 + interesMensual), plazos)) - 1;
		ecuacion = ecuacionArriba / ecuacionAbajo;
		cuotaMensual = capital * ecuacion;
		System.out.println("La cuota mensual es: " + cuotaMensual + " ï¿½");
		
	}
	
	/* Ejercicio 7 :Realiza el "complemento a dos" de un nï¿½mero dado por el usuario. El complemento a dos consiste en dos pasos:
	 * en primer lugar se deben cambiar todos los bits del valor al que el complemento se estï¿½ aplicando, en segundo 
	 * lugar se le debe sumar 1 (uno). Este ejercicio pedirï¿½ al usuario un valor y mostrarï¿½ el complemento a dos del mismo.
	 * La impresiï¿½n debe hacerse sin signo.
	 */
		
	public static void introduccionEj7 () {
	
	}
	
	/*Ejercicio 8: Realiza un programa que pida al usuario tres nï¿½meros enteros, y 
	 * localice e imprima en pantalla el mayor y el menor de los tres introducidos.
	 */
	
	public static void introduccionEj8 () {
		
		int n1 = 0;
		int n2 =0;
		int n3 =0;
		
		int resultadoMayor = 0;
		int resultadoMenor = 0;
		
		//String pedro = (1 > 0) ? "pedro" : "manolo";
		
		try {
			String str1 = JOptionPane.showInputDialog("Introduzca el primer numero: ");
			n1 = Integer.parseInt(str1);
			String str2 = JOptionPane.showInputDialog("Introduzca el segundo numero: ");
			n2 = Integer.parseInt(str2);
			String str3 = JOptionPane.showInputDialog("Introduzca el tercer numero: ");
			n3 = Integer.parseInt(str3);
		}
		catch (NumberFormatException ex) {
			System.out.println("ERROR. Se ha producido un error al insertar los datos: ");
			ex.printStackTrace();
		}
		System.out.println("El primer numero es: " + n1);
		System.out.println("El segundo numero es: " + n2);
		System.out.println("El tercer numero es: " + n3);
		System.out.println("");
		
		//resultado mayor
		if (n1 >= n2 && n1 >= n3) {
			resultadoMayor = n1;
		}
		else if (n2 >= n3 && n2 >= n1){			
			resultadoMayor = n2;
		} 
		else {
			resultadoMayor = n3;
		}
		
		//resultado menor
		if (n1 <= n2 && n1 <= n3) {
			resultadoMenor = n1;
		}
		else if (n2 <= n3 && n2 <= n1){			
			resultadoMenor = n2;
		} 
		else {
			resultadoMenor = n3;
		}
		
		System.out.println("Mayor: " + resultadoMayor + " Menor: " + resultadoMenor);
	}
	
	public static void introduccionEj8B () {
		
		int n1 = 0;
		int n2 =0;
		int n3 =0;
		
		int resultadoMayor = 0;
		int resultadoMenor = 0;
		
		
		try {
			String str1 = JOptionPane.showInputDialog("Introduzca el primer numero: ");
			n1 = Integer.parseInt(str1);
			String str2 = JOptionPane.showInputDialog("Introduzca el segundo numero: ");
			n2 = Integer.parseInt(str2);
			String str3 = JOptionPane.showInputDialog("Introduzca el tercer numero: ");
			n3 = Integer.parseInt(str3);
		}
		catch (NumberFormatException ex) {
			System.out.println("ERROR. Se ha producido un error al insertar los datos: ");
			ex.printStackTrace();
		}
		System.out.println("El primer numero es: " + n1);
		System.out.println("El segundo numero es: " + n2);
		System.out.println("El tercer numero es: " + n3);
		System.out.println("");
		
		resultadoMayor = Math.max(Math.max(n1, n2), n3);
		resultadoMenor = Math.min(Math.min(n1, n2), n3);
		
		System.out.println("Mayor: " + resultadoMayor + " Menor: " + resultadoMenor);
	}
		
	/* Ejercicio 1: Realiza un ejercicio que pida dos variables al usuario, tras lo cual, muestre en
	 * pantalla el nï¿½mero mayor de los dos introducidos.
	 */
	
	public static void condicionalesEj1 () {		
		
		int n1 =0;
		int n2 =0;
		int resultadoMayor =0;
		
		try {
			String str1 = JOptionPane.showInputDialog("Introduzca el primer numero: ");
			n1 = Integer.parseInt(str1);
			String str2 = JOptionPane.showInputDialog("Introduzca el segundo numero: ");
			n2 = Integer.parseInt(str2);
			}
		catch (NumberFormatException ex) {
			System.out.println("ERROR. Se ha producido un error al insertar los datos: ");
			ex.printStackTrace();
		}
		System.out.println("El primer numero es: " + n1);
		System.out.println("El segundo numero es: " + n2);
		
		if (n1 >= n2) {
			resultadoMayor = n1;
		}
		else {
			resultadoMayor =n2;
		}
		System.out.println("Mayor: " + resultadoMayor);
	}
	
	// Ejercicio 2: Repetir el ejercicio anterior para mostrar el nï¿½mero menor de los dos introducidos.
	
	public static void condicionalesEj2 () {		
		
		int n1 =0;
		int n2 =0;
		int resultadoMenor =0;
		
		try {
			String str1 = JOptionPane.showInputDialog("Introduzca el primer numero: ");
			n1 = Integer.parseInt(str1);
			String str2 = JOptionPane.showInputDialog("Introduzca el segundo numero: ");
			n2 = Integer.parseInt(str2);
			}
		catch (NumberFormatException ex) {
			System.out.println("ERROR. Se ha producido un error al insertar los datos: ");
			ex.printStackTrace();
		}
		System.out.println("El primer numero es: " + n1);
		System.out.println("El segundo numero es: " + n2);
		
		if (n1 <= n2) {
			resultadoMenor = n1;
		}
		else {
			resultadoMenor =n2;
		}
		System.out.println("Menor: " + resultadoMenor);
	}
	
	/*Ejercicio 3: Repetir el ejercicio 1ï¿½ de este bloque de ejercicios, 
	 * pero pidiendo al usuario cinco variables. Es decir, se pedirï¿½n 
	 * al usuario cinco variables y se mostrarï¿½ el mayor valor en pantalla.
	 */
	
	public static void condicionalesEj3 () {
		
		int n1 =0;
		int n2 =0;
		int n3 =0;
		int n4 =0;
		int n5 =0;
		int resultadoMayor =0;
		
		try {
			String str1 = JOptionPane.showInputDialog("Introduzca el primer numero: ");
			n1 = Integer.parseInt(str1);
			String str2 = JOptionPane.showInputDialog("Introduzca el segundo numero: ");
			n2 = Integer.parseInt(str2);
			String str3 = JOptionPane.showInputDialog("Introduzca el tercer numero: ");
			n3 = Integer.parseInt(str3);
			String str4 = JOptionPane.showInputDialog("Introduzca el cuarto numero: ");
			n4 = Integer.parseInt(str4);
			String str5 = JOptionPane.showInputDialog("Introduzca el quinto numero: ");
			n5 = Integer.parseInt(str5);
		}
		catch (NumberFormatException ex) {
			System.out.println("ERROR. Se ha producido un error al insertar los datos: ");
			ex.printStackTrace();
		}
		System.out.println("1er numero: " + n1);
		System.out.println("2do numero: " + n2);
		System.out.println("3ro numero: " + n3);
		System.out.println("4to numero: " + n4);
		System.out.println("5to numero: " + n5);
		System.out.println("");
		
		if (n1 >= n2 && n1 >= n3 && n1 >= n4 && n1 >= n5) {
			resultadoMayor = n1;
		}
		else if (n2 >= n3 && n2 >= n4 && n2 >= n5){
			resultadoMayor = n2;
		}
		else if (n3 >= n4 && n3 >= n5) {
			resultadoMayor = n3;
		}
		else if (n4 >= n5) {
			resultadoMayor = n4;
		}
		else {
			resultadoMayor = n5;
		}
		System.out.println("El numero mayor es: " + resultadoMayor);
	}
	
	public static void condicionalesEj3B () {
		
		int n1 =0;
		int mayor =0;
		String texto = "Introduce un nÃºmero: ";	
		
		try {
			mayor = Integer.parseInt(JOptionPane.showInputDialog(texto));
			
			n1 = Integer.parseInt(JOptionPane.showInputDialog(texto));
			mayor = (n1 > mayor)? n1:mayor;
			
			n1 = Integer.parseInt(JOptionPane.showInputDialog(texto));
			mayor = (n1 > mayor)? n1:mayor;
			
			n1 = Integer.parseInt(JOptionPane.showInputDialog(texto));
			mayor = (n1 > mayor)? n1:mayor;
			
			n1 = Integer.parseInt(JOptionPane.showInputDialog(texto));
			mayor = (n1 > mayor)? n1:mayor;
			
		}
		catch (NumberFormatException ex) {
			System.out.println("ERROR. Se ha producido un error al insertar los datos: ");
			ex.printStackTrace();
		}
		
		System.out.println("El numero mayor es: " + mayor);
	}
	
	/* Ejercicio 4: Repetir el ejercicio 3ï¿½ de este bloque de ejercicios, pero mostrando el menor valor 
	* de los cinco introducidos por el usuario.
	*/
	
	public static void condicionalesEj4 ( ) {

		int n1 =0;
		int n2 =0;
		int n3 =0;
		int n4 =0;
		int n5 =0;
		int resultadoMenor =0;
		
		try {
			String str1 = JOptionPane.showInputDialog("Introduzca el primer numero: ");
			n1 = Integer.parseInt(str1);
			String str2 = JOptionPane.showInputDialog("Introduzca el segundo numero: ");
			n2 = Integer.parseInt(str2);
			String str3 = JOptionPane.showInputDialog("Introduzca el tercer numero: ");
			n3 = Integer.parseInt(str3);
			String str4 = JOptionPane.showInputDialog("Introduzca el cuarto numero: ");
			n4 = Integer.parseInt(str4);
			String str5 = JOptionPane.showInputDialog("Introduzca el quinto numero: ");
			n5 = Integer.parseInt(str5);
		}
		catch (NumberFormatException ex) {
			System.out.println("ERROR. Se ha producido un error al insertar los datos: ");
			ex.printStackTrace();
		}
		System.out.println("1er numero: " + n1);
		System.out.println("2do numero: " + n2);
		System.out.println("3ro numero: " + n3);
		System.out.println("4to numero: " + n4);
		System.out.println("5to numero: " + n5);
		System.out.println("");
		
		if (n1 <= n2 && n1 <= n3 && n1 <= n4 && n1 <= n5) {
			resultadoMenor = n1;
		}
		else if (n2 <= n3 && n2 <= n4 && n2 <= n5){
			resultadoMenor = n2;
		}
		else if (n3 <= n4 && n3 <= n5) {
			resultadoMenor = n3;
		}
		else if (n4 <= n5) {
			resultadoMenor = n4;
		}
		else {
			resultadoMenor = n5;
		}
		System.out.println("El numero menor es: " + resultadoMenor);
		
	}
	
	//Ejercicio 5: Pedir al usuario cinco nï¿½meros, e imprimir posteriormente el mayor valor introducido y el menor valor introducido.
	
	public static void condicionalesEj5 ( ) {

		int n1 =0;
		int n2 =0;
		int n3 =0;
		int n4 =0;
		int n5 =0;
		int resultadoMenor =0;
		int resultadoMayor =0;
		
		try {
			String str1 = JOptionPane.showInputDialog("Introduzca el primer numero: ");
			n1 = Integer.parseInt(str1);
			String str2 = JOptionPane.showInputDialog("Introduzca el segundo numero: ");
			n2 = Integer.parseInt(str2);
			String str3 = JOptionPane.showInputDialog("Introduzca el tercer numero: ");
			n3 = Integer.parseInt(str3);
			String str4 = JOptionPane.showInputDialog("Introduzca el cuarto numero: ");
			n4 = Integer.parseInt(str4);
			String str5 = JOptionPane.showInputDialog("Introduzca el quinto numero: ");
			n5 = Integer.parseInt(str5);
		}
		catch (NumberFormatException ex) {
			System.out.println("ERROR. Se ha producido un error al insertar los datos: ");
			ex.printStackTrace();
		}
		System.out.println("1er numero: " + n1);
		System.out.println("2do numero: " + n2);
		System.out.println("3ro numero: " + n3);
		System.out.println("4to numero: " + n4);
		System.out.println("5to numero: " + n5);
		System.out.println("");
		
		// resultado menor
		
		if (n1 <= n2 && n1 <= n3 && n1 <= n4 && n1 <= n5) {
			resultadoMenor = n1;
		}
		else if (n2 <= n3 && n2 <= n4 && n2 <= n5){
			resultadoMenor = n2;
		}
		else if (n3 <= n4 && n3 <= n5) {
			resultadoMenor = n3;
		}
		else if (n4 <= n5) {
			resultadoMenor = n4;
		}
		else {
			resultadoMenor = n5;
		}
		
		//resultado mayor
		
		if (n1 >= n2 && n1 >= n3 && n1 >= n4 && n1 >= n5) {
			resultadoMayor = n1;
		}
		else if (n2 >= n3 && n2 >= n4 && n2 >= n5){
			resultadoMayor = n2;
		}
		else if (n3 >= n4 && n3 >= n5) {
			resultadoMayor = n3;
		}
		else if (n4 >= n5) {
			resultadoMayor = n4;
		}
		else {
			resultadoMayor = n5;
		}
		System.out.println("El numero mayor es: " + resultadoMayor + " y el menor: " + resultadoMenor);
	}
 /* Ejercicio 6: Realizar un ejercicio que pida un nï¿½mero al usuario e indique en pantalla si se trata de un nï¿½mero par o impar.
  * Recuerda que un nï¿½mero par es aquel cuyo resto de su divisiï¿½n entre dos sea siempre cero, y recuerda que 
  * un nï¿½mero impar es aquel cuyo resto de su divisiï¿½n entre dos sea siempre uno. 
  */
	
	public static void condicionalesEj6 () {
		
		int n1 = 0;
		int resto =0;
		String resultado = "";
		
		try {
			String str1 = JOptionPane.showInputDialog("Introduce un numero: ");
			n1 = Integer.parseInt(str1);
		}
		catch (NumberFormatException ex) {
			System.out.println("ERROR. Se ha producido un error al introducir los datos");
			ex.printStackTrace();
		}
		
		/*
		int resto = 4 % 2;  //0
		int cociente = 4 / 2;  //2
		*/
		
		resto = n1 % 2;
		
		if (resto == 1) {
			System.out.println("El numero es impar");
		}
		else {
			System.out.println("El numero es par");
		}
		
		
		resultado = (n1 % 2 == 0) ? "par" : "impar";
		
		System.out.println("El numero " + n1 + " es " + resultado);
	}
	
	public static void condicionalesEj6B () {
		
		int n1 = 0;
		String resultado = "";
		
		try {
			String str1 = JOptionPane.showInputDialog("Introduce un numero: ");
			n1 = Integer.parseInt(str1);
		}
		catch (NumberFormatException ex) {
			System.out.println("ERROR. Se ha producido un error al introducir los datos");
			ex.printStackTrace();
		}
		
		resultado = (n1 % 2 == 0) ? "par" : "impar";
		
		System.out.println("El numero " + n1 + " es " + resultado);
	}
	
	/* Ejercicio 7: Utiliza la operacion AND y el operador "if", para tratar de averiguar si un nï¿½mero
	 * introducido por el usuario es par o impar. Serï¿½a recomendable que estudiases el cï¿½digo de la clase 
	 * "OperadoresANivelDeBits" del capitulo 1 de este tutorial.
	 */
	
	public static void condicionalesEj7 () {

		String str = JOptionPane.showInputDialog("Introduzca un numero");
		int num = Integer.parseInt(str);
		
		if ((num & 1) == 0) {
			System.out.println("El numero " + num + " es impar");
		} 
		else {	
			System.out.println("El nï¿½mero " + num + " es par");
		}
	}
		/* Ejercicio 8: Realiza un ejercicio que acumule cinco nï¿½meros introducidos por el usuario, es decir,
	 * que sume las cantidades introducidas, pero realizando cuatro categorï¿½as: nï¿½meros negativos, nï¿½meros bajos
	 * (entre 0 y 25, ambos inclusive), nï¿½meros medios (entre 26 y 250, ambos inclusive) y nï¿½meros grandes (mayores de 250).
	 * Al finalizar el programa, se debe mostrar el total de las sumas de los nï¿½meros introducidos en cada una de las categorï¿½as. 
	 */
	
	public static void condicionalesEj8 () {
		
		float n1 =0;
		float n2 =0;
		float n3 =0;
		float n4 =0;
		float n5 =0;
		float sumaNeg =0;
		float sumaPeq =0;
		float sumaMed =0;
		float sumaGra =0;
		
		try {
			String str1 = JOptionPane.showInputDialog("Introduzca el primer numero: ");
			n1 = Float.parseFloat(str1);
			String str2 = JOptionPane.showInputDialog("Introduzca el segundo numero: ");
			n2 = Float.parseFloat(str2);
			String str3 = JOptionPane.showInputDialog("Introduzca el tercer numero: ");
			n3 = Float.parseFloat(str3);
			String str4 = JOptionPane.showInputDialog("Introduzca el cuarto numero: ");
			n4 = Float.parseFloat(str4);
			String str5 = JOptionPane.showInputDialog("Introduzca el quinto numero: ");
			n5 = Float.parseFloat(str5);
		}
		catch (NumberFormatException ex) {
			System.out.println("ERROR. Se ha producido un error al insertar los datos: ");
			ex.printStackTrace();
		}
		// n1
		if (n1 < 0) {
			sumaNeg += n1;		// "+=" es lo mismo que escribir "sumaNeg = SumaNeg + n1"
		}
			else if (n1 <= 25) {
				sumaPeq += n1;
			}
				else if (n1 <=250) {
					sumaMed += n1;
				}
					else {
						sumaGra += n1;
		}
		//n2
		if (n2 < 0) {
			sumaNeg = sumaNeg + n2;		
		}
			else if (n2 <= 25) {
				sumaPeq = sumaPeq + n2;
			}
				else if (n2 <=250) {
					sumaMed = sumaMed + n2;
				}
					else {
						sumaGra = sumaGra + n2;
					}
		//n3
		if (n3 < 0) {
			sumaNeg = sumaNeg + n3;		
		}
			else if (n3 <= 25) {
				sumaPeq = sumaPeq + n3;
			}
				else if (n3 <=250) {
					sumaMed = sumaMed + n3;
				}
					else {
						sumaGra = sumaGra + n3;
		}
		//n4
		if (n4 < 0) {
			sumaNeg = sumaNeg + n4;		
		}
			else if (n4 <= 25) {
				sumaPeq = sumaPeq + n4;
			}
				else if (n4 <=250) {
					sumaMed = sumaMed + n4;
				}
					else {
						sumaGra = sumaGra + n4;
					}
		//n5
		if (n5 < 0) {
			sumaNeg = sumaNeg + n5;		
		}
			else if (n5 <= 25) {
				sumaPeq = sumaPeq + n5;
			}
				else if (n5 <=250) {
					sumaMed = sumaMed + n5;
				}
					else {
						sumaGra = sumaGra + n5;
					}
		
		System.out.println("La suma de los numeros negativos es: " + sumaNeg );
		System.out.println("La suma de los numeros pequeÃ±os es: " + sumaPeq );
		System.out.println("La suma de los numeros medianos es: " + sumaMed );
		System.out.println("La suma de los numeros grandes es: " + sumaGra );
	}
	
	public static void condicionalesEj8B () {
		
		float n1 =0;

		float sumaNeg = 0f;
		float sumaPeq = 0f;
		float sumaMed = 0f;
		float sumaGra = 0f;			
		
		for (int i = 0; i < 5 ; i++) {
			try {
				String str1 = JOptionPane.showInputDialog("Introduzca el numero " + (i+1) + ": ");
				n1 = Float.parseFloat(str1);
			}			
			catch (NumberFormatException ex) {
				System.out.println("ERROR. Se ha producido un error al insertar los datos: ");
				ex.printStackTrace();
			}	
			
			if (n1 < 0) {
				sumaNeg = sumaNeg + n1;		
			}
				else if (n1 <= 25) {
					sumaPeq = sumaPeq + n1;
				}
					else if (n1 <=250) {
						sumaMed = sumaMed + n1;
					}
						else {
							sumaGra = sumaGra + n1;
						}
		}
		
		System.out.println("La suma de los numeros negativos es: " + sumaNeg );
		System.out.println("La suma de los numeros pequeï¿½os es: " + sumaPeq );
		System.out.println("La suma de los numeros medianos es: " + sumaMed );
		System.out.println("La suma de los numeros grandes es: " + sumaGra );
	}
	
	/* public static void condicionalesEj8C () {
		
		float n1 =0;
		float n2 =0;
		float n3 =0;
		float n4 =0;
		float n5 =0;
		Float sumaNeg = new Float(0f);
		Float sumaPeq = new Float(0f);
		Float sumaMed = new Float(0f);
		Float sumaGra = new Float(0f);
		
		try {
			String str1 = JOptionPane.showInputDialog("Introduzca el primer numero: ");
			n1 = Float.parseFloat(str1);
			String str2 = JOptionPane.showInputDialog("Introduzca el segundo numero: ");
			n2 = Float.parseFloat(str2);
			String str3 = JOptionPane.showInputDialog("Introduzca el tercer numero: ");
			n3 = Float.parseFloat(str3);
			String str4 = JOptionPane.showInputDialog("Introduzca el cuarto numero: ");
			n4 = Float.parseFloat(str4);
			String str5 = JOptionPane.showInputDialog("Introduzca el quinto numero: ");
			n5 = Float.parseFloat(str5);
		}
		catch (NumberFormatException ex) {
			System.out.println("ERROR. Se ha producido un error al insertar los datos: ");
			ex.printStackTrace();
		}		
		
		sumarAGrupo(n1, sumaNeg, sumaPeq, sumaMed, sumaGra);
		sumarAGrupo(n2, sumaNeg, sumaPeq, sumaMed, sumaGra);
		sumarAGrupo(n3, sumaNeg, sumaPeq, sumaMed, sumaGra);
		sumarAGrupo(n4, sumaNeg, sumaPeq, sumaMed, sumaGra);
		sumarAGrupo(n5, sumaNeg, sumaPeq, sumaMed, sumaGra);
		
		System.out.println("La suma de los numeros negativos es: " + sumaNeg );
		System.out.println("La suma de los numeros pequeï¿½os es: " + sumaPeq );
		System.out.println("La suma de los numeros medianos es: " + sumaMed );
		System.out.println("La suma de los numeros grandes es: " + sumaGra );
	}
	
	public static void sumarAGrupo(float num, Float sumaNeg, Float sumaPeq, Float sumaMed, Float sumaGra) {
		if (num < 0) {
			sumaNeg = sumaNeg + num;		
		}
		else if (num  >= 0 && num <= 25) {
			sumaPeq = sumaPeq + num;
		}
		else if (num >=26 && num <=250) {
			sumaMed = sumaMed + num;
		}
		else {
			sumaGra = sumaGra + num;
		}
	} */	
	
	 /*	Ejercicio 9: Realiza un ejercicio igual al anterior, pero con las dos siguientes diferencias: no 
	  * existe la categorï¿½a de nï¿½meros negativos, por tanto si el usuario introduce un negativo, 
	  * el programa debe terminar; la otra diferencia es que, al acabar, el programa no debe mostrar la 
	  * suma de los nï¿½meros, sino cuantos han entrado en cada categorï¿½a. A esto se llema contadores, a 
	  * diferencia del ejercicio anterior, que reciben el nombre de acumuladores.	
	  */
	
	public static void condicionalesEj9 () {
		
		float n1 = 0;

		int contPeq = 0;
		int contMed = 0;
		int contGra = 0;	
		
		/*boolean bollo = true;
		while (bollo) {
			if(n1 > 10) {
				bollo = false;
			}
		}
		
		do {
			
		} while (true);
		*/
		
		for (int i = 0; i < 5; i++) {
			try {
				String str1 = JOptionPane.showInputDialog("Introduzca el numero " + (i+1) + ": ");
				n1 = Float.parseFloat(str1);
			}			
			catch (NumberFormatException ex) {
				System.out.println("ERROR. Se ha producido un error al insertar los datos: ");
				ex.printStackTrace();
				n1 = -1;
			}	
			
			if (n1 < 0) {
				i = 5;	// System.exit(0); Acaba con la ejecucion del programa.	
			}
			else if (n1 <= 25) {
				contPeq++; //suma siempre 1
			}
			else if (n1 <=250) {
				contMed++;
			}
			else {
				contGra++;
			}
		}
		
		System.out.println("La suma de los numeros pequeï¿½os es: " + contPeq );
		System.out.println("La suma de los numeros medianos es: " + contMed );
		System.out.println("La suma de los numeros grandes es: " + contGra );
	}
	
	/*Ejercicio 10: Realiza un ejercicio que califique la nota obtenida por un alumno/a en un examen. 
	 * El ejercicio pedirÃ¡ al usuario la nota numÃ©rica, y se imprimirÃ¡ en pantalla su traducciÃ³n 
	 * a nota de texto: muy deficiente, insuficiente, suficiente, bien, notable y sobresaliente.
	 * Debes realizar el ejercicio a travÃ©s de una sentencia switch, no de if anidados. 
	 */
	
	public static void condicionalesEj10 () {
		
		String texto = "Introduce una nota";
		String mensaje ="";
		int num = Integer.parseInt(JOptionPane.showInputDialog(texto));
				
		switch (num) {
		case 0:
		case 1:
		case 2:
			mensaje = "Muy deficiente";
			break;
		case 3:
		case 4:
			mensaje = "Insuficiente";
			break;
		case 5:
			mensaje = "Suficiente";
			break;
		case 6:
			mensaje = "Bien";
			break;
		case 7:
		case 8:
			mensaje = "Notable";
			break;
		case 9:
		case 10:
			mensaje = "Sobresaliente";
			break;
		}
		JOptionPane.showMessageDialog(null, "Nota: " + mensaje);	
	}
	/* Ejercicio 11: Realiza una calculadora avanzada, pero con la particularidad 
	 * de que las operaciones deben ser raices, potencias y el mÃ³dulo de la divisiÃ³n.
	 */
	
	public static void condicionalesEj11 () {
		String menu = "MENU\n"
				+ "1.- Suma de dos numeros\n"
				+ "2.- Resta de dos numeros\n"
				+ "3.- Multiplicacion de dos numeros\n"
				+ "4.- Division de dos numeros\n"
				+ "5.- Raiz de un numero\n"
				+ "6.- Potencia de un numero\n"
				+ "7.- Modulo de una division";
		
		int num1, num2;
		float resultadoR =0f;
		int opcion = 0;
		double resultadoP =0d;
		opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
		
		switch (opcion) {
		case 1: //suma de dos numeros
			num1 =Integer.parseInt(JOptionPane.showInputDialog("Introduzca el primer numero"));
			num2 =Integer.parseInt(JOptionPane.showInputDialog("Introduzca el segundo numero"));
			JOptionPane.showMessageDialog(null, "Resultado: " + (num1 + num2));
			break;
		case 2: //resta de dos numeros
			num1 =Integer.parseInt(JOptionPane.showInputDialog("Introduzca el primer numero"));
			num2 =Integer.parseInt(JOptionPane.showInputDialog("Introduzca el segundo numero"));
			JOptionPane.showMessageDialog(null, "Resultado: " + (num1 - num2));
			break;
		case 3: //multiplicacion de dos numeros
			num1 =Integer.parseInt(JOptionPane.showInputDialog("Introduzca el primer numero"));
			num2 =Integer.parseInt(JOptionPane.showInputDialog("Introduzca el segundo numero"));
			JOptionPane.showMessageDialog(null, "Resultado: " + (num1 * num2));
			break;
		case 4: //division de dos numeros
			num1 =Integer.parseInt(JOptionPane.showInputDialog("Introduzca el primer numero"));
			num2 =Integer.parseInt(JOptionPane.showInputDialog("Introduzca el segundo numero"));
			JOptionPane.showMessageDialog(null, "Resultado: " + (num1 / num2));
			break;
		case 5: //raiz de un numero
			num1 =Integer.parseInt(JOptionPane.showInputDialog("Introduzca el un numero"));
			resultadoR = (float) Math.sqrt(num1);
			JOptionPane.showMessageDialog(null, "Resultado: " + resultadoR);
			break;
		case 6: //potencia de un numero
			num1 =Integer.parseInt(JOptionPane.showInputDialog("Introduzca el numero base"));
			num2 =Integer.parseInt(JOptionPane.showInputDialog("Introduzca el exponente"));
			resultadoP = Math.pow(num1, num2);
			JOptionPane.showMessageDialog(null, "Resultado: " + resultadoP);
			break;
		case 7: //Modulo de una division
			num1 =Integer.parseInt(JOptionPane.showInputDialog("Introduzca el primer numero"));
			num2 =Integer.parseInt(JOptionPane.showInputDialog("Introduzca el segundo numero"));
			JOptionPane.showMessageDialog(null, "Resultado: " + (num1 % num2));
			break;
		}
	}
	/* Ejercicio 12: Realiza un programa que resuelva lo siguientes puntos:
       a.- Que muestre un menú en pantalla con opciones para: 
           1. Cálculo de la hipotenusa de un triángulo.
           2. Cálculo de la superficie de una circunferencia.
           3. Cálculo del perímetro de una circunferencia.
           4. Cálculo del área de un rectángulo.
           5. Cálculo del área de un triángulo.
           0. Salir de la aplicación.
       b.- En la opción "1" debe pedir dos datos, correspondientes a las longitudes de los dos catetos de un triángulo. 
       Se debe imprimir la longitud de la hipotenusa. Recuerda que Hipotenusa al cuadrado = cateto1 al cuadrado + cateto2 al cuadrado.
       c.- En la opción "2" debe pedir la longitud del radio de una circunferencia e imprimir la superficie de la misma. 
       Recuerda que el área es igual a PI por el radio al cuadrado. Recuerda también que PI es igual a 3,1416.
       d.- En la opción "3" debe pedir la longitud del radio de una circunferencia e imprimir la longitud del perímetro de la misma.
       Recuerda que la longitud de la circunferencia = 2 por PI por el radio.
       e.- En la opción "4" debe pedir las longitudes de la base y la altura de un rectángulo, e imprimir el área de dicho rectángulo.
       Recuerda que el área del rectángulo es igual a la base por la altura. 
       f.- En la opción "5" debe pedir la base y la altura de un tríangulo e imprimir el área del mismo. 
       Recuerda que el área del triángulo es la mitad del área del rectángulo de igual base y altura. 
       g.- Tras mostrar el resultado de cada opción, el programa debe hacer una pausa (para poder observar el resultado), y volver a pintar el menú.
       Esto se repetirá siempre que la opción no sea "0", en cuyo caso el programa acabará.
       h.- Si la opción no fuese "0", "1", "2", "3", "4" o "5", el programa deberá dar el mensaje de "opción incorrecta" y volverá a mostrar el menú.*/
	
	public static void condicionalesEj12 () {
		String menu = "MENU\n"
				+ "1.- Cálculo de la hipotenusa de un triángulo.\n"
				+ "2.- Cálculo de la superficie de una circunferencia.\n"
				+ "3.- Cálculo del perímetro de una circunferencia.\n"
				+ "4.- Cálculo del área de un rectángulo.\n"
				+ "5.- Cálculo del área de un triángulo.\n"
				+ "0.- Salir de la aplicación.";
		
		int n1, n2;
		int opcion =0;
		double resultado = 0d;
		opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
		
		switch (opcion) {
		case 0:
			System.exit(0); // Acaba radicalmente con la ejecución
			break;
		case 1: //Hipotenusa
			n1 =Integer.parseInt(JOptionPane.showInputDialog("Introduzca la longitud del cateto numero 1"));
			n2 =Integer.parseInt(JOptionPane.showInputDialog("Introduzca la longitud del cateto numero 2"));
			resultado = Math.pow(n1, 2) + Math.pow(n2, 2); // n1 y n2 elevados a 2
			resultado = Math.sqrt(resultado); //Raiz cuadrada del resultado
			JOptionPane.showMessageDialog(null, "Hipotenusa: " + resultado);
			break;
		case 2: // superficie
			n1 =Integer.parseInt(JOptionPane.showInputDialog("Introduzca el radio de la circunferencia"));
			resultado = Math.pow(n1, 2);
			resultado = resultado * 3.1416;
			JOptionPane.showMessageDialog(null, "Superficie de la circunferencia: " + resultado);
			break;
		case 3: //Perimetro
			n1 =Integer.parseInt(JOptionPane.showInputDialog("Introduzca el radio de la circunferencia"));
			resultado = 2*3.1416*n1;
			JOptionPane.showMessageDialog(null, "Perimetro: " + resultado);
			break;
		case 4: //Area Rectagulo
			n1 =Integer.parseInt(JOptionPane.showInputDialog("Introduzca la longitud de la base del rectangulo"));
			n2 =Integer.parseInt(JOptionPane.showInputDialog("Introduzca la altura del rectangulo"));
			resultado = n1*n2;
			JOptionPane.showMessageDialog(null, "Area del rectangulo: " + resultado);
			break;
		case 5: //Area Triangulo
			n1 =Integer.parseInt(JOptionPane.showInputDialog("Introduzca la longitud de la base del triangulo"));
			n2 =Integer.parseInt(JOptionPane.showInputDialog("Introduzca la altura del triangulo"));
			resultado = (n1*n2)/2;
			JOptionPane.showMessageDialog(null, "Area del triangulo: " + resultado);
			break;
		}
	}
}
	


	
















	
	
	
	

