package board.spring.mybatis;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardMybatisDAO {
	@Autowired
	SqlSession session;

	public void setSession(SqlSession session) {
		this.session = session;
	}

	public List<BoardVO> getAllBoard() {
		List<BoardVO> list = session.selectList("board.allboard");
		return list;
	}

	public List<BoardVO> boardPaging(int[] param) {
		List<BoardVO> list = session.selectList("board.boardpaging", param);
		return list;
	}

	public void boardWrite(BoardVO vo) {
		session.insert("board.boardwrite", vo);
	}

	public boolean confirmWriter(String writer) {
		if (session.selectOne("board.confirmwriter", writer) != null) {
			return true;
		} else {
			return false;
		}
	}

	public int totalBoardNumber() {
		return session.selectOne("board.totalboardnumber");
	}

	public void viewcountUp(int seq) {
		session.update("viewcountup", seq);
	}

	public BoardVO boardDetail(int seq) {
		return session.selectOne("boarddetail", seq);
	}

	public boolean confirmboardpassword(HashMap<String, Integer> map) {
		if (session.selectOne("confirmboardpassword", map) != null) {
			return true;
		} else {
			return false;
		}
	}

	public void boardUpdate(BoardVO vo) {
		session.update("boardupdate", vo);
	}

	public void boarddelete(int seq) {
		session.delete("boarddelete", seq);
	}

	public void memberInsert(MemberVO vo) {
		session.insert("member.memberinsert", vo);

	}

	public String memberConfirm(String userid) {
		return session.selectOne("member.memberconfirm", userid);
	}

}
