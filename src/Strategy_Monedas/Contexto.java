package Strategy_Monedas;

public class Contexto {
IConver convert;

	public Contexto(IConver convert) {
		this.convert = convert;
	}
	
	public  double ejecutar(double moneda) {
		return convert.conversorMoneda(moneda);
	}
}
