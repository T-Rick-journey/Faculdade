package Testes;

import java.util.Date;

import dao.AlunoDao;
import dao.EmprestimosDao;
import dao.PublicacaoDAO;
import entity.Aluno;
import entity.Publicacao;

public class TestUtil {
    
    EmprestimosDao emprestimoDao;

    public static String formatarData(Date data){
        StringBuilder sb = new StringBuilder();
        sb.append(data.getDate()).append("/")
          .append(data.getMonth() + 1).append("/")
          .append(data.getYear() + 1900).append(" ")
          .append(data.getHours()).append(":")
          .append(data.getMinutes()).append(":")
          .append(data.getSeconds());
        return sb.toString();
    }

    public static Aluno buscarAlunoPorId(Long id){
        try {
            AlunoDao alunoDao = new AlunoDao();
            return alunoDao.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Publicacao buscarPublicacaoPorId(Long id){
        try {
            PublicacaoDAO publicacaoDAO = new PublicacaoDAO();
            return publicacaoDAO.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
