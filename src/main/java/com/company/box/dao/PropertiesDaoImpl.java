package com.company.box.dao;

import com.company.box.domain.SarsProperties;
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
public class PropertiesDaoImpl {

    @PersistenceContext
    private EntityManager em;

    public List<SarsProperties> findAllSarsPropertiesByQuery(
            String PropName
    ){
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<SarsProperties> criteriaQuery = criteriaBuilder.createQuery(SarsProperties.class);

        Root<SarsProperties> root = criteriaQuery.from(SarsProperties.class);
        Predicate namepredicate = criteriaBuilder.like(root.get("propName"), "%" + PropName + "%");
        criteriaQuery.where(namepredicate);
        TypedQuery<SarsProperties> query = em.createQuery(criteriaQuery);
        return  query.getResultList();
    }
}
