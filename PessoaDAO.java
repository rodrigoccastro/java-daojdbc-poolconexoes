package daoSistemaFamilia;

import java.sql.ResultSet;
import java.util.ArrayList;

import daojdbc.GenericDAO;

public class PessoaDAO extends GenericDAO {


	protected ArrayList<Object> getValuesForObj(Object obj) {
		ArrayList<Object> arr = new ArrayList<Object>();
		Pessoa p = (Pessoa) obj;
		arr.add(p.getCpf());
		arr.add(p.getNome());
		return arr;
	}
	
	protected Pessoa makeObj(ResultSet rs) throws Exception {
		Pessoa p = new Pessoa();
		p.setCpf(rs.getString("cpf"));
		p.setNome(rs.getString("nome"));
		return p;
	} 
	
	public ArrayList<Object> getListAll() throws Exception  {
        	String query = "SELECT cpf, nome FROM pessoas";
    		return executeQuery(query, null);
    	}

}