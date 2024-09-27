package edu.coderhouse.Jpa.service;

import edu.coderhouse.Jpa.entity.Client;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class ClientService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void createClient(Client client) {
        entityManager.persist(client);
    }
}