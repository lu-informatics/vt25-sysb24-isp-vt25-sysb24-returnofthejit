package se.ics.whatscookin.eao;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import se.ics.whatscookin.ejb.AppUser;

/**
 * Session Bean implementation class AppUserEAOImpl
 */
@Stateless
public class AppUserEAOImpl implements AppUserEAOLocal {

    /**
     * Default constructor. 
     */
    public AppUserEAOImpl() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
    private EntityManager em;
    
    public AppUser findAppUserById(Long id) {
        return em.find(AppUser.class, id);
    }

}
