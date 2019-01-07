package ejercicios.objetos.bloque3;


public class Baraja {

	private Carta barajaCartas[] = new Carta[48];
	private static Baraja baraja = null;
	
	public static Baraja getBaraja() {
		if(baraja == null) {
			baraja = new Baraja();
		}
		return baraja;
	}
	
	public Baraja() {
		creaBaraja();
		barajar();
	}
	
	public void creaBaraja() {
		for (int j = 0; j < 4; j++) {
			for (int i = 1; i <= 12; i++) {
				barajaCartas[(i +(j*12))-1] = new Carta(i, j);
//				System.out.println(barajaCartas[i +(j*10)]);
				System.out.println((i +(j*12))-1);
			}
		}
		
		
		
		// Es algo jodido así que no te agobies si no te sale. Lo vemos luego. También podrías darle una vuelta al método "repartir".
		// Lov iu pexioxa <3
	}
	

	public void barajar() {
	
		for (int i = 0; i < 100; i++) {
			int indiceAzar1 =  (int) Math.round(Math.random() * (barajaCartas.length-1));// 6
			int indiceAzar2 =  (int) Math.round(Math.random() * (barajaCartas.length-1));// 25
			
			Carta aux = barajaCartas[indiceAzar1];
			barajaCartas[indiceAzar1] = barajaCartas[indiceAzar2];
			barajaCartas[indiceAzar2] = aux;
		}
	}
	
	public Carta[] getBarajaCartas() {
		return barajaCartas;
	}

}
