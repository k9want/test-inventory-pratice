package com.grizz.inventoryapp.inventory.controller;

import com.grizz.inventoryapp.inventory.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/{itemId}")
    Object findByItemId(@PathVariable String itemId) {
        if (inventoryService.findByItemId(itemId) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        System.out.println("itemId = " + itemId);
        return itemId;
    }
}
