import java.text.DecimalFormat;

public class logica {
	
	public String logicaConvertir(String option1,String option2, Double gradInicial) {
		//String temps[] = {"ºCentígrados", "ºFahrenheit", "ºKelvin", "ºRankine"};
		DecimalFormat formato = new DecimalFormat("#.000");
		double resultado = gradInicial;
		
		if (option1.equals("ºCentígrados")) {//=============Centi1
			
			if (option2.equals("ºCentígrados")) {
				resultado = gradInicial;
			} else if (option2.equals("ºFahrenheit")) {
				resultado = (gradInicial* (1.8)+32)  ;
			}else if (option2.equals("ºKelvin")) {
				resultado = gradInicial + 273.15 ;
			}else {
				resultado = gradInicial*( 1.8) + 491.67;
			}
			
		} else if (option1.equals("ºFahrenheit")) {//===========Far1
			if (option2.equals("ºCentígrados")) {
				resultado = (gradInicial - 32) * (5/9);
			} else if (option2.equals("ºFahrenheit")) {
				
			}else if (option2.equals("ºKelvin")) {
				resultado = (gradInicial-32)*(5/9)+273.15 ;
			}else {
				resultado = gradInicial+ 459.67;
			}
			
		}else if (option1.equals("ºKelvin")) {//==Kelvin 1
			if (option2.equals("ºCentígrados")) {
				
			} else if (option2.equals("ºFahrenheit")) {
				resultado = ((gradInicial- 273.15) *1.8) +32;
			}else if (option2.equals("ºKelvin")) {
				resultado = gradInicial -273.15 ;
			}else {
				resultado = gradInicial*1.8;
			}
		}else {
			if (option2.equals("ºCentígrados")) {
				resultado = (gradInicial- 491.67)*(0.5555) ;
			} else if (option2.equals("ºFahrenheit")) {
				resultado = (gradInicial-459.67)  ;
			}else if (option2.equals("ºKelvin")) {
				resultado = gradInicial/(1.8);
			}else {
				
			}
		}
		
		return formato.format(resultado);
		
	}
	
}
