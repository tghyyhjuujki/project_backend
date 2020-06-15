package board.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import board.entity.TemplateEntity;

public interface JpaTemplateRepository extends CrudRepository<TemplateEntity, Integer> {
	
	List<TemplateEntity> findAllByOrderByIdDesc();
}
