package HumanResourceManagementSystems.humanResourceManagementSystems.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.Favorite;

public interface FavoriteDao extends JpaRepository<Favorite, Integer> {

	Favorite getById(int id);

	Favorite findByJobSeekerIdAndJobAdvertId(int jobSeekerId, int jobAdvertId);

	List<Favorite> getAllByJobSeekerId(int id);	
}
