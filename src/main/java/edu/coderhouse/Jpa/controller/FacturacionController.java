package edu.coderhouse.Jpa.controller;

import edu.coderhouse.Jpa.dto.FacturaDTO;
import edu.coderhouse.Jpa.entity.Invoices;
import edu.coderhouse.Jpa.entity.Linea;
import edu.coderhouse.Jpa.entity.Client;  // Asegúrate de importar Client
import edu.coderhouse.Jpa.service.FacturacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/facturacion")
public class FacturacionController {

    private final FacturacionService facturacionService;

    @Autowired
    public FacturacionController(FacturacionService facturacionService) {
        this.facturacionService = facturacionService;
    }

    @PostMapping("/crear")
    public void crearFactura(@RequestBody FacturaDTO facturaDTO) {
        Invoices invoice = new Invoices();  // Crea una nueva factura
        invoice.setFecha(LocalDateTime.now()); // Establece la fecha de la factura

        Client client = facturaDTO.getClient();  // Obtiene el cliente desde el DTO
        List<Linea> lineas = facturaDTO.getLineas();  // Obtiene las líneas del DTO

        // Llama al servicio con la factura, el cliente y las líneas
        facturacionService.crearFacturaConProductos(invoice, client, lineas);
    }
}
