package br.univel.jonas.meusistema;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConexaoBanco {
	private Connection connect = null; 
	private Statement start; 
	private ResultSet result; 
	
	public void conectar(){
		
		String usuario = "jdbc:mysql://localhost:3306/animal";
		String servidor = "root";
		String senha = "Dmolidor18";
		String driver = "com.mysql.jdbc.Driver";
		
		try {
			
			Class.forName(driver);
			this.connect = DriverManager.getConnection(usuario,servidor,senha);
			this.start = this.connect.createStatement();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public boolean verificaConexao() {
		if(this.connect != null){
			return true;
		}else{
			return false;
		}
	}
	
	public void listarContatos(){
		try {
			String query = "SELECT * FROM contato ORDER BY nome";
			this.result = this.start.executeQuery(query);
			
			while (this.result.next()) { 
				System.out.println("ID: "+this.result.getString("id")+"Raça: "+this.result.getString("raca")+"Idade: "+this.result.getString("idade"));
			}
		} catch (Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}
	}
	
	
	public void inserirContatos(String raca, int idade){
		try {
			String query = "";
			this.start.executeUpdate(query);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void editarContato(String raca, int idade){
		try {
			String query = "";
			System.out.println(query);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deletarContato(String raca, int idade, long id){
		try {
			String query = "DELETE FROM contato WHERE id = "+ id +";";
			
			this.start.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void desconectar(){
		try {
			this.connect.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

