package edu.coderhouse.Jpa;

import edu.coderhouse.Jpa.entity.Client;
import edu.coderhouse.Jpa.entity.Invoices;
import edu.coderhouse.Jpa.entity.Linea;
import edu.coderhouse.Jpa.dto.FacturaDTO;
import edu.coderhouse.Jpa.service.ClientService;
import edu.coderhouse.Jpa.service.FacturacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableTransactionManagement
public class JpaApplication implements CommandLineRunner {

	@Autowired
	private FacturacionService facturacionService;  // el servicio de facturación

	@Autowired
	private ClientService clientService; //  el servicio de cliente

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Crear o recuperar el cliente
		Client cliente = new Client();
		cliente.setDni("12345678");  // Establece el DNI u otras propiedades necesarias
		cliente.setName("Juan");
		cliente.setLastname("Pérez");

		// Crear una nueva factura
		Invoices invoice = new Invoices();
		invoice.setFecha(LocalDateTime.now());  // Establece la fecha de la factura

		// Crear líneas de factura
		List<Linea> lineas = new ArrayList<>();
		Linea linea1 = new Linea();
		linea1.setDescripcion("Producto 1");
		linea1.setCantidad(2);
		linea1.setPrecio(100);

		Linea linea2 = new Linea();
		linea2.setDescripcion("Producto 2");
		linea2.setCantidad(1);
		linea2.setPrecio(200);

		lineas.add(linea1);
		lineas.add(linea2);

		// Llamar al servicio para crear la factura con cliente y líneas
		try {
			facturacionService.crearFacturaConProductos(invoice, cliente, lineas);
			System.out.println("Factura creada con éxito");
		} catch (Exception e) {
			System.out.println("Error al crear la factura: " + e.getMessage());
		}
	}
}

