package se.ics.whatscookin.facade;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import se.ics.whatscookin.eao.AppUserEAOLocal;
import se.ics.whatscookin.ejb.AppUser;

/**
 * Session Bean implementation class AppUserFacade
 */
@Stateless
public class AppUserFacade implements AppUserFacadeLocal {
	
	@EJB
    private AppUserEAOLocal appUserEAO;

    /**
     * Default constructor. 
     */
    public AppUserFacade() {
        // TODO Auto-generated constructor stub
    }
    
    public AppUser getUserById(Long id) {
        return appUserEAO.findAppUserById(id);
    }

}
