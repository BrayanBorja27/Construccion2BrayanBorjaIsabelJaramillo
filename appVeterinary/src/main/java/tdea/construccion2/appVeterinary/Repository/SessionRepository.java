package tdea.construccion2.appVeterinary.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tdea.construccion2.appVeterinary.Models.*;

public interface SessionRepository extends JpaRepository<Session, Long> {
	
	public Session findSessionById(long id);

}
