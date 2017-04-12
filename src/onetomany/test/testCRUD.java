package onetomany.test;

import beans.Country;
import beans.Minister;
import onetomany.utils.HbnUtils;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

/**
 * Created by user on 17-4-5.
 */
public class testCRUD {
    @Test
    public void testIn(){
        Session session = HbnUtils.getSession();
        try {
            session.beginTransaction();
            Minister aaa = new Minister("aaa");
            Minister bbb = new Minister("bbb");
            Minister ccc = new Minister("ccc");
            HashSet<Minister> ministers = new HashSet<>();
            ministers.add(aaa);
            ministers.add(bbb);
            ministers.add(ccc);
            Country usa = new Country("USA");
            usa.setMinisters(ministers);
            session.save(aaa);
            session.save(bbb);
            session.save(ccc);
            session.save(usa);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
}
