package board.spring.mybatis;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardMybatisService implements BoardService {
	@Autowired
	BoardMybatisDAO dao;

	public void setDao(BoardMybatisDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<BoardVO> getAllEmp() {
		return dao.getAllBoard();
	}

	@Override
	public void boardWrite(BoardVO vo) {
		dao.boardWrite(vo);
	}

	@Override
	public int totalBoardNumber() {
		return dao.totalBoardNumber();
	}

	@Override
	public List<BoardVO> boardPaging(int[] param) {
		return dao.boardPaging(param);
	}

	@Override
	public void viewcountUp(int seq) {
		dao.viewcountUp(seq);

	}

	@Override
	public BoardVO boardDetail(int seq) {
		return dao.boardDetail(seq);

	}

	@Override
	public void boardUpdate(BoardVO vo) {
		dao.boardUpdate(vo);

	}

	@Override
	public boolean confirmBoardPassword(HashMap<String, Integer> map) {
		return dao.confirmboardpassword(map);
	}

	@Override
	public void boardDelete(int seq) {
		dao.boarddelete(seq);

	}

	@Override
	public boolean confirmWriter(String writer) {
		if (dao.confirmWriter(writer)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void memberInsert(MemberVO vo) {
		dao.memberInsert(vo);

	}

	@Override
	public String memberConfirm(String userid) {
		return dao.memberConfirm(userid);

	}

}
