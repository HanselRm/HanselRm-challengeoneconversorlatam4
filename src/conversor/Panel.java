package conversor;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Fabrica_Moneda.externaFabrica;
import Fabrica_Temp.Fabrica_Temperatura;
import Strategy_Monedas.Contexto;
import Strategy_Temperatura.ContextoTemp;

import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Panel {
	// Instancia del panel
	private  JFrame frame;
	private Strategy_Monedas.Contexto Contexto;
	private ContextoTemp ContextoTem;
	
	
	public static void main(String[] args) 
	{
		Panel panel = new Panel();
		panel.menuPrincipal();
	}
	
	
	
	public  void crearventana(int ancho, int largo) throws HeadlessException {
		
		//propiedades de la ventana
		frame = new JFrame("Nueva ventana");
		frame.setSize(ancho,largo);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	 
	 
	
	public  void menuPrincipal() {
		JPanel jpanel1  = new JPanel(null);
		
		crearventana(370,300);
		
		
		JLabel titulo = new JLabel("Seleccione una opcion");
		titulo.setBounds(115, -138, 300, 300);
		
		
		String[] opciones = {"","Convertidor de monedas", "Temperaturas"};
		
		JComboBox<String> comboBox = new JComboBox<>(opciones);
		
		comboBox.setBounds(100, 35, 150, 25);

		comboBox.addItemListener(new ItemListener() {
			
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					
					
					if(comboBox.getSelectedIndex() == 1)
					{
						jpanel1.setVisible(false);
						menuMonedas();
						frame.validate();
						frame.repaint();
					}
					
					if(comboBox.getSelectedIndex() == 2)
					{
						jpanel1.setVisible(false);
						menuTemperatura();
						frame.validate();
						frame.repaint();
					}
				}
				
			}
		});
		
		jpanel1.add(titulo);
		jpanel1.add(comboBox,BorderLayout.CENTER);
		
			
		frame.add(jpanel1);
		frame.setVisible(true);
		
		
	}
	
	public void menuMonedas() {

		JPanel jpanel2  = new JPanel();
		
		JLabel Titulo = new JLabel("Seleccione que moneda quiere convertir");

		
		String[] opciones = {"","Peso a dolar", "Peso a Euro", "Peso a Libra Esterlina", 
								"Peso a Won Sul coreano","Peso a Yen Japones", "Dolar a Peso ", 
								"Euro a Peso ", "Libra Esterlina a Peso ","Won Sul coreano a Peso ", 
								"Yen Japones a Peso ",};
		JComboBox<String> comboBox = new JComboBox<>(opciones);
		
			comboBox.addItemListener(new ItemListener() {
						
						public void itemStateChanged(ItemEvent e) {
							if(e.getStateChange() == ItemEvent.SELECTED) {
								
								
								if(comboBox.getSelectedIndex() > 0 &&  comboBox.getSelectedIndex() <= 10)
								{
									jpanel2.setVisible(false);
									externaFabrica.Fabrica fabrica = new externaFabrica.Fabrica();
									Contexto = new Contexto(fabrica.Factory(comboBox.getSelectedIndex()));
									ejecutarConversor();
									frame.validate();
									frame.repaint();
								}
							}
							
						}
					});
		
		jpanel2.add(Titulo);
		jpanel2.add(comboBox);
		
		frame.add(jpanel2);
		frame.setVisible(true);
	}
	
	public void menuTemperatura() {
		JPanel jpanel4 = new JPanel(null);
		
		
		JLabel Titulo = new JLabel("Seleccione que  quiere convertir");
		Titulo.setBounds(88, -138, 300, 300);
		
		String opciones[] = {"", "Celsius a Fahrenhei", "Celsius a Kelvin", 
							"Fahrenhei a Celsius", "Fahrenhei a Kelvin", "Kelvin a Celsius",
							"Kelvin  a Fahrenhei"};
		
		JComboBox<String> comboBox = new JComboBox<>(opciones);
		
		comboBox.setBounds(100, 35, 150, 25);
		comboBox.addItemListener(new ItemListener() {
			
			
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					
					if(comboBox.getSelectedIndex() > 0 &&  comboBox.getSelectedIndex() <= 10)
					{
						jpanel4.setVisible(false);
						Fabrica_Temperatura.Fabrica fabricaTemp = new Fabrica_Temperatura.Fabrica();
						ContextoTem = new ContextoTemp(fabricaTemp.Factory(comboBox.getSelectedIndex()));
						ejecutarTemp();
						frame.validate();
						frame.repaint();
					}
				}
				
			}
		});
		
		jpanel4.add(Titulo);
		jpanel4.add(comboBox);
		
		frame.add(jpanel4);
		frame.setVisible(true);
		
	}
	
	public void ejecutarConversor() {
		
		JPanel jpanel3 = new JPanel(null);
		
		JLabel titulo = new JLabel("Ingrese la cantidad de dinero que deseas convertir");
		titulo.setBounds(40, -138, 300, 300);
		
		JTextField input = new JTextField();
		input.setBounds(100, 35, 150, 25);
		
		JButton boton = new JButton("Convertir");
		boton.setBounds(100, 65, 150, 25);
		
		ActionListener evento = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {

					JOptionPane.showMessageDialog(null, "El resultado es " +
												Contexto.ejecutar(Double.parseDouble(input.getText())), 
												"Resultado", JOptionPane.INFORMATION_MESSAGE); 
					menuOpcionSiNoCancel();
					
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Ingrese un valor numerico", 
							"Resultado", JOptionPane.ERROR_MESSAGE); 
				}
			}
		};
		boton.addActionListener(evento);
		
		jpanel3.add(titulo);
		jpanel3.add(input);
		jpanel3.add(boton);
		
		frame.add(jpanel3);
		frame.setVisible(true);
	}
	
	public void ejecutarTemp() {
		JPanel jpanel5 = new JPanel(null);
		
		JLabel titulo = new JLabel("Ingrese la cantidad de dinero que deseas convertir");
		titulo.setBounds(40, -138, 300, 300);
		
		JTextField input = new JTextField();
		input.setBounds(100, 35, 150, 25);
		
		JButton boton = new JButton("Convertir");
		boton.setBounds(100, 65, 150, 25);
		
		ActionListener evento = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {

					JOptionPane.showMessageDialog(null, "El resultado es " +
												  ContextoTem.ejecutar(Double.parseDouble(input.getText())), 
												"Resultado", JOptionPane.INFORMATION_MESSAGE);
					menuOpcionSiNoCancel();
					
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Ingrese un valor numerico", 
							"Resultado", JOptionPane.ERROR_MESSAGE); 
				}
			}
		};
		
		boton.addActionListener(evento);
		
		jpanel5.add(titulo);
		jpanel5.add(input);
		jpanel5.add(boton);
		
		frame.add(jpanel5);
		frame.setVisible(true);
	}
	
	

	public void menuOpcionSiNoCancel() {
		
		int opcionSeleccionada = JOptionPane.showConfirmDialog(null, "Desea Continuar",null, 
																JOptionPane.YES_NO_CANCEL_OPTION,
																JOptionPane.QUESTION_MESSAGE);
		
		if(opcionSeleccionada == JOptionPane.YES_OPTION) {
			frame.dispose();
			menuPrincipal();
		}
		else if(opcionSeleccionada == JOptionPane.NO_OPTION) {
			System.exit(0);
		}
		else {
			JOptionPane.showMessageDialog(null, "Programa Finalizado");
			System.exit(0);
		}
		

	}
	
	
	
}
