package start;

import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class MemberTest {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("startJpa");
    private static final EntityManager em = emf.createEntityManager();

    @Test
    public void saveTest() {
        EntityTransaction trx = em.getTransaction();
        trx.begin();
        try {
            Member member = new Member();
            member.setId(4L);
            member.setName("hello111");
            em.persist(member);

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

    @Test
    public void updateTest() {
        EntityTransaction trx = em.getTransaction();
        trx.begin();
        try {
            Member member = em.find(Member.class, 4L);
            member.setName("hello4");
            em.persist(member);

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }


    @Test
    public void removeTest() {
        EntityTransaction trx = em.getTransaction();
        trx.begin();
        try {
            Member member = em.find(Member.class, 3L);
            em.remove(member);
            trx.commit();
        } catch (Exception e) {
            trx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

    @Test
    public void findTest() {
        // based on Member object
        List<Member> members = em.createQuery("select m from Member as m", Member.class).getResultList();
        for (Member member : members) {
            System.out.println(member.getName());
        }
    }

}