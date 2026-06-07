package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaQuery;

import entity.Publicacao;

public class PublicacaoDAO implements DAO<Publicacao>{

    EntityManager em = getEntityManager();

    @Override
    public Publicacao findById(Long id) {
        return em.find(Publicacao.class, id);
    }

    @Override
    public List<Publicacao> findAll() {
        CriteriaQuery<Publicacao> cq = getEntityManager().getCriteriaBuilder().createQuery(Publicacao.class);
        cq.select(cq.from(Publicacao.class));
        return getEntityManager().createQuery(cq).getResultList();
    }

    @Override
    public void insert(Publicacao entity) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(entity);
        transaction.commit();
    }

    @Override
    public void update(Publicacao entity) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.merge(entity);
        transaction.commit();
    }

    @Override
    public void delete(Publicacao entity) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Publicacao Publicacao = em.find(Publicacao.class, entity.getId());
        em.remove(Publicacao);
        transaction.commit();
    }
    
}
