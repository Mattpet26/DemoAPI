package com.example.demo.Repository;

import com.example.demo.Model.Alert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AlertRepository extends JpaRepository<Alert, Long> {
    List<Alert> findByIdAndStartTsAndAlertTs(Long Id, LocalDateTime StartTs, String AlertTs);
}
