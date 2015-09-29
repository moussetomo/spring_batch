package im360.writer;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * This class reads configuration file for Hibernate and holds session factory object
 * @author takaimasatomo
 *
 */
public class HibernateUtil {
    
	/**
	 * session factory
	 */
    private static final SessionFactory sessionFactory;

    /**
     * initialize session factory
     */
    static {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
        	Configuration configuration = new Configuration();
        	configuration.configure();
        	ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        	sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * getter for session factory
     * @return
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * close session factory
     */
    public static void closeSessionFactory() {
    	if(sessionFactory != null) {
    		sessionFactory.close();
    	}
    }
}
