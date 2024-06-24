package com.manaCoulby.gestionTicket.controlleur;


import com.manaCoulby.gestionTicket.Entity.BaseConnaissance;
import com.manaCoulby.gestionTicket.Repository.BaseConnRepository;
import com.manaCoulby.gestionTicket.service.BaseConnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("base")
public class BaseConnControlleur {
    @Autowired
    public BaseConnService baseConnService;

    @PostMapping("creer")
    public ResponseEntity<BaseConnaissance> createBaseConn(@RequestBody BaseConnaissance baseConnaissance) {
         this.baseConnService.creerBaseConnaissance(baseConnaissance) ;
         return ResponseEntity.ok().body(baseConnaissance);
    }

    @GetMapping("liste")
    public ResponseEntity<List<BaseConnaissance>> getBaseConnaissance() {
        List<BaseConnaissance> baseConnaissances = baseConnService.getAllBaseConnaissance();
        return ResponseEntity.ok(baseConnaissances);
    }

    @PutMapping("modifier/{id}")
    public ResponseEntity<BaseConnaissance> updateBaseConn(@PathVariable int id, @RequestBody BaseConnaissance baseConnaissance) {
        baseConnaissance.setIdBaseConn(id);
        BaseConnaissance updateBase = baseConnService.updateBaseConn(id, baseConnaissance);
        return ResponseEntity.ok(updateBase);
    }

}
