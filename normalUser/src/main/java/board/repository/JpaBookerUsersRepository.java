package board.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import board.entity.BookerUsers;

public interface JpaBookerUsersRepository extends CrudRepository<BookerUsers, Integer> {
	List<BookerUsers> findAllByOrderByIdDesc();
}
