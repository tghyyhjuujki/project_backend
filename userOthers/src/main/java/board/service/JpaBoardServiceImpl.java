package board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import board.entity.BookTable;
import board.repository.JpaBookerUsersRepository;

@Service
public class JpaBoardServiceImpl implements JpaBoardService {

	
	@Autowired
	JpaBookerUsersRepository jpaBookerUsersRepository;
	
	
	@Override
	public List<BookTable> selectBookerUsersList() throws Exception {
		return (List<BookTable>) jpaBookerUsersRepository.findAll();
	}
	
	@Override
	public List<BookTable> selectBookerUsersListStoreNum(String store_number) throws Exception {
		return jpaBookerUsersRepository.findAllByStoreNumber(store_number);
	}
	
//	@Override
//	public List<BoardEntity> selectFavorite() throws Exception {
//		return jpaBoardRepository.findAllByHitCntGreaterThanEqual(5);
//	}	
//	
	

	// 	save = insert, update
	@Override
	public void saveBookerUsers(BookTable bookTable, MultipartHttpServletRequest request) throws Exception {
		// 필수 항목(not null)인 작성자 ID를 설정
//		board.setCreatorId("admin");
//		
//		// 첨부 파일 처리
//		List<BoardFileEntity> files = fileUtils.parseFileInfo2(board.getBoardIdx(), request);
//		if (!CollectionUtils.isEmpty(files)) {
//			board.setFileInfoList(files);
//		}
		bookTable.setStoreNumber("1");
		jpaBookerUsersRepository.save(bookTable);		
	}

@Override
public void deleteBoard(int boardIdx) throws Exception {
	// TODO Auto-generated method stub
	
}


//	@Override
//	public BoardEntity selectBoardDetail(int boardIdx) throws Exception {
//		Optional<BoardEntity> optional = jpaBoardRepository.findById(boardIdx);
//		if (optional.isPresent()) {
//			BoardEntity board = optional.get();
//			
//			//	게시판 상세 정보에서 조회 회수를 1 증가해서 업데이트
//			board.setHitCnt(board.getHitCnt() + 1);
//			jpaBoardRepository.save(board);
//			
//			return board;			
//		} else {
//			throw new NullPointerException();
//		}
//	}
}
