package board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import board.entity.BookerUsers;
import board.service.JpaBoardService;

// @RestController = @Controller + @ResponseBody
// 요청 처리 결과를 JSON 형식의 데이터를 포함한 응답 본문으로 전송 
@CrossOrigin(origins = "*") 
@RestController
public class RestApiBoardController {
	
	@Autowired
	private JpaBoardService jpaBoardService;
	

	@RequestMapping(value = "/api/users", method = RequestMethod.GET)
	public List<BookerUsers> openBookerUsersList() throws Exception {
		return jpaBoardService.selectBookerUsersList();
	}
	
//	// @RequestBody --> 요청 파라미터가 HTTP 본문에 포함되어 있음
//	//                  POST, PUT 방식을 처리할 때 사용
	@RequestMapping(value = "/api/users", method = RequestMethod.POST)
	public void saveBoard(@RequestBody BookerUsers bookerUsers) throws Exception {
		jpaBoardService.saveBookerUsers(bookerUsers, null);
	}
//
//	@RequestMapping(value = "/api/board/{boardIdx}", method = RequestMethod.GET)
//	public BoardDto openBoardDetail(@PathVariable("boardIdx") int boardIdx) throws Exception {
//		return boardService.selectBoardDetail(boardIdx);
//	}
//
//	@RequestMapping(value = "/api/board/{boardIdx}", method = RequestMethod.PUT)
//	public BoardDto updateBoard(@RequestBody BoardDto board) throws Exception {
//		boardService.updateBoard(board);
//		int boardIdx = board.getBoardIdx();
//		return boardService.selectBoardDetail(boardIdx);
//	}
//
//	@RequestMapping(value = "/api/board/{boardIdx}", method = RequestMethod.DELETE)
//	public HashMap deleteBoard(@PathVariable("boardIdx") int boardIdx) throws Exception {
//		HashMap hm = new HashMap();
//		try {
//			boardService.deleteBoard(boardIdx);
//			hm.put("result", "success");
//		} catch (Exception e) {
//			hm.put("reusult", "fail");
//			throw e;
//		}
//		return hm;
//	}
}
