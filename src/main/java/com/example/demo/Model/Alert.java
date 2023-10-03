package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Alert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long AlertId;
    private Long SerivceId;
    private String ServiceName;
    private String Model;
    private String AlertType;
    private String AlertTs;
    private String Severity;
    private String Team;
    private LocalDateTime StartTs;

    public Alert() {
    }

    public Alert(Long alertId, Long serivceId, String serviceName, String model, String alertType, String alertTs, String severity, String team) {
        AlertId = alertId;
        SerivceId = serivceId;
        ServiceName = serviceName;
        Model = model;
        AlertType = alertType;
        AlertTs = alertTs;
        Severity = severity;
        Team = team;
        StartTs = LocalDateTime.now();
    }

    public Long getAlertId() {
        return AlertId;
    }

    public void setAlertId(Long alertId) {
        AlertId = alertId;
    }

    public Long getSerivceId() {
        return SerivceId;
    }

    public void setSerivceId(Long serivceId) {
        SerivceId = serivceId;
    }

    public String getServiceName() {
        return ServiceName;
    }

    public void setServiceName(String serviceName) {
        ServiceName = serviceName;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getAlertType() {
        return AlertType;
    }

    public void setAlertType(String alertType) {
        AlertType = alertType;
    }

    public String getAlertTs() {
        return AlertTs;
    }

    public void setAlertTs(String alertTs) {
        AlertTs = alertTs;
    }

    public String getSeverity() {
        return Severity;
    }

    public void setSeverity(String severity) {
        Severity = severity;
    }

    public String getTeam() {
        return Team;
    }

    public void setTeam(String team) {
        Team = team;
    }

    public LocalDateTime getStartTs() {
        return StartTs;
    }

    public void setStartTs(LocalDateTime startTs) {
        StartTs = startTs;
    }
}
