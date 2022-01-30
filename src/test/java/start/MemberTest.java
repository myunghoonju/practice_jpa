/*
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
            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            member.setTeam(team);
            em.persist(member);

            em.flush();
            em.clear();

            Member memberFound = em.find(Member.class, member.getId());
            List<Member> members = memberFound.getTeam().getMembers();

            for (Member mem : members) {
                System.out.println("member = " + mem.getUsername());
            }

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
            member.setUsername("hello4");
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
            System.out.println(member.getUsername());
        }
    }

    @Test
    public void repeatableReadTest() {
        EntityTransaction trx = em.getTransaction();
        trx.begin();
        try {
            //from db
            Member member1 = em.find(Member.class, 4L);
            System.out.println(member1.getUsername());
            //from cache
            Member member2 = em.find(Member.class, 4L);
            System.out.println(member2.getUsername());
            //true
            System.out.println(member1 == member2);
        } catch (Exception e) {
            trx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}*/
