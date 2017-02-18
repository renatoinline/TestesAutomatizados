package numeroRomano;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public final class NumeroRomanoConverter {
	
	/*
	 * Dicion�rio com o mapeamento dos valores b�sicos dos n�meros romanos.
	 * 
	 * Define a ordem do maior para o menor. Essa ordem � importante para
	 * deixar o c�digo do m�todo toNumeroRomano mais simples. Por isso uso do LinkedHashMap.
	 * 
	 * Define n�o apenas valores de caracteres sozinhos, tamb�m define valores
	 * em pares como 'CM' que representa 900 (ou 100 menos 1000).
	 * 
	 * */ 
	private static final LinkedHashMap<String, Integer> numerosRomanosDicionario = new LinkedHashMap<String, Integer>(){
		
		private static final long serialVersionUID = 2185432093411273045L;
		{
			put("M",  1000);
			put("CM", 900);
			put("D",  500);
			put("CD", 400);
			put("C",  100);
			put("XC", 90);
			put("L",  50);
			put("XL", 40);
			put("X",  10);
			put("IX", 9);
			put("V",  5);
			put("IV", 4);
			put("I",  1);
		}		
	};
	
	private NumeroRomanoConverter(){}
	
	public static String toNumeroRomano(int numeroArabico){
		// Adicionando implementa��o, agora o teste deve passar.
		
		String resultado = "";
		
		// iterando pelo dicion�rio
		for(Entry<String, Integer> pair : numerosRomanosDicionario.entrySet()){
			
			String key = pair.getKey();
			int value = pair.getValue();
			
			// qnd chegar num n�mero menor ou igual ao valor informado inicia a convers�o 
			while(numeroArabico >= value){
				
				// ap�s encontrar um valor menor ou igual
				// vai concatenando a string contendo algarismos romanos ao resultado.
				resultado += key;
				
				// subtrai o numeroArabico do valor que j� foi encontrado
				// e cujo o algarismo romano j� foi concatenado ao resultado
				// assim o loop continua at� que todos os itens do dicion�rio tenham sido testados
				numeroArabico -= value;
			}
		}
		
		return resultado;
	}
	
	public static int fromNumeroRomano(String numeroRomano){
		return 0;
	}	
	
}
