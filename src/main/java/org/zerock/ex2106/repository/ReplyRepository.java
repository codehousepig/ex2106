package org.zerock.ex2106.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.zerock.ex2106.entitiy.Board;
import org.zerock.ex2106.entitiy.Reply;

import java.util.List;

public interface ReplyRepository  extends JpaRepository<Reply, Long> {

    // Board 삭제시에 댓글들 삭제
    @Modifying
    @Query("delete from Reply r where r.board.bno = :bno")
    void deleteByBno(Long bno);

    // 게시글로 댓글 목록 가져오기
    List<Reply> getReplyByBoardOrderByRno(Board board);
}
