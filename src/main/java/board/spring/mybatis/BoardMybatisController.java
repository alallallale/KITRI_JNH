package board.spring.mybatis;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardMybatisController {
	@Autowired
	BoardService service;

	@RequestMapping(value = "/boardpaginglist")
	public ModelAndView boardList(@RequestParam(value = "num", required = false, defaultValue = "1") int num) {
		ModelAndView mav = new ModelAndView();

		int totalBoardNum = service.totalBoardNumber();
		int totalPageNumber = totalBoardNum / 5;
		if (totalBoardNum % 5 != 0) {
			totalPageNumber++;
		}

		// 가져올 번호들
		int[] param = new int[2];
		param[0] = num * 5 - 4;
		param[1] = num * 5;

		System.out.println("총 게시물 갯수 : " + totalBoardNum + "\n" + "보고싶은 페이지 수 : " + num);
		System.out.println("가지고 온 게시물 번호 : " + param[0] + "~" + param[1]);

		List<BoardVO> list = service.boardPaging(param);
		mav.addObject("list", list);
		mav.addObject("totalPageNumber", totalPageNumber);
		mav.setViewName("/boardpaginglist");
		return mav;
	}

	@RequestMapping(value = "/boardwrite")
	public ModelAndView boardWrite() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/boardwrite");
		return mav;
	}

	@RequestMapping(value = "/boardwrite", method = RequestMethod.POST)
	public String boardWrite(BoardVO vo) {
		// 현재 member 테이블이 없어서 확인할 수 없음
		System.out.println(vo);
		if (service.confirmWriter(vo.getWriter())) {
			vo.contents = vo.contents.replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;")
					.replaceAll("\n", "<br>");
			service.boardWrite(vo);

			return "/boardwritesuccess";

		} else {
			return "/memberinsert";
		}
	}

	@RequestMapping(value = "/boarddetail")
	public ModelAndView boardDetail(int seq) {
		service.viewcountUp(seq);
		ModelAndView mav = new ModelAndView();
		BoardVO vo = service.boardDetail(seq);
		String changeTime = new SimpleDateFormat("yyyy-MM-dd HH:MM:dd").format(vo.getTime());
		mav.addObject("changeTime", changeTime);
		mav.addObject("vo", vo);
		return mav;
	}

	@RequestMapping(value = "/boardupdate")
	public ModelAndView boardUpdate(int seq) {
		ModelAndView mav = new ModelAndView();
		BoardVO vo = service.boardDetail(seq);
		System.out.println(vo.toString());
		mav.addObject("vo", vo);
		mav.setViewName("/boardUpdate");
		return mav;
	}

	@RequestMapping(value = "boardupdate", method = RequestMethod.POST)
	public String boardUpdate(BoardVO vo) {
		// 현재 member 테이블이 없어서 확인할 수 없음
		if (service.confirmWriter(vo.getWriter())) {
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			map.put("seq", vo.getSeq());
			map.put("password", vo.getPassword());
			if (service.confirmBoardPassword(map)) {
				vo.contents = vo.contents.replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;")
						.replaceAll("\n", "<br>");
				service.boardUpdate(vo);
				return "/boardupdatesuccess";
			} else {
				return "/boardupdatefail";
			}
		} else {
			return "/memberinsert";
		}
	}

	@RequestMapping(value = "/boardwritesuccess")
	public String boardWriteSuccess() {
		return "/boardwritesuccess";
	}

	@RequestMapping(value = "/boardwritefail")
	public String boardWriteFail() {
		return "/boardwritefail";
	}

	@RequestMapping(value = "/boarddelete")
	public String boardDelete(int seq) {
		service.boardDelete(seq);
		return "/boarddelete";
	}

	@RequestMapping(value = "/memberinsert")
	public String memberInsert() {
		return "/memberinsert";
	}

	@RequestMapping(value = "/memberinsert", method = RequestMethod.POST)
	public String memberInsert(MemberVO vo) {
		if (service.memberConfirm(vo.getUserid()) != null) {
			return "/memberoverlap";
		} else {
			service.memberInsert(vo);
			return "/membersuccess";

		}
	}

}
