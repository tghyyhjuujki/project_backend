package board.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import board.common.FileUtils;
import board.entity.BestMenu;
import board.entity.BoardEntity;
import board.entity.BoardFileEntity;
import board.entity.TemplateEntity;
import board.repository.JpaBestMenuRepository;
import board.repository.JpaBoardRepository;
import board.repository.JpaTemplateRepository;

@Service
public class JpaBoardServiceImpl implements JpaBoardService {
	
	@Autowired
	JpaBoardRepository jpaBoardRepository;
	
	@Autowired
	JpaBestMenuRepository jpaBestMenuRepository;
	
	@Autowired
	JpaTemplateRepository jpaTemplateRepository;

	@Autowired 
	FileUtils fileUtils;
	
//	@Override
//	public List<BoardEntity> selectFavorite() throws Exception {
//		return jpaBoardRepository.findAllByHitCntGreaterThanEqual(5);
//	}	
	
	@Override
	public List<BoardEntity> selectBoardList() throws Exception {
		return jpaBoardRepository.findAllByOrderByBoardIdxDesc();
	}
	
	//BestMenu
	@Override
	public List<BestMenu> selectBestMenuList() throws Exception {
		return jpaBestMenuRepository.findAllByOrderByIdDesc();
	}
	@Override
	public void saveBestMenu(BestMenu bestMenu) throws Exception {
		jpaBestMenuRepository.save(bestMenu);		
	}
	
	//Template
	@Override
	public List<TemplateEntity> selectTemplateList() throws Exception {
		return jpaTemplateRepository.findAllByOrderByIdDesc();
	}
	@Override
	public void saveTemplate(TemplateEntity templateEntity) throws Exception {
		jpaTemplateRepository.save(templateEntity);		
	}

	
	@Override
	public List<BoardEntity> selectBoardListStoreNum(String storeNumber) throws Exception {
		return jpaBoardRepository.findAllByStoreNumber(storeNumber);
	}

	// 	save = insert, update
	@Override
	public void saveBoard(BoardEntity board, MultipartHttpServletRequest request) throws Exception {
		// 필수 항목(not null)인 작성자 ID를 설정
		board.setCreatorId("admin");
		
		// 첨부 파일 처리
		List<BoardFileEntity> files = fileUtils.parseFileInfo2(board.getBoardIdx(), request);
		if (!CollectionUtils.isEmpty(files)) {
			board.setFileInfoList(files);
		}
		//jpaBoardRepository.findAllByStoreNumber(storeNumber);
		jpaBoardRepository.save(board);		
	}
	
	@Override
	public void saveFirstBoard(BoardEntity board) throws Exception {
		jpaBoardRepository.save(board);		
	}

	@Override
	public BoardEntity selectBoardDetail(int boardIdx) throws Exception {
		Optional<BoardEntity> optional = jpaBoardRepository.findById(boardIdx);
		if (optional.isPresent()) {
			BoardEntity board = optional.get();
			jpaBoardRepository.save(board);
			
			return board;			
		} else {
			throw new NullPointerException();
		}
	}

	@Override
	public void deleteBoard(int boardIdx) throws Exception {
		jpaBoardRepository.deleteById(boardIdx);
	}

	@Override
	public BoardFileEntity selectBoardFileInfo(int idx, int boardIdx) throws Exception {
		BoardFileEntity boardFile = jpaBoardRepository.findBoardFile(boardIdx, idx);
		return boardFile;
	}


}
