package dao;

import clase.Cliente;
import utils.ObjectDBUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;

public class ClienteDAO {

    public static void insertarCliente(Cliente cliente){

        EntityManager em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
        em.close();
    }

    public static void listarTodo(){
        EntityManager em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        TypedQuery<Cliente> q = em.createQuery("select c from Cliente c", Cliente.class);
        ArrayList<Cliente> clientes = (ArrayList<Cliente>) q.getResultList();

        for (Cliente clientito:clientes){
            System.out.println(clientito);
        }
    }

    public static void getCliente(Long id) {
        EntityManager em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();

        try {
            Cliente cliente = em.find(Cliente.class, id);

            if (cliente != null) {
                System.out.println(cliente);
            } else {
                System.out.println("El cliente con la ID " + id + " no ha sido encontrado.");
            }
        } finally {
            em.close();
        }
    }

    public static void listarMejoresClientes(long cantidad){
        EntityManager em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        TypedQuery<Cliente> q = em.createQuery("select c from Cliente c where c.totalDeVentas > :cantidad and c.estado ='activo'", Cliente.class);
        q.setParameter("cantidad", cantidad);
        ArrayList<Cliente> clientes = (ArrayList<Cliente>) q.getResultList();

        System.out.println("TOTAL DE VENTAS SUPERIOR A: "+cantidad);
        for (Cliente clientito:clientes){
            System.out.println(clientito);
        }

        em.close();
    }

    public static void estadisticas() {
        EntityManager em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();

        TypedQuery<Long> totalVentasQuery = em.createQuery("SELECT SUM(c.totalDeVentas) FROM Cliente c", Long.class);
        Long totalVentas = totalVentasQuery.getSingleResult();
        System.out.println("Ventas totales: " + totalVentas);

        TypedQuery<Double> promedioVentasQuery = em.createQuery("SELECT AVG(c.totalDeVentas) FROM Cliente c WHERE c.estado = 'activo'", Double.class);
        Double promedioVentas = promedioVentasQuery.getSingleResult();
        System.out.println("Promedio de ventas de clientes activos: " + promedioVentas);

        TypedQuery<Long> clientesInactivosQuery = em.createQuery("SELECT COUNT(c) FROM Cliente c WHERE c.estado = 'inactivo' AND c.totalDeVentas > 0", Long.class);
        Long cantidadClientesInactivos = clientesInactivosQuery.getSingleResult();
        System.out.println("Cantidad de clientes inactivos con alguna venta: " + cantidadClientesInactivos);

        em.close();
    }



}
