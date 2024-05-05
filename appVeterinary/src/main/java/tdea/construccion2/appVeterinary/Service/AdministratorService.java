package tdea.construccion2.appVeterinary.Service;

import tdea.construccion2.appVeterinary.Dto.PersonDto;

public interface AdministratorService {

    public void createVeterinarian(PersonDto personDto) throws Exception;

    public void createSeller(PersonDto personDto) throws Exception;

}
