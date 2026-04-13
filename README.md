# Faculdade
Repositório para salvar atividades relacionadas a minha faculdade

## Atividade 1ª avaliação critérios
O arquivo de banco de dados utilizado para desenvolver este projeto esta localizado em src\atividade.mv.db e já possui as tabelas e os dados de testes cadastrados
O banco foi desenvolvido a partir da seguinte URL jdbc:h2:tcp://localhost:9092/C:/Faculdade/src/atividade que para ser reutilizada precisa de adaptações em seu caminho conforme o local onde foi instalado
### Elaborar o mapeamento em código Sql para as tabela.
- Presente no diretorio sql\CREATES.SQL
### Construir o código Java das classes com o mapeamento em JPA
- Presente no diretorio src\entity
### Criar uma classe DAO para a classe Emprétimo
- Presente no diretorio src\dao\EmprestimosDao.java
### Crie uma classe de testes para o DAO da questão anterior (para incluir, alterar, deletar e consultar dados de objetos Empréstimos, por Id, Todos e por nome do aluno).
Os testes requisitados e seus respectivos arquivos são os seguintes
- incluir -> src\Testes\TestInsertEmprestimo.java
- alterar -> src\Testes\TestUpdate.java
- deletar -> src\Testes\TestDelete.java
- consultar Empréstimos por:
  - Id -> src\Testes\TestFindById.java
  - Todos -> src\Testes\TestFindAll.java
  - por nome do aluno -> src\Testes\TestFindEmprestimoByAluno.java