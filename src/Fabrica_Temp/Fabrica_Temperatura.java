package Fabrica_Temp;

import Grados.CelsiusToFahrenheit;
import Grados.CelsiusToKelvin;
import Grados.fahrenheitToCelsius;
import Grados.fahrenheitToKelvin;
import Grados.kelvinToCelsius;
import Grados.kelvinTofahrenheit;
import Strategy_Temperatura.IconverTemperatura;

public class Fabrica_Temperatura {
	
	public static class Fabrica {
		
	
		public static IconverTemperatura Factory(int identificador) {
			switch (identificador) {
			case 1: {
				
				return new CelsiusToFahrenheit();
			}
			case 2: {
				
				return new CelsiusToKelvin();
			}
			case 3: {
				
				return new fahrenheitToCelsius();
			}
			case 4: {
				
				return new fahrenheitToKelvin();
			}
			case 5: {
				
				return new kelvinToCelsius();
			}
			case 6: {
	
				return new kelvinTofahrenheit();
			}
			
			default:
				throw new IllegalArgumentException("Unexpected value: " + identificador);
			}
		}
	}
}
