package edu.coderhouse.Jpa.dto;

import edu.coderhouse.Jpa.entity.Linea;
import edu.coderhouse.Jpa.entity.Client;

import java.util.List;

public class FacturaDTO {
    private Client client;  // Agrega el cliente
    private List<Linea> lineas;  // Lista de líneas de la factura

    public Client getClient() {
        return client;  // Devuelve el cliente
    }

    public void setClient(Client client) {
        this.client = client;  // Establece el cliente
    }

    public List<Linea> getLineas() {
        return lineas;  // Devuelve la lista de líneas
    }

    public void setLineas(List<Linea> lineas) {
        this.lineas = lineas;  // Establece la lista de líneas
    }
}
