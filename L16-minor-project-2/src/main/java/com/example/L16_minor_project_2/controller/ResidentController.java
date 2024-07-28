package com.example.L16_minor_project_2.controller;

import com.example.L16_minor_project_2.dto.AllPendingVisitsDTO;
import com.example.L16_minor_project_2.dto.VisitDto;
import com.example.L16_minor_project_2.entity.User;
import com.example.L16_minor_project_2.enums.VisitStatus;
import com.example.L16_minor_project_2.service.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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


//    @GetMapping("/pendingVisits")
//    public ResponseEntity<List<VisitDto>> getPendingVisits(@RequestHeader Long userId){
//        return ResponseEntity.ok(residentService.getPendingVisits(userId));
//    }

    @GetMapping("/pendingVisits")
    public ResponseEntity<List<VisitDto>> getPendingVisits(@AuthenticationPrincipal User user){
        return ResponseEntity.ok(residentService.getPendingVisits(user.getId()));
    }


    @GetMapping("/page-pendingVisits")
    public ResponseEntity<AllPendingVisitsDTO> getPagePendingVisits(@AuthenticationPrincipal User user, @RequestParam Integer pageNo, @RequestParam Integer pageSize){
        return ResponseEntity.ok(residentService.getPendingVisitByPage(user.getId(),pageNo,pageSize));
    }
}
