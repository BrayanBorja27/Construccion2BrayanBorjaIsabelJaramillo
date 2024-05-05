package tdea.construccion2.appVeterinary.Service;

import tdea.construccion2.appVeterinary.Dto.PersonDto;

public interface LoginService {

    public void login(PersonDto personDto) throws Exception;

    public void logout(long sessionId) throws Exception;

    public void setSessionID(long sessionId);
}
