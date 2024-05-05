package tdea.construccion2.appVeterinary.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tdea.construccion2.appVeterinary.Dto.ClinicalHistoryDto;
import tdea.construccion2.appVeterinary.Models.ClinicalHistory;
import tdea.construccion2.appVeterinary.Repository.ClinicalHistoryRepository;

@Service
public class ClinicalHistoryDaoImp implements ClinicalHistoryDao {

	@Autowired
	ClinicalHistoryRepository clinicalHistoryRepository;

	@Override
	public void createClinicalHistory(ClinicalHistoryDto clinicalHistoryDto) throws Exception {
		ClinicalHistory clinicalHistory = new ClinicalHistory(clinicalHistoryDto);
		clinicalHistoryRepository.save(clinicalHistory);

	}

	@Override
	public ClinicalHistoryDto findClinicalHistoryById(ClinicalHistoryDto clinicalHistoryDto) throws Exception {

		ClinicalHistory clinicalHistory = clinicalHistoryRepository.findById(clinicalHistoryDto.getDate());
		if (clinicalHistory == null) {
			return null;
		}
		return new ClinicalHistoryDto(clinicalHistory);
	}

	public ClinicalHistoryRepository getClinicalHistoryRepository() {
		return clinicalHistoryRepository;
	}

	public void setClinicalHistoryRepository(ClinicalHistoryRepository clinicalHistoryRepository) {
		this.clinicalHistoryRepository = clinicalHistoryRepository;
	}

	public void cancelOrder(ClinicalHistoryDto clinicalHistoryDto) {
		clinicalHistoryDto.setOrderCancellation(false);
		ClinicalHistory clinicalHistory = new ClinicalHistory(clinicalHistoryDto);
		clinicalHistoryRepository.save(clinicalHistory);
	}

	@Override
	public ClinicalHistoryDto findClinicalHistoryByOrderId(long orderId) throws Exception {
		ClinicalHistoryDto clinicalHistoryDto = new ClinicalHistoryDto(
				clinicalHistoryRepository.findByOrder(orderId));
		return clinicalHistoryDto;
	}

}
