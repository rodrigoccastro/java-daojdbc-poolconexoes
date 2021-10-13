package teste;

import java.util.*;
import daoSistemaFamilia.Pessoa;
import daoSistemaFamilia.PessoaDAO;
import daojdbc.GestorConexoes;

public class execucao {
	public static void main(String [] args){

		try { 
			
			//**** init
			String stringDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; 
			String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=familia;user=sa;password=barnabe123;"; 
			GestorConexoes.init(stringDriver,connectionUrl);
			
			
			PessoaDAO pd = new PessoaDAO();
			
			Pessoa ps = new Pessoa();
			String texto = java.time.LocalTime.now().toString();
			ps.setCpf(texto);
			ps.setNome("nome-"+texto);

			//inserir
			pd.executeSpInsertPessoa(ps);

			//alterar
			ps.setNome("xxx-"+texto);
			pd.executeSpUpdatePessoa(ps);
			
			//pesq
			ps = pd.getSpPessoa(texto);
			System.out.println(ps.getCpf() +"-"+ ps.getNome());

			//deletar
			//ret = pd.executeSpDeletePessoa(texto);
			//System.out.println("ret sp_delete:"+ ret);
			
			//listagem geral
			ArrayList<Object> arr = pd.executeSpGetListAll();
			for (Object o : arr) {
				Pessoa p = (Pessoa) o;
				System.out.println(p.getCpf() +"-"+ p.getNome());
			}

			
			// testar performance
			
			
			//*** destroy
			GestorConexoes.close();
			
		} catch (Exception e) {
			System.out.println("erro:"+ e.getMessage());
		}
		
		
		
	}	


}
