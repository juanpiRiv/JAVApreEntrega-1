package edu.coderhouse.Jpa.service;

import edu.coderhouse.Jpa.entity.Invoices;
import edu.coderhouse.Jpa.entity.Linea;
import edu.coderhouse.Jpa.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Service
public class FacturacionService {

    private final InvoiceService invoiceService;
    private final LineaService lineaService;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public FacturacionService(InvoiceService invoiceService, LineaService lineaService) {
        this.invoiceService = invoiceService;
        this.lineaService = lineaService;
    }

    @Transactional
    public void crearFacturaConProductos(Invoices invoice, Client client, List<Linea> lineas) {
        // CLIENT NO ID
        if (client.getId() == null) {
            entityManager.persist(client);
        }

        invoice.setClient(client);
        invoiceService.createInvoice(invoice);

        // LINEA
        for (Linea linea : lineas) {
            linea.setInvoices(invoice);  // LINEA=FACTURA

    }
}
