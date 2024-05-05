package tdea.construccion2.appVeterinary.Service;

import tdea.construccion2.appVeterinary.Dto.ClinicalHistoryDto;
import tdea.construccion2.appVeterinary.Dto.OrderDto;
import tdea.construccion2.appVeterinary.Dto.PersonDto;
import tdea.construccion2.appVeterinary.Dto.PetDto;

public interface VeterinarianService {

	public void createPet(PetDto petDto) throws Exception;

	public void createClinicalHistory(ClinicalHistoryDto medicalHistoryDto) throws Exception;

	public void createOwner(PersonDto personDto) throws Exception;

	public void cancelOrder(OrderDto orderDto) throws Exception;
}
