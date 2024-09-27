package edu.coderhouse.Jpa.service;

import edu.coderhouse.Jpa.entity.Linea;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LineaService {

    private final SessionFactory sessionFactory;

    @Autowired
    public LineaService(EntityManagerFactory factory) {
        this.sessionFactory = factory.unwrap(SessionFactory.class);
    }

    @Transactional
    public void createLinea(Linea linea) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(linea);
    }
}
