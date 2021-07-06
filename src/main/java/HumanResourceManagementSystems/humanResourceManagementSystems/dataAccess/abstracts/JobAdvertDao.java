package HumanResourceManagementSystems.humanResourceManagementSystems.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.JobAdvert;
import HumanResourceManagementSystems.humanResourceManagementSystems.entities.dtos.JobAdvertFilterDto;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer> {

	@Query("From JobAdvert where isOpen = true")
	List<JobAdvert> getAllOpenJobAdvertList();

	@Query("From JobAdvert where isOpen = true Order By publishedAt Desc")
	List<JobAdvert> findAllByOrderByPublishedAtDesc();

	@Query("From JobAdvert where isOpen = true and employer_id =:id")
	List<JobAdvert> getAllOpenJobAdvertByEmployer(int id);

	JobAdvert getById(int id);

	List<JobAdvert> getByEmployerId(int id);

	@Modifying
	@Query("Update JobAdvert set isActive=true where id=:id")
	int activateAndConfirm(@Param("id") int id);

	@Modifying
	@Query("update JobAdvert set confirmStatus=true where id=:id")
	int updateconfirmStatus(@Param("id") int id);

	List<JobAdvert> getAllByIsActiveFalse();

	List<JobAdvert> getAllByIsActiveTrue();

	List<JobAdvert> getByisActiveTrueAndConfirmStatusTrue();

	@Query("Select j from HumanResourceManagementSystems.humanResourceManagementSystems.entities.concretes.JobAdvert "
			+ "j where ((:#{#filter.cityId}) IS NULL OR j.city.id IN (:#{#filter.cityId}))"
			+ " and ((:#{#filter.typeOfWorkId}) IS NULL OR j.typeOfWork.id IN (:#{#filter.typeOfWorkId}))"
			+ " and ((:#{#filter.typeOfWorkplaceId}) IS NULL OR j.typeOfWorkplace.id IN (:#{#filter.typeOfWorkplaceId}))"
			+ " and ((:#{#filter.workingTimeId}) IS NULL OR j.workingTime.id IN (:#{#filter.workingTimeId}))"
			+ " and j.isActive=true")
	public Page<JobAdvert> getByFilter(@Param("filter") JobAdvertFilterDto jobAdvertFilterDto, Pageable pageable);
}
