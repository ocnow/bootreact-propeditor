package com.company.box.dao;

import com.company.box.domain.SarsProperties;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface PropertiesDAO extends CrudRepository<SarsProperties,Integer> {
    List<SarsProperties> findCustomByPropName(String propName);

}
