package com.example.L12_minor_project_1.controller;

import com.example.L12_minor_project_1.dto.VisitDto;
import com.example.L12_minor_project_1.enums.VisitStatus;
import com.example.L12_minor_project_1.service.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resident")
public class ResidentController {

    @Autowired
    private ResidentService residentService;

    @PutMapping("actOnVisit/{id}")
    public ResponseEntity<String> actOnVisit(@PathVariable Long id, @RequestParam VisitStatus visitStatus){
        return ResponseEntity.ok(residentService.updateVisit(id,visitStatus));
    }


    @GetMapping("/pendingVisits")
    public ResponseEntity<List<VisitDto>> getPendingVisits(@RequestHeader Long userId){
        return ResponseEntity.ok(residentService.getPendingVisits(userId));
    }
}
