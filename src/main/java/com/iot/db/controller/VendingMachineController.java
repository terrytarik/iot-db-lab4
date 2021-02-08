package com.iot.db.controller;

import com.iot.db.entity.VendingMachine;
import com.iot.db.service.VendingMachineService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vending-machine")
public class VendingMachineController {
    @Autowired
    private VendingMachineService vendingMachineService;

    @GetMapping
    public List<VendingMachine> getAllVendingMachines() {
        return vendingMachineService.getAll();
    }

    @GetMapping("/{id}")
    public VendingMachine getVendingMachineById(@PathVariable Integer id) {
        return vendingMachineService.getById(id);
    }

    @PostMapping
    public VendingMachine saveVendingMachine(@RequestBody VendingMachine vendingMachine) {
        return vendingMachineService.save(vendingMachine);
    }

    @PutMapping
    public VendingMachine updateVendingMachine(@RequestBody VendingMachine vendingMachine) {
        return vendingMachineService.save(vendingMachine);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteVendingMachineById(@PathVariable Integer id) {
        vendingMachineService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
