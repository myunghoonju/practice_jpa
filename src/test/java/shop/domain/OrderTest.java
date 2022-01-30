package shop.domain;

import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class OrderTest {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("startJpa");
    private static final EntityManager em = emf.createEntityManager();

    @Test
    public void saveTest() {
        EntityTransaction trx = em.getTransaction();
        trx.begin();
        try {
            trx.commit();
        } catch (Exception e) {
            trx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

}