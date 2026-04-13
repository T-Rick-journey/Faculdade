package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.Pessoa;

public class TestesPessoaDAO {

	public static void main(String[] args) {
		DAO dao = new PessoaDAO();
		EntityManager em = dao.getEntityManager();

		// incluiVariasPessoas(em);
                
                /** inclui mais uma pessoa
                Pessoa p = new Pessoa(100, "CLAUDIO MARTINS", "BELEM", "PA");
                dao.insert(p);
                System.out.println("Insert do CLAUDIO");
                */
		/* altera(em);
                Pessoa p = (Pessoa) dao.findById(100);
                p.setNome("JOANA DARC");
                dao.update(p);
                System.out.println("UPDATE do objeto ID=100 -> CLAUDIO");
		*/

                // Deletar o objeto Entidade pelo ID =100
                Pessoa p = (Pessoa) dao.findById(100);
                dao.delete(p);
                System.out.println("DELETE o objeto ID=100"); 
                
                 em.close();
                
	}

	private static void incluiVariasPessoas(EntityManager em) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Pessoa p = new Pessoa(91, "JOAO MENDES", "BELÉM", "PA");
		em.persist(p);
		p = new Pessoa(92, "MARIA CARVALHO", "BELÉM", "PA");
		em.persist(p);
		p = new Pessoa(93, "PEDRO SILVA", "CAMETÁ", "PA");
		em.persist(p);
		p = new Pessoa(94, "LUIZ CARLOS", "SANTARÉM", "PA");
		em.persist(p);
		p = new Pessoa(95, "JOSÉ SANTOS", "SANTARÉM", "PA");
		em.persist(p);
		p = new Pessoa(96, "MÁRIO PONTES", "BELÉM", "PA");

		em.persist(p);
		transaction.commit();
	}

}
