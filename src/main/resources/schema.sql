CREATE TABLE client (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    lastname VARCHAR(150) NOT NULL,
    dni VARCHAR(11) NOT NULL
);

CREATE TABLE adress (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    street VARCHAR(150) NOT NULL,
    number INT NOT NULL,
    floor INT,
    departament VARCHAR(50),
    cp VARCHAR(150) NOT NULL,
    location VARCHAR(150) NOT NULL,
    state VARCHAR(150) NOT NULL,
    clientid INT,
    CONSTRAINT FK_client_adress FOREIGN KEY (clientid)
    REFERENCES client(id)
);

CREATE TABLE products (
   productsid INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   codigo INT NOT NULL,
   descripcion VARCHAR(255) NOT NULL,
   cantidad INT,
   precio FLOAT(7, 2)
);

CREATE TABLE invoices (
      comprobanteid INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
      fecha DATETIME,
      clientid INT,
      CONSTRAINT FK_client_invoice FOREIGN KEY (clientid)
      REFERENCES client(id)
);

CREATE TABLE linea (
    lineaid INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(255) NOT NULL,
    cantidad INT,
    precio FLOAT(7, 2),
    comprobanteid INT NOT NULL,
    productoid INT NOT NULL,
    CONSTRAINT FK_comprobante_linea FOREIGN KEY (comprobanteid)
    REFERENCES invoices(comprobanteid),
    CONSTRAINT FK_product_linea FOREIGN KEY (productoid)
    REFERENCES products(productsid)
);
