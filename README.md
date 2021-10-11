# daojdbc
Estrutura básica de conexao a banco via jdbc (Conexao.java);
Implementei um pool de conexoes para melhor performance ao redistribuir conexões evitando abertura e fechamento a cada ação (GestorConexao.java);
Também existe um repositorio padrão abstrato para ser extendido e completado por repositorios filhos (GenericDAO.java);
Criei duas classes como exemplo, que servem para representar um objeto e repositório (Pessoa.java e PessoaDAO.java).
