package com.security.template.controller;

import com.security.template.model.Hall;
import com.security.template.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/hall")
public class HallController {

    @Autowired
    private HallService hallService;


    @PostMapping("/addHalls")
    public ResponseEntity<?> addHalls(@RequestBody Hall halls){
            return new ResponseEntity<>(hallService.addHalls(halls), HttpStatus.CREATED);
    } 
    
    @GetMapping("/getHall/{id}")
   public ResponseEntity<?> getHalls(@PathVariable Long id){
    return new ResponseEntity<>(hallService.getHalls(id),HttpStatus.OK);
   }
    
   @GetMapping("/getAlls")
   public ResponseEntity<?> getAllHall(){
    return new ResponseEntity<>(hallService.getAllHall(),HttpStatus.OK);
   }

   @PutMapping("/putHall/{id}")
   public ResponseEntity<?> updateHall ( @PathVariable Long id,@RequestBody Hall halls) {
    try {
        Hall updatedHall = hallService.updateHall(id,halls);
        return new ResponseEntity<>(updatedHall, HttpStatus.OK);
    } catch (RuntimeException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }  
   }

   @DeleteMapping("/deleteHall/{id}")
   public String deleteHall(@PathVariable Long id){
    return hallService.deleteHall(id);
   }
   


    
}
