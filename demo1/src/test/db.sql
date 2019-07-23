DROP DATABASE IF EXISTS a2;

CREATE DATABASE a2;

USE a2;

CREATE TABLE member (
    id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
    PRIMARY KEY(id),
    regDate DATETIME NOT NULL,
    loginId CHAR(100) NOT NULL,
    loginPw CHAR(100) NOT NULL,
    `name` CHAR(100) NOT NULL
    );
    
CREATE TABLE article (
    id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
    PRIMARY KEY(id),
    regDate DATETIME NOT NULL,
    title CHAR(100) NOT NULL,
    body TEXT NOT NULL,
    writer CHAR(100) NOT NULL,
    memberId INT(10) UNSIGNED NOT NULL,
    boardId INT(10) UNSIGNED NOT NULL
    );

CREATE TABLE articleReply (
    id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
    PRIMARY KEY(id),
    regDate DATETIME NOT NULL,
    body TEXT NOT NULL,
    writer CHAR(100) NOT NULL,
    memberId INT(10) UNSIGNED NOT NULL,
    boardId INT(10) UNSIGNED NOT NULL,
    articleId INT(10) UNSIGNED NOT NULL
    );
    
CREATE TABLE board (
    id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
    PRIMARY KEY(id),
    regDate DATETIME NOT NULL,
    `name` CHAR(100) NOT NULL
    );
    
INSERT INTO member(id, regDate, loginId, loginPw, `name`) VALUES(1, NOW(), 'user1', 'user1', '홍길동');
INSERT INTO member(id, regDate, loginId, loginPw, `name`) VALUES(2, NOW(), 'user2', 'user2', '임꺽정'); 

INSERT INTO article(id, regDate, writer, title, body, memberId, boardId) VALUES(1, NOW(), '홍길동', '제목1', '내용1', 1, 1);
INSERT INTO article(id, regDate, writer, title, body, memberId, boardId) VALUES(2, NOW(), '임꺽정', '제목1', '내용1', 2, 1);
INSERT INTO article(id, regDate, writer, title, body, memberId, boardId) VALUES(3, NOW(), '홍길동', '제목3', '내용3', 1, 2);

INSERT INTO articleReply(id, regDate, writer, articleId, boardId, memberId, body) VALUES(1, NOW(), '임꺽정', 1, 1, 2, '댓글 내용 1_1');
INSERT INTO articleReply(id, regDate, writer, articleId, boardId, memberId, body) VALUES(2, NOW(), '홍길동', 2, 1, 1, '댓글 내용 2_1');
INSERT INTO articleReply(id, regDate, writer, articleId, boardId, memberId, body) VALUES(3, NOW(), '임꺽정', 1, 1, 2, '댓글 내용 1_2');

INSERT INTO board(id, regDate, `name`) VALUES(1, NOW(), '공지사항');
INSERT INTO board(id, regDate, `name`) VALUES(2, NOW(), '자유게시판'); 