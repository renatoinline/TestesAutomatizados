/*
 * Classe para converter números arábicos em romanos e vice-versa. 
 * 
 * Nos números Romanos existem sete caracteres que são repetidas e combinadas de
 * várias formas para representar números.
 * 
 * I = 1
 * V = 5
 * X = 10
 * L = 50
 * C = 100
 * D = 500
 * M = 1000  
 * 
 * 
 * */

package numeroRomano;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

import exceptions.InvalidRomanNumeralError;
import exceptions.NumberOutOfRangeException;

public final class NumeroRomanoConverter {
	
	/*
	 * Dicionário com o mapeamento dos valores básicos dos números romanos.
	 * 
	 * Define a ordem do maior para o menor. Essa ordem é importante para
	 * deixar o código do método toNumeroRomano mais simples. Por isso uso do LinkedHashMap.
	 * 
	 * Define não apenas valores de caracteres sozinhos, também define valores
	 * em pares como 'CM' que representa 900 (ou 100 menos 1000).	 * 
	 * */ 
	private static final LinkedHashMap<String, Integer> numerosRomanosDicionario = 
			new LinkedHashMap<String, Integer>(){
		
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
	
	public static String toNumeroRomano(int numeroArabico) throws NumberOutOfRangeException{
		// Adicionando implementação, agora o teste deve passar.
		
		if(numeroArabico <= 0 || numeroArabico > 4000)
			throw new NumberOutOfRangeException("Número fora de intervalo. Deve ser entre 1 e 3999.");
		
		String resultado = "";
		
		// iterando pelo dicionário
		for(Entry<String, Integer> pair : numerosRomanosDicionario.entrySet()){
			
			String nRomano = pair.getKey();
			int nArabico = pair.getValue();
			
			// qnd chegar num número menor ou igual ao valor informado inicia a conversão 
			while(numeroArabico >= nArabico){
				
				// após encontrar um valor menor ou igual
				// vai concatenando a string contendo algarismos romanos ao resultado.
				resultado += nRomano;
				
				// subtrai o numeroArabico do valor que já foi encontrado
				// e cujo o algarismo romano já foi concatenado ao resultado
				// assim o loop continua até que todos os itens do dicionário tenham sido testados
				numeroArabico -= nArabico;
			}
		}
		
		return resultado;
	}
	
	public static int fromNumeroRomano(String numeroRomano) throws InvalidRomanNumeralError{
		
		if(!numeroRomano.matches("M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})"))
			throw new InvalidRomanNumeralError("Número Romano inválido");
			
		int resultado = 0,
			indice = 0,
			numeroRomanoLen = numeroRomano.length();
		
		// iterando pelo dicionário
		for(Entry<String, Integer> pair : numerosRomanosDicionario.entrySet()){
			
			String nRomano = pair.getKey();
			int nArabico = pair.getValue();
			int nlen = nRomano.length();			
			
			while(indice + nlen <= numeroRomanoLen &&
					numeroRomano.substring(indice, indice + nlen).equals(nRomano)){
				
				resultado += nArabico;
				indice += nRomano.length();
			}
		}		
		return resultado;		
	}	
}
