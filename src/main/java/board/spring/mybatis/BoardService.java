package board.spring.mybatis;

import java.util.HashMap;
import java.util.List;

public interface BoardService {
	// 모든 게시판 조회 서비스
	public List<BoardVO> getAllEmp();

	// 페이지에 따른 게시판 조회 서비스
	public List<BoardVO> boardPaging(int[] param);

	// 게시판 작성
	public void boardWrite(BoardVO vo);

	public int totalBoardNumber();

	public void viewcountUp(int seq);

	public BoardVO boardDetail(int seq);

	public void boardUpdate(BoardVO vo);

	public boolean confirmBoardPassword(HashMap<String, Integer> map);

	public void boardDelete(int seq);

	public boolean confirmWriter(String writer);

	public void memberInsert(MemberVO vo);

	public String memberConfirm(String userid);
}
