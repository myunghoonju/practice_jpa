package join.domain;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

@Slf4j
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


            log.info("realObj instanceof Movie :: {}", realObj instanceof Movie);
            log.info("realObj.getClass() == Movie.class :: {}" , realObj.getClass() == Movie.class);
            log.info("reference instanceof Movie :: {}", (reference instanceof Movie));
            log.info("realObj.getClass() :: {}", realObj.getClass());
            log.info("reference.getClass() :: {}", reference.getClass());
            log.info("reference.getClass() == Movie.class :: {}", (reference.getClass() == Movie.class));
            log.info("reference.getClass() == realObj.getClass() :: {}", (reference.getClass() == realObj.getClass()));

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}