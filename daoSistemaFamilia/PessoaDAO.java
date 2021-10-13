package daoSistemaFamilia;

import java.sql.ResultSet;
import java.util.ArrayList;
import daojdbc.GenericDAO;

public class PessoaDAO extends GenericDAO {


	protected Pessoa makeObj(ResultSet rs) throws Exception {
		Pessoa p = new Pessoa();
		p.setCpf(rs.getString("cpf"));
		p.setNome(rs.getString("nome"));
		return p;
	} 
	
	public ArrayList<Object> executeSpGetListAll() throws Exception  {
    	return executeQueryStoredProcedure("{CALL sp_listpessoas}", null);
	}

	public Pessoa getSpPessoa(String cpf) throws Exception  {
		Pessoa p = null;
		ArrayList<Object> args = new ArrayList<Object>();
		args.add(cpf);
		Object resp = executeQueryStoredProcedureOnly("{CALL sp_getpessoa(?)}", args);
		if (resp != null) {
			p = (Pessoa) resp;
		}
    	return p;
    }
	
	public int executeSpInsertPessoa(Pessoa p) throws Exception  {
		ArrayList<Object> argsx = new ArrayList<Object>();
		argsx.add(p.getCpf());
		argsx.add(p.getNome());
		return executeUpdateStoredProcedure("{CALL sp_insertpessoas(?,?)}", argsx);
	}

	public int executeSpUpdatePessoa(Pessoa p) throws Exception  {
		ArrayList<Object> argsx = new ArrayList<Object>();
		argsx.add(p.getCpf());
		argsx.add(p.getNome());
		return executeUpdateStoredProcedure("{CALL sp_updatepessoas(?,?)}", argsx);
	}

	public int executeSpDeletePessoa(String cpf) throws Exception  {
		ArrayList<Object> argsx = new ArrayList<Object>();
		argsx.add(cpf);
		return executeUpdateStoredProcedure("{CALL sp_deletepessoas(?)}", argsx);
	}

	/*
	public ArrayList<Object> getListAll() throws Exception  {
    	return executeQuery("SELECT * FROM pessoas", null);
    }

	public Pessoa getQueryPessoa(String cpf) throws Exception  {
		Pessoa p = null;
		ArrayList<Object> args = new ArrayList<Object>();
		args.add(cpf);
		ArrayList<Object> resp = executeQuery("SELECT * FROM pessoas where cpf = ?", args);
		if (resp != null) {
			p = (Pessoa) resp.get(0);
		}
    	return p;
    }
	
	public int insertPessoa(Pessoa p) throws Exception  {
		ArrayList<Object> args = new ArrayList<Object>();
		args.add(p.getCpf());
		args.add(p.getNome());
		return executeUpdate("insert into pessoas (cpf, nome) values (?,?)", args);
    }
	
	public int updatePessoa(Pessoa p) throws Exception  {
		ArrayList<Object> args = new ArrayList<Object>();
		args.add(p.getNome());
		args.add(p.getCpf());
		return executeUpdate("update pessoas set nome=? where cpf=?", args);
    }
	
	public int deletePessoa(String cpf) throws Exception  {
		ArrayList<Object> args = new ArrayList<Object>();
		args.add(cpf);
		return executeUpdate("delete from pessoas where cpf=?", args);
    }
	*/
	
}