package daojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class GestorConexoes {

	private static String stDriver;
	private static String stConnectionUrl;
	private static List<Connection> listConexoes;
	
	public static void init(String driver, String connectionUrl) throws Exception {
		stDriver = driver; 
		stConnectionUrl = connectionUrl; 
		Class.forName(stDriver);
		Connection con = DriverManager.getConnection(stConnectionUrl);
    	listConexoes = new ArrayList<Connection>();
		listConexoes.add(con);
    }

    public static synchronized Connection getConexao() throws Exception {
        if (listConexoes.isEmpty()) {
        	return DriverManager.getConnection(stConnectionUrl);
        } else {
        	return listConexoes.remove(0);
        }
    }

    public synchronized static void devolveConexao(Connection con) {
    	listConexoes.add(con);
    }

    public static void close() throws Exception {
        while (!listConexoes.isEmpty()) {
        	listConexoes.remove(0).close();
        }
		stDriver = null; 
		stConnectionUrl = null; 
		listConexoes = null;
    }

}
