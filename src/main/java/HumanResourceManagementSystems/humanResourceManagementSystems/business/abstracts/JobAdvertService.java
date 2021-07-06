package HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts;

import java.util.List;

import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.JobAdvert;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.dtos.JobAdvertDto;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.dtos.JobAdvertFilterDto;

public interface JobAdvertService {

	Result add(JobAdvertDto jobAdvertDto);

	Result update(JobAdvert jobAdvert);

	Result delete(int id);

	Result changeOpenToClose(int id);

	Result activateAndConfirm(int id);

	Result updateconfirmStatus(int id);

	DataResult<JobAdvert> getById(int id);

	DataResult<List<JobAdvert>> getByEmployerId(int id);

	DataResult<List<JobAdvert>> getAll();

	DataResult<List<JobAdvert>> getAllOpenJobAdvertList();

	DataResult<List<JobAdvert>> getAllByOrderByPublishedAt();

	DataResult<List<JobAdvert>> getAllOpenJobAdvertByEmployer(int id);

	DataResult<List<JobAdvert>> getAllByIsActiveTrue();

	DataResult<List<JobAdvert>> getAllByIsActiveFalse();

	DataResult<List<JobAdvert>> getAllSorted();

	DataResult<List<JobAdvert>> getByisActiveTrueAndConfirmStatusTrue();

	DataResult<List<JobAdvert>> getByisActiveTrueAndConfirmStatusTrue(int pageNo, int pageSize);

	DataResult<List<JobAdvert>> getByisActiveTrueAndConfirmStatusTrueAndFilter(int pageNo, int pageSize,
			JobAdvertFilterDto jobAdvertFilterDto);
}
