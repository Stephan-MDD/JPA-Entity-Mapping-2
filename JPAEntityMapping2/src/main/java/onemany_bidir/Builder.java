/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onemany_bidir;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Stephan
 */
public class Builder {
    public static void main(String[] args) {
        Persistence.generateSchema("onemany_bidir", null);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("onemany_bidir");
        EntityManager em = emf.createEntityManager();
        
        CustomerEntity cust1 = new CustomerEntity("A", "B");
        CustomerEntity cust2 = new CustomerEntity("C", "D");
        CustomerEntity cust3 = new CustomerEntity("E", "F");
        CustomerEntity cust4 = new CustomerEntity("G", "H");
        
        AddressEntity adr1 = new AddressEntity("1", "2");
        AddressEntity adr2 = new AddressEntity("3", "4");
        AddressEntity adr3 = new AddressEntity("5", "6");
        AddressEntity adr4 = new AddressEntity("7", "8");
        
        cust1.setAddress(adr1);
        cust2.setAddress(adr2);
        cust3.setAddress(adr3);
        cust4.setAddress(adr4);
        
        try {
            em.getTransaction().begin();
            em.persist(cust1);
            em.persist(cust2);
            em.persist(cust3);
            em.persist(cust4);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
