package se.ics.whatscookin.eao;

import jakarta.ejb.Local;
import se.ics.whatscookin.ejb.AppUser;

@Local
public interface AppUserEAOLocal {
	AppUser findAppUserById(Long id);
}
