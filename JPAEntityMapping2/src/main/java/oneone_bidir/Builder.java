/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oneone_bidir;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Stephan
 */
public class Builder {
    public static void main(String[] args) {
        Persistence.generateSchema("oneone_bidir", null);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("oneone_bidir");
        EntityManager em = emf.createEntityManager();
        
        onemany_bidir.CustomerEntity cust1 = new onemany_bidir.CustomerEntity("A", "B");
        onemany_bidir.CustomerEntity cust2 = new onemany_bidir.CustomerEntity("C", "D");
        onemany_bidir.CustomerEntity cust3 = new onemany_bidir.CustomerEntity("E", "F");
        onemany_bidir.CustomerEntity cust4 = new onemany_bidir.CustomerEntity("G", "H");
        
        onemany_bidir.AddressEntity adr1 = new onemany_bidir.AddressEntity("1", "2");
        onemany_bidir.AddressEntity adr2 = new onemany_bidir.AddressEntity("3", "4");
        onemany_bidir.AddressEntity adr3 = new onemany_bidir.AddressEntity("5", "6");
        onemany_bidir.AddressEntity adr4 = new onemany_bidir.AddressEntity("7", "8");
        
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
