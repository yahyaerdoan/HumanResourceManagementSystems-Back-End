package HumanResourceManagementSystems.humanResourceManagementSystems.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.ProgrammingSkill;

public interface ProgrammingSkillDao extends JpaRepository<ProgrammingSkill, Integer> {

	ProgrammingSkill getById(int id);

	List<ProgrammingSkill> getAllByJobseekerId(int id);
}
