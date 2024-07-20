//package ar.edu.utn.frc.tup.lciii;
//
//import entities.bankEntity;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import javax.persistence.Query;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//
//public class EntityTest {
//    private static SessionFactory sessionFactory;
//
//    @BeforeAll
//    public static void setUp() {
//        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
//        sessionFactory= configuration.buildSessionFactory();
//    }
//
//    @AfterAll
//    public static void tearDown() {
//        if(sessionFactory!=null){
//            sessionFactory.close();
//        }
//    }
//
//    @Test
//    public void testCreateAndFindBankEntity() {
//        try(Session session = sessionFactory.openSession()){
//            session.beginTransaction();
//            bankEntity bank = new bankEntity();
//            bank.setMoney(1000.0);
//            session.save(bank);
//            session.getTransaction().commit();
//        }
//        try(Session session = sessionFactory.openSession()){
//            session.beginTransaction();
//            Query query=session.createQuery("select max(id_bank) from bankEntity");
//            Integer maxId = (Integer) query.getSingleResult();
//            bankEntity foundBank = session.get(bankEntity.class, maxId);
//            session.getTransaction().commit();
//            assertNotNull(foundBank);
//            assertEquals(1000.0, foundBank.getMoney());
//        }
//    }
//
//
//}
