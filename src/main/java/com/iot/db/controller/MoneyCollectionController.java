package com.iot.db.controller;

import com.iot.db.entity.MoneyCollection;
import com.iot.db.entity.Technician;
import com.iot.db.entity.VendingMachine;
import com.iot.db.service.MoneyCollectionService;
import com.iot.db.service.TechnicianService;
import com.iot.db.service.VendingMachineService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/money-collection")
public class MoneyCollectionController {
    @Autowired
    private MoneyCollectionService moneyCollectionService;
    @Autowired
    private TechnicianService technicianService;
    @Autowired
    private VendingMachineService vendingMachineService;

    @GetMapping
    public List<MoneyCollection> findAll() {
        return moneyCollectionService.findAll();
    }

    @GetMapping("/{id}")
    public MoneyCollection findById(@PathVariable Integer id) {
        return moneyCollectionService.findById(id);
    }

    @PostMapping
    public MoneyCollection save(@RequestBody MoneyCollection moneyCollection,
                                @RequestParam Integer technicianId,
                                @RequestParam Integer vendingMachineId) {
        Technician technician = technicianService.findById(technicianId);
        VendingMachine vendingMachine = vendingMachineService.getById(vendingMachineId);
        moneyCollection.setTechnician(technician);
        moneyCollection.setVendingMachine(vendingMachine);
        return moneyCollectionService.save(moneyCollection);
    }

    @PutMapping
    public MoneyCollection update(@RequestBody MoneyCollection moneyCollection,
                                  @RequestParam Integer technicianId,
                                  @RequestParam Integer vendingMachineId) {
        Technician technician = technicianService.findById(technicianId);
        VendingMachine vendingMachine = vendingMachineService.getById(vendingMachineId);
        moneyCollection.setTechnician(technician);
        moneyCollection.setVendingMachine(vendingMachine);
        return moneyCollectionService.save(moneyCollection);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Integer id) {
        moneyCollectionService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
