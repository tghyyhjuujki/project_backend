package board.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import board.entity.BookTable;

public interface JpaBoardService {
	
	List<BookTable> selectBookerUsersList() throws Exception;
	List<BookTable> selectBookerUsersListStoreNum(String store_number) throws Exception;
	void saveBookerUsers(BookTable bookTable, MultipartHttpServletRequest request) throws Exception;
	
	
//	List<BoardEntity> selectFavorite() throws Exception;
	
	 
//	BoardEntity selectBoardDetail(int boardIdx) throws Exception;
	
	/*
	void insertBoard(BoardEntity board, MultipartHttpServletRequest request) throws Exception;
	void updateBoard(BoardEntity board) throws Exception;
	*/
	
	// save가 insert와 update 역할을 모두 수행
	
	
	void deleteBoard(int boardIdx) throws Exception;
}
