/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manymany_bidir;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Stephan
 */
public class Builder {
    public static void main(String[] args) {
        Persistence.generateSchema("manymany_bidir", null);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("manymany_bidir");
        EntityManager em = emf.createEntityManager();
        
        CustomerEntity cust1 = new CustomerEntity("Marc", "A");
        CustomerEntity cust2 = new CustomerEntity("Liam", "B");
        CustomerEntity cust3 = new CustomerEntity("Noah", "C");
        CustomerEntity cust4 = new CustomerEntity("Vida", "D");
                
        AddressEntity adr1 = new AddressEntity("Street 1", "CPH");
        AddressEntity adr2 = new AddressEntity("Street 1", "Miami");
        AddressEntity adr3 = new AddressEntity("Street 1", "Paris");
        AddressEntity adr4 = new AddressEntity("Street 1", "Tokyo");
        
        List<AddressEntity> addresses1 = new ArrayList();
        List<AddressEntity> addresses2 = new ArrayList();
        
        addresses1.add(adr1);
        addresses1.add(adr2);
        addresses1.add(adr3);
        addresses1.add(adr4);
        
        addresses2.add(adr1);
        
        cust1.setAddresses(addresses1);
        cust2.setAddresses(addresses1);
        cust3.setAddresses(addresses2);
        cust3.setAddresses(addresses2);
        
        try {
            em.getTransaction().begin();
            
            em.persist(cust1);
            em.persist(cust2);
            em.persist(cust3);
            em.persist(cust4);
            
            em.persist(adr1);
            em.persist(adr2);
            em.persist(adr3);
            em.persist(adr4);
            
            em.getTransaction().commit();
                                    
            CustomerEntity cust = em.find(CustomerEntity.class, 2);
            
            cust.getAddresses().forEach((adr) -> {
                System.out.println( adr.getStreet() +" "+ adr.getCity());
            });
           
        } finally {
            em.close();
        }
        
        
    }
}
