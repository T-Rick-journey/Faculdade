package exemplo1.entidades;

import dao.*;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ClienteDAO implements DAO<Cliente> {

    EntityManager em = getEntityManager();

    @Override
    public Cliente findById(Long id) {
        return em.find(Cliente.class, id);
    }

    @Override
    public List<Cliente> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(Cliente.class));
        return getEntityManager().createQuery(cq).getResultList();
    }

    @Override
    public void insert(Cliente t) {
        EntityTransaction transaction
                = em.getTransaction();
        transaction.begin();
        em.persist(t);  // simula o SQL "INSERT INTO..."
        transaction.commit();
    }

    @Override
    public void update(Cliente t) {
        EntityTransaction transaction
                = em.getTransaction();
        transaction.begin();
        em.merge(t); // simula o SQL "UPDATE ..."
        transaction.commit();
    }

    @Override
    public void delete(Cliente t) {
        EntityTransaction transaction
                = em.getTransaction();
        transaction.begin();
        Cliente pessoa = em.find(Cliente.class, t.getId());
        em.remove(pessoa); // simula o SQL "DELETE..."
        transaction.commit();
    }

    public void adicionaEndereco(Endereco e) {
        EntityTransaction transaction
                = em.getTransaction();
        transaction.begin();
        em.persist(e);
        transaction.commit();
    }
    
    public Endereco findEnderecoById (Integer id) {
        return em.find(Endereco.class, id);
    }

    public Pedido novoPedido(String prod, int qtd, BigDecimal valor) {
        EntityTransaction transaction
                = em.getTransaction();
        transaction.begin();
        Pedido p = new Pedido(prod, qtd, valor);
        
        em.persist(p);
        transaction.commit();
        return p;
        
    }

}
