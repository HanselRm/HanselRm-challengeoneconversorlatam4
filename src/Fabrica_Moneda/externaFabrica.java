package Fabrica_Moneda;

import Monedas.dolarPeso;
import Monedas.euroPeso;
import Monedas.libraEsterlinaPeso;
import Monedas.pesoDolar;
import Monedas.pesoEuro;
import Monedas.pesoLibraEsterlina;
import Monedas.pesoWonSulCoreano;
import Monedas.pesoYenJapones;
import Monedas.wonSulCoreanoPeso;
import Monedas.yenJaponesPeso;
import Strategy_Monedas.IConver;

public class externaFabrica{
	
	public static class Fabrica {

		public static IConver Factory(int identificador) {
			switch (identificador) {
			case 1: {
				
				return new pesoDolar();
			}
			case 2: {
				
				return new pesoEuro();
			}
			case 3: {
				
				return new pesoLibraEsterlina();
			}
			case 4: {
				
				return new pesoWonSulCoreano();
			}
			case 5: {
				
				return new pesoYenJapones();
			}
			case 6: {
	
				return new dolarPeso();
			}
			case 7: {
				
				return new euroPeso();
			}
			case 8: {
				
				return new libraEsterlinaPeso();
			}
			case 9: {
				
				return new wonSulCoreanoPeso();
			}
			case 10: {
				
				return new yenJaponesPeso();
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + identificador);
			}
		}
	}	
}

