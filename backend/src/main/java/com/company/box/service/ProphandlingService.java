package com.company.box.service;

import com.company.box.domain.SarsProperties;

import java.util.List;


public interface ProphandlingService{


    public List<SarsProperties> getAllProps();
    public SarsProperties saveOrUpdateProp(SarsProperties sarsProperties);

    public void deleteProp(Integer id);
}
