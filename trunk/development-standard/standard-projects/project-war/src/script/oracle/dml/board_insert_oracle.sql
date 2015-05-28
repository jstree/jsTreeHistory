/* 전경훈 시작 */
/* 게시판 테이블명은 동적으로 변동되야함 */
INSERT INTO T_BOARD_COMMENT_TEST (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE) VALUES ('1', '0', '0', '1', '4', '0', 'Root Node');
INSERT INTO T_BOARD_COMMENT_TEST (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE) VALUES ('2', '1', '0', '2', '3', '1', 'First Child Node', 'drive');

