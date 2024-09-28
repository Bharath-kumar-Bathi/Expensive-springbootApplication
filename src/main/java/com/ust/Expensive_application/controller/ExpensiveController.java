package com.ust.Expensive_application.controller;


import com.ust.Expensive_application.dto.Expensivedto;
import com.ust.Expensive_application.exception.ExpensiveNotFoundException;
import com.ust.Expensive_application.model.Expensive;
import com.ust.Expensive_application.service.ExpensiveService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/expensive")
public class ExpensiveController {
    @Autowired
    private ExpensiveService expensiveService;

    @PostMapping("/addexpensive")
    public ResponseEntity<Expensive> addExpensive(@RequestBody  @Valid Expensivedto dto) {
        return new ResponseEntity<>(expensiveService.addExpensive(dto), HttpStatus.CREATED);
    }
    @GetMapping("/getexpensive/{id}")
    public ResponseEntity<Expensive> getExpensive(@PathVariable UUID id) throws ExpensiveNotFoundException {
        return  ResponseEntity.ok(expensiveService.getExpensive(id));
    }


}


