package HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts;

import java.util.List;


import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.JobAdvert;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.dtos.JobAdvertDto;

public interface JobAdvertService {

	Result add(JobAdvertDto jobAdvertDto);

	Result update(JobAdvert jobAdvert);

	Result delete(int id);

	Result changeOpenToClose(int id);

	DataResult<JobAdvert> getById(int id);

	DataResult<List<JobAdvert>> getAll();

	DataResult<List<JobAdvert>> getAllOpenJobAdvertList();

	DataResult<List<JobAdvert>> getAllByOrderByPublishedAt();

	DataResult<List<JobAdvert>> getAllOpenJobAdvertByEmployer(int id);
}
