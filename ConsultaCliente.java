package provajava;

import java.sql.SQLException;
import java.util.Scanner;

public class ConsultaCliente {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		String nome;
		
		System.out.print("Digite o nome do cliente para consulta: ");
		nome = teclado.next();
		
		ConectaBD consulta = new ConectaBD();
		try {
			consulta.buscaCliente(nome);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
//		try {
//			
//			String nomeCliente = consulta.rs.getString("nome");
//			String cpf = consulta.rs.getString("cpf");
//			String endereco = consulta.rs.getString("endereco");
//			
//			System.out.println("Nome: " + nomeCliente);
//			System.out.println("CPF: "+ cpf);
//			System.out.println("Endereço: " + endereco);
//			System.out.println();
//			
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
