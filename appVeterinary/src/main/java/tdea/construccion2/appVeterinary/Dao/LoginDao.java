package tdea.construccion2.appVeterinary.Dao;

import tdea.construccion2.appVeterinary.Dto.SessionDto;
import tdea.construccion2.appVeterinary.Dto.PersonDto;

public interface LoginDao {

	public SessionDto login(PersonDto personDto) throws Exception;
	public SessionDto findSessionById(long sessionId) throws Exception;
	public void logout(long sessionId) throws Exception;
    
}
