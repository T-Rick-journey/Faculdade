package Testes;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import dao.EmprestimosDao;
import entity.Emprestimo;

public class EmprestimoTest {

    private static EmprestimosDao emprestimoDao;
    private static EntityManager entityManager;

    public static void main(String[] args) {
        testConexão();
        testaOperacoes();
    }

    public static void testConexão() {
        try {
            System.out.println("Testando Conexão com o Banco de Dados");

            entityManager = Persistence.createEntityManagerFactory("atividade").createEntityManager();

            if (entityManager != null && entityManager.isOpen()) {
                System.out.println("Conexão com o banco Ok");
            } else {
                System.out.println("Falha conectar ao banco");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
                System.out.println("✓ EntityManager fechado\n");
            }
        }
    }

    public static void testaOperacoes() {
        try {
            emprestimoDao = new EmprestimosDao();

            System.out.println("1. TESTE INSERT");
            Long idEmprestimo1 = testaInsert(
                                    LocalDateTime.now(),
                                    LocalDateTime.now().plusWeeks(2)
                                );
            Long idEmprestimo2 = testaInsert(
                                    LocalDateTime.now().plusMonths(1),
                                    LocalDateTime.now().plusMonths(2)
                                );
            System.out.println("id do primeiro insert : " + idEmprestimo1 + "\n" +
                               "id do segundo insert : " + idEmprestimo2 + "\n");

            System.out.println("2. TESTE FIND ALL");
            testaFindAll();


            System.out.println("3. TESTE FIND BY ID");
            if (idEmprestimo1 != null) {
                testFindById(idEmprestimo1);
            }

            System.out.println("4. TESTE UPDATE");
            if (idEmprestimo1 != null) {
                testUpdate(idEmprestimo1);
            }
            System.out.println();

            // 5. TESTE FIND ALL APÓS UPDATE
            System.out.println("5. FIND ALL APÓS UPDATE");
            testaFindAll();
            System.out.println();

            // 6. TESTE DELETE
            System.out.println("6. TESTE DELETE");
            if (idEmprestimo2 != null) {
                testaDelete(idEmprestimo2);
            }
            System.out.println();

            // 7. TESTE FIND ALL FINAL
            System.out.println("7. FIND ALL FINAL");
            testaFindAll();

        } catch (Exception e) {
            System.err.println("ERRO nos testes: " + e.getMessage());
        }
    }

    private static Long testaInsert(LocalDateTime dataEmprestimo, LocalDateTime dataDevolucao) {
        try {
            Emprestimo emprestimo = new Emprestimo(
                    null,
                    dataDevolucao,
                    dataEmprestimo
            );

            emprestimoDao.insert(emprestimo);
            System.out.println("✓ Empréstimo 1 inserido com sucesso");
            System.out.println("  Data Empréstimo: " + emprestimo.getDataEmprestimo());
            System.out.println("  Data Devolução: " + emprestimo.getDataDevolucao());

            return emprestimo.getId();

        } catch (Exception e) {
            System.err.println("Erro no empréstimo: " + e.getMessage());
            return null;
        }
    }

    private static void testaFindAll() {
        try {
            List<Emprestimo> emprestimos = emprestimoDao.findAll();

            System.out.println("Total emprestimos = " + emprestimos.size());

            for (Emprestimo emprestimo : emprestimos) {
                System.out.println(
                          "ID: " + emprestimo.getId()
                        + " || Empréstimo: " + emprestimo.getDataEmprestimo()
                        + " || Devolução: " + emprestimo.getDataDevolucao()
                        + " || Aluno: " + (emprestimo.getAluno() != null ? emprestimo.getAluno().getNome() : "N/A")
                        + " || Publicação: " + (emprestimo.getPublicacao() != null ? emprestimo.getPublicacao().getTitulo() : "N/A"));
            }
        } catch (Exception e) {
            System.err.println("Erro no findAll: " + e.getMessage());
        }
    }

    private static void testFindById(Long id) {
        try {
            Emprestimo emprestimo = emprestimoDao.findById(id);

            if (emprestimo != null) {
                System.out.println("  findById(" + id + ") executado com sucesso");
                System.out.println("  ID: " + emprestimo.getId());
                System.out.println("  Data Empréstimo: " + emprestimo.getDataEmprestimo());
                System.out.println("  Data Devolução: " + emprestimo.getDataDevolucao());
            } else {
                System.out.println("⚠ findById(" + id + ") - Empréstimo não encontrado");
            }

        } catch (Exception e) {
            System.err.println("✗ Erro ao executar findById: " + e.getMessage());
        }
    }

    private static void testUpdate(Long id) {
        try {
            Emprestimo emprestimo = emprestimoDao.findById(id);

            if (emprestimo != null) {
                emprestimo.setDataDevolucao(LocalDateTime.now().plusMonths(4));

                emprestimoDao.update(emprestimo);
                System.out.println("✓ update() executado com sucesso");
                System.out.println("  ID: " + emprestimo.getId());
                System.out.println("  Nova Data Devolução: " + emprestimo.getDataDevolucao());
            } else {
                System.out.println("⚠ update() - Empréstimo não encontrado");
            }

        } catch (Exception e) {
            System.err.println("✗ Erro ao executar update: " + e.getMessage());
        }
    }

    /**
     * Testa o método delete
     */
    private static void testaDelete(Long id) {
        try {
            Emprestimo emprestimo = emprestimoDao.findById(id);

            if (emprestimo != null) {
                emprestimoDao.delete(emprestimo);
                System.out.println("✓ delete() executado com sucesso");
                System.out.println("  Empréstimo ID " + id + " deletado");
            } else {
                System.out.println("⚠ delete() - Empréstimo não encontrado");
            }

        } catch (Exception e) {
            System.err.println("✗ Erro ao executar delete: " + e.getMessage());
        }
    }
}
