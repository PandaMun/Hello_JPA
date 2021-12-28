package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class jpaMain {
    public static void main(String[] args) {
        //EntityManagerFactory 생성
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
        //EntityManager 생성
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        //transaction 생성
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        try {
            Member member = new Member();
            member.setId(1L);
            member.setName("pandamun");

            entityManager.persist(member);

            tx.commit();
        }catch (Exception e) {
            tx.rollback();
        }
        finally {
            entityManager.close();
        }
        entityManagerFactory.close();

    }
}
