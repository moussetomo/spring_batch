package im360.writer;

import im360.beans.GradeOutput;

import java.util.List;

import org.hibernate.Session;
import org.springframework.batch.item.ItemWriter;

/**
 * This class persists the grade outputs
 * @author takaimasatomo
 *
 */
public class GradeWriter implements ItemWriter<GradeOutput> {
 
	/**
	 * write grade output to database using Hibernate
	 */
	@Override
	public void write(List<? extends GradeOutput> items) throws Exception {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			 
			// writes to database table
			for (GradeOutput item : items) {
				session.save( item );
			}
			session.getTransaction().commit();
		}
		catch(Exception ex) {
			ex.printStackTrace();
			if(session != null) {
				session.getTransaction().rollback();
			}
		}

		finally {
			if ( session != null ) {
				session.close();
			}
		}
	}
}