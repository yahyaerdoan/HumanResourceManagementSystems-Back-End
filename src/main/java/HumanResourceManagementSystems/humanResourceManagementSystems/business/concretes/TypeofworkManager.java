package HumanResourceManagementSystems.humanResourceManagementSystems.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.TypeofworkService;
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
	public List<Typeofwork> getAll() {
		
		return this.typeofworkDao.findAll();
	}
	
}