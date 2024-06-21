package com.example.manganoob.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public abstract class RolesRepositoryImpl implements RolesRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void resetAutoIncrement() {
        entityManager.createNativeQuery("ALTER TABLE Roles AUTO_INCREMENT = 1")
                .executeUpdate();
    }
}
