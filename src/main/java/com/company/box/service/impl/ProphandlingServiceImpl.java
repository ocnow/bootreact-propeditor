package com.company.box.service.impl;

import com.company.box.dao.PropertiesDAO;
import com.company.box.domain.SarsProperties;
import com.company.box.service.ProphandlingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProphandlingServiceImpl implements ProphandlingService {

    @Autowired
    PropertiesDAO propertiesDAO;

    @Override
    public List<SarsProperties> getAllProps(){
        List<SarsProperties> sarsProps = new ArrayList<>();
        Iterable<SarsProperties> propIterable =  propertiesDAO.findAll();
        for(SarsProperties prop : propIterable){
            sarsProps.add(prop);
        }
        return sarsProps;
    }

    @Override
    public SarsProperties saveOrUpdateProp(SarsProperties sarsProperties){
        SarsProperties prop = propertiesDAO.save(sarsProperties);
        return prop;
    }

    @Override
    public void deleteProp(Integer id){
        propertiesDAO.deleteById(id);
    }

}
