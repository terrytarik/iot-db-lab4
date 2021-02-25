package com.iot.db.controller;

import com.iot.db.entity.Technician;
import com.iot.db.service.TechnicianService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/technician")
public class TechnicianController {
    @Autowired
    private TechnicianService technicianService;

    @GetMapping
    public List<Technician> findAll() {
        return technicianService.findAll();
    }

    @GetMapping("/{id}")
    public Technician findById(@PathVariable Integer id) {
        return technicianService.findById(id);
    }

    @PostMapping
    public Technician save(@RequestBody Technician moneyCollection) {
        return technicianService.save(moneyCollection);
    }

    @PutMapping
    public Technician update(@RequestBody Technician moneyCollection) {
        return technicianService.save(moneyCollection);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Integer id) {
        technicianService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
