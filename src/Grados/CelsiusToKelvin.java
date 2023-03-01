package Grados;

import Strategy_Temperatura.IconverTemperatura;

public class CelsiusToKelvin implements IconverTemperatura{

	@Override
	public double conversorTemperatura(double grados) {
		return Math.round(grados + 273.15);
	}

}
