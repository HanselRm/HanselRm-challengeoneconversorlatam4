package Grados;

import Strategy_Temperatura.IconverTemperatura;

public class CelsiusToFahrenheit implements IconverTemperatura{

	@Override
	public double conversorTemperatura(double grados) {
		return Math.round((grados * 9 / 5) + 32);
	}

}
