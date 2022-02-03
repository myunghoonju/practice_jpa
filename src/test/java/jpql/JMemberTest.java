package jpql;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

@Slf4j
public class JMemberTest {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("startJpa");
    private static final EntityManager em = emf.createEntityManager();

    @Test
    public void memberTest() {
        EntityTransaction trx = em.getTransaction();
        trx.begin();
        try {
/*
            JMember jMember = new JMember();
            jMember.setUsername("jmember");
            jMember.setAge(10);
            em.persist(jMember);


            //select
            TypedQuery<JMember> result1 = em.createQuery("select m from JMember as m", JMember.class); // specific return type
            Query result2 = em.createQuery("select jm.username, jm.age from JMember as jm"); // vague return type


            //result
            List<JMember> resultList = result1.getResultList(); // if null then return empty list
            JMember singleResult = result1.getSingleResult(); // if return two or none then error

            // parameter binding
            TypedQuery<JMember> result3 = em.createQuery("select m from JMember as m where m.username = :username", JMember.class);
            result3.setParameter("username", "jmember");
            JMember singleResult = result3.getSingleResult();
            log.info(singleResult.getUsername());

            singleResult.setAge(20);

            TypedQuery<JMemberDTO> dto = em.createQuery("select new jpql.JMemberDTO(m.username, m.age) from JMember as m where m.username = :username", JMemberDTO.class);
            dto.setParameter("username", "jmember");
            List<JMemberDTO> resultList = dto.getResultList();
            log.info("resultList.get(0).getAge() {}", resultList.get(0).getAge());
*/
            trx.commit();
        } catch (Exception e) {
            trx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

    @Test
    public void pagingTest() {
        EntityTransaction trx = em.getTransaction();
        trx.begin();
        try {
            for (int i = 1; i <= 10; i++) {
                JMember jMember = new JMember();
                jMember.setUsername("jmember" + i);
                jMember.setAge(i);
                em.persist(jMember);
            }

            List<JMember> result = em.createQuery("select jm from JMember as jm order by jm.age desc", JMember.class)
                    .setFirstResult(1)
                    .setMaxResults(5)
                    .getResultList();

            for (JMember jm : result) {
                log.info(jm.getUsername());
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
    public void joinTest() {
        EntityTransaction trx = em.getTransaction();
        trx.begin();
        try {
            JTeam jTeam = new JTeam();
            jTeam.setName("jTeamA");
            em.persist(jTeam);

            JMember jMember = new JMember();
            jMember.setUsername("jMember");
            jMember.setAge(10);
            jMember.changeTeam(jTeam);
            em.persist(jMember);

            em.flush();
            em.clear();
            String query = "select jm from JMember as jm inner join jm.team jt";
            List<JMember> resultList = em.createQuery(query, JMember.class).getResultList();
            log.info("======================LAZY LOADING========================");
            log.info(resultList.get(0).getTeam().toString());
            trx.commit();
        } catch (Exception e) {
            trx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

    @Test
    public void testForm() {
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