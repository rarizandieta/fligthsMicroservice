package com.fligth.app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fligth.app.entities.Fligth;
import com.fligth.app.services.FligthService;

@RestController
@RequestMapping("api/fligths")
public class FligthController {

    @Autowired
    private FligthService fligthService;

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(fligthService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        Optional<Fligth> fligth = fligthService.findById(id);
        if (fligth.isPresent()) {
            //entra si se encontró un vuelo con el id dado, si no se encontró se devuelve un 404--
            return ResponseEntity.ok(fligth.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
