package numeroRomano.Test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

import numeroRomano.NumeroRomanoConverter;

public class NumeroRomanoConverterTest {
	
	// Arrange
	// Massa de testes com valores conhecidos
	private static final Map<Integer, String> valoresConhecidos = new HashMap<Integer, String>(){
		
		private static final long serialVersionUID = 7035786039538100677L;
		{
			put(1, "I");
			put(2, "II");
			put(3, "III");
			put(4, "IV");
			put(5, "V");
			put(6, "VI");
			put(7, "VII");
			put(8, "VIII");
			put(9, "IX");
			put(10, "X");
			put(50, "L");
			put(100, "C");
			put(500, "D");
			put(1000, "M");
			put(31, "XXXI");
			put(148, "CXLVIII");
			put(294, "CCXCIV");
			put(312, "CCCXII");
			put(421, "CDXXI");
			put(528, "DXXVIII");
			put(621, "DCXXI");
			put(782, "DCCLXXXII");
			put(870, "DCCCLXX");
			put(941, "CMXLI");
			put(1043, "MXLIII");
			put(1110, "MCX");
			put(1226, "MCCXXVI");
			put(1301, "MCCCI");
			put(1485, "MCDLXXXV");
			put(1509, "MDIX");
			put(1607, "MDCVII");
			put(1754, "MDCCLIV");
			put(1832, "MDCCCXXXII");
			put(1993, "MCMXCIII");
			put(2074, "MMLXXIV");
			put(2152, "MMCLII");
			put(2212, "MMCCXII");
			put(2343, "MMCCCXLIII");
			put(2499, "MMCDXCIX");
			put(2574, "MMDLXXIV");
			put(2646, "MMDCXLVI");
			put(2723, "MMDCCXXIII");
			put(2892, "MMDCCCXCII");
			put(2975, "MMCMLXXV");
			put(3051, "MMMLI");
			put(3185, "MMMCLXXXV");
			put(3250, "MMMCCL");
			put(3313, "MMMCCCXIII");
			put(3408, "MMMCDVIII");
			put(3501, "MMMDI");
			put(3610, "MMMDCX");
			put(3743, "MMMDCCXLIII");
			put(3844, "MMMDCCCXLIV");
			put(3888, "MMMDCCCLXXXVIII");
			put(3940, "MMMCMXL");
			put(3999, "MMMCMXCIX");
		}
	};
	
	
	@Test
	public void testFromNumeroRomano() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testToNumeroRomano(){
		
		// Act
		for(Entry<Integer, String> pair : valoresConhecidos.entrySet()){
			
			String resultado = NumeroRomanoConverter.toNumeroRomano(pair.getKey());
			// Assert
			assertEquals("A conversão não retornou o valor esperado.", 
					pair.getValue(), 
					resultado);
						
		}
	}

}
