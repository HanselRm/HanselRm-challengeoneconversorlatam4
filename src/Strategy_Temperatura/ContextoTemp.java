package Strategy_Temperatura;

public class ContextoTemp {
	public IconverTemperatura temperatura;
	
	public ContextoTemp(IconverTemperatura temperatura) {
		this.temperatura = temperatura;
	}
	
	public double ejecutar(double temp) {
		return temperatura.conversorTemperatura(temp);
	}
}
