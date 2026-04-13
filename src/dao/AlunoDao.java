package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaQuery;

import entity.Aluno;
import exemplo1.entidades.Cliente;

public class AlunoDao implements DAO<Aluno> {

    EntityManager em = getEntityManager();

    @Override
    public Aluno findById(Long id) {
        return em.find(Aluno.class, id);
    }

    @Override
    public List<Aluno> findAll() {
        CriteriaQuery<Aluno> cq = getEntityManager().getCriteriaBuilder().createQuery(Aluno.class);
        cq.select(cq.from(Aluno.class));
        return getEntityManager().createQuery(cq).getResultList();
    }

    @Override
    public void insert(Aluno entity) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(entity);
        transaction.commit();
    }

    @Override
    public void update(Aluno entity) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.merge(entity);
        transaction.commit();
    }

    @Override
    public void delete(Aluno entity) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Aluno aluno = em.find(Aluno.class, entity.getId());
        em.remove(aluno);
        transaction.commit();
    }
    
    
}
