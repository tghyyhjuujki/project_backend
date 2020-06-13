package board.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import board.entity.BoardEntity;
import board.service.JpaBoardService;

// @RestController = @Controller + @ResponseBody
// 요청 처리 결과를 JSON 형식의 데이터를 포함한 응답 본문으로 전송 
@RestController
@CrossOrigin(origins = "*")
public class RestApiBoardController {
	
	@Autowired
	private JpaBoardService jpaBoardService;
	
	@RequestMapping(value = "/api/store_list", method = RequestMethod.GET)
	public List<BoardEntity> openBoardList() throws Exception {
		return jpaBoardService.selectBoardList();
	}
}
