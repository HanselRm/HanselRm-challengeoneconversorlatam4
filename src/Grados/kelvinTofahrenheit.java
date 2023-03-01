package Grados;

import Strategy_Temperatura.IconverTemperatura;

public class kelvinTofahrenheit implements IconverTemperatura {

	@Override
	public double conversorTemperatura(double grados) {
		return Math.round((grados - 273.15) * 9 / 5 + 32);
	}

}
