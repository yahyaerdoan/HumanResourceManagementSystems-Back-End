package HumanResourceManagementSystems.humanResourceManagementSystems.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.SystemworkerService;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.Systemworker;

@Service
public class SystemworkerManager implements SystemworkerService{

	@Override
	public List<Systemworker> getAll() {
		
		return null;
	}

}
