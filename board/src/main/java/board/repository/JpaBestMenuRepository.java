package board.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import board.entity.BestMenu;

public interface JpaBestMenuRepository extends CrudRepository<BestMenu, Integer> {
	
	List<BestMenu> findAllByOrderByIdDesc();
}
