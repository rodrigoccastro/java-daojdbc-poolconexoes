# daojdbc
Pool de conexões para acesso jdbc e repositório genérico.

Estrutura básica de conexao a banco via jdbc;
Implementei um pool de conexoes para melhor performance ao redistribuir conexões evitando abertura e fechamento a cada ação (GestorConexoes.java);
Também existe um repositorio padrão abstrato para ser extendido e completado por repositorios filhos (GenericDAO.java);
Criei duas classes como exemplo, que servem para representar um objeto e repositório (Pessoa.java e PessoaDAO.java).
