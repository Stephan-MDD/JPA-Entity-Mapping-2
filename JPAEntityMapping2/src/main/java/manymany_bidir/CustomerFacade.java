/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manymany_bidir;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Stephan
 */
public class CustomerFacade {

    EntityManagerFactory emf;

    public CustomerFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public CustomerEntity getCustomer(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CustomerEntity.class, id);  
        } finally {
            em.close();
        }
    }

    public List<CustomerEntity> getCustomers() {
        EntityManager em = getEntityManager();
        try {
            //...
        } finally {
            em.close();
        }
    }

    public CustomerEntity addCustomer(CustomerEntity cust) {
    }

    ;
    public CustomerEntity deleteCustomer(int id) {
    }

    public CustomerEntity editCustomer(CustomerEntity cust) {
    }

}
