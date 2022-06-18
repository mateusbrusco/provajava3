package provajava;

import java.util.Scanner;

public class AlteraCadastro {
	
	Scanner teclado = new Scanner(System.in);
	private String nome, cpf, dataNasc, telefone, email, endereco, numero, complemento, cidade, estado, modelo, marca, placa, cor;
	private int anoFab, anoMod;
	private double km, valor;
	
	public void setInfoCliente(String nome, String cpf, String dataNasc, String telefone, String email, String endereco, String numero, String complemento, String cidade, String estado) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNasc = dataNasc;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.numero = numero;
		this.complemento = complemento;
		this.cidade = cidade;
		this.estado = estado;
	}
	
	public void setInfoMoto(String modelo, String marca, String placa, String cor, int anoFab, int anoMod, double km, double valor) {
		this.modelo = modelo;
		this.marca = marca;
		this.placa = placa;
		this.cor = cor;
		this.anoFab = anoFab;
		this.anoMod = anoMod;
		this.km = km;
		this.valor = valor;
	}
	

	
	public void alteraCliente() {
		ConectaBD atualizacao = new ConectaBD();
		System.out.println("----------------------------------------------------------");
		System.out.println("            Altera cadastro de " + nome +  "              ");
		System.out.println("----------------------------------------------------------");
		System.out.print("Telefone: " + telefone + " - Novo telefone: ");
		telefone = teclado.nextLine();
		System.out.print("E-mail: " + email + " - Novo e-mail: ");
		email = teclado.nextLine();
		System.out.print("Endereço: " + endereco + " - Novo endereço: ");
		endereco = teclado.nextLine();
		System.out.print("Número: " + numero + " - Novo número: ");
		numero = teclado.nextLine();
		System.out.print("Complemento: " + complemento + " - Novo complemento: ");
		complemento = teclado.nextLine();
		System.out.print("Cidade: " + cidade + " - Nova cidade: ");
		cidade = teclado.nextLine();
		System.out.print("Estado: " + estado + " - Novo estado: ");
		estado = teclado.nextLine();
		System.out.println("----------------------------------------------------------");
		
		// Chama o método cadastraCliente da classe ConectaBD e passa informações inseridas para envio para o banco de dados
	    try {
			atualizacao.atualizaCadastroCliente(nome, cpf, dataNasc, telefone, email, endereco, numero, complemento, cidade, estado);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public void alteraMoto() {
		ConectaBD atualizacao = new ConectaBD();
		System.out.println("----------------------------------------------------------");
		System.out.println("       Altera cadastro de " + marca + modelo + "          ");
		System.out.println("----------------------------------------------------------");
		System.out.print("Cor: " + cor + " - Nova cor: ");
		cor = teclado.nextLine();
		System.out.print("Quilometragem: " + km + " - Nova quilometragem: ");
		km = teclado.nextDouble();
		System.out.print("Valor: " + valor + " - Novo valor: ");
		valor = teclado.nextDouble();
		System.out.println("----------------------------------------------------------");
		
	    try {
			atualizacao.atualizaCadastroMoto(modelo, marca, placa, cor, anoFab, anoMod, km, valor);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
