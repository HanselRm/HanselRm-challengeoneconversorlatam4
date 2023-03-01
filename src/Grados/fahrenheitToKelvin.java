package Grados;

import Strategy_Temperatura.IconverTemperatura;

public class fahrenheitToKelvin implements IconverTemperatura {

	@Override
	public double conversorTemperatura(double grados) {
		return Math.round((grados - 32) * 5 / 9 + 273.15);
	}

}
