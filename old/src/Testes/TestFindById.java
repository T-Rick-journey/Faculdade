package Testes;

import java.time.LocalDateTime;
import java.util.Date;

import dao.EmprestimosDao;
import entity.Emprestimo;

public class TestFindById {

    public static void main(String[] args) {
        testFindById(1L);
    }

    private static void testFindById(Long id) {
        try {
            EmprestimosDao emprestimosDao = new EmprestimosDao();
            Emprestimo emprestimo = emprestimosDao.findById(id);

            if (emprestimo != null) {
                System.out.println("ID: " + emprestimo.getId());
                System.out.println("Data Empréstimo: " + TestUtil.formatarData(emprestimo.getDataEmprestimo()));
                System.out.println("Data Devolução: " + TestUtil.formatarData(emprestimo.getDataDevolucao()));
                System.out.println("Aluno: " + (emprestimo.getAluno() != null ? emprestimo.getAluno().getNome() : "N/A"));
            System.out.println("Publicação: " + (emprestimo.getPublicacao() != null ? emprestimo.getPublicacao().getTitulo() : "N/A"));
            } else {
                System.out.println("Empréstimo de ID " + id + " não encontrado");
            }

        } catch (Exception e) {
            System.err.println("✗ Erro ao executar findById: " + e.getMessage());
        }
    }
}