package Testes;

import java.time.LocalDateTime;
import java.util.Date;

import dao.EmprestimosDao;
import entity.Emprestimo;
import Testes.TestInsertEmprestimo;

public class TestDelete {

    public static void main(String[] args) {
        Emprestimo emprestimo = TestInsertEmprestimo.testaInsert(
            Date.from(LocalDateTime.now().atZone(java.time.ZoneId.systemDefault()).toInstant()),
            Date.from(LocalDateTime.now().plusWeeks(2).atZone(java.time.ZoneId.systemDefault()).toInstant())
        );
        testDelete(emprestimo.getId());
    }

    private static void testDelete(Long id) {
        try {
            EmprestimosDao emprestimosDao = new EmprestimosDao();
            Emprestimo emprestimo = emprestimosDao.findById(id);

            if (emprestimo != null) {
                emprestimosDao.delete(emprestimo);
                System.out.println("  Empréstimo ID " + id + " deletado");
            } else {
                System.out.println("Empréstimo de ID " + id + " não encontrado");
            }

        } catch (Exception e) {
            System.err.println("Erro ao executar delete: " + e.getMessage());
            e.printStackTrace();
        }
    }


}