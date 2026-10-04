package org.example.service;

import org.example.model.AuditLog;
import org.example.repository.AuditLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class AuditLogService {

    private final AuditLogRepository auditLogRepository;

    @Autowired
    public AuditLogService(AuditLogRepository auditLogRepository) {
        this.auditLogRepository = auditLogRepository;
    }

    /// Always starts a new transaction.
    /// Suspend outer one until finished.
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addLog(String action) {
        AuditLog auditLog = new AuditLog();
        auditLog.setAction(action);
        auditLog.setCreatedAt(LocalDateTime.now());

        auditLogRepository.save(auditLog);
    }
}
