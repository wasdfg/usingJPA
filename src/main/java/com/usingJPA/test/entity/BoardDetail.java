package com.usingJPA.test.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Getter;

@Entity
@Getter
public class BoardDetail {
    @Id
    private Long boardId;

    @MapsId
    @OneToOne
    @JoinColumn(name="BOARD_ID")
    private Board board;

    private String content;

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
