package com.company.box.controller;

import com.company.box.dao.PropertiesDaoImpl;
import com.company.box.domain.SarsProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    PropertiesDaoImpl propertiesDao;

    @GetMapping("/api/hello")
    public List<SarsProperties> hello(){
        return propertiesDao.findAllSarsPropertiesByQuery("PROP_2");
    }

    @GetMapping("/api/pron")
    public List<SarsProperties> jello(){
        List<SarsProperties> proplist = new ArrayList<SarsProperties>();
        proplist.add(new SarsProperties(1,"Name","valie"));
        proplist.add(new SarsProperties(2,"Name1","valie1"));
        proplist.add(new SarsProperties(3,"Name2","valie2"));
        return proplist;
    }
}
