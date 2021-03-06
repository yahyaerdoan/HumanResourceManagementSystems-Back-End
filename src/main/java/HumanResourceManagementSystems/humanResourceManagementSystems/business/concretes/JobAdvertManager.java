package HumanResourceManagementSystems.humanResourceManagementSystems.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.JobAdvertService;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.ErrorResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.SuccessDataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.SuccessResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.dataAccess.abstracts.CityDao;
import HumanResourceManagementSystems.humanResourceManagementSystems.dataAccess.abstracts.EmployerDao;
import HumanResourceManagementSystems.humanResourceManagementSystems.dataAccess.abstracts.JobAdvertDao;
import HumanResourceManagementSystems.humanResourceManagementSystems.dataAccess.abstracts.TypeOfWorkDao;
import HumanResourceManagementSystems.humanResourceManagementSystems.dataAccess.abstracts.TypeOfWorkplaceDao;
import HumanResourceManagementSystems.humanResourceManagementSystems.dataAccess.abstracts.WorkingTimeDao;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.JobAdvert;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.dtos.JobAdvertDto;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.dtos.JobAdvertFilterDto;

@Service
public class JobAdvertManager implements JobAdvertService {

	private CityDao cityDao;
	private EmployerDao employerDao;
	private JobAdvertDao jobAdvertDao;
	private TypeOfWorkDao typeOfWorkDao;
	private WorkingTimeDao workingTimeDao;
	private TypeOfWorkplaceDao typeOfWorkplaceDao;

	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao, CityDao cityDao, EmployerDao employerDao,
			TypeOfWorkDao typeOfWorkDao, WorkingTimeDao workingTimeDao, TypeOfWorkplaceDao typeOfWorkplaceDao) {
		super();
		this.jobAdvertDao = jobAdvertDao;
		this.cityDao = cityDao;
		this.employerDao = employerDao;
		this.typeOfWorkDao = typeOfWorkDao;
		this.workingTimeDao = workingTimeDao;
		this.typeOfWorkplaceDao = typeOfWorkplaceDao;
	}

	@Override
	public Result add(JobAdvertDto jobAdvertDto) {
		JobAdvert jobAdvert = new JobAdvert();
		jobAdvert.setCity(this.cityDao.getById(jobAdvertDto.getCityId()));
		jobAdvert.setEmployer(this.employerDao.getById(jobAdvertDto.getEmployerId()));
		jobAdvert.setTypeOfWork(this.typeOfWorkDao.getById(jobAdvertDto.getTypeOfWorkId()));
		jobAdvert.setWorkingTime(this.workingTimeDao.getById(jobAdvertDto.getWorkingTimeId()));
		jobAdvert.setTypeOfWorkplace(this.typeOfWorkplaceDao.getById(jobAdvertDto.getTypeOfWorkplaceId()));
		jobAdvert.setSalaryMin(jobAdvertDto.getSalaryMin());
		jobAdvert.setSalaryMax(jobAdvertDto.getSalaryMax());
		jobAdvert.setOpen(jobAdvertDto.isOpen());
		jobAdvert.setActive(jobAdvertDto.isActive());
		jobAdvert.setOpenPositionCount(jobAdvertDto.getOpenPositionCount());
		jobAdvert.setDescription(jobAdvertDto.getDescription());
		jobAdvert.setDeadline(jobAdvertDto.getDeadline());
		jobAdvert.setPublishedAt(jobAdvertDto.getPublishedAt());

		if (!CheckIfNullField(jobAdvert)) {
			return new ErrorResult("Eksik bilgi girdiniz. L??tfen b??t??n bo??luklar?? doldurun.");
		}
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("???? ilan?? eklendi.");
	}

	@Override
	public Result update(JobAdvert jobAdvert) {
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("???? ilan?? g??ncellendi.");
	}

	@Override
	public Result delete(int id) {
		this.jobAdvertDao.deleteById(id);
		return new SuccessResult("???? ilan?? silindi.");
	}

	@Override
	public DataResult<JobAdvert> getById(int id) {
		return new SuccessDataResult<JobAdvert>(this.jobAdvertDao.getById(id));
	}

	@Override
	public DataResult<List<JobAdvert>> getAll() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll());
	}

	@Override
	public Result changeOpenToClose(int id) {
		if (getById(id) == null) {
			return new ErrorResult("???? ilan?? bulunamad??.");

		}
		if (getById(id).getData().isOpen() == false) {
			return new ErrorResult("???? ilan?? kapal??.");
		}

		JobAdvert jobAdvert = getById(id).getData();
		jobAdvert.setOpen(false);
		update(jobAdvert);
		return new SuccessResult("???? ilan?? ba??ar??yla kapat??ld??.");
	}

	@Override
	public DataResult<List<JobAdvert>> getAllOpenJobAdvertList() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getAllOpenJobAdvertList());
	}

	@Override
	public DataResult<List<JobAdvert>> getAllByOrderByPublishedAt() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAllByOrderByPublishedAtDesc());
	}

	@Override
	public DataResult<List<JobAdvert>> getAllOpenJobAdvertByEmployer(int id) {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getAllOpenJobAdvertByEmployer(id));
	}

	private boolean CheckIfNullField(JobAdvert jobAdvert) {
		if (jobAdvert.getTypeOfWork() != null && jobAdvert.getDescription() != null && jobAdvert.getCity() != null
				&& jobAdvert.getOpenPositionCount() != 0) {
			return true;
		}
		return false;
	}

	@Override
	public Result activateAndConfirm(int id) {
		this.jobAdvertDao.activateAndConfirm(id);
		return new SuccessResult("i?? ilan?? aktif.");
	}

	@Override
	public DataResult<List<JobAdvert>> getAllByIsActiveFalse() {
		return new SuccessDataResult<List<JobAdvert>>(jobAdvertDao.getAllByIsActiveFalse());
	}

	@Override
	public DataResult<List<JobAdvert>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.ASC, "publishedAt");
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll(sort), "Success");
	}

	@Override
	public DataResult<List<JobAdvert>> getAllByIsActiveTrue() {
		return new SuccessDataResult<List<JobAdvert>>(jobAdvertDao.getAllByIsActiveTrue());
	}

	@Override
	public Result updateconfirmStatus(int id) {
		this.jobAdvertDao.updateconfirmStatus(id);
		return new SuccessResult("i?? ilan?? onayland??.");
	}

	@Override
	public DataResult<List<JobAdvert>> getByEmployerId(int id) {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByEmployerId(id));
	}

	@Override
	public DataResult<List<JobAdvert>> getByisActiveTrueAndConfirmStatusTrue() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByisActiveTrueAndConfirmStatusTrue());
	}

	@Override
	public DataResult<List<JobAdvert>> getByisActiveTrueAndConfirmStatusTrueAndFilter(int pageNo, int pageSize,
			JobAdvertFilterDto jobAdvertFilterDto) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		return new SuccessDataResult<List<JobAdvert>>(
				this.jobAdvertDao.getByFilter(jobAdvertFilterDto, pageable).getContent(),
				this.jobAdvertDao.getByFilter(jobAdvertFilterDto, pageable).getTotalElements() + "");
	}

	@Override
	public DataResult<List<JobAdvert>> getByisActiveTrueAndConfirmStatusTrue(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll(pageable).getContent());
	}

}
