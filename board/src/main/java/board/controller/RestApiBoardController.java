package board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import board.entity.BestMenu;
import board.entity.BoardEntity;
import board.entity.TemplateEntity;
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
	
	@RequestMapping(value = "/api/store_list", method = RequestMethod.POST)
	public void saveBoard(@RequestBody BoardEntity board) throws Exception {
		jpaBoardService.saveFirstBoard(board);
	}
	
	@RequestMapping(value = "/api/store_list/{storeNumber}", method = RequestMethod.GET)
	public List<BoardEntity> openBoardListStoreNum(@PathVariable("storeNumber") String storeNumber) throws Exception {
		return jpaBoardService.selectBoardListStoreNum(storeNumber);
	}
	
	//best menu
	@RequestMapping(value = "/api/best_menu", method = RequestMethod.GET)
	public List<BestMenu> openBestMenuList() throws Exception {
		return jpaBoardService.selectBestMenuList();
	}
	@RequestMapping(value = "/api/best_menu", method = RequestMethod.POST)
	public void saveBestMenu(@RequestBody BestMenu bestMenu) throws Exception {
		jpaBoardService.saveBestMenu(bestMenu);
	}
	
	//template
	@RequestMapping(value = "/api/template", method = RequestMethod.GET)
	public List<TemplateEntity> openTemplate() throws Exception {
		return jpaBoardService.selectTemplateList();
	}
	@RequestMapping(value = "/api/template", method = RequestMethod.POST)
	public void saveTemplate(@RequestBody TemplateEntity templateEntity) throws Exception {
		jpaBoardService.saveTemplate(templateEntity);
	}
}
