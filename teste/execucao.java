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
	//java 16
	/*
	 * public abstract sealed class Shape
	permits Circle, Rectangle, Square {...}
	 */
	//java 14
	/*
		switch (1) {
	    case 1, 2, 3 -> System.out.println(6);
	    case 4 -> System.out.println(7);
	    case 5, 6 -> System.out.println(8);
	    case 7 -> System.out.println(9);
		}

		record Ponto(int x, int y) { }
		Ponto p = new Ponto(1,2);
		System.out.println(p.x());
		System.out.println(p.y());
		
		Object obj = "teste";
		if (obj instanceof String s) {
			System.out.println(s);
		}
		
		*/
	
	//exemplo de conexao
	/*
	 * 
		Connection con;
	    Statement stmt;
	    String query = "select * from pessoas";
	    try
	    {
	            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    }
	    catch(Exception e)
	    {
	            System.err.print("ClassNotFoundException: ");
	            System.err.println(e.getMessage());
	    }

	    
	    try
	    {
	    	String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=familia;user=sa;password=barnabe123;"; 
	    	con = DriverManager.getConnection(connectionUrl);
	           stmt = con.createStatement();
	            ResultSet rs = stmt.executeQuery(query);
	           System.out.println("Lista de linhas da tabela:");
	            while (rs.next())
	            {
	            String cpf = rs.getString("cpf");
	            String nome = rs.getString("nome");
	            System.out.println(cpf + " " + nome);
	            }
	            stmt.close();
	            con.close();
	    }
	            catch(SQLException ex)
	    {
	            System.err.println("SQLException: " + ex.getMessage());
	    }
	 */
	
	//java 13
	/*
	 * String jsonBlock = """
	            {
	                 greeting: "Hello",
	                 audience: "World",
	                 punctuation: "!"
	            }
	            """;
		System.out.println(jsonBlock);
	 * 
	 *  int etiqueta = 18;
		int tamanho = 5;
		int numero = switch(tamanho) {
		 case 1 -> 10;
		 case 2 -> 12;
		 case 3 -> 14;
		 case 4 -> 16; 
		 case 5 -> { 
		         yield (etiqueta < 10 ? 15 : 18);
		         }
		 case 6 -> 20;
		default -> throw new IllegalArgumentException("Unexpected value: " + tamanho);
		 };
	
			System.out.println(numero);
	 */
	
	//java 10
	/*
	var...
	var novidades = Arrays.asList("Lambdas", "Default Method",	
			"Stream API", "Date and Time API");
	novidades.forEach(n -> System.out.println(n));
	 */
	
	//lambda
	/*
	List<String> novidades = Arrays.asList("Lambdas", "Default Method",
	
			"Stream API", "Date and Time API");

	// Antes do Java 8:
	for (String novidade : novidades) {
		System.out.println(novidade);
	}
	//   Como fica o código com uso de Lambda no Java 8:
	novidades.forEach(n -> System.out.println(n));
	*/
	
	//exemplo de maps
	/*
	Map<Integer, Set<Integer>> mapOfIntegers = new HashMap<>();
    Integer aKey = 10;    
    Set<Integer> aSet = new HashSet<>();
    aSet.add(1);
    aSet.add(2);
    mapOfIntegers.put(aKey, aSet);
	System.out.println(mapOfIntegers.get(aKey).toString());
	*/
	
	
	// exemplo de enumeracoes
	/*
	enum Season {WINTER, SPRING, SUMMER, FALL}
	for(Season aux : Season.values())
		System.out.println(aux);
	*/                 

	//exemplo de loop de array list
	/*
	 	List<String> stores = new ArrayList<String>();
		stores.add("abc1");
		stores.add("abc2");
		stores.add("abc3");
		List<String> peoples = new ArrayList<String>();
		peoples.add("fulano1");
		peoples.add("fulano2");
		peoples.add("fulano3");

		for(Iterator<String> i = stores.iterator(); i.hasNext(); )
		{
			String store = i.next();
			for(Iterator<String> j = peoples.iterator(); j.hasNext(); )
			{
				String people = j.next();
				System.out.println("store: "+store+" - "+"people: "+people);
			}
		}

		for(String st : stores)
		for(String pe : peoples)
			System.out.println("store: "+st+" - "+"people: "+pe);
	 */

}
