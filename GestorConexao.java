package daojdbc;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class GestorConexao {

	private static List<Connection> listConexoes;

	public static void Init(String stringDriver, String connectionUrl) throws Exception {
    		Conexao.Init(stringDriver, connectionUrl);
    	}

    	public synchronized static Connection pegaConexao() throws Exception {
    		Connection con = null;
	        if (listConexoes == null) {
        		listConexoes = new ArrayList<Connection>();
	        }
        	if (listConexoes.isEmpty()) {
        		con = (new Conexao()).getConnection();
	        } else {
        		con = listConexoes.remove(0);
        		if (con == null) {
        			con = pegaConexao();
		        }
	        }
		return con;
	}

	public synchronized static void devolveConexao(Connection con) {
    		if (con != null) {
    			listConexoes.add(con);
	    	}
	}

	public static void Close() throws Exception {
        	if (listConexoes != null) {
        		while (!listConexoes.isEmpty()) {
        			Connection con = listConexoes.remove(0);
	        		con.close();
        		}
	        }
    	}

}
