package Testes;

import java.util.List;

import dao.EmprestimosDao;
import entity.Emprestimo;

public class TestFindEmprestimoByAluno {
    
    public static void main(String[] args) {
        testFindEmprestimoByNomeAluno("silva");
    }

    public static void testFindEmprestimoByNomeAluno(String nomeAluno){
        try {
            EmprestimosDao dao = new EmprestimosDao();
            List<Emprestimo> emprestimos =dao.findByNomeAluno(nomeAluno);
            for (Emprestimo emprestimo : emprestimos) {
                System.out.println("-----------------------------");
                System.out.println(
                          "ID: " + emprestimo.getId()
                        + " || Empréstimo: " + TestUtil.formatarData(emprestimo.getDataEmprestimo())
                        + " || Devolução: " + TestUtil.formatarData(emprestimo.getDataDevolucao())
                        + " || Aluno: " + (emprestimo.getAluno() != null ? emprestimo.getAluno().getNome() : "N/A")
                        + " || Publicação: " + (emprestimo.getPublicacao() != null ? emprestimo.getPublicacao().getTitulo() : "N/A"));
            }
        } catch (Exception e) {
            System.err.println("Erro ao listar emprestimos por nome do aluno: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
