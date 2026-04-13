package Testes;

import java.time.LocalDateTime;
import java.util.Date;

import dao.EmprestimosDao;
import entity.Emprestimo;

public class TestInsertEmprestimo {

    public static void main(String[] args) {
        testaInsert(Date.from(LocalDateTime.now().atZone(java.time.ZoneId.systemDefault()).toInstant()),
                   Date.from(LocalDateTime.now().plusWeeks(2).atZone(java.time.ZoneId.systemDefault()).toInstant()));
    }

    public static Emprestimo testaInsert(Date dataEmprestimo, Date dataDevolucao) {
        try {
            EmprestimosDao emprestimoDao = new EmprestimosDao();

            Emprestimo emprestimo = new Emprestimo(
                    null,
                    dataDevolucao,
                    dataEmprestimo,
                    TestUtil.buscarAlunoPorId(1L),
                    TestUtil.buscarPublicacaoPorId(2L)
            );

            emprestimoDao.insert(emprestimo);
            System.out.println("ID: " + emprestimo.getId());
            System.out.println("Empréstimo: " + TestUtil.formatarData(emprestimo.getDataEmprestimo()));
            System.out.println("Devolução: " + TestUtil.formatarData(emprestimo.getDataDevolucao()));
            System.out.println("Aluno: " + (emprestimo.getAluno() != null ? emprestimo.getAluno().getNome() : "N/A"));
            System.out.println("Publicação: " + (emprestimo.getPublicacao() != null ? emprestimo.getPublicacao().getTitulo() : "N/A"));

            return emprestimo;
        } catch (Exception e) {
            System.err.println("Erro no empréstimo: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}