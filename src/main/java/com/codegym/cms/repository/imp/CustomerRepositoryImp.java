package com.codegym.cms.repository.imp;

import com.codegym.cms.model.Customer;
import com.codegym.cms.repository.CustomerRepository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@SuppressWarnings("ALL")
@Transactional
public class CustomerRepositoryImp implements CustomerRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Customer> findAll() {
        Query query = em.createNamedQuery("findAll");
        return query.getResultList();
    }

    @Override
    public Customer findById(Long id) {
        TypedQuery<Customer> query = (TypedQuery<Customer>) em.createNamedQuery("findById");
        query.setParameter("id",id);
        try{
            return query.getSingleResult();
        } catch (NoResultException e){
            return null;
        }
    }

    @Override
    public void save(Customer model) {
        if(model != null){
            em.merge(model);
        } else {
            em.persist(model);
        }
    }

    @Override
    public void remove(Long id) {
        Customer user = findById(id);
        if (user != null){
            em.remove(user);
        }
    }
}
