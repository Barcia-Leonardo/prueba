package ar.edu.utn.frc.tup.lciii;

import entities.bankEntity;
import entities.propertyEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.Query;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


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
//    //trae null la property no funciona test
//    @Test
//    public void testGetProperties() {
//        try (Session session = sessionFactory.openSession()) {
//            session.beginTransaction();
//
//            propertyEntity property1 = new propertyEntity();
//            propertyEntity property2 = new propertyEntity();
//            session.save(property1);
//            session.save(property2);
//
//            bankEntity bank = new bankEntity();
//            bank.setMoney(1000.0);
//            bank.setProperties(Arrays.asList(property1, property2));
//            session.save(bank);
//
//            session.getTransaction().commit();
//        }
//
//        try (Session session = sessionFactory.openSession()) {
//            session.beginTransaction();
//            Query query = session.createQuery("select max(id_bank) from bankEntity");
//            Integer maxId = (Integer) query.getSingleResult();
//            bankEntity foundBank = session.get(bankEntity.class, maxId);
//            session.getTransaction().commit();
//            assertNotNull(foundBank);
//            List<propertyEntity> properties = foundBank.getProperties();
//            assertNotNull(properties);
//            assertEquals(2, properties.size());
//        }
//
//    }
//
//}
