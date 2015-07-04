/* 바로보드 게시판 개별설정 */
CREATE TABLE MY_SCHEMA.T_BOARD_CONFIG (
	C_ID NUMBER NOT NULL, /* 노드아이디 */
	C_PARENTID NUMBER NOT NULL, /* 부모노드아이디 */
	C_POSITION NUMBER NOT NULL, /* 노드포지션 */
	C_LEFT NUMBER NOT NULL, /* 노드좌측끝포인트 */
	C_RIGHT NUMBER NOT NULL, /* 노드우측끝포인트 */
	C_LEVEL NUMBER NOT NULL, /* 노드DEPTH */
	C_TITLE VARCHAR2(4000), /* 게시판명 */
	C_TYPE VARCHAR2(4000), /* 노드타입 */
	C_BOARD_USE_FL CHAR(1) DEFAULT 1, /* 게시판 사용여부 */
	C_BOARD_TYPE NUMBER, /* 게시판 유형 */
	C_BOARD_TABLE_NAME VARCHAR2(20), /* 게시판 테이블명 */
	C_POSTING_CNT_PER_PAGE NUMBER DEFAULT 20, /* 페이지당목록수 */
	C_LEVEL_FOR_VIEW_LIST NUMBER, /* 목록보기권한 */
	C_LEVEL_FOR_READ_CONTENT NUMBER, /* 글읽기권한 */
	C_LEVEL_FOR_POSTING NUMBER, /* 글쓰기권한 */
	C_LEVEL_FOR_REPLY NUMBER, /* 글답변권한 */
	C_LEVEL_FOR_COMMENT NUMBER, /* 댓글쓰기권한 */
	C_LEVEL_FOR_CLIPPING NUMBER, /* 링크권한 */
	C_LEVEL_FOR_FILE_UPLOAD NUMBER, /* 업로드권한 */
	C_LEVEL_FOR_FILE_DOWNLOAD NUMBER, /* 다운로드권한 */
	C_COMMENT_CNT_FOR_BAN_DELETION NUMBER DEFAULT 5, /* 원글삭제불가여부 */
	C_COMMENT_CNT_FOR_BAN_EDITING NUMBER DEFAULT 10, /* 원글수정불가여부 */
	C_USE_WRITTING_ANONYM_FL CHAR(1) DEFAULT 0, /* 비밀글적용여부 */
	C_REG_DT VARCHAR2(14) /* 생성일시 */
);

COMMENT ON TABLE MY_SCHEMA.T_BOARD_CONFIG IS '바로보드 게시판 개별설정';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_CONFIG.C_ID IS '노드아이디';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_CONFIG.C_PARENTID IS '부모노드아이디';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_CONFIG.C_POSITION IS '노드포지션';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_CONFIG.C_LEFT IS '노드좌측끝포인트';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_CONFIG.C_RIGHT IS '노드우측끝포인트';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_CONFIG.C_LEVEL IS '노드DEPTH';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_CONFIG.C_TITLE IS '게시판명';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_CONFIG.C_TYPE IS '노드타입';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_CONFIG.C_BOARD_USE_FL IS '게시판 사용여부';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_CONFIG.C_BOARD_TYPE IS '게시판 유형';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_CONFIG.C_BOARD_TABLE_NAME IS '게시판 테이블명';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_CONFIG.C_POSTING_CNT_PER_PAGE IS '페이지당목록수';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_CONFIG.C_LEVEL_FOR_VIEW_LIST IS '목록보기권한';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_CONFIG.C_LEVEL_FOR_READ_CONTENT IS '글읽기권한';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_CONFIG.C_LEVEL_FOR_POSTING IS '글쓰기권한';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_CONFIG.C_LEVEL_FOR_REPLY IS '글답변권한';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_CONFIG.C_LEVEL_FOR_COMMENT IS '댓글쓰기권한';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_CONFIG.C_LEVEL_FOR_CLIPPING IS '링크권한';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_CONFIG.C_LEVEL_FOR_FILE_UPLOAD IS '업로드권한';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_CONFIG.C_LEVEL_FOR_FILE_DOWNLOAD IS '다운로드권한';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_CONFIG.C_COMMENT_CNT_FOR_BAN_DELETION IS '원글삭제불가여부';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_CONFIG.C_COMMENT_CNT_FOR_BAN_EDITING IS '원글수정불가여부';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_CONFIG.C_USE_WRITTING_ANONYM_FL IS '비밀글적용여부';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_CONFIG.C_REG_DT IS '생성일시';

CREATE UNIQUE INDEX MY_SCHEMA.PK_T_BOARD_CONFIG
	ON MY_SCHEMA.T_BOARD_CONFIG (
		C_ID ASC
	);

ALTER TABLE MY_SCHEMA.T_BOARD_CONFIG
	ADD
		CONSTRAINT PK_T_BOARD_CONFIG
		PRIMARY KEY (
			C_ID
		);

/* 게시판 */
CREATE TABLE MY_SCHEMA.TABLE2 (
);

COMMENT ON TABLE MY_SCHEMA.TABLE2 IS '게시판';

/* 게시판 첨부파일 */
CREATE TABLE MY_SCHEMA.TABLE3 (
);

COMMENT ON TABLE MY_SCHEMA.TABLE3 IS '게시판 첨부파일';

/* 게시판 댓글 */
CREATE TABLE MY_SCHEMA.TABLE4 (
);

COMMENT ON TABLE MY_SCHEMA.TABLE4 IS '게시판 댓글';

/* 게시판 좋아요 */
CREATE TABLE MY_SCHEMA.TABLE5 (
);

COMMENT ON TABLE MY_SCHEMA.TABLE5 IS '게시판 좋아요';

/* 바로보드 게시판 */
CREATE TABLE MY_SCHEMA.T_BOARD (
	C_ID NUMBER NOT NULL, /* 노드아이디 */
	C_PARENTID NUMBER NOT NULL, /* 부모노드아이디 */
	C_POSITION NUMBER NOT NULL, /* 노드포지션 */
	C_LEFT NUMBER NOT NULL, /* 노드좌측끝포인트 */
	C_RIGHT NUMBER NOT NULL, /* 노드우측끝포인트 */
	C_LEVEL NUMBER NOT NULL, /* 노드DEPTH */
	C_TITLE VARCHAR2(4000), /* 글제목 */
	C_TYPE VARCHAR2(4000), /* 노드타입 */
	C_ROOT_ARTICLE_ID NUMBER, /* 루트글아이디 */
	C_REG_ID NUMBER NOT NULL, /* 글쓴이 */
	C_CONTENT CLOB, /* 내용 */
	C_ALLOW_COMMENT_FL CHAR(1), /* 코멘트허용여부 */
	C_ALLOW_REPLY_FL CHAR(1), /* 댓글허용여부 */
	C_ALLOW_TRACKBACK_FL CHAR(1), /* 엮인글허용여부 */
	C_ALERT_RESPONSE_FL CHAR(1), /* 알림여부 */
	C_OPEN_ARTICLE_FL CHAR(1), /* 글공개여부 */
	C_ANNOUNCEMENT_FL CHAR(1), /* 공지글여부 */
	C_VIEW_CNT NUMBER, /* 조회수 */
	C_IS_DELETED_FL CHAR(1), /* 삭제여부 */
	C_REG_DT VARCHAR2(14), /* 생성일시 */
	C_MOD_DT VARCHAR2(14) /* 수정일시 */
);

COMMENT ON TABLE MY_SCHEMA.T_BOARD IS '바로보드 게시판';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD.C_ID IS '노드아이디';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD.C_PARENTID IS '부모노드아이디';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD.C_POSITION IS '노드포지션';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD.C_LEFT IS '노드좌측끝포인트';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD.C_RIGHT IS '노드우측끝포인트';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD.C_LEVEL IS '노드DEPTH';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD.C_TITLE IS '글제목';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD.C_TYPE IS '노드타입';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD.C_ROOT_ARTICLE_ID IS '루트글아이디';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD.C_REG_ID IS '글쓴이';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD.C_CONTENT IS '내용';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD.C_ALLOW_COMMENT_FL IS '코멘트허용여부';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD.C_ALLOW_REPLY_FL IS '댓글허용여부';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD.C_ALLOW_TRACKBACK_FL IS '엮인글허용여부';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD.C_ALERT_RESPONSE_FL IS '알림여부';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD.C_OPEN_ARTICLE_FL IS '글공개여부';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD.C_ANNOUNCEMENT_FL IS '공지글여부';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD.C_VIEW_CNT IS '조회수';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD.C_IS_DELETED_FL IS '삭제여부';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD.C_REG_DT IS '생성일시';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD.C_MOD_DT IS '수정일시';

CREATE UNIQUE INDEX MY_SCHEMA.PK_T_BOARD
	ON MY_SCHEMA.T_BOARD (
		C_ID ASC
	);

ALTER TABLE MY_SCHEMA.T_BOARD
	ADD
		CONSTRAINT PK_T_BOARD
		PRIMARY KEY (
			C_ID
		);

/* 바로보드 게시판 첨부파일 */
CREATE TABLE MY_SCHEMA.T_BOARD_FILE (
	C_ID NUMBER NOT NULL, /* 노드아이디 */
	C_PARENTID NUMBER NOT NULL, /* 부모노드아이디 */
	C_POSITION NUMBER NOT NULL, /* 노드포지션 */
	C_LEFT NUMBER NOT NULL, /* 노드좌측끝포인트 */
	C_RIGHT NUMBER NOT NULL, /* 노드우측끝포인트 */
	C_LEVEL NUMBER NOT NULL, /* 노드DEPTH */
	C_TITLE VARCHAR2(4000), /* 원본파일이름 */
	C_TYPE VARCHAR2(4000), /* 노드타입 */
	C_ARTICLE_ID NUMBER NOT NULL, /* 글번호 */
	C_SAVED_FILE_NM VARCHAR2(50), /* 저장파일이름 */
	C_EXTENSION NUMBER, /* 파일확장자 */
	C_ATTACH_FILE NUMBER, /* 파일첨부유형 */
	C_REG_DT VARCHAR2(14) /* 생성일시 */
);

COMMENT ON TABLE MY_SCHEMA.T_BOARD_FILE IS '바로보드 게시판 첨부파일';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_FILE.C_ID IS '노드아이디';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_FILE.C_PARENTID IS '부모노드아이디';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_FILE.C_POSITION IS '노드포지션';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_FILE.C_LEFT IS '노드좌측끝포인트';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_FILE.C_RIGHT IS '노드우측끝포인트';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_FILE.C_LEVEL IS '노드DEPTH';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_FILE.C_TITLE IS '원본파일이름';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_FILE.C_TYPE IS '노드타입';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_FILE.C_ARTICLE_ID IS '글번호';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_FILE.C_SAVED_FILE_NM IS '저장파일이름';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_FILE.C_EXTENSION IS '파일확장자';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_FILE.C_ATTACH_FILE IS '파일첨부유형';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_FILE.C_REG_DT IS '생성일시';

CREATE UNIQUE INDEX MY_SCHEMA.PK_T_BOARD_FILE
	ON MY_SCHEMA.T_BOARD_FILE (
		C_ID ASC
	);

ALTER TABLE MY_SCHEMA.T_BOARD_FILE
	ADD
		CONSTRAINT PK_T_BOARD_FILE
		PRIMARY KEY (
			C_ID
		);

/* 바로보드 댓글 */
CREATE TABLE MY_SCHEMA.T_BOARD_COMMENT (
	C_ID NUMBER NOT NULL, /* 노드아이디 */
	C_PARENTID NUMBER NOT NULL, /* 부모노드아이디 */
	C_POSITION NUMBER NOT NULL, /* 노드포지션 */
	C_LEFT NUMBER NOT NULL, /* 노드좌측끝포인트 */
	C_RIGHT NUMBER NOT NULL, /* 노드우측끝포인트 */
	C_LEVEL NUMBER NOT NULL, /* 노드DEPTH */
	C_TITLE VARCHAR2(4000), /* 댓글내용 */
	C_TYPE VARCHAR2(4000), /* 노드타입 */
	C_ARTICLE_ID NUMBER, /* 글번호 */
	C_REG_ID NUMBER, /* 작성자아이디 */
	C_VIEW_ONLY_REG_ID_FL CHAR(1), /* 작성자만보기여부 */
	C_REG_DT VARCHAR2(14), /* 생성일시 */
	C_MOD_DT VARCHAR2(14) /* 수정일시 */
);

COMMENT ON TABLE MY_SCHEMA.T_BOARD_COMMENT IS '바로보드 댓글';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_COMMENT.C_ID IS '노드아이디';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_COMMENT.C_PARENTID IS '부모노드아이디';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_COMMENT.C_POSITION IS '노드포지션';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_COMMENT.C_LEFT IS '노드좌측끝포인트';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_COMMENT.C_RIGHT IS '노드우측끝포인트';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_COMMENT.C_LEVEL IS '노드DEPTH';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_COMMENT.C_TITLE IS '댓글내용';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_COMMENT.C_TYPE IS '노드타입';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_COMMENT.C_ARTICLE_ID IS '글번호';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_COMMENT.C_REG_ID IS '작성자아이디';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_COMMENT.C_VIEW_ONLY_REG_ID_FL IS '작성자만보기여부';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_COMMENT.C_REG_DT IS '생성일시';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_COMMENT.C_MOD_DT IS '수정일시';

CREATE UNIQUE INDEX MY_SCHEMA.PK_T_BOARD_COMMENT
	ON MY_SCHEMA.T_BOARD_COMMENT (
		C_ID ASC
	);

ALTER TABLE MY_SCHEMA.T_BOARD_COMMENT
	ADD
		CONSTRAINT PK_T_BOARD_COMMENT
		PRIMARY KEY (
			C_ID
		);

/* 기본 CONTENTS 설정 */
CREATE TABLE MY_SCHEMA.T_CONTENTS (
	C_ID NUMBER NOT NULL, /* 노드아이디 */
	C_PARENTID NUMBER NOT NULL, /* 부모노드아이디 */
	C_POSITION NUMBER NOT NULL, /* 노드포지션 */
	C_LEFT NUMBER NOT NULL, /* 노드좌측끝포인트 */
	C_RIGHT NUMBER NOT NULL, /* 노드우측끝포인트 */
	C_LEVEL NUMBER NOT NULL, /* 노드DEPTH */
	C_TITLE VARCHAR2(4000), /* 제목 */
	C_TYPE VARCHAR2(4000), /* 노드타입 */
	C_CORP_INTRO CLOB, /* 회사소개 */
	C_USE_PROV CLOB, /* 서비스이용약관 */
	C_PERSON_INFO CLOB, /* 개인정보처리방침 */
	C_REGI_YMD VARCHAR2(14), /* 등록일자 */
	C_REGI_ID NUMBER, /* 등록자 */
	C_MODI_YMD VARCHAR2(14), /* 수정일자 */
	C_MODI_ID NUMBER /* 수정자 */
);

COMMENT ON TABLE MY_SCHEMA.T_CONTENTS IS '기본 CONTENTS 설정';

COMMENT ON COLUMN MY_SCHEMA.T_CONTENTS.C_ID IS '노드아이디';

COMMENT ON COLUMN MY_SCHEMA.T_CONTENTS.C_PARENTID IS '부모노드아이디';

COMMENT ON COLUMN MY_SCHEMA.T_CONTENTS.C_POSITION IS '노드포지션';

COMMENT ON COLUMN MY_SCHEMA.T_CONTENTS.C_LEFT IS '노드좌측끝포인트';

COMMENT ON COLUMN MY_SCHEMA.T_CONTENTS.C_RIGHT IS '노드우측끝포인트';

COMMENT ON COLUMN MY_SCHEMA.T_CONTENTS.C_LEVEL IS '노드DEPTH';

COMMENT ON COLUMN MY_SCHEMA.T_CONTENTS.C_TITLE IS '제목';

COMMENT ON COLUMN MY_SCHEMA.T_CONTENTS.C_TYPE IS '노드타입';

COMMENT ON COLUMN MY_SCHEMA.T_CONTENTS.C_CORP_INTRO IS '회사소개';

COMMENT ON COLUMN MY_SCHEMA.T_CONTENTS.C_USE_PROV IS '서비스이용약관';

COMMENT ON COLUMN MY_SCHEMA.T_CONTENTS.C_PERSON_INFO IS '개인정보처리방침';

COMMENT ON COLUMN MY_SCHEMA.T_CONTENTS.C_REGI_YMD IS '등록일자';

COMMENT ON COLUMN MY_SCHEMA.T_CONTENTS.C_REGI_ID IS '등록자';

COMMENT ON COLUMN MY_SCHEMA.T_CONTENTS.C_MODI_YMD IS '수정일자';

COMMENT ON COLUMN MY_SCHEMA.T_CONTENTS.C_MODI_ID IS '수정자';

CREATE UNIQUE INDEX MY_SCHEMA.PK_T_CONTENTS
	ON MY_SCHEMA.T_CONTENTS (
		C_ID ASC
	);

ALTER TABLE MY_SCHEMA.T_CONTENTS
	ADD
		CONSTRAINT PK_T_CONTENTS
		PRIMARY KEY (
			C_ID
		);

/* 바로보드 좋아요 */
CREATE TABLE MY_SCHEMA.T_BOARD_LIKE (
	C_ID NUMBER NOT NULL, /* 노드아이디 */
	C_PARENTID NUMBER NOT NULL, /* 부모노드아이디 */
	C_POSITION NUMBER NOT NULL, /* 노드포지션 */
	C_LEFT NUMBER NOT NULL, /* 노드좌측끝포인트 */
	C_RIGHT NUMBER NOT NULL, /* 노드우측끝포인트 */
	C_LEVEL NUMBER NOT NULL, /* 노드DEPTH */
	C_TITLE VARCHAR2(4000), /* 노드제목 */
	C_TYPE VARCHAR2(4000), /* 노드타입 */
	C_ARTICLE_ID NUMBER, /* 글번호 */
	C_REG_ID NUMBER, /* 작성자아이디 */
	C_REG_DT VARCHAR2(14) /* 생성일시 */
);

COMMENT ON TABLE MY_SCHEMA.T_BOARD_LIKE IS '바로보드 좋아요';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_LIKE.C_ID IS '노드아이디';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_LIKE.C_PARENTID IS '부모노드아이디';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_LIKE.C_POSITION IS '노드포지션';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_LIKE.C_LEFT IS '노드좌측끝포인트';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_LIKE.C_RIGHT IS '노드우측끝포인트';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_LIKE.C_LEVEL IS '노드DEPTH';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_LIKE.C_TITLE IS '노드제목';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_LIKE.C_TYPE IS '노드타입';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_LIKE.C_ARTICLE_ID IS '글번호';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_LIKE.C_REG_ID IS '작성자아이디';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_LIKE.C_REG_DT IS '생성일시';

CREATE UNIQUE INDEX MY_SCHEMA.PK_T_BOARD_LIKE
	ON MY_SCHEMA.T_BOARD_LIKE (
		C_ID ASC
	);

ALTER TABLE MY_SCHEMA.T_BOARD_LIKE
	ADD
		CONSTRAINT PK_T_BOARD_LIKE
		PRIMARY KEY (
			C_ID
		);

/* 문의게시판 설정 */
CREATE TABLE MY_SCHEMA.T_INQUIRE_BOARD (
	C_ID NUMBER NOT NULL, /* 노드아이디 */
	C_PARENTID NUMBER NOT NULL, /* 부모노드아이디 */
	C_POSITION NUMBER NOT NULL, /* 노드포지션 */
	C_LEFT NUMBER NOT NULL, /* 노드좌측끝포인트 */
	C_RIGHT NUMBER NOT NULL, /* 노드우측끝포인트 */
	C_LEVEL NUMBER NOT NULL, /* 노드DEPTH */
	C_TITLE VARCHAR2(4000), /* 글제목 */
	C_TYPE VARCHAR2(4000), /* 노드타입 */
	C_REQ_SETTING VARCHAR2(4000), /* 문의분류항목설정 */
	C_EMAIL_FL CHAR(1) DEFAULT 0, /* 이메일입력여부 */
	C_PHONE_FL CHAR(1) DEFAULT 0, /* 핸드폰번호입력여부 */
	C_SMS_FL CHAR(1) DEFAULT 0, /* SMS/SNS알림여부 */
	C_REG_DT VARCHAR2(14), /* 시스템등록일시 */
	C_REG_ID NUMBER, /* 시스템등록아이디 */
	C_MOD_DT VARCHAR2(14), /* 시스템수정일시 */
	C_MOD_ID NUMBER /* 시스템수정아이디 */
);

COMMENT ON TABLE MY_SCHEMA.T_INQUIRE_BOARD IS '문의게시판 설정';

COMMENT ON COLUMN MY_SCHEMA.T_INQUIRE_BOARD.C_ID IS '노드아이디';

COMMENT ON COLUMN MY_SCHEMA.T_INQUIRE_BOARD.C_PARENTID IS '부모노드아이디';

COMMENT ON COLUMN MY_SCHEMA.T_INQUIRE_BOARD.C_POSITION IS '노드포지션';

COMMENT ON COLUMN MY_SCHEMA.T_INQUIRE_BOARD.C_LEFT IS '노드좌측끝포인트';

COMMENT ON COLUMN MY_SCHEMA.T_INQUIRE_BOARD.C_RIGHT IS '노드우측끝포인트';

COMMENT ON COLUMN MY_SCHEMA.T_INQUIRE_BOARD.C_LEVEL IS '노드DEPTH';

COMMENT ON COLUMN MY_SCHEMA.T_INQUIRE_BOARD.C_TITLE IS '글제목';

COMMENT ON COLUMN MY_SCHEMA.T_INQUIRE_BOARD.C_TYPE IS '노드타입';

COMMENT ON COLUMN MY_SCHEMA.T_INQUIRE_BOARD.C_REQ_SETTING IS '문의분류항목설정';

COMMENT ON COLUMN MY_SCHEMA.T_INQUIRE_BOARD.C_EMAIL_FL IS '이메일입력여부';

COMMENT ON COLUMN MY_SCHEMA.T_INQUIRE_BOARD.C_PHONE_FL IS '핸드폰번호입력여부';

COMMENT ON COLUMN MY_SCHEMA.T_INQUIRE_BOARD.C_SMS_FL IS 'SMS/SNS알림여부';

COMMENT ON COLUMN MY_SCHEMA.T_INQUIRE_BOARD.C_REG_DT IS '시스템등록일시';

COMMENT ON COLUMN MY_SCHEMA.T_INQUIRE_BOARD.C_REG_ID IS '시스템등록아이디';

COMMENT ON COLUMN MY_SCHEMA.T_INQUIRE_BOARD.C_MOD_DT IS '시스템수정일시';

COMMENT ON COLUMN MY_SCHEMA.T_INQUIRE_BOARD.C_MOD_ID IS '시스템수정아이디';

CREATE UNIQUE INDEX MY_SCHEMA.PK_T_INQUIRE_BOARD
	ON MY_SCHEMA.T_INQUIRE_BOARD (
		C_ID ASC
	);

ALTER TABLE MY_SCHEMA.T_INQUIRE_BOARD
	ADD
		CONSTRAINT PK_T_INQUIRE_BOARD
		PRIMARY KEY (
			C_ID
		);

/* 바로보드 게시판2 */
CREATE TABLE MY_SCHEMA.TABLE7 (
	C_ID NUMBER NOT NULL, /* 노드아이디 */
	C_PARENTID NUMBER NOT NULL, /* 부모노드아이디 */
	C_POSITION NUMBER NOT NULL, /* 노드포지션 */
	C_LEFT NUMBER NOT NULL, /* 노드좌측끝포인트 */
	C_RIGHT NUMBER NOT NULL, /* 노드우측끝포인트 */
	C_LEVEL NUMBER NOT NULL, /* 노드DEPTH */
	C_TITLE VARCHAR2(4000), /* 게시판제목 */
	C_TYPE VARCHAR2(4000) /* 노드타입 */
);

COMMENT ON TABLE MY_SCHEMA.TABLE7 IS '바로보드 게시판2';

COMMENT ON COLUMN MY_SCHEMA.TABLE7.C_ID IS '노드아이디';

COMMENT ON COLUMN MY_SCHEMA.TABLE7.C_PARENTID IS '부모노드아이디';

COMMENT ON COLUMN MY_SCHEMA.TABLE7.C_POSITION IS '노드포지션';

COMMENT ON COLUMN MY_SCHEMA.TABLE7.C_LEFT IS '노드좌측끝포인트';

COMMENT ON COLUMN MY_SCHEMA.TABLE7.C_RIGHT IS '노드우측끝포인트';

COMMENT ON COLUMN MY_SCHEMA.TABLE7.C_LEVEL IS '노드DEPTH';

COMMENT ON COLUMN MY_SCHEMA.TABLE7.C_TITLE IS '게시판제목';

COMMENT ON COLUMN MY_SCHEMA.TABLE7.C_TYPE IS '노드타입';

CREATE UNIQUE INDEX MY_SCHEMA.PK_TABLE7
	ON MY_SCHEMA.TABLE7 (
		C_ID ASC
	);

ALTER TABLE MY_SCHEMA.TABLE7
	ADD
		CONSTRAINT PK_TABLE7
		PRIMARY KEY (
			C_ID
		);

/* 새 테이블 */
CREATE TABLE MY_SCHEMA.TABLE (
);

COMMENT ON TABLE MY_SCHEMA.TABLE IS '새 테이블';

/* 바로보드 게시판 파일코드 */
CREATE TABLE MY_SCHEMA.T_BOARD_FILE_CODE (
	C_ID NUMBER NOT NULL, /* 노드아이디 */
	C_PARENTID NUMBER NOT NULL, /* 부모노드아이디 */
	C_POSITION NUMBER NOT NULL, /* 노드포지션 */
	C_LEFT NUMBER NOT NULL, /* 노드좌측끝포인트 */
	C_RIGHT NUMBER NOT NULL, /* 노드우측끝포인트 */
	C_LEVEL NUMBER NOT NULL, /* 노드DEPTH */
	C_TITLE VARCHAR2(4000), /* 제목 */
	C_TYPE VARCHAR2(4000) /* 노드타입 */
);

COMMENT ON TABLE MY_SCHEMA.T_BOARD_FILE_CODE IS '바로보드 게시판 파일코드';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_FILE_CODE.C_ID IS '노드아이디';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_FILE_CODE.C_PARENTID IS '부모노드아이디';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_FILE_CODE.C_POSITION IS '노드포지션';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_FILE_CODE.C_LEFT IS '노드좌측끝포인트';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_FILE_CODE.C_RIGHT IS '노드우측끝포인트';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_FILE_CODE.C_LEVEL IS '노드DEPTH';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_FILE_CODE.C_TITLE IS '제목';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_FILE_CODE.C_TYPE IS '노드타입';

CREATE UNIQUE INDEX MY_SCHEMA.PK_T_BOARD_FILE_CODE
	ON MY_SCHEMA.T_BOARD_FILE_CODE (
		C_ID ASC
	);

ALTER TABLE MY_SCHEMA.T_BOARD_FILE_CODE
	ADD
		CONSTRAINT PK_T_BOARD_FILE_CODE
		PRIMARY KEY (
			C_ID
		);

/* 바로보드 게시판 기본설정 */
CREATE TABLE MY_SCHEMA.T_BOARD_BASIC_CONFIG (
	C_ID NUMBER NOT NULL, /* 노드아이디 */
	C_PARENTID NUMBER NOT NULL, /* 부모노드아이디 */
	C_POSITION NUMBER NOT NULL, /* 노드포지션 */
	C_LEFT NUMBER NOT NULL, /* 노드좌측끝포인트 */
	C_RIGHT NUMBER NOT NULL, /* 노드우측끝포인트 */
	C_LEVEL NUMBER NOT NULL, /* 노드DEPTH */
	C_TITLE VARCHAR2(4000), /* 노드제목 */
	C_TYPE VARCHAR2(4000), /* 노드타입 */
	C_USE_LIKE_FL CHAR(1) DEFAULT 1, /* 글추천필드사용여부 */
	C_VIEW_CONTENT_IN_LIST_FL CHAR(1) DEFAULT 0, /* 목록에서내용사용여부 */
	C_VIEW_ATTACHE_IN_LIST_FL CHAR(1) DEFAULT 0, /* 목록에서첨부파일사용여부 */
	C_MAX_LENGTH_IN_TITLE NUMBER DEFAULT 50, /* 제목길이제한 */
	C_MIN_LENGTH_IN_CONTENT NUMBER DEFAULT 1, /* 최소글자수제한 */
	C_MAX_LENGTH_IN_CONTENT NUMBER DEFAULT 10000, /* 최대글자수제한 */
	C_USE_SNS_LINK_FL CHAR(1) DEFAULT 1, /* SNS연동사용여부 */
	C_SPAM_KEYWORDS VARCHAR2(4000), /* 스팸키워드설정 */
	C_BLOCK_DOUBT_REQUEST_FL CHAR(1) DEFAULT 0, /* 자동차단설정 */
	C_REG_DT VARCHAR2(14) /* 생성일시 */
);

COMMENT ON TABLE MY_SCHEMA.T_BOARD_BASIC_CONFIG IS '바로보드 게시판 기본설정';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_BASIC_CONFIG.C_ID IS '노드아이디';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_BASIC_CONFIG.C_PARENTID IS '부모노드아이디';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_BASIC_CONFIG.C_POSITION IS '노드포지션';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_BASIC_CONFIG.C_LEFT IS '노드좌측끝포인트';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_BASIC_CONFIG.C_RIGHT IS '노드우측끝포인트';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_BASIC_CONFIG.C_LEVEL IS '노드DEPTH';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_BASIC_CONFIG.C_TITLE IS '노드제목';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_BASIC_CONFIG.C_TYPE IS '노드타입';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_BASIC_CONFIG.C_USE_LIKE_FL IS '글추천필드사용여부';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_BASIC_CONFIG.C_VIEW_CONTENT_IN_LIST_FL IS '목록에서내용사용여부';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_BASIC_CONFIG.C_VIEW_ATTACHE_IN_LIST_FL IS '목록에서첨부파일사용여부';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_BASIC_CONFIG.C_MAX_LENGTH_IN_TITLE IS '제목길이제한';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_BASIC_CONFIG.C_MIN_LENGTH_IN_CONTENT IS '최소글자수제한';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_BASIC_CONFIG.C_MAX_LENGTH_IN_CONTENT IS '최대글자수제한';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_BASIC_CONFIG.C_USE_SNS_LINK_FL IS 'SNS연동사용여부';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_BASIC_CONFIG.C_SPAM_KEYWORDS IS '스팸키워드설정';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_BASIC_CONFIG.C_BLOCK_DOUBT_REQUEST_FL IS '자동차단설정';

COMMENT ON COLUMN MY_SCHEMA.T_BOARD_BASIC_CONFIG.C_REG_DT IS '생성일시';

CREATE UNIQUE INDEX MY_SCHEMA.PK_T_BOARD_BASIC_CONFIG
	ON MY_SCHEMA.T_BOARD_BASIC_CONFIG (
		C_ID ASC
	);

ALTER TABLE MY_SCHEMA.T_BOARD_BASIC_CONFIG
	ADD
		CONSTRAINT PK_T_BOARD_BASIC_CONFIG
		PRIMARY KEY (
			C_ID
		);

ALTER TABLE MY_SCHEMA.T_BOARD
	ADD
		CONSTRAINT FK_T_BOARD_CONFIG_TO_T_BOARD
		FOREIGN KEY (
			C_ID
		)
		REFERENCES MY_SCHEMA.T_BOARD_CONFIG (
			C_ID
		);

ALTER TABLE MY_SCHEMA.T_BOARD_FILE
	ADD
		CONSTRAINT FK_T_BOARD_TO_T_BOARD_FILE
		FOREIGN KEY (
			C_ARTICLE_ID
		)
		REFERENCES MY_SCHEMA.T_BOARD (
			C_ID
		);

ALTER TABLE MY_SCHEMA.T_BOARD_COMMENT
	ADD
		CONSTRAINT FK_T_BOARD_TO_T_BOARD_COMMENT
		FOREIGN KEY (
			C_ARTICLE_ID
		)
		REFERENCES MY_SCHEMA.T_BOARD (
			C_ID
		);

ALTER TABLE MY_SCHEMA.T_BOARD_LIKE
	ADD
		CONSTRAINT FK_T_BOARD_TO_T_BOARD_LIKE
		FOREIGN KEY (
			C_ARTICLE_ID
		)
		REFERENCES MY_SCHEMA.T_BOARD (
			C_ID
		);