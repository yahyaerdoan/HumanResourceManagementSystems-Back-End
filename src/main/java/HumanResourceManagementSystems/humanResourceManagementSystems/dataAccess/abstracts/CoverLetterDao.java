package HumanResourceManagementSystems.humanResourceManagementSystems.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.CoverLetter;

public interface CoverLetterDao extends JpaRepository<CoverLetter, Integer> {

	CoverLetter getById(int id);
}
