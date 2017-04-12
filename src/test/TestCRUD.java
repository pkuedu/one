package test;


import beans.Country;
import beans.Minister;
import beans.Student;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import utils.HbnUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by user on 17-3-30.
 */
public class TestCRUD {

    @Test
    public void testMini(){
        Session session = HbnUtils.getSession();
        try {
            session.beginTransaction();

            Minister minister = new Minister("aaa");
            Minister minister1 = new Minister("bbb");
            Minister minister2 = new Minister("ccc");
            Set<Minister> ministers = new HashSet<>();
            ministers.add(minister);
            ministers.add(minister1);
            ministers.add(minister2);

            Country country = new Country("USA");
            country.setMinisters(ministers);

            session.save(minister);
            session.save(minister1);
            session.save(minister2);
            session.save(country);

            session.beginTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    @Test
    public void testSave(){
        /*//1.加载主配置文件
        Configuration configure = new Configuration().configure();
        //2.创建Session工厂对象
        SessionFactory sessionFactory = configure.buildSessionFactory();
        //3.获取Session对象
        Session currentSession = sessionFactory.getCurrentSession();*/
        Session currentSession = HbnUtils.getSession();
        try {
            //4.开启事物
            currentSession.beginTransaction();
            //5.执行操作
            Student student = new Student("张小三", 25, 97.5);
            currentSession.save(student);
            //6.事务提交
            currentSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            //7.事务回滚
            currentSession.getTransaction().rollback();
        }
    }

    @Test
    public void testDelete(){
        Session session = HbnUtils.getSession();
        try {
            session.beginTransaction();
            Student student = new Student();
            student.setId(8);
            //删除的条件是对象要具有id
            session.delete(student);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    @Test
    public void testUpdate(){
        Session session = HbnUtils.getSession();

        try {
            session.beginTransaction();
            Student student = new Student("李小四",21,88.9);
            student.toString();
            student.setId(9);
            session.update(student);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    public void testGetLoad(){
        //get() 与 load()
        //get() 若加载的对象不存在，则返回null;
        //load() 若加载的对象不存在，则抛出异常;
    }

    @Test
    public void testSQL(){
        Session session = HbnUtils.getSession();
        try {
            session.beginTransaction();
            String sql = "SELECT * FROM t_student ORDER BY tid DESC";
            List<Student> list = session.createSQLQuery(sql).addEntity(Student.class).list();
            for (Student student:list){
                System.out.println(student);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
}
