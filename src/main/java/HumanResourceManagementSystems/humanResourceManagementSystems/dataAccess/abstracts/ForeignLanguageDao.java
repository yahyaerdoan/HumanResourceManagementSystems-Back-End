package HumanResourceManagementSystems.humanResourceManagementSystems.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.ForeignLanguage;

public interface ForeignLanguageDao extends JpaRepository<ForeignLanguage, Integer> {

	ForeignLanguage getById(int id);

	List<ForeignLanguage> getAllByJobseekerId(int id);
}
