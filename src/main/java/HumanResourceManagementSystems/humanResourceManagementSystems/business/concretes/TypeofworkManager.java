package HumanResourceManagementSystems.humanResourceManagementSystems.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.TypeofworkService;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.SuccessDataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.SuccessResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.dataAccess.abstracts.TypeofworkDao;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.Typeofwork;

@Service
public class TypeofworkManager implements TypeofworkService{

	private TypeofworkDao typeofworkDao;
	
	@Autowired
	public TypeofworkManager(TypeofworkDao typeofworkDao) {
		super();
		this.typeofworkDao = typeofworkDao;
	}
	@Override
	public DataResult<List<Typeofwork>> getAll() {
		
		return new SuccessDataResult<List<Typeofwork>>
		(this.typeofworkDao.findAll(), "İş Alanı Türleri Listelendi!");		
				
	}
	@Override
	public Result add(Typeofwork typeofwork) {
		this.typeofworkDao.save(typeofwork);
		return new SuccessResult("İş Türü Eklendi!");
	}
	
}