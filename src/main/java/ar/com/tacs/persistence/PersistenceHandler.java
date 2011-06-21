package ar.com.tacs.persistence;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

public class PersistenceHandler {
    @SuppressWarnings("static-access")
	private static final PersistenceManagerFactory pmfInstance =
        JDOHelper.getPersistenceManagerFactory("transactions-optional");

    private PersistenceHandler() {}

    public static PersistenceManagerFactory get() {
        return pmfInstance;
    }    
    
}
