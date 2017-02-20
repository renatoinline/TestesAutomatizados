package numeroRomano;

import java.util.Scanner;

import exceptions.InvalidRomanNumeralError;
import exceptions.NumberOutOfRangeException;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		
		// Exemplo
		int numeroArabico = 156;
		String numeroRomano = "MCMLXXII";
		
		System.out.println("Convertendo n�mero para algarismo romano.\n");
		
		System.out.println("Convertendo o n�mero: " + numeroArabico);
		
		try {
			System.out.println("O resultado �: " + NumeroRomanoConverter.toNumeroRomano(numeroArabico));
		} catch (NumberOutOfRangeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\n");
		System.out.println("Convertendo n�mero para algarismo arabico.\n");		
		System.out.println("Convertendo o n�mero: " + numeroRomano);
		
		try {
			System.out.println("O resultado � : " + NumeroRomanoConverter.fromNumeroRomano(numeroRomano));
		} catch (InvalidRomanNumeralError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
		System.out.println("Tecle Enter para encerrar...");
		scanner.nextLine();
		scanner.close();
	}

}
