package daojdbc;

import java.sql.*;
import java.util.ArrayList;

public abstract class GenericDAO {
	
	
	private PreparedStatement addArgs(PreparedStatement pstm, String sql, ArrayList<Object> args) throws Exception{
		if (args != null) {
			for (int i=0; i< args.size(); i++){
				pstm.setObject(i+1, args.get(i));
			}
		}
		return pstm;
	}
	
	public int executeUpdate(String sql, ArrayList<Object> args) throws Exception{
		int toReturn = 0;
		Connection conn = GestorConexoes.getConexao();
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm = addArgs(pstm, sql, args);
        toReturn = pstm.executeUpdate();
		pstm.close();
		GestorConexoes.devolveConexao(conn);
		return toReturn;
	}

	public ArrayList<Object> executeQuery(String sql, ArrayList<Object> args) throws Exception{
		ArrayList<Object> toReturn = null;
		Connection conn = GestorConexoes.getConexao();
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm = addArgs(pstm, sql, args);
		ResultSet rs = pstm.executeQuery();
		toReturn = makeObjList(rs);
		pstm.close();
		GestorConexoes.devolveConexao(conn);
		return toReturn;
	}
	
	public int executeUpdateStoredProcedure(String sql, ArrayList<Object> args)  throws Exception{
		Connection conn = GestorConexoes.getConexao();
		CallableStatement stmt = conn.prepareCall(sql);
		stmt = addArgs(stmt, sql, args);
		int ret = stmt.executeUpdate();
		stmt.close();
		GestorConexoes.devolveConexao(conn);
		return ret;
	}

	private CallableStatement addArgs(CallableStatement pstm, String sql, ArrayList<Object> args) throws Exception{
		if (args != null) {
			for (int i=0; i< args.size(); i++){
				pstm.setObject(i+1, args.get(i));
			}
		}
		return pstm;
	}
	
	public ArrayList<Object> executeQueryStoredProcedure(String sql, ArrayList<Object> args)  throws Exception{
		ArrayList<Object> toReturn = null;
		Connection conn = GestorConexoes.getConexao();
		CallableStatement stmt = conn.prepareCall(sql);
		stmt = addArgs(stmt, sql, args);
		ResultSet rs = stmt.executeQuery();
		toReturn = makeObjList(rs);
		stmt.close();
		GestorConexoes.devolveConexao(conn);
		return toReturn;
	}

	
	public Object executeQueryStoredProcedureOnly(String sql, ArrayList<Object> args)  throws Exception{
		Object toReturn = null;
		Connection conn = GestorConexoes.getConexao();
		CallableStatement stmt = conn.prepareCall(sql);
		stmt = addArgs(stmt, sql, args);
		ResultSet rs = stmt.executeQuery();
		if (rs != null) {
			rs.next();
			toReturn = makeObj(rs);
		}
		stmt.close();
		GestorConexoes.devolveConexao(conn);
		return toReturn;
	}

	protected ArrayList<Object> makeObjList(ResultSet rs) throws Exception {
		ArrayList<Object> registros = new ArrayList<Object>();
		while (rs.next())
        {
			registros.add(makeObj(rs));
		}
		return registros;
	}
	
	protected abstract Object makeObj(ResultSet rs) throws Exception; 
	
}