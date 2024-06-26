package tdea.construccion2.appVeterinary.Dao;

import tdea.construccion2.appVeterinary.Dto.PersonDto;

public interface PersonDao {

    public PersonDto findUserByUserName(PersonDto person) throws Exception;
    
    public PersonDto findUserById(PersonDto personId) throws Exception;

    public void createPerson(PersonDto personDto) throws Exception;

    public boolean findUserExistById(PersonDto personDto) throws Exception; 

    public boolean findExistingUserByUserName(PersonDto personDto) throws Exception;
}
