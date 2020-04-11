package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Funcionario;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		List<Funcionario> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		Funcionario f = new Funcionario();
	
		int nFunc = 2;
		
		for(int i = 0; i < nFunc; i++) {
			
			System.out.println("id:");
			int id =  sc.nextInt();
			System.out.println("nome:");
			String nome =  sc.next();
			System.out.println("Salario:");
			Double salario =  sc.nextDouble();
			
			list.add(new Funcionario(id, nome, salario));
		}
		
		System.out.println("entra com id do funcionario para dar aumento:");
		int id = sc.nextInt();
		Funcionario fc = list.stream().filter( x ->  x.getId() == id).findFirst().orElse(null);
		
		if(fc == null) {
			System.out.println("funcionário não existe");
		} else {
			System.out.println("percentual de aumento:");
			Double per = sc.nextDouble();
			fc.aumentaSalario(per);
			
			for (Funcionario x : list ) {
				System.out.println(x.toString());
			}
		
		}
	
	}

}
