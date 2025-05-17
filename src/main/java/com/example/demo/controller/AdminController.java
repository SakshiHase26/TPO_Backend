// AdminController.java
package com.example.demo.controller;

import com.example.demo.entity.Tpo;
import com.example.demo.repository.TpoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class AdminController {

    private final TpoRepository tpoRepository;

    @GetMapping("/pending-tpos")
    public List<Tpo> getPendingTpos() {
        return tpoRepository.findAll()
                .stream()
                .filter(tpo -> !tpo.isApproved())
                .toList();
    }

    // ✅ Add this here to get all TPOs (approved + unapproved)
    @GetMapping("/all-tpos")
    public List<Tpo> getAllTpos() {
        return tpoRepository.findAll();
    }
}
