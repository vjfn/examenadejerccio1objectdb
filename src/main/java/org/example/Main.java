package org.example;

import clase.Cliente;
import dao.ClienteDAO;

public class Main {
    public static void main(String[] args) {

        System.out.println("Examen de Víctor Jesús Fernández Noguer!");

        Cliente cliente1 = new Cliente("Victor",5L,"activo");
        Cliente cliente2 = new Cliente("Victor2",7L);
        Cliente cliente3 = new Cliente("Victor3");
        Cliente cliente4 = new Cliente("Victor4",2L,"inactivo");
        Cliente cliente5 = new Cliente("Victor5",1L,"inactivo");

        try {
            ClienteDAO.insertarCliente(cliente1);
            ClienteDAO.insertarCliente(cliente2);
            ClienteDAO.insertarCliente(cliente3);
            ClienteDAO.insertarCliente(cliente4);
            ClienteDAO.insertarCliente(cliente5);
        }catch (Exception e){}

        System.out.println("UNICO ClIENTE POR ID");
        ClienteDAO.getCliente(1L);

        System.out.println("LISTADO MEJORES CLIENTES");
        ClienteDAO.listarMejoresClientes(4L);

        System.out.println("ESTADISTICAS");
        ClienteDAO.estadisticas();

        System.out.println("TODOS LOS CLIENTES EN LA BASE DE DATOS");
        ClienteDAO.listarTodo();



    }
}