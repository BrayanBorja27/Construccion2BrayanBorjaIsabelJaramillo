package tdea.construccion2.appVeterinary.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tdea.construccion2.appVeterinary.Dto.PersonDto;
import tdea.construccion2.appVeterinary.Dto.SessionDto;
import tdea.construccion2.appVeterinary.Models.Session;
import tdea.construccion2.appVeterinary.Repository.SessionRepository;

@Service
public class LoginDaoImp implements LoginDao {

    @Autowired
	private SessionRepository sessionRepository;

    @Override
    public SessionDto login(PersonDto personDto) throws Exception {
    	Session session = new Session();
		session.setUserName(personDto.getUserName());
		session.setRol(personDto.getRole());
		sessionRepository.save(session);
		return new SessionDto (session);
    }

    @Override
    public void logout(long sessionId) throws Exception {
    	Session session = sessionRepository.findSessionById(sessionId);
		if (session != null) {
			sessionRepository.delete(session);
		}
    }

    @Override
    public SessionDto findSessionById(long sessionId) throws Exception {
    	Session session = sessionRepository.findSessionById(sessionId);
		if( session==null) {
			return null;
		}
		return new SessionDto(session);
    }
    
    public SessionRepository getSessionRepository() {
		return sessionRepository;
	}

	public void setSessionRepository(SessionRepository sessionRepository) {
		this.sessionRepository = sessionRepository;
	}

}
