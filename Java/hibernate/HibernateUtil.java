import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

    private static SessionFactory factory;
    static {
        factory = new MetadataSources(new StandardServiceRegistryBuilder().configure().build())
                .buildMetadata().buildSessionFactory();
    }
    //线程局部变量
    private static ThreadLocal<Session> sessionThreadLocal = new ThreadLocal<>();
    /***
     * 打开Session：线程不安全的，线程内部尽可能共享（ 线程变量）
     * 1） 先从线程变量中获得
     * 2） 如果没有再从factory中获得，并放在线程变量中
     */
    public static Session openSession() {
        Session s = sessionThreadLocal.get();
        if(s == null || !s.isOpen()) {
            s = factory.openSession();
            sessionThreadLocal.set(s);
        }
        return s;
    }

    /***
     * 关闭Session
     */
    public static void closeSession() {
        Session s = sessionThreadLocal.get();
        sessionThreadLocal.set(null);

        if(s != null && s.isOpen()) {
            s.close();
        }
    }

    /***
     * 关闭SessionFactory
     */
    public static void destory() {
        if (factory.isOpen()) {
            factory.close();
        }
    }
}
