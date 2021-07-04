package HumanResourceManagementSystems.humanResourceManagementSystems.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.TypeOfWorkService;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.SuccessDataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.SuccessResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.dataAccess.abstracts.TypeOfWorkDao;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.TypeOfWork;

@Service
public class TypeOfWorkManager implements TypeOfWorkService {

	private TypeOfWorkDao typeOfWorkDao;

	@Autowired
	public TypeOfWorkManager(TypeOfWorkDao typeOfWorkDao) {
		super();
		this.typeOfWorkDao = typeOfWorkDao;
	}

	@Override
	public DataResult<List<TypeOfWork>> getAll() {

		return new SuccessDataResult<List<TypeOfWork>>(this.typeOfWorkDao.findAll(), "İş pozisyonları listelendi.");
	}

	@Override
	public Result add(TypeOfWork typeOfWork) {
		this.typeOfWorkDao.save(typeOfWork);
		return new SuccessResult("İş pozisyonu bilgisi eklendi.");
	}

	@Override
	public DataResult<TypeOfWork> getWorkByTitle(String title) {
		return new SuccessDataResult<TypeOfWork>(this.typeOfWorkDao.findByTitle(title), "İş pozisyonları getirildi.");
	}

	@Override
	public Result delete(int id) {
		this.typeOfWorkDao.deleteById(id);
		return new SuccessResult("İş pozisyonu bilgisi silindi.");
	}

	@Override
	public Result update(TypeOfWork typeOfWork) {
		this.typeOfWorkDao.save(typeOfWork);
		return new SuccessResult("İş pozisyonu bilgisi güncellendi.");
	}

	@Override
	public DataResult<TypeOfWork> getById(int id) {
		return new SuccessDataResult<TypeOfWork>(this.typeOfWorkDao.getById(id));
	}

}