package HumanResourceManagementSystems.humanResourceManagementSystems.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.ForeignLanguageService;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.SuccessDataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.SuccessResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.dataAccess.abstracts.ForeignLanguageDao;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.ForeignLanguage;

@Service
public class ForeignLanguageManager implements ForeignLanguageService {

	private ForeignLanguageDao foreignLanguageDao;

	@Autowired
	public ForeignLanguageManager(ForeignLanguageDao foreignLanguageDao) {
		super();
		this.foreignLanguageDao = foreignLanguageDao;
	}

	@Override
	public Result add(ForeignLanguage foreignLanguage) {

		this.foreignLanguageDao.save(foreignLanguage);
		return new SuccessResult("Yabancı dil bilgisi eklendi.");
	}

	@Override
	public DataResult<ForeignLanguage> getById(int id) {
		return new SuccessDataResult<ForeignLanguage>(this.foreignLanguageDao.getById(id));
	}

	@Override
	public DataResult<List<ForeignLanguage>> getAllByJobSeekerId(int id) {
		return new SuccessDataResult<List<ForeignLanguage>>(this.foreignLanguageDao.getAllByJobSeekerId(id));
	}

	@Override
	public Result delete(int id) {
		this.foreignLanguageDao.deleteById(id);
		return new SuccessResult("Yabancı dil bilgisi silindi.");
	}

	@Override
	public Result update(ForeignLanguage foreignLanguage) {
		this.foreignLanguageDao.save(foreignLanguage);
		return new SuccessResult("Yabancı dil bilgisi güncellendi.");
	}

	@Override
	public DataResult<List<ForeignLanguage>> getAll() {
		return new SuccessDataResult<List<ForeignLanguage>>(this.foreignLanguageDao.findAll());
	}

}
