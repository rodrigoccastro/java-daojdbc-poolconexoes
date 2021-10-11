package daojdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public abstract class GenericDAO {
	
	
	public int executeUpdate(String sql, ArrayList<Object> args) throws Exception{
		int toReturn = 0;
		Connection conn = GestorConexao.pegaConexao();
		if (conn != null) {
			PreparedStatement pstm = conn.prepareStatement(sql);
			if (args != null) {
				for (int i =0; i< args.size(); i++){
					pstm.setObject(i+1, args.indexOf(i));
				}
			}
            		toReturn = pstm.executeUpdate();
			pstm.close();
		}
		GestorConexao.devolveConexao(conn);
		return toReturn;
	}

	public ArrayList<Object> executeQuery(String sql, ArrayList<Object> args) throws Exception{
		ArrayList<Object> toReturn = null;
		Connection conn = GestorConexao.pegaConexao();
		if (conn != null) {
			PreparedStatement pstm = conn.prepareStatement(sql);
			if (args != null) {
				for (int i =0; i< args.size(); i++){
					pstm.setObject(i+1, args.indexOf(i));
				}
			}
            		ResultSet rs = pstm.executeQuery();
            		toReturn = makeObjList(rs);
			pstm.close();
		}
		GestorConexao.devolveConexao(conn);
		return toReturn;
	}
	

	public ArrayList<Object> makeObjList(ResultSet rs) throws Exception {
		ArrayList<Object> registros = new ArrayList<Object>();
		int i = 0;
        	while (rs.next()) {
	        	Object obj = makeObj(rs);
        		registros.add(obj);
        		i = i + 1;
	        }
		return registros;
	}

	protected abstract ArrayList<Object> getValuesForObj(Object obj);
	protected abstract Object makeObj(ResultSet rs) throws Exception; 
	
}