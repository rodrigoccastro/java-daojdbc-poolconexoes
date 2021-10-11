package daojdbc;

import java.sql.Connection;
import java.sql.DriverManager;

class Conexao {
	
	private static String stringDriver; 
	private static String connectionUrl; 
	private Connection con;

	static void Init(String vStringDriver, String vConnectionUrl) throws Exception {
		stringDriver = vStringDriver; 
		connectionUrl = vConnectionUrl; 
		Class.forName(stringDriver);
	}

	Conexao() throws Exception {
		con = DriverManager.getConnection(connectionUrl);
	}

	Connection getConnection() {
		return con;
	}
}
