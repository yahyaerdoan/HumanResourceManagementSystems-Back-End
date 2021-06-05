package HumanResourceManagementSystems.humanResourceManagementSystems.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.Image;

public interface ImageDao extends JpaRepository<Image, Integer> {

	Image getById(int id);

	Image getByJobseekerId(int id);
}
