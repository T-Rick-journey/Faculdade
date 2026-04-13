package Testes;

import java.time.LocalDateTime;
import java.util.Date;

import dao.EmprestimosDao;
import entity.Emprestimo;

public class TestUpdate{

    public static void main(String[] args){
        Emprestimo emprestimo = TestInsertEmprestimo.testaInsert(Date.from(LocalDateTime.now().atZone(java.time.ZoneId.systemDefault()).toInstant()),
                   Date.from(LocalDateTime.now().plusWeeks(2).atZone(java.time.ZoneId.systemDefault()).toInstant()));
        testUpdate(emprestimo.getId());
    }

    private static void testUpdate(Long id) {
        try {
            EmprestimosDao emprestimoDao = new EmprestimosDao();
            Emprestimo emprestimo = emprestimoDao.findById(id);

            if (emprestimo != null) {
                emprestimo.setDataDevolucao(Date.from(LocalDateTime.now().plusMonths(4).atZone(java.time.ZoneId.systemDefault()).toInstant()));

                emprestimoDao.update(emprestimo);
                System.out.println("Atualizado com sucesso: ");
                System.out.println("ID: " + emprestimo.getId());
                System.out.println("Empréstimo: " + TestUtil.formatarData(emprestimo.getDataEmprestimo()));
                System.out.println("Devolução: " + TestUtil.formatarData(emprestimo.getDataDevolucao()));
                System.out.println("Aluno: " + (emprestimo.getAluno() != null ? emprestimo.getAluno().getNome() : "N/A"));
                System.out.println("Publicação: " + (emprestimo.getPublicacao() != null ? emprestimo.getPublicacao().getTitulo() : "N/A"));

            } else {
                System.out.println("⚠ update() - Empréstimo não encontrado");
            }

        } catch (Exception e) {
            System.err.println("✗ Erro ao executar update: " + e.getMessage());
        }
    }
}