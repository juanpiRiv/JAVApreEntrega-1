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
    private EntityManager entityManager; // Inyecta el EntityManager

    @Autowired
    public FacturacionService(InvoiceService invoiceService, LineaService lineaService) {
        this.invoiceService = invoiceService;
        this.lineaService = lineaService;
    }

    @Transactional
    public void crearFacturaConProductos(Invoices invoice, Client client, List<Linea> lineas) {
        // Asegúrate de que el cliente esté persistido
        if (client.getId() == null) {
            entityManager.persist(client); // Persistimos el cliente si no tiene ID
        }

        invoice.setClient(client);  // Establece el cliente en la factura
        invoiceService.createInvoice(invoice); // Guarda la factura

        // Guardar cada línea asociada a la factura
        for (Linea linea : lineas) {
            linea.setInvoices(invoice);  // Asocia la línea con la factura
//            lineaService.createLinea(linea);  // Guarda la línea
        }
    }
}
