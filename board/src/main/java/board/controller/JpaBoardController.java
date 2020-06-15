package board.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import board.entity.BoardEntity;
import board.entity.BoardFileEntity;
import board.service.JpaBoardService;


@Controller
@CrossOrigin(origins = "*") 
public class JpaBoardController {

	@Autowired
	private JpaBoardService jpaBoardService;

//	@RequestMapping(value = "/jpa/favorite", method = RequestMethod.GET)
//	public ModelAndView openFavorite() throws Exception {
//		ModelAndView mv = new ModelAndView("/board/jpaBoardList");
//		List<BoardEntity> list = jpaBoardService.selectFavorite();
//		mv.addObject("memberList", list);
//		return mv;
//	}
//	
//	@RequestMapping(value = "/jpa/board", method = RequestMethod.GET)
//	public ModelAndView openBoardList() throws Exception {
//		ModelAndView mv = new ModelAndView("/board/jpaBoardList");
//		List<BoardEntity> list = jpaBoardService.selectBoardList();
//		mv.addObject("memberList", list);
//		return mv;
//	}
//
//	@RequestMapping(value = "/api/store_list", method = RequestMethod.GET)
//	public String openBoardWrite() throws Exception {
//		return "/board/jpaBoardWrite";
//	}

//	@RequestMapping(value = "/api/store_list", method = RequestMethod.POST)
//	public void insertBoard(BoardEntity board, MultipartHttpServletRequest request) throws Exception {
//		jpaBoardService.saveBoard(board, request);
//	}

//	@RequestMapping(value = "/jpa/board/{boardIdx}", method = RequestMethod.GET)
//	public ModelAndView openBoardDetail(@PathVariable("boardIdx") int boardIdx) throws Exception {
//		ModelAndView mv = new ModelAndView("/board/jpaBoardDetail");
//		BoardEntity board = jpaBoardService.selectBoardDetail(boardIdx);
//		mv.addObject("board", board);
//		return mv;
//	}
//
//	@RequestMapping(value = "/jpa/board/{boardIdx}", method = RequestMethod.PUT)
//	public String updateBoard(BoardEntity board) throws Exception {
//		jpaBoardService.saveBoard(board, null);
//		return "redirect:/jpa/board";
//	}
//
//	@RequestMapping(value = "/jpa/board/{boardIdx}", method = RequestMethod.DELETE)
//	public String deleteBoard(@PathVariable("boardIdx") int boardIdx) throws Exception {
//		jpaBoardService.deleteBoard(boardIdx);
//		return "redirect:/jpa/board";
//	}

	@RequestMapping(value = "/jpa/board/file", method = RequestMethod.GET)
	public void downloadBoardFile(@RequestParam int idx, @RequestParam int boardIdx, HttpServletResponse response)
			throws Exception {
		BoardFileEntity boardFile = jpaBoardService.selectBoardFileInfo(idx, boardIdx);

		if (!ObjectUtils.isEmpty(boardFile)) {
			String fileName = boardFile.getOriginalFileName();

			byte[] files = FileUtils.readFileToByteArray(new File(boardFile.getStoredFilePath()));

			response.setContentType("application/octet-stream");
			response.setContentLength(files.length);

			response.setHeader("Content-Disposition",
					"attachment; filename=\"" + URLEncoder.encode(fileName, "UTF-8") + "\";");
			response.setHeader("Content-Transfer-Encoding", "binary");

			response.getOutputStream().write(files);
			response.getOutputStream().flush();
			response.getOutputStream().close();
		}
	}
	
}
