package HumanResourceManagementSystems.humanResourceManagementSystems.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HumanResourceManagementSystems.humanResourceManagementSystems.business.abstracts.LinkService;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.DataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.Result;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.SuccessDataResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.core.utilities.results.SuccessResult;
import HumanResourceManagementSystems.humanResourceManagementSystems.dataAccess.abstracts.LinkDao;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.Link;

@Service
public class LinkManager implements LinkService {

	private LinkDao linkDao;

	@Autowired
	public LinkManager(LinkDao linkDao) {
		super();
		this.linkDao = linkDao;
	}

	@Override
	public Result add(Link link) {
		this.linkDao.save(link);
		return new SuccessResult("Bağlantı adresi eklendi.");
	}

	@Override
	public DataResult<Link> getById(int id) {
		return new SuccessDataResult<Link>(this.linkDao.getById(id));
	}

	@Override
	public DataResult<List<Link>> getAllByJobSeekerId(int id) {
		return new SuccessDataResult<List<Link>>(this.linkDao.getAllByJobSeekerId(id));
	}

}
