package com.example.demo.Controllers;

import com.example.demo.Model.Alert;
import com.example.demo.Service.AlertService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/alerts")
public class AlertController {
    private final AlertService alertService;

    @Autowired
    public AlertController(AlertService alertService){
        this.alertService = alertService;
    }

    @PostMapping
    @ApiOperation(value = "Save Alert")
    public ResponseEntity<Alert> createAlert(@RequestBody Alert alert){
        Alert createdAlert = alertService.saveAlert(alert);

        if(createdAlert != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(createdAlert);
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    @ApiOperation(value = "Get an alert by ID, StartTs and AlertTs")
    public ResponseEntity<List<Alert>> getAlerts(
        @RequestParam(required = true) Long Id,
        @RequestParam(required = true) LocalDateTime StartTs,
        @RequestParam(required = true) String AlertTs
        ){

        List<Alert> alerts = alertService.getAlertsByCriteria(Id, StartTs, AlertTs);
        if(alerts.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(alerts);
        }
    }
}
