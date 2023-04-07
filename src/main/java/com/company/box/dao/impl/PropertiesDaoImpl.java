package com.company.box.dao.impl;

import com.company.box.dao.PropertiesDAO;
import com.company.box.domain.SarsProperties;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;



@Repository
public class PropertiesDaoImpl extends SimpleJpaRepository<SarsProperties,Integer> implements PropertiesDAO {

    @PersistenceContext
    EntityManager em;

    public PropertiesDaoImpl(EntityManager entityManager) {
        super(SarsProperties.class, entityManager);
    }

    @Override
    public List<SarsProperties> findCustomByPropName(String propName) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<SarsProperties> criteriaQuery = criteriaBuilder.createQuery(SarsProperties.class);

        Root<SarsProperties> root = criteriaQuery.from(SarsProperties.class);
        Predicate namepredicate = criteriaBuilder.like(root.get("propName"), "%" + propName + "%");
        criteriaQuery.where(namepredicate);
        TypedQuery<SarsProperties> query = em.createQuery(criteriaQuery);
        return  query.getResultList();
    }
}
