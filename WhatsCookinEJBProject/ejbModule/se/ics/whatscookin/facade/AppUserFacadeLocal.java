package se.ics.whatscookin.facade;

import jakarta.ejb.Local;
import se.ics.whatscookin.ejb.AppUser;

@Local
public interface AppUserFacadeLocal {
   public AppUser getUserById(Long id);
}
