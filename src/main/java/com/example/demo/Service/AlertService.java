package com.example.demo.Service;

import com.example.demo.Model.Alert;
import com.example.demo.Repository.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AlertService {
    private final AlertRepository alertRepository;

    @Autowired
    public AlertService(AlertRepository alertRepository){
        this.alertRepository = alertRepository;
    }

    public List<Alert> getAlertsByCriteria(Long Id, LocalDateTime StartTs, String AlertTs){
        if(Id == null || StartTs == null || AlertTs == null){
            throw new IllegalArgumentException("Alert search requires that you provide an ID, StartTs and AlertTs");
        }else {
            return alertRepository.findByIdAndStartTsAndAlertTs(Id, StartTs, AlertTs);
        }
    }

    public Alert saveAlert(Alert alert){
        return alertRepository.save(alert);
    }
}
