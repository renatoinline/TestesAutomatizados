package numeroRomano;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Exemplo
		int numeroArabico = 57;
		
		System.out.println("Convertendo n�mero para algarismo romano.\n");
		
		System.out.println("Convertendo o n�mero: " + numeroArabico);
		
		System.out.println("O resultado �: " + NumeroRomanoConverter.toNumeroRomano(numeroArabico));
		
		Scanner scanner = new Scanner(System.in); 
		scanner.nextLine();
		scanner.close();
	}

}
