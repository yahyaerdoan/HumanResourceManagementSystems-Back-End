package HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts;

import java.util.List;

import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.City;

public interface CityService {

	Result add(City city);

	Result delete(int id);

	Result update(City city);

	DataResult<City> getById(int id);

	DataResult<List<City>> getAll();
}
