package teste;

import java.util.*;
import daoSistemaFamilia.Pessoa;
import daoSistemaFamilia.PessoaDAO;
import daojdbc.GestorConexao;

public class execucao {

	public static void main(String [] args){

		try { 
			
			//**** init
			String stringDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; 
			String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=familia;user=sa;password=pwd;"; 
			GestorConexao.Init(stringDriver,connectionUrl);
			
			
			PessoaDAO pd = new PessoaDAO();
			ArrayList<Object> arr = pd.getListAll();
			for (Object o : arr) {
				Pessoa p = (Pessoa) o;
				System.out.println(p.getCpf() +"-"+ p.getNome());
			}
			
			
			//*** destroy
			GestorConexao.Close();
			
		} catch (Exception e) {
			System.out.println("erro:"+ e.getMessage());
		}
		
	}	

}
