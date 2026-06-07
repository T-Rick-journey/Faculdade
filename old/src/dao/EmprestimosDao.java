package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaQuery;

import entity.Emprestimo;

public class EmprestimosDao implements DAO<Emprestimo> {

    EntityManager em = getEntityManager();

    @Override
    public Emprestimo findById(Long id) {
        return em.find(Emprestimo.class, id);
    }

    @Override
    public List<Emprestimo> findAll() {
        CriteriaQuery<Emprestimo> cq = getEntityManager().getCriteriaBuilder().createQuery(Emprestimo.class);
        cq.select(cq.from(Emprestimo.class));
        return getEntityManager().createQuery(cq).getResultList();
    }

    @Override
    public void insert(Emprestimo entity) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(entity);
        transaction.commit();
    }

    @Override
    public void update(Emprestimo entity) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.merge(entity);
        transaction.commit();
    }

    @Override
    public void delete(Emprestimo entity) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Emprestimo Emprestimo = em.find(Emprestimo.class, entity.getId());
        em.remove(Emprestimo);
        transaction.commit();
    }

    public List<Emprestimo> findByNomeAluno(String nomeAluno) {
        return em.createQuery("SELECT e FROM Emprestimo e WHERE LOWER(e.aluno.nome) LIKE LOWER(:nomeAluno)", Emprestimo.class)
                .setParameter("nomeAluno", "%" + nomeAluno + "%")
                .getResultList();
    }
    
}
