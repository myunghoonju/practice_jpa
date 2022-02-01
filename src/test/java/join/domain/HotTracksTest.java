package join.domain;

import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.lang.reflect.Member;
import java.time.LocalDateTime;

public class HotTracksTest {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("startJpa");
    private static final EntityManager em = emf.createEntityManager();

    @Test
    public void runTest() {
        EntityTransaction trx = em.getTransaction();
        trx.begin();
        try {
            Movie movie = new Movie();
            movie.setDirector("director");
            movie.setActor("actor");
            movie.setName("moviename");
            movie.setPrice(1000);
            movie.setCreateBy("Ju");
            movie.setCreateAt(LocalDateTime.now());

            em.persist(movie);

            em.flush();
            em.clear();

            Movie realObj = em.find(Movie.class, movie.getId());
            Movie reference = em.getReference(Movie.class, movie.getId());

/*
            Movie reference = em.getReference(Movie.class, movie.getId());
            Movie realObj = em.find(Movie.class, movie.getId());
*/

/*
            Movie realObj = em.find(Movie.class, movie.getId());
            em.clear();
            Movie reference = em.getReference(Movie.class, movie.getId());
*/


            System.out.println("" + (realObj instanceof Movie));
            System.out.println("" + (realObj.getClass() == Movie.class));
            System.out.println("" + (reference instanceof Movie));
            System.out.println("" + realObj.getClass());
            System.out.println("" + reference.getClass());
            System.out.println("" + (reference.getClass() == Movie.class));
            System.out.println("" + (reference.getClass() == realObj.getClass()));

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}