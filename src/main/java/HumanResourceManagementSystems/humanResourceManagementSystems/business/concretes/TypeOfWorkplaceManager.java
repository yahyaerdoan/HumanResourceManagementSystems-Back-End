package HumanResourceManagementSystems.humanResourceManagementSystems.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.TypeOfWorkplaceService;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.SuccessDataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.SuccessResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.dataAccess.abstracts.TypeOfWorkplaceDao;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.TypeOfWorkplace;

@Service
public class TypeOfWorkplaceManager implements TypeOfWorkplaceService {

	private TypeOfWorkplaceDao typeOfWorkplaceDao;

	@Autowired
	public TypeOfWorkplaceManager(TypeOfWorkplaceDao typeOfWorkplaceDao) {
		super();
		this.typeOfWorkplaceDao = typeOfWorkplaceDao;
	}

	@Override
	public Result add(TypeOfWorkplace typeOfWorkplace) {
		this.typeOfWorkplaceDao.save(typeOfWorkplace);
		return new SuccessResult("Çalışma yeri türü eklendi");
	}

	@Override
	public DataResult<List<TypeOfWorkplace>> getAll() {
		return new SuccessDataResult<List<TypeOfWorkplace>>(this.typeOfWorkplaceDao.findAll(), 
				"Çalışma yeri türleri listelendi.");
	}

	@Override
	public DataResult<TypeOfWorkplace> getTypeByWorkplace(String typeOfWorkplace) {
		return new SuccessDataResult<TypeOfWorkplace>(this.typeOfWorkplaceDao.findByTypeOfWorkplace(typeOfWorkplace),
				"Çalışma zamanı türleri getirildi.");
	}

}
