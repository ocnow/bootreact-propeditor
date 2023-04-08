package com.company.box.controller;

import com.company.box.domain.SarsProperties;
import com.company.box.service.ProphandlingService;
import oracle.ucp.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class PropController {

    @Autowired
    ProphandlingService prophandlingService;

    @GetMapping("/api/GetAllProps")
    @ResponseBody
    public List<SarsProperties> getAllProps(){
        return prophandlingService.getAllProps();
    }

    @PostMapping("/api/SaveProp")
    public SarsProperties saveProp(@RequestBody SarsProperties properties){
        System.out.println("updating the record.....");
        return prophandlingService.saveOrUpdateProp(properties);
    }

    @DeleteMapping("/api/DeleteProp/{id}")
    public ResponseEntity<Map<String,Object>> deleteEntity(@PathVariable Integer id){
        prophandlingService.deleteProp(id);

        Map<String,Object> response = new HashMap<>();
        response.put("id",id);
        response.put("message","Item has been deleted");

        return ResponseEntity.ok().body(response);
    }
}
