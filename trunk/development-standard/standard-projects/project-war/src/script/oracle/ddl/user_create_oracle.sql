/* 회원_금지단어 */
DROP TABLE T_USER_PROH_WORD;

CREATE TABLE T_USER_PROH_WORD (
    C_ID NUMBER NOT NULL, /* 노드아이디 */
    C_PARENTID NUMBER NOT NULL, /* 부모노드아이디 */
    C_POSITION NUMBER NOT NULL, /* 노드포지션 */
    C_LEFT NUMBER NOT NULL, /* 노드좌측끝포인트 */
    C_RIGHT NUMBER NOT NULL, /* 노드우측끝포인트 */
    C_LEVEL NUMBER NOT NULL, /* 노드레벨 */
    C_TITLE VARCHAR2(4000), /* 노드명 */
    C_TYPE VARCHAR2(100), /* 노드타입 */
    C_TYPE_CD CHAR(1) NOT NULL /* 유형코드 */
);

COMMENT ON TABLE T_USER_PROH_WORD IS '회원_금지단어';

COMMENT ON COLUMN T_USER_PROH_WORD.C_ID IS '노드아이디';

COMMENT ON COLUMN T_USER_PROH_WORD.C_PARENTID IS '부모노드아이디';

COMMENT ON COLUMN T_USER_PROH_WORD.C_POSITION IS '노드포지션';

COMMENT ON COLUMN T_USER_PROH_WORD.C_LEFT IS '노드좌측끝포인트';

COMMENT ON COLUMN T_USER_PROH_WORD.C_RIGHT IS '노드우측끝포인트';

COMMENT ON COLUMN T_USER_PROH_WORD.C_LEVEL IS '노드레벨';

COMMENT ON COLUMN T_USER_PROH_WORD.C_TITLE IS '노드명';

COMMENT ON COLUMN T_USER_PROH_WORD.C_TYPE IS '노드타입';

COMMENT ON COLUMN T_USER_PROH_WORD.C_TYPE_CD IS '유형코드';

--CREATE UNIQUE INDEX PK_T_USER_PROH_WORD
--  ON T_USER_PROH_WORD (
--      C_ID ASC
--  );

ALTER TABLE T_USER_PROH_WORD
    ADD
        CONSTRAINT PK_T_USER_PROH_WORD
        PRIMARY KEY (
            C_ID
        );
        
DROP SEQUENCE S_USER_PROH_WORD;

CREATE SEQUENCE S_USER_PROH_WORD
  START WITH 7313
  MAXVALUE 999999999999999999999999999
  MINVALUE 0
  NOCYCLE
  CACHE 20
  NOORDER;
  
/* 회원_이용약관 */
DROP TABLE T_USER_TERMS_OF_USE;
  
CREATE TABLE T_USER_TERMS_OF_USE (
    C_ID NUMBER NOT NULL, /* 노드아이디 */
    C_PARENTID NUMBER NOT NULL, /* 부모노드아이디 */
    C_POSITION NUMBER NOT NULL, /* 노드포지션 */
    C_LEFT NUMBER NOT NULL, /* 노드좌측끝포인트 */
    C_RIGHT NUMBER NOT NULL, /* 노드우측끝포인트 */
    C_LEVEL NUMBER NOT NULL, /* 노드레벨 */
    C_TITLE VARCHAR2(4000), /* 노드명 */
    C_TYPE VARCHAR2(100), /* 노드타입 */
    C_TYPE_CD CHAR(1) NOT NULL, /* 유형코드 */
    C_COMPANY_INTR VARCHAR2(4000) NOT NULL, /* 회사소개 */
    C_TERMS_OF_USE VARCHAR2(4000) NOT NULL, /* 이용약관 */
    C_PRIVACY_POLICY VARCHAR2(4000) NOT NULL /* 개인정보취급방침 */
);

COMMENT ON TABLE T_USER_TERMS_OF_USE IS '회원_이용약관';

COMMENT ON COLUMN T_USER_TERMS_OF_USE.C_ID IS '노드아이디';

COMMENT ON COLUMN T_USER_TERMS_OF_USE.C_PARENTID IS '부모노드아이디';

COMMENT ON COLUMN T_USER_TERMS_OF_USE.C_POSITION IS '노드포지션';

COMMENT ON COLUMN T_USER_TERMS_OF_USE.C_LEFT IS '노드좌측끝포인트';

COMMENT ON COLUMN T_USER_TERMS_OF_USE.C_RIGHT IS '노드우측끝포인트';

COMMENT ON COLUMN T_USER_TERMS_OF_USE.C_LEVEL IS '노드레벨';

COMMENT ON COLUMN T_USER_TERMS_OF_USE.C_TITLE IS '노드명';

COMMENT ON COLUMN T_USER_TERMS_OF_USE.C_TYPE IS '노드타입';

COMMENT ON COLUMN T_USER_TERMS_OF_USE.C_TYPE_CD IS '유형코드';

COMMENT ON COLUMN T_USER_TERMS_OF_USE.C_COMPANY_INTR IS '회사소개';

COMMENT ON COLUMN T_USER_TERMS_OF_USE.C_TERMS_OF_USE IS '이용약관';

COMMENT ON COLUMN T_USER_TERMS_OF_USE.C_PRIVACY_POLICY IS '개인정보취급방침';

--CREATE UNIQUE INDEX PK_T_USER_TERMS_OF_USE
--  ON T_USER_TERMS_OF_USE (
--      C_ID ASC
--  );

ALTER TABLE T_USER_TERMS_OF_USE
    ADD
        CONSTRAINT PK_T_USER_TERMS_OF_USE
        PRIMARY KEY (
            C_ID
        );

DROP SEQUENCE S_USER_TERMS_OF_USE;

CREATE SEQUENCE S_USER_TERMS_OF_USE
  START WITH 7313
  MAXVALUE 999999999999999999999999999
  MINVALUE 0
  NOCYCLE
  CACHE 20
  NOORDER;
  
/* 회원_가입필드컴포넌트 */
DROP TABLE T_USER_JOIN_FIELD_COMP;
  
CREATE TABLE T_USER_JOIN_FIELD_COMP (
    C_ID NUMBER NOT NULL, /* 노드아이디 */
    C_PARENTID NUMBER NOT NULL, /* 부모노드아이디 */
    C_POSITION NUMBER NOT NULL, /* 노드포지션 */
    C_LEFT NUMBER NOT NULL, /* 노드좌측끝포인트 */
    C_RIGHT NUMBER NOT NULL, /* 노드우측끝포인트 */
    C_LEVEL NUMBER NOT NULL, /* 노드레벨 */
    C_TITLE VARCHAR2(4000), /* 노드명 */
    C_TYPE VARCHAR2(100) /* 노드타입 */
);

COMMENT ON TABLE T_USER_JOIN_FIELD_COMP IS '회원_가입필드컴포넌트';

COMMENT ON COLUMN T_USER_JOIN_FIELD_COMP.C_ID IS '노드아이디';

COMMENT ON COLUMN T_USER_JOIN_FIELD_COMP.C_PARENTID IS '부모노드아이디';

COMMENT ON COLUMN T_USER_JOIN_FIELD_COMP.C_POSITION IS '노드포지션';

COMMENT ON COLUMN T_USER_JOIN_FIELD_COMP.C_LEFT IS '노드좌측끝포인트';

COMMENT ON COLUMN T_USER_JOIN_FIELD_COMP.C_RIGHT IS '노드우측끝포인트';

COMMENT ON COLUMN T_USER_JOIN_FIELD_COMP.C_LEVEL IS '노드레벨';

COMMENT ON COLUMN T_USER_JOIN_FIELD_COMP.C_TITLE IS '노드명';

COMMENT ON COLUMN T_USER_JOIN_FIELD_COMP.C_TYPE IS '노드타입';

--CREATE UNIQUE INDEX PK_T_USER_JOIN_FIELD_COMP
--  ON T_USER_JOIN_FIELD_COMP (
--      C_ID ASC
--  );

ALTER TABLE T_USER_JOIN_FIELD_COMP
    ADD
        CONSTRAINT PK_T_USER_JOIN_FIELD_COMP
        PRIMARY KEY (
            C_ID
        );

DROP SEQUENCE S_USER_JOIN_FIELD_COMP;

CREATE SEQUENCE S_USER_JOIN_FIELD_COMP
  START WITH 7313
  MAXVALUE 999999999999999999999999999
  MINVALUE 0
  NOCYCLE
  CACHE 20
  NOORDER;
  
/* 회원_가입필드 */
DROP TABLE T_USER_JOIN_FIELD;
  
CREATE TABLE T_USER_JOIN_FIELD (
    C_ID NUMBER NOT NULL, /* 노드아이디 */
    C_PARENTID NUMBER NOT NULL, /* 부모노드아이디 */
    C_POSITION NUMBER NOT NULL, /* 노드포지션 */
    C_LEFT NUMBER NOT NULL, /* 노드좌측끝포인트 */
    C_RIGHT NUMBER NOT NULL, /* 노드우측끝포인트 */
    C_LEVEL NUMBER NOT NULL, /* 노드레벨 */
    C_TITLE VARCHAR2(4000), /* 노드명 */
    C_TYPE VARCHAR2(100), /* 노드타입 */
    C_COMP_KIND_CD NUMBER NOT NULL, /* 컴포넌트종류코드 */
    C_USE_FL CHAR(1) DEFAULT 0 NOT NULL, /* 사용여부 */
    C_INFO_OPEN_FL CHAR(1) DEFAULT 0 NOT NULL, /* 정보공개여부 */
    C_ESSE_INPUT_FL CHAR(1) DEFAULT 0 NOT NULL /* 필수입력여부 */
);

COMMENT ON TABLE T_USER_JOIN_FIELD IS '회원_가입필드';

COMMENT ON COLUMN T_USER_JOIN_FIELD.C_ID IS '노드아이디';

COMMENT ON COLUMN T_USER_JOIN_FIELD.C_PARENTID IS '부모노드아이디';

COMMENT ON COLUMN T_USER_JOIN_FIELD.C_POSITION IS '노드포지션';

COMMENT ON COLUMN T_USER_JOIN_FIELD.C_LEFT IS '노드좌측끝포인트';

COMMENT ON COLUMN T_USER_JOIN_FIELD.C_RIGHT IS '노드우측끝포인트';

COMMENT ON COLUMN T_USER_JOIN_FIELD.C_LEVEL IS '노드레벨';

COMMENT ON COLUMN T_USER_JOIN_FIELD.C_TITLE IS '노드명';

COMMENT ON COLUMN T_USER_JOIN_FIELD.C_TYPE IS '노드타입';

COMMENT ON COLUMN T_USER_JOIN_FIELD.C_COMP_KIND_CD IS '컴포넌트종류코드';

COMMENT ON COLUMN T_USER_JOIN_FIELD.C_USE_FL IS '사용여부';

COMMENT ON COLUMN T_USER_JOIN_FIELD.C_INFO_OPEN_FL IS '정보공개여부';

COMMENT ON COLUMN T_USER_JOIN_FIELD.C_ESSE_INPUT_FL IS '필수입력여부';

--CREATE UNIQUE INDEX PK_T_USER_JOIN_FIELD
--  ON T_USER_JOIN_FIELD (
--      C_ID ASC
--  );

ALTER TABLE T_USER_JOIN_FIELD
    ADD
        CONSTRAINT PK_T_USER_JOIN_FIELD
        PRIMARY KEY (
            C_ID
        );

ALTER TABLE T_USER_JOIN_FIELD
    ADD
        CONSTRAINT FK_T_USER_JOIN_FIELD_COMP
        FOREIGN KEY (
            C_COMP_KIND_CD
        )
        REFERENCES T_USER_JOIN_FIELD_COMP (
            C_ID
        );

DROP SEQUENCE S_USER_JOIN_FIELD;

CREATE SEQUENCE S_USER_JOIN_FIELD
  START WITH 7313
  MAXVALUE 999999999999999999999999999
  MINVALUE 0
  NOCYCLE
  CACHE 20
  NOORDER;

/* 회원_비밀번호보안수준 */
DROP TABLE T_USER_PASSWORD_SECURITY_LEVEL;

CREATE TABLE T_USER_PASSWORD_SECURITY_LEVEL (
    C_ID NUMBER NOT NULL, /* 노드 아이디 */
    C_PARENTID NUMBER NOT NULL, /* 부모노드아이디 */
    C_POSITION NUMBER NOT NULL, /* 노드포지션 */
    C_LEFT NUMBER NOT NULL, /* 노드좌측끝포인트 */
    C_RIGHT NUMBER NOT NULL, /* 노드우측끝포인트 */
    C_LEVEL NUMBER NOT NULL, /* 노드레벨 */
    C_TITLE VARCHAR2(4000), /* 노드명 */
    C_TYPE VARCHAR2(100) /* 노드타입 */
);

COMMENT ON TABLE T_USER_PASSWORD_SECURITY_LEVEL IS '회원_비밀번호보안수준';

COMMENT ON COLUMN T_USER_PASSWORD_SECURITY_LEVEL.C_ID IS '노드 아이디';

COMMENT ON COLUMN T_USER_PASSWORD_SECURITY_LEVEL.C_PARENTID IS '부모노드아이디';

COMMENT ON COLUMN T_USER_PASSWORD_SECURITY_LEVEL.C_POSITION IS '노드포지션';

COMMENT ON COLUMN T_USER_PASSWORD_SECURITY_LEVEL.C_LEFT IS '노드좌측끝포인트';

COMMENT ON COLUMN T_USER_PASSWORD_SECURITY_LEVEL.C_RIGHT IS '노드우측끝포인트';

COMMENT ON COLUMN T_USER_PASSWORD_SECURITY_LEVEL.C_LEVEL IS '노드레벨';

COMMENT ON COLUMN T_USER_PASSWORD_SECURITY_LEVEL.C_TITLE IS '노드명';

COMMENT ON COLUMN T_USER_PASSWORD_SECURITY_LEVEL.C_TYPE IS '노드타입';

--CREATE UNIQUE INDEX PK_T_USER_PWD_SECU_LEVEL
--  ON T_USER_PASSWORD_SECURITY_LEVEL (
--      C_ID ASC
--  );

ALTER TABLE T_USER_PASSWORD_SECURITY_LEVEL
    ADD
        CONSTRAINT PK_T_USER_PWD_SECU_LEVEL
        PRIMARY KEY (
            C_ID
        );

ALTER TABLE T_USER_BASIC_SETTING
    ADD
        CONSTRAINT FK_T_USER_PWD_SECU_LEVEL
        FOREIGN KEY (
            C_PASSWORD_SECURITY_LEVEL_CD
        )
        REFERENCES T_USER_PASSWORD_SECURITY_LEVEL (
            C_ID
        );
    
DROP SEQUENCE S_USER_PASSWORD_SECURITY_LEVEL;

CREATE SEQUENCE S_USER_PASSWORD_SECURITY_LEVEL
  START WITH 7313
  MAXVALUE 999999999999999999999999999
  MINVALUE 0
  NOCYCLE
  CACHE 20
  NOORDER;
  
/* 회원_기본설정 */
DROP TABLE T_USER_BASIC_SETTING;
  
CREATE TABLE T_USER_BASIC_SETTING (
    C_ID NUMBER NOT NULL, /* 노드아이디 */
    C_PARENTID NUMBER NOT NULL, /* 부모노드아이디 */
    C_POSITION NUMBER NOT NULL, /* 노드포지션 */
    C_LEFT NUMBER NOT NULL, /* 노드좌측끝포인트 */
    C_RIGHT NUMBER NOT NULL, /* 노드우측끝포인트 */
    C_LEVEL NUMBER NOT NULL, /* 노드레벨 */
    C_TITLE VARCHAR2(4000), /* 노드명 */
    C_TYPE VARCHAR2(100), /* 노드타입 */
    C_WEB_MASTER_NM VARCHAR2(30) NOT NULL, /* 웹마스터이름 */
    C_WEB_MASTER_EMAIL VARCHAR2(320) NOT NULL, /* 웹마스터이메일 */
    C_JOIN_APPROVAL_FL CHAR(1) DEFAULT 0 NOT NULL, /* 가입승인여부 */
    C_EMAIL_AUTH_USE_FL CHAR(1) DEFAULT 0 NOT NULL, /* 이메일인증사용여부 */
    C_PASSWORD_SECURITY_LEVEL_CD NUMBER NOT NULL, /* 비밀번호보안수준코드 */
    C_PASSWORD_CHANGE_DCNT NUMBER(3) NOT NULL, /* 비밀번호변경일수 */
    C_LOGIN_LIMIT_DCNT NUMBER(2) NOT NULL, /* 로그인제한일수 */
    C_LOGIN_FAILURE_LIMIT_CNT NUMBER(1) NOT NULL /* 로그인실패제한횟수 */
);

COMMENT ON TABLE T_USER_BASIC_SETTING IS '회원_기본설정';

COMMENT ON COLUMN T_USER_BASIC_SETTING.C_ID IS '노드아이디';

COMMENT ON COLUMN T_USER_BASIC_SETTING.C_PARENTID IS '부모노드아이디';

COMMENT ON COLUMN T_USER_BASIC_SETTING.C_POSITION IS '노드포지션';

COMMENT ON COLUMN T_USER_BASIC_SETTING.C_LEFT IS '노드좌측끝포인트';

COMMENT ON COLUMN T_USER_BASIC_SETTING.C_RIGHT IS '노드우측끝포인트';

COMMENT ON COLUMN T_USER_BASIC_SETTING.C_LEVEL IS '노드레벨';

COMMENT ON COLUMN T_USER_BASIC_SETTING.C_TITLE IS '노드명';

COMMENT ON COLUMN T_USER_BASIC_SETTING.C_TYPE IS '노드타입';

COMMENT ON COLUMN T_USER_BASIC_SETTING.C_WEB_MASTER_NM IS '웹마스터이름';

COMMENT ON COLUMN T_USER_BASIC_SETTING.C_WEB_MASTER_EMAIL IS '웹마스터이메일';

COMMENT ON COLUMN T_USER_BASIC_SETTING.C_JOIN_APPROVAL_FL IS '가입승인여부';

COMMENT ON COLUMN T_USER_BASIC_SETTING.C_EMAIL_AUTH_USE_FL IS '이메일인증사용여부';

COMMENT ON COLUMN T_USER_BASIC_SETTING.C_PASSWORD_SECURITY_LEVEL_CD IS '비밀번호보안수준코드';

COMMENT ON COLUMN T_USER_BASIC_SETTING.C_PASSWORD_CHANGE_DCNT IS '비밀번호변경일수';

COMMENT ON COLUMN T_USER_BASIC_SETTING.C_LOGIN_LIMIT_DCNT IS '로그인제한일수';

COMMENT ON COLUMN T_USER_BASIC_SETTING.C_LOGIN_FAILURE_LIMIT_CNT IS '로그인실패제한횟수';

--CREATE UNIQUE INDEX PK_T_USER_BASIC_SETTING
--  ON T_USER_BASIC_SETTING (
--      C_ID ASC
--  );

ALTER TABLE T_USER_BASIC_SETTING
    ADD
        CONSTRAINT PK_T_USER_BASIC_SETTING
        PRIMARY KEY (
            C_ID
        );

DROP SEQUENCE S_USER_BASIC_SETTING;

CREATE SEQUENCE S_USER_BASIC_SETTING
  START WITH 7313
  MAXVALUE 999999999999999999999999999
  MINVALUE 0
  NOCYCLE
  CACHE 20
  NOORDER;
  
  /* 회원_등급관리 */
CREATE TABLE T_USER_GRADE_MANAGE (
	C_ID NUMBER NOT NULL, /* 노드아이디 */
	C_PARENTID NUMBER NOT NULL, /* 부모노드아이디 */
	C_POSITION NUMBER NOT NULL, /* 노드포지션 */
	C_LEFT NUMBER NOT NULL, /* 노드좌측끝포인트 */
	C_RIGHT NUMBER NOT NULL, /* 노드우측끝포인트 */
	C_LEVEL NUMBER NOT NULL, /* 노드레벨 */
	C_TITLE VARCHAR2(4000), /* 노드명 */
	C_TYPE VARCHAR2(100), /* 노드타입 */
	C_POINT_BY_GRADE_USE_FL CHAR(1) DEFAULT 0 NOT NULL, /* 등급별포인트사용여부 */
	C_POINT_BY_GRADE NUMBER NOT NULL, /* 등급별포인트 */
	C_ICON_FILE_NM VARCHAR2(4000) /* 아이콘파일명 */
);

COMMENT ON TABLE T_USER_GRADE_MANAGE IS '회원_등급관리';
COMMENT ON COLUMN T_USER_GRADE_MANAGE.C_ID IS '노드아이디';
COMMENT ON COLUMN T_USER_GRADE_MANAGE.C_PARENTID IS '부모노드아이디';
COMMENT ON COLUMN T_USER_GRADE_MANAGE.C_POSITION IS '노드포지션';
COMMENT ON COLUMN T_USER_GRADE_MANAGE.C_LEFT IS '노드좌측끝포인트';
COMMENT ON COLUMN T_USER_GRADE_MANAGE.C_RIGHT IS '노드우측끝포인트';
COMMENT ON COLUMN T_USER_GRADE_MANAGE.C_LEVEL IS '노드레벨';
COMMENT ON COLUMN T_USER_GRADE_MANAGE.C_TITLE IS '노드명';
COMMENT ON COLUMN T_USER_GRADE_MANAGE.C_TYPE IS '노드타입';
COMMENT ON COLUMN T_USER_GRADE_MANAGE.C_POINT_BY_GRADE_USE_FL IS '등급별포인트사용여부';
COMMENT ON COLUMN T_USER_GRADE_MANAGE.C_POINT_BY_GRADE IS '등급별포인트';
COMMENT ON COLUMN T_USER_GRADE_MANAGE.C_ICON_FILE_NM IS '아이콘파일명';

/*CREATE UNIQUE INDEX PK_T_USER_GRADE_MANAGE
	ON T_USER_GRADE_MANAGE (
		C_ID ASC
	);*/

ALTER TABLE T_USER_GRADE_MANAGE
	ADD
		CONSTRAINT PK_T_USER_GRADE_MANAGE
		PRIMARY KEY (
			C_ID
		);
		
CREATE SEQUENCE S_USER_GRADE_MANAGE
  START WITH 7313
  MAXVALUE 999999999999999999999999999
  MINVALUE 0
  NOCYCLE
  CACHE 20
  NOORDER;
  
  

/* 회원_등급별메뉴 */
CREATE TABLE T_USER_MENU_BY_GRADE (
	C_ID NUMBER NOT NULL, /* 노드아이디 */
	C_PARENTID NUMBER NOT NULL, /* 부모노드아이디 */
	C_POSITION NUMBER NOT NULL, /* 노드포지션 */
	C_LEFT NUMBER NOT NULL, /* 노드좌측끝포인트 */
	C_RIGHT NUMBER NOT NULL, /* 노드우측끝포인트 */
	C_LEVEL NUMBER NOT NULL, /* 노드레벨 */
	C_TITLE VARCHAR2(4000), /* 노드명 */
	C_TYPE VARCHAR2(100), /* 노드타입 */
	C_USER_GRADE_ID NUMBER NOT NULL, /* 회원등급ID */
	C_MENU_ID NUMBER NOT NULL /* 메뉴ID */
);

COMMENT ON TABLE T_USER_MENU_BY_GRADE IS '회원_등급별메뉴';
COMMENT ON COLUMN T_USER_MENU_BY_GRADE.C_ID IS '노드아이디';
COMMENT ON COLUMN T_USER_MENU_BY_GRADE.C_PARENTID IS '부모노드아이디';
COMMENT ON COLUMN T_USER_MENU_BY_GRADE.C_POSITION IS '노드포지션';
COMMENT ON COLUMN T_USER_MENU_BY_GRADE.C_LEFT IS '노드좌측끝포인트';
COMMENT ON COLUMN T_USER_MENU_BY_GRADE.C_RIGHT IS '노드우측끝포인트';
COMMENT ON COLUMN T_USER_MENU_BY_GRADE.C_LEVEL IS '노드레벨';
COMMENT ON COLUMN T_USER_MENU_BY_GRADE.C_TITLE IS '노드명';
COMMENT ON COLUMN T_USER_MENU_BY_GRADE.C_TYPE IS '노드타입';
COMMENT ON COLUMN T_USER_MENU_BY_GRADE.C_USER_GRADE_ID IS '회원등급ID';
COMMENT ON COLUMN T_USER_MENU_BY_GRADE.C_MENU_ID IS '메뉴ID';

/*CREATE UNIQUE INDEX PK_T_USER_MENU_BY_GRADE
	ON T_USER_MENU_BY_GRADE (
		C_ID ASC
	);*/

ALTER TABLE T_USER_MENU_BY_GRADE
	ADD
		CONSTRAINT PK_T_USER_MENU_BY_GRADE
		PRIMARY KEY (
			C_ID
		);


ALTER TABLE T_USER_MENU_BY_GRADE
	ADD
		CONSTRAINT FK_T_USER_GRADE_MANAGE_TO_T_USER_MENU_BY_GRADE
		FOREIGN KEY (
			C_USER_GRADE_ID
		)
		REFERENCES T_USER_GRADE_MANAGE (
			C_ID
		);
		
CREATE SEQUENCE S_USER_MENU_BY_GRADE
  START WITH 7313
  MAXVALUE 999999999999999999999999999
  MINVALUE 0
  NOCYCLE
  CACHE 20
  NOORDER;
  
/* 회원_쪽지유형코드 */
CREATE TABLE T_USER_NOTE_TYPE_CODE (
	C_ID NUMBER NOT NULL, /* 노드아이디 */
	C_PARENTID NUMBER NOT NULL, /* 부모노드아이디 */
	C_POSITION NUMBER NOT NULL, /* 노드포지션 */
	C_LEFT NUMBER NOT NULL, /* 노드좌측끝포인트 */
	C_RIGHT NUMBER NOT NULL, /* 노드우측끝포인트 */
	C_LEVEL NUMBER NOT NULL, /* 노드레벨 */
	C_TITLE VARCHAR2(4000), /* 노드명 */
	C_TYPE VARCHAR2(100) /* 노드타입 */
);

COMMENT ON TABLE T_USER_NOTE_TYPE_CODE IS '회원_쪽지유형코드';
COMMENT ON COLUMN T_USER_NOTE_TYPE_CODE.C_ID IS '노드아이디';
COMMENT ON COLUMN T_USER_NOTE_TYPE_CODE.C_PARENTID IS '부모노드아이디';
COMMENT ON COLUMN T_USER_NOTE_TYPE_CODE.C_POSITION IS '노드포지션';
COMMENT ON COLUMN T_USER_NOTE_TYPE_CODE.C_LEFT IS '노드좌측끝포인트';
COMMENT ON COLUMN T_USER_NOTE_TYPE_CODE.C_RIGHT IS '노드우측끝포인트';
COMMENT ON COLUMN T_USER_NOTE_TYPE_CODE.C_LEVEL IS '노드레벨';
COMMENT ON COLUMN T_USER_NOTE_TYPE_CODE.C_TITLE IS '노드명';
COMMENT ON COLUMN T_USER_NOTE_TYPE_CODE.C_TYPE IS '노드타입';

/*CREATE UNIQUE INDEX PK_T_USER_NOTE_TYPE_CODE
	ON T_USER_NOTE_TYPE_CODE (
		C_ID ASC
	);*/

ALTER TABLE T_USER_NOTE_TYPE_CODE
	ADD
		CONSTRAINT PK_T_USER_NOTE_TYPE_CODE
		PRIMARY KEY (
			C_ID
		);

CREATE SEQUENCE S_USER_NOTE_TYPE_CODE
  START WITH 7313
  MAXVALUE 999999999999999999999999999
  MINVALUE 0
  NOCYCLE
  CACHE 20
  NOORDER;
		
/* 회원_쪽지상세 */
CREATE TABLE T_USER_NOTE_DETAIL (
	C_ID NUMBER NOT NULL, /* 노드아이디 */
	C_PARENTID NUMBER NOT NULL, /* 부모노드아이디 */
	C_POSITION NUMBER NOT NULL, /* 노드포지션 */
	C_LEFT NUMBER NOT NULL, /* 노드좌측끝포인트 */
	C_RIGHT NUMBER NOT NULL, /* 노드우측끝포인트 */
	C_LEVEL NUMBER NOT NULL, /* 노드레벨 */
	C_TITLE VARCHAR2(4000), /* 노드명 */
	C_TYPE VARCHAR2(100), /* 노드타입 */
	C_CONTENT VARCHAR2(4000) NOT NULL /* 내용 */
);

COMMENT ON TABLE T_USER_NOTE_DETAIL IS '회원_쪽지상세';
COMMENT ON COLUMN T_USER_NOTE_DETAIL.C_ID IS '노드아이디';
COMMENT ON COLUMN T_USER_NOTE_DETAIL.C_PARENTID IS '부모노드아이디';
COMMENT ON COLUMN T_USER_NOTE_DETAIL.C_POSITION IS '노드포지션';
COMMENT ON COLUMN T_USER_NOTE_DETAIL.C_LEFT IS '노드좌측끝포인트';
COMMENT ON COLUMN T_USER_NOTE_DETAIL.C_RIGHT IS '노드우측끝포인트';
COMMENT ON COLUMN T_USER_NOTE_DETAIL.C_LEVEL IS '노드레벨';
COMMENT ON COLUMN T_USER_NOTE_DETAIL.C_TITLE IS '노드명';
COMMENT ON COLUMN T_USER_NOTE_DETAIL.C_TYPE IS '노드타입';
COMMENT ON COLUMN T_USER_NOTE_DETAIL.C_CONTENT IS '내용';

/*CREATE UNIQUE INDEX PK_T_USER_NOTE_DETAIL
	ON T_USER_NOTE_DETAIL (
		C_ID ASC
	);*/

ALTER TABLE T_USER_NOTE_DETAIL
	ADD
		CONSTRAINT PK_T_USER_NOTE_DETAIL
		PRIMARY KEY (
			C_ID
		);
		
CREATE SEQUENCE S_USER_NOTE_DETAIL
  START WITH 7313
  MAXVALUE 999999999999999999999999999
  MINVALUE 0
  NOCYCLE
  CACHE 20
  NOORDER;
  
/* 회원_회원별쪽지 */
CREATE TABLE T_USER_NOTE_BY_USER (
	C_ID NUMBER NOT NULL, /* 노드아이디 */
	C_PARENTID NUMBER NOT NULL, /* 부모노드아이디 */
	C_POSITION NUMBER NOT NULL, /* 노드포지션 */
	C_LEFT NUMBER NOT NULL, /* 노드좌측끝포인트 */
	C_RIGHT NUMBER NOT NULL, /* 노드우측끝포인트 */
	C_LEVEL NUMBER NOT NULL, /* 노드레벨 */
	C_TITLE VARCHAR2(4000), /* 노드명 */
	C_TYPE VARCHAR2(100), /* 노드타입 */
	C_USER_ID NUMBER NOT NULL, /* 회원ID */
	C_NOTE_DETAIL_ID NUMBER NOT NULL, /* 쪽지상세ID */
	C_NOTE_TYPE_CD NUMBER NOT NULL, /* 쪽지유형코드 */
	C_RECE_DISP_DT CHAR(14) NOT NULL /* 수발신일시 */
);

COMMENT ON TABLE T_USER_NOTE_BY_USER IS '회원_회원별쪽지';
COMMENT ON COLUMN T_USER_NOTE_BY_USER.C_ID IS '노드아이디';
COMMENT ON COLUMN T_USER_NOTE_BY_USER.C_PARENTID IS '부모노드아이디';
COMMENT ON COLUMN T_USER_NOTE_BY_USER.C_POSITION IS '노드포지션';
COMMENT ON COLUMN T_USER_NOTE_BY_USER.C_LEFT IS '노드좌측끝포인트';
COMMENT ON COLUMN T_USER_NOTE_BY_USER.C_RIGHT IS '노드우측끝포인트';
COMMENT ON COLUMN T_USER_NOTE_BY_USER.C_LEVEL IS '노드레벨';
COMMENT ON COLUMN T_USER_NOTE_BY_USER.C_TITLE IS '노드명';
COMMENT ON COLUMN T_USER_NOTE_BY_USER.C_TYPE IS '노드타입';
COMMENT ON COLUMN T_USER_NOTE_BY_USER.C_USER_ID IS '회원ID';
COMMENT ON COLUMN T_USER_NOTE_BY_USER.C_NOTE_DETAIL_ID IS '쪽지상세ID';
COMMENT ON COLUMN T_USER_NOTE_BY_USER.C_NOTE_TYPE_CD IS '쪽지유형코드';
COMMENT ON COLUMN T_USER_NOTE_BY_USER.C_RECE_DISP_DT IS '수발신일시';

/*CREATE UNIQUE INDEX PK_T_USER_NOTE_BY_USER
	ON T_USER_NOTE_BY_USER (
		C_ID ASC
	);*/

ALTER TABLE T_USER_NOTE_BY_USER
	ADD
		CONSTRAINT PK_T_USER_NOTE_BY_USER
		PRIMARY KEY (
			C_ID
		);

ALTER TABLE T_USER_NOTE_BY_USER
	ADD
		CONSTRAINT FK_T_USER_NOTE_DETAIL_TO_T_USER_NOTE_BY_USER
		FOREIGN KEY (
			C_NOTE_DETAIL_ID
		)
		REFERENCES T_USER_NOTE_DETAIL (
			C_ID
		);

/*ALTER TABLE T_USER_NOTE_BY_USER
	ADD
		CONSTRAINT FK_T_USER_INFO_TO_T_USER_NOTE_BY_USER
		FOREIGN KEY (
			C_USER_ID
		)
		REFERENCES T_USER_INFO (
			C_ID
		);*/

ALTER TABLE T_USER_NOTE_BY_USER
	ADD
		CONSTRAINT FK_T_USER_NOTE_TYPE_CODE_TO_T_USER_NOTE_BY_USER
		FOREIGN KEY (
			C_NOTE_TYPE_CD
		)
		REFERENCES T_USER_NOTE_TYPE_CODE (
			C_ID
		);

CREATE SEQUENCE S_USER_NOTE_BY_USER
  START WITH 7313
  MAXVALUE 999999999999999999999999999
  MINVALUE 0
  NOCYCLE
  CACHE 20
  NOORDER;
  
/* 회원_쪽지첨부파일 */
CREATE TABLE T_USER_NOTE_ATTACH_FILE (
	C_ID NUMBER NOT NULL, /* 노드아이디 */
	C_PARENTID NUMBER NOT NULL, /* 부모노드아이디 */
	C_POSITION NUMBER NOT NULL, /* 노드포지션 */
	C_LEFT NUMBER NOT NULL, /* 노드좌측끝포인트 */
	C_RIGHT NUMBER NOT NULL, /* 노드우측끝포인트 */
	C_LEVEL NUMBER NOT NULL, /* 노드레벨 */
	C_TITLE VARCHAR2(4000), /* 노드명 */
	C_TYPE VARCHAR2(100), /* 노드타입 */
	C_NOTE_DETAIL_ID NUMBER NOT NULL, /* 쪽지상세ID */
	C_STORE_FILE_NM VARCHAR2(4000) /* 저장파일명 */
);

COMMENT ON TABLE T_USER_NOTE_ATTACH_FILE IS '회원_쪽지첨부파일';
COMMENT ON COLUMN T_USER_NOTE_ATTACH_FILE.C_ID IS '노드아이디';
COMMENT ON COLUMN T_USER_NOTE_ATTACH_FILE.C_PARENTID IS '부모노드아이디';
COMMENT ON COLUMN T_USER_NOTE_ATTACH_FILE.C_POSITION IS '노드포지션';
COMMENT ON COLUMN T_USER_NOTE_ATTACH_FILE.C_LEFT IS '노드좌측끝포인트';
COMMENT ON COLUMN T_USER_NOTE_ATTACH_FILE.C_RIGHT IS '노드우측끝포인트';
COMMENT ON COLUMN T_USER_NOTE_ATTACH_FILE.C_LEVEL IS '노드레벨';
COMMENT ON COLUMN T_USER_NOTE_ATTACH_FILE.C_TITLE IS '노드명';
COMMENT ON COLUMN T_USER_NOTE_ATTACH_FILE.C_TYPE IS '노드타입';
COMMENT ON COLUMN T_USER_NOTE_ATTACH_FILE.C_NOTE_DETAIL_ID IS '쪽지상세ID';
COMMENT ON COLUMN T_USER_NOTE_ATTACH_FILE.C_STORE_FILE_NM IS '저장파일명';

/*CREATE UNIQUE INDEX PK_T_USER_NOTE_ATTACH_FILE
	ON T_USER_NOTE_ATTACH_FILE (
		C_ID ASC
	);*/

ALTER TABLE T_USER_NOTE_ATTACH_FILE
	ADD
		CONSTRAINT PK_T_USER_NOTE_ATTACH_FILE
		PRIMARY KEY (
			C_ID
		);

ALTER TABLE T_USER_NOTE_ATTACH_FILE
	ADD
		CONSTRAINT FK_T_USER_NOTE_DETAIL_TO_T_USER_NOTE_ATTACH_FILE
		FOREIGN KEY (
			C_NOTE_DETAIL_ID
		)
		REFERENCES T_USER_NOTE_DETAIL (
			C_ID
		);

CREATE SEQUENCE S_USER_NOTE_ATTACH_FILE
  START WITH 7313
  MAXVALUE 999999999999999999999999999
  MINVALUE 0
  NOCYCLE
  CACHE 20
  NOORDER;
  
/* 회원_포인트설정 */
CREATE TABLE T_USER_POINT_SETTING (
	C_ID NUMBER NOT NULL, /* 노드아이디 */
	C_PARENTID NUMBER NOT NULL, /* 부모노드아이디 */
	C_POSITION NUMBER NOT NULL, /* 노드포지션 */
	C_LEFT NUMBER NOT NULL, /* 노드좌측끝포인트 */
	C_RIGHT NUMBER NOT NULL, /* 노드우측끝포인트 */
	C_LEVEL NUMBER NOT NULL, /* 노드레벨 */
	C_TITLE VARCHAR2(4000), /* 노드명 */
	C_TYPE VARCHAR2(100), /* 노드타입 */
	C_POINT_USE_FL CHAR(1) DEFAULT 0 NOT NULL, /* 포인트사용여부 */
	C_DOWNLOAD_PROH_FL CHAR(1) DEFAULT 0 NOT NULL, /* 다운로드금지여부 */
	C_ARTICLE_READ_PROH_FL CHAR(1) DEFAULT 0 NOT NULL, /* 금열람금지여부 */
	C_POINT_EXPIRY_DATE NUMBER NOT NULL, /* 포인트유효기간 */
	C_USER_JOIN_POINT NUMBER NOT NULL, /* 회원가입포인트 */
	C_LOGIN_POINT NUMBER NOT NULL, /* 로그인포인트 */
	C_WRITING_POINT NUMBER NOT NULL, /* 글쓰기포인트 */
	C_ANSWER_POINT NUMBER NOT NULL, /* 댓글포인트 */
	C_UPLOAD_POINT NUMBER NOT NULL, /* 업로드포인트 */
	C_DOWNLOAD_POINT NUMBER NOT NULL, /* 다운로드포인트 */
	C_RECMNDER_POINT NUMBER NOT NULL, /* 추천인포인트 */
	C_DOWNLOAD_DEDU_POINT NUMBER NOT NULL, /* 다운로드차감포인트 */
	C_ARTICLE_READ_DEDU_POINT NUMBER NOT NULL /* 글열람차감포인트 */
);

COMMENT ON TABLE T_USER_POINT_SETTING IS '회원_포인트설정';
COMMENT ON COLUMN T_USER_POINT_SETTING.C_ID IS '노드아이디';
COMMENT ON COLUMN T_USER_POINT_SETTING.C_PARENTID IS '부모노드아이디';
COMMENT ON COLUMN T_USER_POINT_SETTING.C_POSITION IS '노드포지션';
COMMENT ON COLUMN T_USER_POINT_SETTING.C_LEFT IS '노드좌측끝포인트';
COMMENT ON COLUMN T_USER_POINT_SETTING.C_RIGHT IS '노드우측끝포인트';
COMMENT ON COLUMN T_USER_POINT_SETTING.C_LEVEL IS '노드레벨';
COMMENT ON COLUMN T_USER_POINT_SETTING.C_TITLE IS '노드명';
COMMENT ON COLUMN T_USER_POINT_SETTING.C_TYPE IS '노드타입';
COMMENT ON COLUMN T_USER_POINT_SETTING.C_POINT_USE_FL IS '포인트사용여부';
COMMENT ON COLUMN T_USER_POINT_SETTING.C_DOWNLOAD_PROH_FL IS '다운로드금지여부';
COMMENT ON COLUMN T_USER_POINT_SETTING.C_ARTICLE_READ_PROH_FL IS '금열람금지여부';
COMMENT ON COLUMN T_USER_POINT_SETTING.C_POINT_EXPIRY_DATE IS '포인트유효기간';
COMMENT ON COLUMN T_USER_POINT_SETTING.C_USER_JOIN_POINT IS '회원가입포인트';
COMMENT ON COLUMN T_USER_POINT_SETTING.C_LOGIN_POINT IS '로그인포인트';
COMMENT ON COLUMN T_USER_POINT_SETTING.C_WRITING_POINT IS '글쓰기포인트';
COMMENT ON COLUMN T_USER_POINT_SETTING.C_ANSWER_POINT IS '댓글포인트';
COMMENT ON COLUMN T_USER_POINT_SETTING.C_UPLOAD_POINT IS '업로드포인트';
COMMENT ON COLUMN T_USER_POINT_SETTING.C_DOWNLOAD_POINT IS '다운로드포인트';
COMMENT ON COLUMN T_USER_POINT_SETTING.C_RECMNDER_POINT IS '추천인포인트';
COMMENT ON COLUMN T_USER_POINT_SETTING.C_DOWNLOAD_DEDU_POINT IS '다운로드차감포인트';
COMMENT ON COLUMN T_USER_POINT_SETTING.C_ARTICLE_READ_DEDU_POINT IS '글열람차감포인트';

/*CREATE UNIQUE INDEX PK_T_USER_POINT_SETTING
	ON T_USER_POINT_SETTING (
		C_ID ASC
	);*/

ALTER TABLE T_USER_POINT_SETTING
	ADD
		CONSTRAINT PK_T_USER_POINT_SETTING
		PRIMARY KEY (
			C_ID
		);
		
CREATE SEQUENCE S_USER_POINT_SETTING
  START WITH 7313
  MAXVALUE 999999999999999999999999999
  MINVALUE 0
  NOCYCLE
  CACHE 20
  NOORDER;
		
/* 회원_포인트코드 */
CREATE TABLE T_USER_POINT_CODE (
	C_ID NUMBER NOT NULL, /* 노드아이디 */
	C_PARENTID NUMBER NOT NULL, /* 부모노드아이디 */
	C_POSITION NUMBER NOT NULL, /* 노드포지션 */
	C_LEFT NUMBER NOT NULL, /* 노드좌측끝포인트 */
	C_RIGHT NUMBER NOT NULL, /* 노드우측끝포인트 */
	C_LEVEL NUMBER NOT NULL, /* 노드레벨 */
	C_TITLE VARCHAR2(4000), /* 노드명 */
	C_TYPE VARCHAR2(100) /* 노드타입 */
);

COMMENT ON TABLE T_USER_POINT_CODE IS '회원_포인트코드';
COMMENT ON COLUMN T_USER_POINT_CODE.C_ID IS '노드아이디';
COMMENT ON COLUMN T_USER_POINT_CODE.C_PARENTID IS '부모노드아이디';
COMMENT ON COLUMN T_USER_POINT_CODE.C_POSITION IS '노드포지션';
COMMENT ON COLUMN T_USER_POINT_CODE.C_LEFT IS '노드좌측끝포인트';
COMMENT ON COLUMN T_USER_POINT_CODE.C_RIGHT IS '노드우측끝포인트';
COMMENT ON COLUMN T_USER_POINT_CODE.C_LEVEL IS '노드레벨';
COMMENT ON COLUMN T_USER_POINT_CODE.C_TITLE IS '노드명';
COMMENT ON COLUMN T_USER_POINT_CODE.C_TYPE IS '노드타입';

/*CREATE UNIQUE INDEX PK_T_USER_POINT_CODE
	ON T_USER_POINT_CODE (
		C_ID ASC
	);*/

ALTER TABLE T_USER_POINT_CODE
	ADD
		CONSTRAINT PK_T_USER_POINT_CODE
		PRIMARY KEY (
			C_ID
		);

CREATE SEQUENCE S_USER_POINT_CODE
  START WITH 7313
  MAXVALUE 999999999999999999999999999
  MINVALUE 0
  NOCYCLE
  CACHE 20
  NOORDER;		
		
/* 회원_포인트부여 */
CREATE TABLE T_USER_POINT_ASSIGN (
	C_ID NUMBER NOT NULL, /* 노드고유ID */
	C_PARENTID NUMBER NOT NULL, /* 부모노드아이디 */
	C_POSITION NUMBER NOT NULL, /* 노드위치 */
	C_LEFT NUMBER NOT NULL, /* 노드좌측끝포인트 */
	C_RIGHT NUMBER NOT NULL, /* 노드우측끝포인트 */
	C_LEVEL NUMBER NOT NULL, /* 노드레벨 */
	C_TITLE VARCHAR2(4000), /* 노드명 */
	C_TYPE VARCHAR2(100), /* 노드타입 */
	C_USER_ID NUMBER NOT NULL, /* 회원고유ID */
	C_POINT_CODE_ID NUMBER NOT NULL, /* 포인트코드ID */
	C_POINT NUMBER NOT NULL, /* 포인트 */
	C_ASSIGN_DT CHAR(14) NOT NULL, /* 부여일시 */
	C_DESC VARCHAR2(4000) /* 설명 */
);

COMMENT ON TABLE T_USER_POINT_ASSIGN IS '회원_포인트부여';
COMMENT ON COLUMN T_USER_POINT_ASSIGN.C_ID IS '노드고유ID';
COMMENT ON COLUMN T_USER_POINT_ASSIGN.C_PARENTID IS '부모노드아이디';
COMMENT ON COLUMN T_USER_POINT_ASSIGN.C_POSITION IS '노드위치';
COMMENT ON COLUMN T_USER_POINT_ASSIGN.C_LEFT IS '노드좌측끝포인트';
COMMENT ON COLUMN T_USER_POINT_ASSIGN.C_RIGHT IS '노드우측끝포인트';
COMMENT ON COLUMN T_USER_POINT_ASSIGN.C_LEVEL IS '노드레벨';
COMMENT ON COLUMN T_USER_POINT_ASSIGN.C_TITLE IS '노드명';
COMMENT ON COLUMN T_USER_POINT_ASSIGN.C_TYPE IS '노드타입';
COMMENT ON COLUMN T_USER_POINT_ASSIGN.C_USER_ID IS '회원고유ID';
COMMENT ON COLUMN T_USER_POINT_ASSIGN.C_POINT_CODE_ID IS '포인트코드ID';
COMMENT ON COLUMN T_USER_POINT_ASSIGN.C_POINT IS '포인트';
COMMENT ON COLUMN T_USER_POINT_ASSIGN.C_ASSIGN_DT IS '부여일시';
COMMENT ON COLUMN T_USER_POINT_ASSIGN.C_DESC IS '설명';

/*CREATE UNIQUE INDEX PK_T_USER_POINT_ASSIGN
	ON T_USER_POINT_ASSIGN (
		C_ID ASC
	);*/

ALTER TABLE T_USER_POINT_ASSIGN
	ADD
		CONSTRAINT PK_T_USER_POINT_ASSIGN
		PRIMARY KEY (
			C_ID
		);

ALTER TABLE T_USER_POINT_ASSIGN
	ADD
		CONSTRAINT FK_T_USER_INFO_TO_T_USER_POINT_ASSIGN
		FOREIGN KEY (
			C_USER_ID
		)
		REFERENCES T_USER_INFO (
			C_ID
		);

ALTER TABLE T_USER_POINT_ASSIGN
	ADD
		CONSTRAINT FK_T_USER_POINT_CODE_TO_T_USER_POINT_ASSIGN
		FOREIGN KEY (
			C_POINT_CODE_ID
		)
		REFERENCES T_USER_POINT_CODE (
			C_ID
		);

CREATE SEQUENCE S_USER_POINT_ASSIGN
  START WITH 7313
  MAXVALUE 999999999999999999999999999
  MINVALUE 0
  NOCYCLE
  CACHE 20
  NOORDER;