package tdea.construccion2.appVeterinary.Dao;

import tdea.construccion2.appVeterinary.Dto.ClinicalHistoryDto;

public interface ClinicalHistoryDao {

	public void createClinicalHistory(ClinicalHistoryDto clinicalHistoryDto) throws Exception;

	public ClinicalHistoryDto findClinicalHistoryById(ClinicalHistoryDto clinicalHistory) throws Exception;

	public ClinicalHistoryDto findClinicalHistoryByOrderId(long orderId) throws Exception;

}
