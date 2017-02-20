package numeroRomano.Test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

import exceptions.InvalidRomanNumeralError;
import exceptions.NumberOutOfRangeException;
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
	public void testFromNumeroRomano() throws InvalidRomanNumeralError {

		// Testando valores corretos/conhecidos.
		// Act
		
		for(Entry<Integer, String> pair : valoresConhecidos.entrySet()){
			
			int nArabico = pair.getKey();
			String nRomano = pair.getValue();
			
			int resultado = NumeroRomanoConverter.fromNumeroRomano(nRomano);
			
			assertEquals("A conversão não retornou o valor esperado.", nArabico, resultado);
						
		}		
	}
	
	@Test(expected = InvalidRomanNumeralError.class)
	public void testFromNumeroRomanoMuitosCaracteresRepetidos() throws InvalidRomanNumeralError{
		
		// Os caracteres 1 = I, 10 = X, C = 100 e M = 1000 podem ser
		// repetidos até 3 vezes.
		
		// Arrange
		String[] valoresInvalidos = new String[]{"MMMM", "DD", "CCCC", "LL", "XXXX", "VV", "IIII"};
		
		// Act
		for (int i = 0; i < valoresInvalidos.length; i++) {
			
			// Assert
			NumeroRomanoConverter.fromNumeroRomano(valoresInvalidos[i]);			
		}
	}
	
	@Test(expected = InvalidRomanNumeralError.class)
	public void testFromNumeroRomanoPadroesRepetidos() throws InvalidRomanNumeralError{
		
		// Alguns padrões não podem ser repetidos. Por exemplo, IX é 9, mas IXIX não é válido.
		
		// Arrange
		String[] valoresInvalidos = new String[]{"CMCM", "CDCD", "XCXC", "XLXL", "IXIX", "IVIV"};
		
		// Act
		for (int i = 0; i < valoresInvalidos.length; i++) {
			
			// Assert
			NumeroRomanoConverter.fromNumeroRomano(valoresInvalidos[i]);			
		}
	}
	
	@Test(expected = InvalidRomanNumeralError.class)
	public void testFromNumeroRomanoAntecedentesMalFormados() throws InvalidRomanNumeralError{
		
		// Os algarismos devem aparecer na ordem correta, do maior para o menor.
		// Por exemplo, CL é 150, mas LC não é válido. O 50 nunca pode vir antes do 100.
		
		// Arrange
		String[] valoresInvalidos = 
				new String[]{"IIMXCC", "VX", "DCM", "CMM", "IXIV", "MCMC", "XCX", "IVI", "LM", "LD", "LC"};
		
		// Act
		for (int i = 0; i < valoresInvalidos.length; i++) {
			
			// Assert
			NumeroRomanoConverter.fromNumeroRomano(valoresInvalidos[i]);			
		}
	}
	
	@Test
	public void testToNumeroRomano() throws NumberOutOfRangeException{
		
		// Testando valores corretos/conhecidos.
		
		// Act
		for(Entry<Integer, String> pair : valoresConhecidos.entrySet()){
			
			int nArabico = pair.getKey();
			String nRomano = pair.getValue();
			
			String resultado = NumeroRomanoConverter.toNumeroRomano(nArabico);
			// Assert
			assertEquals("A conversão não retornou o valor esperado.", 
					nRomano, 
					resultado);
						
		}
	}
	
	// Testando valores incorretos.
	
	@Test(expected = NumberOutOfRangeException.class)
	public void testToNumeroRomanoValorMuitoGrande() throws NumberOutOfRangeException{
		
		// *Intevalo de números que podem ser expressados pelos números Romanos é 1 até 3999.
		
		// Arrange
		int numeroArabico = 5000;
		
		// Act
		NumeroRomanoConverter.toNumeroRomano(numeroArabico);
		
		// Assert: não precisa
	}
	
	@Test(expected = NumberOutOfRangeException.class)
	public void testToNumeroRomanValorZero() throws NumberOutOfRangeException {
		
		// *Intevalo de números que podem ser expressados pelos algarismos Romanos é 1 até 3999.
		// Não existe forma de representar o 0 em algarismos Romanos.
		
		// Arrange
		int numeroArabico = 0;
		
		// Act
		NumeroRomanoConverter.toNumeroRomano(numeroArabico);
		
		// Assert: não precisa
	}
	
	@Test(expected = NumberOutOfRangeException.class)
	public void testToNumeroRomanValorNegativo() throws NumberOutOfRangeException {
		
		// *Intevalo de números que podem ser expressados pelos algarismos Romanos é 1 até 3999.
		// Não existe forma de representar números negativos em algarismos Romanos.
		
		// Arrange
		int numeroArabico = -1;
		
		// Act
		NumeroRomanoConverter.toNumeroRomano(numeroArabico);
		
		// Assert: não precisa
	}
	
	@Test
	public void testIdaEVolta() throws NumberOutOfRangeException, InvalidRomanNumeralError{
		
		// 1. Existe apenas uma única maneira de representar determinado número em algarismos Romanos.
		// 2. O contrário também é verdadeiro: um número Romano válido representa somente um número arábico.
		//    Só pode ser interpretado de uma única forma.
		
		for(int i = 1; i < 4000; i++){
			
			String nRomano = NumeroRomanoConverter.toNumeroRomano(i);
			int nArabico = NumeroRomanoConverter.fromNumeroRomano(nRomano);
			
			// i == fromNumeroRomano(toNumeroRomano(i))
			assertEquals("Os métodos 'fromNumeroRomano' e 'toNumeroRomano' devem ser símetricos. i == fromNumeroRomano(toNumeroRomano(i))",
					i, nArabico);
		}		
	}
}
