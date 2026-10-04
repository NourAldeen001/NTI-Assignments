package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.model.AuditLog;
import org.springframework.stereotype.Repository;

@Repository
public class AuditLogRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(AuditLog auditLog) {
        if(auditLog.getId() == null) entityManager.persist(auditLog);
        else entityManager.merge(auditLog);
    }
}
