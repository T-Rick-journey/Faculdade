package Testes;

import java.util.List;

import dao.EmprestimosDao;
import entity.Emprestimo;

public class TestFindAll {

    public static void main(String[] args) {
        testFindAll();
    }
    
    private static void testFindAll() {
        try {

            EmprestimosDao emprestimoDao = new EmprestimosDao();

            List<Emprestimo> emprestimos = emprestimoDao.findAll();

            System.out.println("Total emprestimos = " + emprestimos.size());

            for (Emprestimo emprestimo : emprestimos) {
                System.out.println(
                          "ID: " + emprestimo.getId()
                        + " || Empréstimo: " + TestUtil.formatarData(emprestimo.getDataEmprestimo())
                        + " || Devolução: " + TestUtil.formatarData(emprestimo.getDataDevolucao())
                        + " || Aluno: " + (emprestimo.getAluno() != null ? emprestimo.getAluno().getNome() : "N/A")
                        + " || Publicação: " + (emprestimo.getPublicacao() != null ? emprestimo.getPublicacao().getTitulo() : "N/A"));
            }
        } catch (Exception e) {
            System.err.println("Erro no findAll: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
