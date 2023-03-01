package Grados;

import Strategy_Temperatura.IconverTemperatura;

public class fahrenheitToCelsius implements IconverTemperatura {

	@Override
	public double conversorTemperatura(double grados) {
		// TODO Auto-generated method stub
		return Math.round(grados - 32) * 5 / 9;
	}

}
