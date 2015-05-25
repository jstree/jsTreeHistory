/* 오권우 시작 */
CREATE TABLE T_USER_INFO_LOG
(
  C_ID        NUMBER                            NOT NULL,
  C_PARENTID  NUMBER                            NOT NULL,
  C_POSITION  NUMBER                            NOT NULL,
  C_LEFT      NUMBER                            NOT NULL,
  C_RIGHT     NUMBER                            NOT NULL,
  C_LEVEL     NUMBER                            NOT NULL,
  C_TITLE     VARCHAR2(4000 BYTE),
  C_TYPE      VARCHAR2(4000 BYTE),
  C_METHOD    VARCHAR2(4000 BYTE),
  C_STATE     VARCHAR2(4000 BYTE),
  C_DATE      DATE                              NOT NULL
);

COMMENT ON TABLE T_USER_INFO_LOG IS '회원_정보 트리거 로그';
COMMENT ON COLUMN T_USER_INFO_LOG.C_ID IS '노드 아이디';
COMMENT ON COLUMN T_USER_INFO_LOG.C_PARENTID IS '부모 노드 아이디';
COMMENT ON COLUMN T_USER_INFO_LOG.C_POSITION IS '노드 포지션';
COMMENT ON COLUMN T_USER_INFO_LOG.C_LEFT IS '노드 좌측 끝 포인트';
COMMENT ON COLUMN T_USER_INFO_LOG.C_RIGHT IS '노드 우측 끝 포인트';
COMMENT ON COLUMN T_USER_INFO_LOG.C_LEVEL IS '노드 DEPTH ';
COMMENT ON COLUMN T_USER_INFO_LOG.C_TITLE IS '노드 명';
COMMENT ON COLUMN T_USER_INFO_LOG.C_TYPE IS '노드 타입';
COMMENT ON COLUMN T_USER_INFO_LOG.C_METHOD IS '노드 변경 행위';
COMMENT ON COLUMN T_USER_INFO_LOG.C_STATE IS '노드 상태값 ( 이전인지. 이후인지)';
COMMENT ON COLUMN T_USER_INFO_LOG.C_DATE IS '노드 변경 시';

CREATE TABLE T_USER_INFO 
(
  C_ID                        NUMBER               NOT NULL,           /* 노드아이디 */
  C_PARENTID                  NUMBER               NOT NULL,           /* 부모노드아이디 */
  C_POSITION                  NUMBER               NOT NULL,           /* 노드포지션 */
  C_LEFT                      NUMBER               NOT NULL,           /* 노드좌측끝포인트 */
  C_RIGHT                     NUMBER               NOT NULL,           /* 노드우측끝포인트 */
  C_LEVEL                     NUMBER               NOT NULL,           /* 노드레벨 */
  C_TITLE                     VARCHAR2(4000)       NOT NULL,           /* 닉네임 */
  C_TYPE                      VARCHAR2(100),                           /* 노드타입 */
  C_USER_GRADE                NUMBER               NOT NULL,           /* 회원등급 */
  C_JOIN_STATE_CD             NUMBER               NOT NULL,           /* 가입상태코드 */
  C_PASSWORD                  VARCHAR2(256)        NOT NULL,           /* 비밀번호 */
  C_EMAIL                     VARCHAR2(320)        NOT NULL,           /* 이메일 */
  C_LOGIN_FAILURE_CNT         NUMBER(1)            DEFAULT 0 NOT NULL, /* 로그인실패횟수 */
  C_PASSWORD_FIND_QUESTION    VARCHAR2(4000)       NOT NULL,           /* 비밀번호찾기질문 */
  C_PASSWORD_FIND_ANSWER      VARCHAR2(4000)       NOT NULL,           /* 비밀번호찾기답변 */
  C_MAILING_SERVICE_USE_FL    CHAR(1)              DEFAULT 0 NOT NULL, /* 메일링서비스사용여부 */
  C_INDI_INFO_OPEN_FL         CHAR(1)              DEFAULT 0 NOT NULL, /* 개인정보공개여부 */
  C_JOIN_DT                   CHAR(14)             NOT NULL,           /* 가입일시 */
  C_PASSWORD_CHANGE_DT        CHAR(14)             NOT NULL,           /* 비밀번호변경일시 */
  C_HOMEPAGE_URL              VARCHAR2(320),                           /* 홈페이지 */
  C_BLOG_URL                  VARCHAR2(320),                           /* 블로그 */
  C_SIGN                      VARCHAR2(320),                           /* 서명 */
  C_PROFILE_PHOTO             VARCHAR2(320),                           /* 프로필사진 */
  C_IMAGE_ICON                VARCHAR2(320),                           /* 사용자아이콘 */
  CONSTRAINT  T_USER_INFO PRIMARY KEY (C_ID, C_TITLE)
);

COMMENT ON TABLE T_USER_INFO IS '회원_정보';
COMMENT ON COLUMN T_USER_INFO.C_ID IS '노드아이디';
COMMENT ON COLUMN T_USER_INFO.C_PARENTID IS '부모노드아이디';
COMMENT ON COLUMN T_USER_INFO.C_POSITION IS '노드포지션';
COMMENT ON COLUMN T_USER_INFO.C_LEFT IS '노드좌측끝포인트';
COMMENT ON COLUMN T_USER_INFO.C_RIGHT IS '노드우측끝포인트';
COMMENT ON COLUMN T_USER_INFO.C_LEVEL IS '노드레벨';
COMMENT ON COLUMN T_USER_INFO.C_TITLE IS '닉네임';
COMMENT ON COLUMN T_USER_INFO.C_TYPE IS '노드타입';
COMMENT ON COLUMN T_USER_INFO.C_USER_GRADE IS '회원등급';
COMMENT ON COLUMN T_USER_INFO.C_JOIN_STATE_CD IS '가입상태코드';
COMMENT ON COLUMN T_USER_INFO.C_PASSWORD IS '비밀번호';
COMMENT ON COLUMN T_USER_INFO.C_EMAIL IS '이메일';
COMMENT ON COLUMN T_USER_INFO.C_LOGIN_FAILURE_CNT IS '로그인실패횟수';
COMMENT ON COLUMN T_USER_INFO.C_PASSWORD_FIND_QUESTION IS '비밀번호찾기질문';
COMMENT ON COLUMN T_USER_INFO.C_PASSWORD_FIND_ANSWER IS '비밀번호찾기답변';
COMMENT ON COLUMN T_USER_INFO.C_MAILING_SERVICE_USE_FL IS '메일링서비스사용여부';
COMMENT ON COLUMN T_USER_INFO.C_INDI_INFO_OPEN_FL IS '개인정보공개여부';
COMMENT ON COLUMN T_USER_INFO.C_JOIN_DT IS '가입일시';
COMMENT ON COLUMN T_USER_INFO.C_PASSWORD_CHANGE_DT IS '비밀번호변경일시';
COMMENT ON COLUMN T_USER_INFO.C_HOMEPAGE_URL IS '홈페이지';
COMMENT ON COLUMN T_USER_INFO.C_BLOG_URL IS '블로그';
COMMENT ON COLUMN T_USER_INFO.C_SIGN IS '서명';
COMMENT ON COLUMN T_USER_INFO.C_PROFILE_PHOTO IS '프로필사진';
COMMENT ON COLUMN T_USER_INFO.C_IMAGE_ICON IS '사용자아이콘';

DROP SEQUENCE S_USER_INFO;

CREATE SEQUENCE S_USER_INFO
  START WITH 10
  MAXVALUE 999999999999999999999999999
  MINVALUE 0
  NOCYCLE
  CACHE 20
  NOORDER;

/*
 * T_USER_INFO 트리거
 */
CREATE OR REPLACE TRIGGER "TRIGGER_T_USER_INFO" 
BEFORE DELETE OR INSERT OR UPDATE
ON T_USER_INFO
REFERENCING NEW AS NEW OLD AS OLD
FOR EACH ROW
DECLARE
tmpVar NUMBER;
/******************************************************************************
   NAME:       TRIGGER_T_USER_INFO
   PURPOSE:    

   REVISIONS:
   Ver        Date        Author           Description
   ---------  ----------  ---------------  ------------------------------------
   1.0        2015-05-02             1. Created this trigger.

   NOTES:

   Automatically available Auto Replace Keywords:
      Object Name:     TRIGGER_T_USER_INFO
      Sysdate:         2015-05-02
      Date and Time:   2015-05-02, 오후 9:23:25, and 2015-05-02 오후 9:23:25
      Username:         (set in TOAD Options, Proc Templates)
      Table Name:      T_USER_INFO (set in the "New PL/SQL Object" dialog)
      Trigger Options:  (set in the "New PL/SQL Object" dialog)
******************************************************************************/
BEGIN
   tmpVar := 0;
    IF UPDATING  THEN    
        insert into T_USER_INFO_LOG 
        values (:old.C_ID,:old.C_PARENTID,:old.C_POSITION,:old.C_LEFT,:old.C_RIGHT,:old.C_LEVEL,:old.C_TITLE,:old.C_TYPE,'update','변경이전데이터',sysdate);        
        insert into T_USER_INFO_LOG 
        values (:new.C_ID,:new.C_PARENTID,:new.C_POSITION,:new.C_LEFT,:new.C_RIGHT,:new.C_LEVEL,:new.C_TITLE,:new.C_TYPE,'update','변경이후데이터',sysdate);   
     END IF;
    IF DELETING THEN
        insert into T_USER_INFO_LOG 
        values (:old.C_ID,:old.C_PARENTID,:old.C_POSITION,:old.C_LEFT,:old.C_RIGHT,:old.C_LEVEL,:old.C_TITLE,:old.C_TYPE,'delete','삭제된데이터',sysdate);
    END IF;   
    IF INSERTING  THEN
        insert into T_USER_INFO_LOG 
        values (:new.C_ID,:new.C_PARENTID,:new.C_POSITION,:new.C_LEFT,:new.C_RIGHT,:new.C_LEVEL,:new.C_TITLE,:new.C_TYPE,'insert','삽입된데이터',sysdate);
    END IF;

   EXCEPTION
     WHEN OTHERS THEN
       -- Consider logging the error and then re-raise
       RAISE;
END TRIGGER_T_USER_INFO;
/


/* 회원_로그인 현황
 * T_USER_LOGIN_CURRENT_STATE 추적 로그 테이블
 * 트리거 Log를 저장합니다.
 */
CREATE TABLE T_USER_LOGIN_STATE_LOG
(
  C_ID        NUMBER                            NOT NULL,
  C_PARENTID  NUMBER                            NOT NULL,
  C_POSITION  NUMBER                            NOT NULL,
  C_LEFT      NUMBER                            NOT NULL,
  C_RIGHT     NUMBER                            NOT NULL,
  C_LEVEL     NUMBER                            NOT NULL,
  C_TITLE     VARCHAR2(4000 BYTE),
  C_TYPE      VARCHAR2(4000 BYTE),
  C_METHOD    VARCHAR2(4000 BYTE),
  C_STATE     VARCHAR2(4000 BYTE),
  C_DATE      DATE                              NOT NULL
);

COMMENT ON TABLE T_USER_INFO_LOG IS '회원_로그인현황 트리거 로그';
COMMENT ON COLUMN T_USER_INFO_LOG.C_ID IS '노드 아이디';
COMMENT ON COLUMN T_USER_INFO_LOG.C_PARENTID IS '부모 노드 아이디';
COMMENT ON COLUMN T_USER_INFO_LOG.C_POSITION IS '노드 포지션';
COMMENT ON COLUMN T_USER_INFO_LOG.C_LEFT IS '노드 좌측 끝 포인트';
COMMENT ON COLUMN T_USER_INFO_LOG.C_RIGHT IS '노드 우측 끝 포인트';
COMMENT ON COLUMN T_USER_INFO_LOG.C_LEVEL IS '노드 DEPTH ';
COMMENT ON COLUMN T_USER_INFO_LOG.C_TITLE IS '노드 명';
COMMENT ON COLUMN T_USER_INFO_LOG.C_TYPE IS '노드 타입';
COMMENT ON COLUMN T_USER_INFO_LOG.C_METHOD IS '노드 변경 행위';
COMMENT ON COLUMN T_USER_INFO_LOG.C_STATE IS '노드 상태값 ( 이전인지. 이후인지)';
COMMENT ON COLUMN T_USER_INFO_LOG.C_DATE IS '노드 변경 시';

CREATE TABLE T_USER_LOGIN_STATE 
(
  C_ID                        NUMBER               NOT NULL,           /* 노드아이디 */
  C_PARENTID                  NUMBER               NOT NULL,           /* 부모노드아이디 */
  C_POSITION                  NUMBER               NOT NULL,           /* 노드포지션 */
  C_LEFT                      NUMBER               NOT NULL,           /* 노드좌측끝포인트 */
  C_RIGHT                     NUMBER               NOT NULL,           /* 노드우측끝포인트 */
  C_LEVEL                     NUMBER               NOT NULL,           /* 노드레벨 */
  C_TITLE                     VARCHAR2(4000)       NOT NULL,           /* 처리상태 */
  C_TYPE                      VARCHAR2(100),                           /* 노드타입 */
  C_USER_ID                   NUMBER               NOT NULL,           /* 회원아이디 */
  C_MAC_ADDRESS               VARCHAR2(17)         NOT NULL,           /* MAC주소 */
  C_IP_ADDRESS                VARCHAR2(39)         NOT NULL,           /* 아이피주소 */
  C_LOGIN_DT                  CHAR(14)             NOT NULL,           /* 로그인일시 */
  CONSTRAINT  T_USER_LOGIN_STATE PRIMARY KEY (C_ID)
);

COMMENT ON TABLE T_USER_LOGIN_STATE IS '회원_로그인현황';
COMMENT ON COLUMN T_USER_LOGIN_STATE.C_ID IS '노드아이디';
COMMENT ON COLUMN T_USER_LOGIN_STATE.C_PARENTID IS '부모노드아이디';
COMMENT ON COLUMN T_USER_LOGIN_STATE.C_POSITION IS '노드포지션';
COMMENT ON COLUMN T_USER_LOGIN_STATE.C_LEFT IS '노드좌측끝포인트';
COMMENT ON COLUMN T_USER_LOGIN_STATE.C_RIGHT IS '노드우측끝포인트';
COMMENT ON COLUMN T_USER_LOGIN_STATE.C_LEVEL IS '노드레벨';
COMMENT ON COLUMN T_USER_LOGIN_STATE.C_TITLE IS '처리상태';
COMMENT ON COLUMN T_USER_LOGIN_STATE.C_TYPE IS '노드타입';
COMMENT ON COLUMN T_USER_LOGIN_STATE.C_USER_ID IS '회원아이디';
COMMENT ON COLUMN T_USER_LOGIN_STATE.C_MAC_ADDRESS IS 'MAC주소';
COMMENT ON COLUMN T_USER_LOGIN_STATE.C_IP_ADDRESS IS '아이피주소';
COMMENT ON COLUMN T_USER_LOGIN_STATE.C_LOGIN_DT IS '로그인일시';

DROP SEQUENCE S_USER_LOGIN_STATE;

CREATE SEQUENCE S_USER_LOGIN_STATE
  START WITH 10
  MAXVALUE 999999999999999999999999999
  MINVALUE 0
  NOCYCLE
  CACHE 20
  NOORDER;

/*
 * T_USER_LOGIN_STATE 트리거
 */
CREATE OR REPLACE TRIGGER "TRIGGER_T_USER_LOGIN_STATE" 
BEFORE DELETE OR INSERT OR UPDATE
ON T_USER_LOGIN_STATE
REFERENCING NEW AS NEW OLD AS OLD
FOR EACH ROW
DECLARE
tmpVar NUMBER;
/******************************************************************************

   NAME:       TRIGGER_T_USER_LOGIN_STATE
   PURPOSE:    

   REVISIONS:
   Ver        Date        Author           Description
   ---------  ----------  ---------------  ------------------------------------
   1.0        2015-05-02             1. Created this trigger.

   NOTES:

   Automatically available Auto Replace Keywords:
      Object Name:     TRIGGER_T_USER_LOGIN_STATE
      Sysdate:         2015-05-02
      Date and Time:   2015-05-02, 오후 9:23:25, and 2015-05-02 오후 9:23:25
      Username:         (set in TOAD Options, Proc Templates)
      Table Name:      T_USER_LOGIN_STATE (set in the "New PL/SQL Object" dialog)
      Trigger Options:  (set in the "New PL/SQL Object" dialog)
******************************************************************************/
BEGIN
   tmpVar := 0;
    IF UPDATING  THEN    
        insert into T_USER_LOGIN_STATE_LOG 
        values (:old.C_ID,:old.C_PARENTID,:old.C_POSITION,:old.C_LEFT,:old.C_RIGHT,:old.C_LEVEL,:old.C_TITLE,:old.C_TYPE,'update','변경이전데이터',sysdate);        
        insert into T_USER_LOGIN_STATE_LOG 
        values (:new.C_ID,:new.C_PARENTID,:new.C_POSITION,:new.C_LEFT,:new.C_RIGHT,:new.C_LEVEL,:new.C_TITLE,:new.C_TYPE,'update','변경이후데이터',sysdate);   
     END IF;
    IF DELETING THEN
        insert into T_USER_LOGIN_STATE_LOG 
        values (:old.C_ID,:old.C_PARENTID,:old.C_POSITION,:old.C_LEFT,:old.C_RIGHT,:old.C_LEVEL,:old.C_TITLE,:old.C_TYPE,'delete','삭제된데이터',sysdate);
    END IF;   
    IF INSERTING  THEN
        insert into T_USER_LOGIN_STATE_LOG 
        values (:new.C_ID,:new.C_PARENTID,:new.C_POSITION,:new.C_LEFT,:new.C_RIGHT,:new.C_LEVEL,:new.C_TITLE,:new.C_TYPE,'insert','삽입된데이터',sysdate);
    END IF;

   EXCEPTION
     WHEN OTHERS THEN
       -- Consider logging the error and then re-raise
       RAISE;
END TRIGGER_T_USER_LOGIN_STATE;
/


/* 회원_가입상태
 * T_USER_JOIN_STATE 추적 로그 테이블
 * 트리거 Log를 저장합니다.
 */
CREATE TABLE T_USER_JOIN_STATE_LOG
(
  C_ID        NUMBER                            NOT NULL,
  C_PARENTID  NUMBER                            NOT NULL,
  C_POSITION  NUMBER                            NOT NULL,
  C_LEFT      NUMBER                            NOT NULL,
  C_RIGHT     NUMBER                            NOT NULL,
  C_LEVEL     NUMBER                            NOT NULL,
  C_TITLE     VARCHAR2(4000 BYTE),
  C_TYPE      VARCHAR2(4000 BYTE),
  C_METHOD    VARCHAR2(4000 BYTE),
  C_STATE     VARCHAR2(4000 BYTE),
  C_DATE      DATE                              NOT NULL
);

COMMENT ON TABLE T_USER_INFO_LOG IS '회원_가입상태 트리거 로그';
COMMENT ON COLUMN T_USER_INFO_LOG.C_ID IS '노드 아이디';
COMMENT ON COLUMN T_USER_INFO_LOG.C_PARENTID IS '부모 노드 아이디';
COMMENT ON COLUMN T_USER_INFO_LOG.C_POSITION IS '노드 포지션';
COMMENT ON COLUMN T_USER_INFO_LOG.C_LEFT IS '노드 좌측 끝 포인트';
COMMENT ON COLUMN T_USER_INFO_LOG.C_RIGHT IS '노드 우측 끝 포인트';
COMMENT ON COLUMN T_USER_INFO_LOG.C_LEVEL IS '노드 DEPTH ';
COMMENT ON COLUMN T_USER_INFO_LOG.C_TITLE IS '노드 명';
COMMENT ON COLUMN T_USER_INFO_LOG.C_TYPE IS '노드 타입';
COMMENT ON COLUMN T_USER_INFO_LOG.C_METHOD IS '노드 변경 행위';
COMMENT ON COLUMN T_USER_INFO_LOG.C_STATE IS '노드 상태값 ( 이전인지. 이후인지)';
COMMENT ON COLUMN T_USER_INFO_LOG.C_DATE IS '노드 변경 시';

CREATE TABLE T_USER_JOIN_STATE
(
  C_ID                        NUMBER               NOT NULL,          /* 노드아이디 */
  C_PARENTID                  NUMBER               NOT NULL,          /* 부모노드아이디 */
  C_POSITION                  NUMBER               NOT NULL,          /* 노드포지션 */
  C_LEFT                      NUMBER               NOT NULL,          /* 노드좌측끝포인트 */
  C_RIGHT                     NUMBER               NOT NULL,          /* 노드우측끝포인트 */
  C_LEVEL                     NUMBER               NOT NULL,          /* 노드레벨 */
  C_TITLE                     VARCHAR2(4000)       NOT NULL,          /* 가입상태명 */
  C_TYPE                      VARCHAR2(100),                          /* 노드타입 */
  CONSTRAINT  T_USER_JOIN_STATE PRIMARY KEY (C_ID)
);

COMMENT ON TABLE T_USER_JOIN_STATE IS '회원_가입상태';
COMMENT ON COLUMN T_USER_JOIN_STATE.C_ID IS '노드아이디';
COMMENT ON COLUMN T_USER_JOIN_STATE.C_PARENTID IS '부모노드아이디';
COMMENT ON COLUMN T_USER_JOIN_STATE.C_POSITION IS '노드포지션';
COMMENT ON COLUMN T_USER_JOIN_STATE.C_LEFT IS '노드좌측끝포인트';
COMMENT ON COLUMN T_USER_JOIN_STATE.C_RIGHT IS '노드우측끝포인트';
COMMENT ON COLUMN T_USER_JOIN_STATE.C_LEVEL IS '노드레벨';
COMMENT ON COLUMN T_USER_JOIN_STATE.C_TITLE IS '가입상태명';
COMMENT ON COLUMN T_USER_JOIN_STATE.C_TYPE IS '노드타입';

DROP SEQUENCE S_USER_JOIN_STATE;

CREATE SEQUENCE S_USER_JOIN_STATE
  START WITH 10
  MAXVALUE 999999999999999999999999999
  MINVALUE 0
  NOCYCLE
  CACHE 20
  NOORDER;

/*
 * T_USER_LOGIN_JOIN_STATE 트리거
 */
CREATE OR REPLACE TRIGGER "TRIGGER_T_USER_JOIN_STATE" 
BEFORE DELETE OR INSERT OR UPDATE
ON T_USER_JOIN_STATE
REFERENCING NEW AS NEW OLD AS OLD
FOR EACH ROW
DECLARE
tmpVar NUMBER;
/******************************************************************************

   NAME:       TRIGGER_T_USER_JOIN_STATE
   PURPOSE:    

   REVISIONS:
   Ver        Date        Author           Description
   ---------  ----------  ---------------  ------------------------------------
   1.0        2015-05-02             1. Created this trigger.

   NOTES:

   Automatically available Auto Replace Keywords:
      Object Name:     TRIGGER_T_USER_JOIN_STATE
      Sysdate:         2015-05-02
      Date and Time:   2015-05-02, 오후 9:23:25, and 2015-05-02 오후 9:23:25
      Username:         (set in TOAD Options, Proc Templates)
      Table Name:      T_USER_JOIN_STATE (set in the "New PL/SQL Object" dialog)
      Trigger Options:  (set in the "New PL/SQL Object" dialog)
******************************************************************************/
BEGIN
   tmpVar := 0;
    IF UPDATING  THEN    
        insert into T_USER_JOIN_STATE_LOG 
        values (:old.C_ID,:old.C_PARENTID,:old.C_POSITION,:old.C_LEFT,:old.C_RIGHT,:old.C_LEVEL,:old.C_TITLE,:old.C_TYPE,'update','변경이전데이터',sysdate);        
        insert into T_USER_JOIN_STATE_LOG 
        values (:new.C_ID,:new.C_PARENTID,:new.C_POSITION,:new.C_LEFT,:new.C_RIGHT,:new.C_LEVEL,:new.C_TITLE,:new.C_TYPE,'update','변경이후데이터',sysdate);   
     END IF;
    IF DELETING THEN
        insert into T_USER_JOIN_STATE_LOG 
        values (:old.C_ID,:old.C_PARENTID,:old.C_POSITION,:old.C_LEFT,:old.C_RIGHT,:old.C_LEVEL,:old.C_TITLE,:old.C_TYPE,'delete','삭제된데이터',sysdate);
    END IF;   
    IF INSERTING  THEN
        insert into T_USER_JOIN_STATE_LOG 
        values (:new.C_ID,:new.C_PARENTID,:new.C_POSITION,:new.C_LEFT,:new.C_RIGHT,:new.C_LEVEL,:new.C_TITLE,:new.C_TYPE,'insert','삽입된데이터',sysdate);
    END IF;

   EXCEPTION
     WHEN OTHERS THEN
       -- Consider logging the error and then re-raise
       RAISE;
END TRIGGER_T_USER_JOIN_STATE;
/

/* 회원_스크랩
 * T_USER_SCRAP 추적 로그 테이블
 * 트리거 Log를 저장합니다. 
 */
 
 CREATE TABLE T_USER_SCRAP_LOG
(
  C_ID        NUMBER                            NOT NULL,
  C_PARENTID  NUMBER                            NOT NULL,
  C_POSITION  NUMBER                            NOT NULL,
  C_LEFT      NUMBER                            NOT NULL,
  C_RIGHT     NUMBER                            NOT NULL,
  C_LEVEL     NUMBER                            NOT NULL,
  C_TITLE     VARCHAR2(4000 BYTE),
  C_TYPE      VARCHAR2(4000 BYTE),
  C_METHOD    VARCHAR2(4000 BYTE),
  C_STATE     VARCHAR2(4000 BYTE),
  C_DATE      DATE                              NOT NULL
);

COMMENT ON TABLE T_USER_INFO_LOG IS '회원_스크랩 트리거 로그';
COMMENT ON COLUMN T_USER_INFO_LOG.C_ID IS '노드 아이디';
COMMENT ON COLUMN T_USER_INFO_LOG.C_PARENTID IS '부모 노드 아이디';
COMMENT ON COLUMN T_USER_INFO_LOG.C_POSITION IS '노드 포지션';
COMMENT ON COLUMN T_USER_INFO_LOG.C_LEFT IS '노드 좌측 끝 포인트';
COMMENT ON COLUMN T_USER_INFO_LOG.C_RIGHT IS '노드 우측 끝 포인트';
COMMENT ON COLUMN T_USER_INFO_LOG.C_LEVEL IS '노드 DEPTH ';
COMMENT ON COLUMN T_USER_INFO_LOG.C_TITLE IS '노드 명';
COMMENT ON COLUMN T_USER_INFO_LOG.C_TYPE IS '노드 타입';
COMMENT ON COLUMN T_USER_INFO_LOG.C_METHOD IS '노드 변경 행위';
COMMENT ON COLUMN T_USER_INFO_LOG.C_STATE IS '노드 상태값 ( 이전인지. 이후인지)';
COMMENT ON COLUMN T_USER_INFO_LOG.C_DATE IS '노드 변경 시';

CREATE TABLE T_USER_SCRAP
(
  C_ID                        NUMBER               NOT NULL,          /* 노드아이디 */  
  C_PARENTID                  NUMBER               NOT NULL,          /* 부모노드아이디 */
  C_POSITION                  NUMBER               NOT NULL,          /* 노드포지션 */
  C_LEFT                      NUMBER               NOT NULL,          /* 노드좌측끝포인트 */
  C_RIGHT                     NUMBER               NOT NULL,          /* 노드우측끝포인트 */
  C_LEVEL                     NUMBER               NOT NULL,          /* 노드레벨 */
  C_TITLE                     VARCHAR2(4000)       NOT NULL,          /* 가입상태명 */
  C_TYPE                      VARCHAR2(100),                          /* 노드타입 */
  C_USER_ID                   NUMBER               NOT NULL,          /* 회원아이디 */
  C_BOARD_ID                  NUMBER               NOT NULL,          /* 보드아이디 */
  C_POSTING_ID                NUMBER               NOT NULL,          /* 글ID */
  C_SCRAP_DT                  CHAR(14)             NOT NULL,          /* 스크랩일시 */
  CONSTRAINT  T_USER_SCRAP PRIMARY KEY (C_ID)
);


COMMENT ON TABLE T_USER_SCRAP IS '회원_스크랩';
COMMENT ON COLUMN T_USER_SCRAP.C_ID IS '노드아이디';
COMMENT ON COLUMN T_USER_SCRAP.C_USER_ID IS '회원아이디';
COMMENT ON COLUMN T_USER_SCRAP.C_PARENTID IS '부모노드아이디';
COMMENT ON COLUMN T_USER_SCRAP.C_POSITION IS '노드포지션';
COMMENT ON COLUMN T_USER_SCRAP.C_LEFT IS '노드좌측끝포인트';
COMMENT ON COLUMN T_USER_SCRAP.C_RIGHT IS '노드우측끝포인트';
COMMENT ON COLUMN T_USER_SCRAP.C_LEVEL IS '노드레벨';
COMMENT ON COLUMN T_USER_SCRAP.C_TITLE IS '노드명';
COMMENT ON COLUMN T_USER_SCRAP.C_TYPE IS '노드타입';
COMMENT ON COLUMN T_USER_SCRAP.C_BOARD_ID IS '보드아이디';
COMMENT ON COLUMN T_USER_SCRAP.C_POSTING_ID IS '글ID';
COMMENT ON COLUMN T_USER_SCRAP.C_SCRAP_DT IS '스크랩일시';

DROP SEQUENCE S_USER_SCRAP;

CREATE SEQUENCE S_USER_SCRAP
  START WITH 10
  MAXVALUE 999999999999999999999999999
  MINVALUE 0
  NOCYCLE
  CACHE 20
  NOORDER;

/*
 * T_USER_SCRAP 트리거
 */
CREATE OR REPLACE TRIGGER "TRIGGER_T_USER_SCRAP" 
BEFORE DELETE OR INSERT OR UPDATE
ON T_USER_SCRAP
REFERENCING NEW AS NEW OLD AS OLD
FOR EACH ROW
DECLARE
tmpVar NUMBER;
/******************************************************************************

   NAME:       TRIGGER_T_USER_SCRAP
   PURPOSE:    

   REVISIONS:
   Ver        Date        Author           Description
   ---------  ----------  ---------------  ------------------------------------
   1.0        2015-05-02             1. Created this trigger.

   NOTES:

   Automatically available Auto Replace Keywords:
      Object Name:     TRIGGER_T_USER_SCRAP
      Sysdate:         2015-05-02
      Date and Time:   2015-05-02, 오후 9:23:25, and 2015-05-02 오후 9:23:25
      Username:         (set in TOAD Options, Proc Templates)
      Table Name:      T_USER_SCRAP (set in the "New PL/SQL Object" dialog)
      Trigger Options:  (set in the "New PL/SQL Object" dialog)
******************************************************************************/
BEGIN
   tmpVar := 0;
    IF UPDATING  THEN    
        insert into T_USER_SCRAP_LOG 
        values (:old.C_ID,:old.C_PARENTID,:old.C_POSITION,:old.C_LEFT,:old.C_RIGHT,:old.C_LEVEL,:old.C_TITLE,:old.C_TYPE,'update','변경이전데이터',sysdate);        
        insert into T_USER_SCRAP_LOG 
        values (:new.C_ID,:new.C_PARENTID,:new.C_POSITION,:new.C_LEFT,:new.C_RIGHT,:new.C_LEVEL,:new.C_TITLE,:new.C_TYPE,'update','변경이후데이터',sysdate);   
     END IF;
    IF DELETING THEN
        insert into T_USER_SCRAP_LOG 
        values (:old.C_ID,:old.C_PARENTID,:old.C_POSITION,:old.C_LEFT,:old.C_RIGHT,:old.C_LEVEL,:old.C_TITLE,:old.C_TYPE,'delete','삭제된데이터',sysdate);
    END IF;   
    IF INSERTING  THEN
        insert into T_USER_JOIN_STATE_LOG 
        values (:new.C_ID,:new.C_PARENTID,:new.C_POSITION,:new.C_LEFT,:new.C_RIGHT,:new.C_LEVEL,:new.C_TITLE,:new.C_TYPE,'insert','삽입된데이터',sysdate);
    END IF;

   EXCEPTION
     WHEN OTHERS THEN
       -- Consider logging the error and then re-raise
       RAISE;
END TRIGGER_T_USER_SCRAP;
/
/* 오권우  끝 */  

/* 류강하 시작 */
/* 회원_금지단어 */
DROP TABLE T_USER_PROH_WORD_LOG;

CREATE TABLE T_USER_PROH_WORD_LOG
(
  C_ID        NUMBER                            NOT NULL,
  C_PARENTID  NUMBER                            NOT NULL,
  C_POSITION  NUMBER                            NOT NULL,
  C_LEFT      NUMBER                            NOT NULL,
  C_RIGHT     NUMBER                            NOT NULL,
  C_LEVEL     NUMBER                            NOT NULL,
  C_TITLE     VARCHAR2(4000 BYTE)               NOT NULL,
  C_TYPE      VARCHAR2(100 BYTE),
  C_METHOD    VARCHAR2(4000 BYTE)               NOT NULL,
  C_STATE     VARCHAR2(4000 BYTE)               NOT NULL,
  C_DATE      DATE                              NOT NULL
);

COMMENT ON TABLE T_USER_PROH_WORD_LOG IS '회원_금지단어 트리거 로그';
COMMENT ON COLUMN T_USER_PROH_WORD_LOG.C_ID IS '노드 아이디';
COMMENT ON COLUMN T_USER_PROH_WORD_LOG.C_PARENTID IS '부모 노드 아이디';
COMMENT ON COLUMN T_USER_PROH_WORD_LOG.C_POSITION IS '노드 포지션';
COMMENT ON COLUMN T_USER_PROH_WORD_LOG.C_LEFT IS '노드 좌측 끝 포인트';
COMMENT ON COLUMN T_USER_PROH_WORD_LOG.C_RIGHT IS '노드 우측 끝 포인트';
COMMENT ON COLUMN T_USER_PROH_WORD_LOG.C_LEVEL IS '노드 DEPTH ';
COMMENT ON COLUMN T_USER_PROH_WORD_LOG.C_TITLE IS '노드 명';
COMMENT ON COLUMN T_USER_PROH_WORD_LOG.C_TYPE IS '노드 타입';
COMMENT ON COLUMN T_USER_PROH_WORD_LOG.C_METHOD IS '노드 변경 행위';
COMMENT ON COLUMN T_USER_PROH_WORD_LOG.C_STATE IS '노드 상태값 ( 이전인지. 이후인지)';
COMMENT ON COLUMN T_USER_PROH_WORD_LOG.C_DATE IS '노드 변경 시';

DROP TABLE T_USER_PROH_WORD;
  
CREATE TABLE T_USER_PROH_WORD (
    C_ID NUMBER NOT NULL, /* 노드아이디 */
    C_PARENTID NUMBER NOT NULL, /* 부모노드아이디 */
    C_POSITION NUMBER NOT NULL, /* 노드포지션 */
    C_LEFT NUMBER NOT NULL, /* 노드좌측끝포인트 */
    C_RIGHT NUMBER NOT NULL, /* 노드우측끝포인트 */
    C_LEVEL NUMBER NOT NULL, /* 노드레벨 */
    C_TITLE VARCHAR2(4000) NOT NULL, /* 단어명 */
    C_TYPE VARCHAR2(100) /* 노드타입 */
);

COMMENT ON TABLE T_USER_PROH_WORD IS '회원_금지단어';

COMMENT ON COLUMN T_USER_PROH_WORD.C_ID IS '노드아이디';

COMMENT ON COLUMN T_USER_PROH_WORD.C_PARENTID IS '부모노드아이디';

COMMENT ON COLUMN T_USER_PROH_WORD.C_POSITION IS '노드포지션';

COMMENT ON COLUMN T_USER_PROH_WORD.C_LEFT IS '노드좌측끝포인트';

COMMENT ON COLUMN T_USER_PROH_WORD.C_RIGHT IS '노드우측끝포인트';

COMMENT ON COLUMN T_USER_PROH_WORD.C_LEVEL IS '노드레벨';

COMMENT ON COLUMN T_USER_PROH_WORD.C_TITLE IS '단어명';

COMMENT ON COLUMN T_USER_PROH_WORD.C_TYPE IS '노드타입';

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
  START WITH 5
  MAXVALUE 999999999999999999999999999
  MINVALUE 0
  NOCYCLE
  CACHE 20
  NOORDER;

CREATE OR REPLACE TRIGGER "TRIGGER_USER_PROH_WORD"
BEFORE DELETE OR INSERT OR UPDATE
ON T_USER_PROH_WORD
REFERENCING NEW AS NEW OLD AS OLD
FOR EACH ROW
DECLARE
tmpVar NUMBER;

BEGIN
   tmpVar := 0;
    IF UPDATING  THEN    
        insert into T_USER_PROH_WORD_LOG 
        values (:old.C_ID,:old.C_PARENTID,:old.C_POSITION,:old.C_LEFT,:old.C_RIGHT,:old.C_LEVEL,:old.C_TITLE,:old.C_TYPE,'update','변경이전데이터',sysdate);        
        insert into T_USER_PROH_WORD_LOG 
        values (:new.C_ID,:new.C_PARENTID,:new.C_POSITION,:new.C_LEFT,:new.C_RIGHT,:new.C_LEVEL,:new.C_TITLE,:new.C_TYPE,'update','변경이후데이터',sysdate);   
     END IF;
    IF DELETING THEN
        insert into T_USER_PROH_WORD_LOG 
        values (:old.C_ID,:old.C_PARENTID,:old.C_POSITION,:old.C_LEFT,:old.C_RIGHT,:old.C_LEVEL,:old.C_TITLE,:old.C_TYPE,'delete','삭제된데이터',sysdate);
    END IF;   
    IF INSERTING  THEN
        insert into T_USER_PROH_WORD_LOG 
        values (:new.C_ID,:new.C_PARENTID,:new.C_POSITION,:new.C_LEFT,:new.C_RIGHT,:new.C_LEVEL,:new.C_TITLE,:new.C_TYPE,'insert','삽입된데이터',sysdate);
    END IF;

   EXCEPTION
     WHEN OTHERS THEN
       -- Consider logging the error and then re-raise
       RAISE;
END TRIGGER_USER_PROH_WORD;

/* 회원_기본컨텐츠 */
DROP TABLE T_USER_BASIC_CONTENTS_LOG;

CREATE TABLE T_USER_BASIC_CONTENTS_LOG
(
  C_ID        NUMBER                            NOT NULL,
  C_PARENTID  NUMBER                            NOT NULL,
  C_POSITION  NUMBER                            NOT NULL,
  C_LEFT      NUMBER                            NOT NULL,
  C_RIGHT     NUMBER                            NOT NULL,
  C_LEVEL     NUMBER                            NOT NULL,
  C_TITLE     VARCHAR2(4000 BYTE)               NOT NULL,
  C_TYPE      VARCHAR2(100 BYTE),
  C_METHOD    VARCHAR2(4000 BYTE)               NOT NULL,
  C_STATE     VARCHAR2(4000 BYTE)               NOT NULL,
  C_DATE      DATE                              NOT NULL
);

COMMENT ON TABLE T_USER_PROH_WORD_LOG IS '회원_기본컨텐츠 트리거 로그';
COMMENT ON COLUMN T_USER_PROH_WORD_LOG.C_ID IS '노드 아이디';
COMMENT ON COLUMN T_USER_PROH_WORD_LOG.C_PARENTID IS '부모 노드 아이디';
COMMENT ON COLUMN T_USER_PROH_WORD_LOG.C_POSITION IS '노드 포지션';
COMMENT ON COLUMN T_USER_PROH_WORD_LOG.C_LEFT IS '노드 좌측 끝 포인트';
COMMENT ON COLUMN T_USER_PROH_WORD_LOG.C_RIGHT IS '노드 우측 끝 포인트';
COMMENT ON COLUMN T_USER_PROH_WORD_LOG.C_LEVEL IS '노드 DEPTH ';
COMMENT ON COLUMN T_USER_PROH_WORD_LOG.C_TITLE IS '노드 명';
COMMENT ON COLUMN T_USER_PROH_WORD_LOG.C_TYPE IS '노드 타입';
COMMENT ON COLUMN T_USER_PROH_WORD_LOG.C_METHOD IS '노드 변경 행위';
COMMENT ON COLUMN T_USER_PROH_WORD_LOG.C_STATE IS '노드 상태값 ( 이전인지. 이후인지)';
COMMENT ON COLUMN T_USER_PROH_WORD_LOG.C_DATE IS '노드 변경 시';

DROP TABLE T_USER_BASIC_CONTENTS;

CREATE TABLE T_USER_BASIC_CONTENTS (
    C_ID NUMBER NOT NULL, /* 노드아이디 */
    C_PARENTID NUMBER NOT NULL, /* 부모노드아이디 */
    C_POSITION NUMBER NOT NULL, /* 노드포지션 */
    C_LEFT NUMBER NOT NULL, /* 노드좌측끝포인트 */
    C_RIGHT NUMBER NOT NULL, /* 노드우측끝포인트 */
    C_LEVEL NUMBER NOT NULL, /* 노드레벨 */
    C_TITLE VARCHAR2(4000) NOT NULL, /* 노드명 */
    C_TYPE VARCHAR2(100), /* 노드타입 */
    C_COMPANY_INTR VARCHAR2(4000) NOT NULL, /* 회사소개 */
    C_TERMS_OF_USE VARCHAR2(4000) NOT NULL, /* 이용약관 */
    C_PRIVACY_POLICY VARCHAR2(4000) NOT NULL /* 개인정보취급방침 */
);

COMMENT ON TABLE T_USER_BASIC_CONTENTS IS '회원_기본컨텐츠';

COMMENT ON COLUMN T_USER_BASIC_CONTENTS.C_ID IS '노드아이디';

COMMENT ON COLUMN T_USER_BASIC_CONTENTS.C_PARENTID IS '부모노드아이디';

COMMENT ON COLUMN T_USER_BASIC_CONTENTS.C_POSITION IS '노드포지션';

COMMENT ON COLUMN T_USER_BASIC_CONTENTS.C_LEFT IS '노드좌측끝포인트';

COMMENT ON COLUMN T_USER_BASIC_CONTENTS.C_RIGHT IS '노드우측끝포인트';

COMMENT ON COLUMN T_USER_BASIC_CONTENTS.C_LEVEL IS '노드레벨';

COMMENT ON COLUMN T_USER_BASIC_CONTENTS.C_TITLE IS '노드명';

COMMENT ON COLUMN T_USER_BASIC_CONTENTS.C_TYPE IS '노드타입';

COMMENT ON COLUMN T_USER_BASIC_CONTENTS.C_COMPANY_INTR IS '회사소개';

COMMENT ON COLUMN T_USER_BASIC_CONTENTS.C_TERMS_OF_USE IS '이용약관';

COMMENT ON COLUMN T_USER_BASIC_CONTENTS.C_PRIVACY_POLICY IS '개인정보취급방침';

--CREATE UNIQUE INDEX PK_T_USER_BASIC_CONTENTS
--  ON T_USER_BASIC_CONTENTS (
--      C_ID ASC
--  );

ALTER TABLE T_USER_BASIC_CONTENTS
    ADD
        CONSTRAINT PK_T_USER_BASIC_CONTENTS
        PRIMARY KEY (
            C_ID
        );

DROP SEQUENCE S_USER_BASIC_CONTENTS;

CREATE SEQUENCE S_USER_BASIC_CONTENTS
  START WITH 3
  MAXVALUE 999999999999999999999999999
  MINVALUE 0
  NOCYCLE
  CACHE 20
  NOORDER;

CREATE OR REPLACE TRIGGER "TRIGGER_USER_BASIC_CONTENTS"
BEFORE DELETE OR INSERT OR UPDATE
ON T_USER_BASIC_CONTENTS
REFERENCING NEW AS NEW OLD AS OLD
FOR EACH ROW
DECLARE
tmpVar NUMBER;

BEGIN
   tmpVar := 0;
    IF UPDATING  THEN    
        insert into T_USER_BASIC_CONTENTS_LOG 
        values (:old.C_ID,:old.C_PARENTID,:old.C_POSITION,:old.C_LEFT,:old.C_RIGHT,:old.C_LEVEL,:old.C_TITLE,:old.C_TYPE,'update','변경이전데이터',sysdate);        
        insert into T_USER_PROH_WORD_LOG 
        values (:new.C_ID,:new.C_PARENTID,:new.C_POSITION,:new.C_LEFT,:new.C_RIGHT,:new.C_LEVEL,:new.C_TITLE,:new.C_TYPE,'update','변경이후데이터',sysdate);   
     END IF;
    IF DELETING THEN
        insert into T_USER_BASIC_CONTENTS_LOG 
        values (:old.C_ID,:old.C_PARENTID,:old.C_POSITION,:old.C_LEFT,:old.C_RIGHT,:old.C_LEVEL,:old.C_TITLE,:old.C_TYPE,'delete','삭제된데이터',sysdate);
    END IF;   
    IF INSERTING  THEN
        insert into T_USER_BASIC_CONTENTS_LOG 
        values (:new.C_ID,:new.C_PARENTID,:new.C_POSITION,:new.C_LEFT,:new.C_RIGHT,:new.C_LEVEL,:new.C_TITLE,:new.C_TYPE,'insert','삽입된데이터',sysdate);
    END IF;

   EXCEPTION
     WHEN OTHERS THEN
       -- Consider logging the error and then re-raise
       RAISE;
END TRIGGER_USER_BASIC_CONTENTS;

/* 회원_비밀번호보안수준 */
DROP TABLE T_USER_PWD_SECU_LEVEL_LOG;

CREATE TABLE T_USER_PWD_SECU_LEVEL_LOG
(
  C_ID        NUMBER                            NOT NULL,
  C_PARENTID  NUMBER                            NOT NULL,
  C_POSITION  NUMBER                            NOT NULL,
  C_LEFT      NUMBER                            NOT NULL,
  C_RIGHT     NUMBER                            NOT NULL,
  C_LEVEL     NUMBER                            NOT NULL,
  C_TITLE     VARCHAR2(4000 BYTE)               NOT NULL,
  C_TYPE      VARCHAR2(100 BYTE),
  C_METHOD    VARCHAR2(4000 BYTE)               NOT NULL,
  C_STATE     VARCHAR2(4000 BYTE)               NOT NULL,
  C_DATE      DATE                              NOT NULL
);

COMMENT ON TABLE T_USER_PWD_SECU_LEVEL_LOG IS '회원_비밀번호보안수준 트리거 로그';
COMMENT ON COLUMN T_USER_PWD_SECU_LEVEL_LOG.C_ID IS '노드 아이디';
COMMENT ON COLUMN T_USER_PWD_SECU_LEVEL_LOG.C_PARENTID IS '부모 노드 아이디';
COMMENT ON COLUMN T_USER_PWD_SECU_LEVEL_LOG.C_POSITION IS '노드 포지션';
COMMENT ON COLUMN T_USER_PWD_SECU_LEVEL_LOG.C_LEFT IS '노드 좌측 끝 포인트';
COMMENT ON COLUMN T_USER_PWD_SECU_LEVEL_LOG.C_RIGHT IS '노드 우측 끝 포인트';
COMMENT ON COLUMN T_USER_PWD_SECU_LEVEL_LOG.C_LEVEL IS '노드 DEPTH ';
COMMENT ON COLUMN T_USER_PWD_SECU_LEVEL_LOG.C_TITLE IS '노드 명';
COMMENT ON COLUMN T_USER_PWD_SECU_LEVEL_LOG.C_TYPE IS '노드 타입';
COMMENT ON COLUMN T_USER_PWD_SECU_LEVEL_LOG.C_METHOD IS '노드 변경 행위';
COMMENT ON COLUMN T_USER_PWD_SECU_LEVEL_LOG.C_STATE IS '노드 상태값 ( 이전인지. 이후인지)';
COMMENT ON COLUMN T_USER_PWD_SECU_LEVEL_LOG.C_DATE IS '노드 변경 시';

DROP TABLE T_USER_PWD_SECU_LEVEL;

CREATE TABLE T_USER_PWD_SECU_LEVEL (
    C_ID NUMBER NOT NULL, /* 노드 아이디 */
    C_PARENTID NUMBER NOT NULL, /* 부모노드아이디 */
    C_POSITION NUMBER NOT NULL, /* 노드포지션 */
    C_LEFT NUMBER NOT NULL, /* 노드좌측끝포인트 */
    C_RIGHT NUMBER NOT NULL, /* 노드우측끝포인트 */
    C_LEVEL NUMBER NOT NULL, /* 노드레벨 */
    C_TITLE VARCHAR2(4000) NOT NULL, /* 비밀번호보안수준 */
    C_TYPE VARCHAR2(100) /* 노드타입 */
);

COMMENT ON TABLE T_USER_PWD_SECU_LEVEL IS '회원_비밀번호보안수준';

COMMENT ON COLUMN T_USER_PWD_SECU_LEVEL.C_ID IS '노드 아이디';

COMMENT ON COLUMN T_USER_PWD_SECU_LEVEL.C_PARENTID IS '부모노드아이디';

COMMENT ON COLUMN T_USER_PWD_SECU_LEVEL.C_POSITION IS '노드포지션';

COMMENT ON COLUMN T_USER_PWD_SECU_LEVEL.C_LEFT IS '노드좌측끝포인트';

COMMENT ON COLUMN T_USER_PWD_SECU_LEVEL.C_RIGHT IS '노드우측끝포인트';

COMMENT ON COLUMN T_USER_PWD_SECU_LEVEL.C_LEVEL IS '노드레벨';

COMMENT ON COLUMN T_USER_PWD_SECU_LEVEL.C_TITLE IS '비밀번호보안수준';

COMMENT ON COLUMN T_USER_PWD_SECU_LEVEL.C_TYPE IS '노드타입';

--CREATE UNIQUE INDEX PK_T_USER_PWD_SECU_LEVEL
--    ON T_USER_PWD_SECU_LEVEL (
--        C_ID ASC
--    );

ALTER TABLE T_USER_PWD_SECU_LEVEL
    ADD
        CONSTRAINT PK_T_USER_PWD_SECU_LEVEL
        PRIMARY KEY (
            C_ID
        );
    
DROP SEQUENCE S_USER_PWD_SECU_LEVEL;

CREATE SEQUENCE S_USER_PWD_SECU_LEVEL
  START WITH 6
  MAXVALUE 999999999999999999999999999
  MINVALUE 0
  NOCYCLE
  CACHE 20
  NOORDER;

CREATE OR REPLACE TRIGGER "TRIGGER_USER_PWD_SECU_LEVEL"
BEFORE DELETE OR INSERT OR UPDATE
ON T_USER_PWD_SECU_LEVEL
REFERENCING NEW AS NEW OLD AS OLD
FOR EACH ROW
DECLARE
tmpVar NUMBER;

BEGIN
   tmpVar := 0;
    IF UPDATING  THEN    
        insert into T_USER_PWD_SECU_LEVEL_LOG 
        values (:old.C_ID,:old.C_PARENTID,:old.C_POSITION,:old.C_LEFT,:old.C_RIGHT,:old.C_LEVEL,:old.C_TITLE,:old.C_TYPE,'update','변경이전데이터',sysdate);        
        insert into T_USER_PROH_WORD_LOG 
        values (:new.C_ID,:new.C_PARENTID,:new.C_POSITION,:new.C_LEFT,:new.C_RIGHT,:new.C_LEVEL,:new.C_TITLE,:new.C_TYPE,'update','변경이후데이터',sysdate);   
     END IF;
    IF DELETING THEN
        insert into T_USER_PWD_SECU_LEVEL_LOG 
        values (:old.C_ID,:old.C_PARENTID,:old.C_POSITION,:old.C_LEFT,:old.C_RIGHT,:old.C_LEVEL,:old.C_TITLE,:old.C_TYPE,'delete','삭제된데이터',sysdate);
    END IF;   
    IF INSERTING  THEN
        insert into T_USER_PWD_SECU_LEVEL_LOG 
        values (:new.C_ID,:new.C_PARENTID,:new.C_POSITION,:new.C_LEFT,:new.C_RIGHT,:new.C_LEVEL,:new.C_TITLE,:new.C_TYPE,'insert','삽입된데이터',sysdate);
    END IF;

   EXCEPTION
     WHEN OTHERS THEN
       -- Consider logging the error and then re-raise
       RAISE;
END TRIGGER_USER_PWD_SECU_LEVEL;

/* 회원_일반설정 */
DROP TABLE T_USER_GENERAL_SETTING_LOG;

CREATE TABLE T_USER_GENERAL_SETTING_LOG
(
  C_ID        NUMBER                            NOT NULL,
  C_PARENTID  NUMBER                            NOT NULL,
  C_POSITION  NUMBER                            NOT NULL,
  C_LEFT      NUMBER                            NOT NULL,
  C_RIGHT     NUMBER                            NOT NULL,
  C_LEVEL     NUMBER                            NOT NULL,
  C_TITLE     VARCHAR2(4000 BYTE)               NOT NULL,
  C_TYPE      VARCHAR2(100 BYTE),
  C_METHOD    VARCHAR2(4000 BYTE)               NOT NULL,
  C_STATE     VARCHAR2(4000 BYTE)               NOT NULL,
  C_DATE      DATE                              NOT NULL
);

COMMENT ON TABLE T_USER_GENERAL_SETTING_LOG IS '회원_일반설정 트리거 로그';
COMMENT ON COLUMN T_USER_GENERAL_SETTING_LOG.C_ID IS '노드 아이디';
COMMENT ON COLUMN T_USER_GENERAL_SETTING_LOG.C_PARENTID IS '부모 노드 아이디';
COMMENT ON COLUMN T_USER_GENERAL_SETTING_LOG.C_POSITION IS '노드 포지션';
COMMENT ON COLUMN T_USER_GENERAL_SETTING_LOG.C_LEFT IS '노드 좌측 끝 포인트';
COMMENT ON COLUMN T_USER_GENERAL_SETTING_LOG.C_RIGHT IS '노드 우측 끝 포인트';
COMMENT ON COLUMN T_USER_GENERAL_SETTING_LOG.C_LEVEL IS '노드 DEPTH ';
COMMENT ON COLUMN T_USER_GENERAL_SETTING_LOG.C_TITLE IS '노드 명';
COMMENT ON COLUMN T_USER_GENERAL_SETTING_LOG.C_TYPE IS '노드 타입';
COMMENT ON COLUMN T_USER_GENERAL_SETTING_LOG.C_METHOD IS '노드 변경 행위';
COMMENT ON COLUMN T_USER_GENERAL_SETTING_LOG.C_STATE IS '노드 상태값 ( 이전인지. 이후인지)';
COMMENT ON COLUMN T_USER_GENERAL_SETTING_LOG.C_DATE IS '노드 변경 시';

DROP TABLE T_USER_GENERAL_SETTING;

CREATE TABLE T_USER_GENERAL_SETTING (
    C_ID NUMBER NOT NULL, /* 노드아이디 */
    C_PARENTID NUMBER NOT NULL, /* 부모노드아이디 */
    C_POSITION NUMBER NOT NULL, /* 노드포지션 */
    C_LEFT NUMBER NOT NULL, /* 노드좌측끝포인트 */
    C_RIGHT NUMBER NOT NULL, /* 노드우측끝포인트 */
    C_LEVEL NUMBER NOT NULL, /* 노드레벨 */
    C_TITLE VARCHAR2(4000) NOT NULL, /* 노드명 */
    C_TYPE VARCHAR2(100), /* 노드타입 */
    C_PASSWORD_SECURITY_LEVEL_CD NUMBER NOT NULL, /* 비밀번호보안수준코드 */
    C_WEB_MASTER_NM VARCHAR2(30) NOT NULL, /* 웹마스터이름 */
    C_WEB_MASTER_EMAIL VARCHAR2(320) NOT NULL, /* 웹마스터이메일 */
    C_JOIN_APPROVAL_FL CHAR(1) DEFAULT 0 NOT NULL, /* 가입승인여부 */
    C_EMAIL_AUTH_USE_FL CHAR(1) DEFAULT 0 NOT NULL, /* 이메일인증사용여부 */
    C_PASSWORD_CHANGE_DCNT NUMBER(3) NOT NULL, /* 비밀번호변경일수 */
    C_LOGIN_LIMIT_DCNT NUMBER(2) NOT NULL, /* 로그인제한일수 */
    C_LOGIN_FAILURE_LIMIT_CNT NUMBER(1) NOT NULL /* 로그인실패제한횟수 */
);

COMMENT ON TABLE T_USER_GENERAL_SETTING IS '회원_일반설정';

COMMENT ON COLUMN T_USER_GENERAL_SETTING.C_ID IS '노드아이디';

COMMENT ON COLUMN T_USER_GENERAL_SETTING.C_PARENTID IS '부모노드아이디';

COMMENT ON COLUMN T_USER_GENERAL_SETTING.C_POSITION IS '노드포지션';

COMMENT ON COLUMN T_USER_GENERAL_SETTING.C_LEFT IS '노드좌측끝포인트';

COMMENT ON COLUMN T_USER_GENERAL_SETTING.C_RIGHT IS '노드우측끝포인트';

COMMENT ON COLUMN T_USER_GENERAL_SETTING.C_LEVEL IS '노드레벨';

COMMENT ON COLUMN T_USER_GENERAL_SETTING.C_TITLE IS '노드명';

COMMENT ON COLUMN T_USER_GENERAL_SETTING.C_TYPE IS '노드타입';

COMMENT ON COLUMN T_USER_GENERAL_SETTING.C_PASSWORD_SECURITY_LEVEL_CD IS '비밀번호보안수준코드';

COMMENT ON COLUMN T_USER_GENERAL_SETTING.C_WEB_MASTER_NM IS '웹마스터이름';

COMMENT ON COLUMN T_USER_GENERAL_SETTING.C_WEB_MASTER_EMAIL IS '웹마스터이메일';

COMMENT ON COLUMN T_USER_GENERAL_SETTING.C_JOIN_APPROVAL_FL IS '가입승인여부';

COMMENT ON COLUMN T_USER_GENERAL_SETTING.C_EMAIL_AUTH_USE_FL IS '이메일인증사용여부';

COMMENT ON COLUMN T_USER_GENERAL_SETTING.C_PASSWORD_CHANGE_DCNT IS '비밀번호변경일수';

COMMENT ON COLUMN T_USER_GENERAL_SETTING.C_LOGIN_LIMIT_DCNT IS '로그인제한일수';

COMMENT ON COLUMN T_USER_GENERAL_SETTING.C_LOGIN_FAILURE_LIMIT_CNT IS '로그인실패제한횟수';

--CREATE UNIQUE INDEX PK_T_USER_GENERAL_SETTING
--  ON T_USER_GENERAL_SETTING (
--      C_ID ASC
--  );

ALTER TABLE T_USER_GENERAL_SETTING
    ADD
        CONSTRAINT PK_T_USER_GENERAL_SETTING
        PRIMARY KEY (
            C_ID
        );
        
ALTER TABLE T_USER_GENERAL_SETTING
    ADD
        CONSTRAINT FK_T_USER_PWD_SECU_LEVEL
        FOREIGN KEY (
            C_PASSWORD_SECURITY_LEVEL_CD
        )
        REFERENCES T_USER_PWD_SECU_LEVEL (
            C_ID
        );

DROP SEQUENCE S_USER_GENERAL_SETTING;

CREATE SEQUENCE S_USER_GENERAL_SETTING
  START WITH 4
  MAXVALUE 999999999999999999999999999
  MINVALUE 0
  NOCYCLE
  CACHE 20
  NOORDER;

CREATE OR REPLACE TRIGGER "TRIGGER_USER_GENERAL_SETTING"
BEFORE DELETE OR INSERT OR UPDATE
ON T_USER_GENERAL_SETTING
REFERENCING NEW AS NEW OLD AS OLD
FOR EACH ROW
DECLARE
tmpVar NUMBER;

BEGIN
   tmpVar := 0;
    IF UPDATING  THEN    
        insert into T_USER_GENERAL_SETTING_LOG 
        values (:old.C_ID,:old.C_PARENTID,:old.C_POSITION,:old.C_LEFT,:old.C_RIGHT,:old.C_LEVEL,:old.C_TITLE,:old.C_TYPE,'update','변경이전데이터',sysdate);        
        insert into T_USER_PROH_WORD_LOG 
        values (:new.C_ID,:new.C_PARENTID,:new.C_POSITION,:new.C_LEFT,:new.C_RIGHT,:new.C_LEVEL,:new.C_TITLE,:new.C_TYPE,'update','변경이후데이터',sysdate);   
     END IF;
    IF DELETING THEN
        insert into T_USER_GENERAL_SETTING_LOG 
        values (:old.C_ID,:old.C_PARENTID,:old.C_POSITION,:old.C_LEFT,:old.C_RIGHT,:old.C_LEVEL,:old.C_TITLE,:old.C_TYPE,'delete','삭제된데이터',sysdate);
    END IF;   
    IF INSERTING  THEN
        insert into T_USER_GENERAL_SETTING_LOG 
        values (:new.C_ID,:new.C_PARENTID,:new.C_POSITION,:new.C_LEFT,:new.C_RIGHT,:new.C_LEVEL,:new.C_TITLE,:new.C_TYPE,'insert','삽입된데이터',sysdate);
    END IF;

   EXCEPTION
     WHEN OTHERS THEN
       -- Consider logging the error and then re-raise
       RAISE;
END TRIGGER_USER_GENERAL_SETTING;

/* 회원_가입필드 */
DROP TABLE T_USER_JOIN_FIELD_LOG;

CREATE TABLE T_USER_JOIN_FIELD_LOG
(
  C_ID        NUMBER                            NOT NULL,
  C_PARENTID  NUMBER                            NOT NULL,
  C_POSITION  NUMBER                            NOT NULL,
  C_LEFT      NUMBER                            NOT NULL,
  C_RIGHT     NUMBER                            NOT NULL,
  C_LEVEL     NUMBER                            NOT NULL,
  C_TITLE     VARCHAR2(4000 BYTE)               NOT NULL,
  C_TYPE      VARCHAR2(100 BYTE),
  C_METHOD    VARCHAR2(4000 BYTE)               NOT NULL,
  C_STATE     VARCHAR2(4000 BYTE)               NOT NULL,
  C_DATE      DATE                              NOT NULL
);

COMMENT ON TABLE T_USER_JOIN_FIELD_LOG IS '회원_가입필드 트리거 로그';
COMMENT ON COLUMN T_USER_JOIN_FIELD_LOG.C_ID IS '노드 아이디';
COMMENT ON COLUMN T_USER_JOIN_FIELD_LOG.C_PARENTID IS '부모 노드 아이디';
COMMENT ON COLUMN T_USER_JOIN_FIELD_LOG.C_POSITION IS '노드 포지션';
COMMENT ON COLUMN T_USER_JOIN_FIELD_LOG.C_LEFT IS '노드 좌측 끝 포인트';
COMMENT ON COLUMN T_USER_JOIN_FIELD_LOG.C_RIGHT IS '노드 우측 끝 포인트';
COMMENT ON COLUMN T_USER_JOIN_FIELD_LOG.C_LEVEL IS '노드 DEPTH ';
COMMENT ON COLUMN T_USER_JOIN_FIELD_LOG.C_TITLE IS '노드 명';
COMMENT ON COLUMN T_USER_JOIN_FIELD_LOG.C_TYPE IS '노드 타입';
COMMENT ON COLUMN T_USER_JOIN_FIELD_LOG.C_METHOD IS '노드 변경 행위';
COMMENT ON COLUMN T_USER_JOIN_FIELD_LOG.C_STATE IS '노드 상태값 ( 이전인지. 이후인지)';
COMMENT ON COLUMN T_USER_JOIN_FIELD_LOG.C_DATE IS '노드 변경 시';

DROP TABLE T_USER_JOIN_FIELD;

CREATE TABLE T_USER_JOIN_FIELD (
    C_ID NUMBER NOT NULL, /* 노드아이디 */
    C_PARENTID NUMBER NOT NULL, /* 부모노드아이디 */
    C_POSITION NUMBER NOT NULL, /* 노드포지션 */
    C_LEFT NUMBER NOT NULL, /* 노드좌측끝포인트 */
    C_RIGHT NUMBER NOT NULL, /* 노드우측끝포인트 */
    C_LEVEL NUMBER NOT NULL, /* 노드레벨 */
    C_TITLE VARCHAR2(4000) NOT NULL, /* 가입필드명 */
    C_TYPE VARCHAR2(100), /* 노드타입 */
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

COMMENT ON COLUMN T_USER_JOIN_FIELD.C_TITLE IS '가입필드명';

COMMENT ON COLUMN T_USER_JOIN_FIELD.C_TYPE IS '노드타입';

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

DROP SEQUENCE S_USER_JOIN_FIELD;

CREATE SEQUENCE S_USER_JOIN_FIELD
  START WITH 12
  MAXVALUE 999999999999999999999999999
  MINVALUE 0
  NOCYCLE
  CACHE 20
  NOORDER;
  
CREATE OR REPLACE TRIGGER "TRIGGER_USER_JOIN_FIELD"
BEFORE DELETE OR INSERT OR UPDATE
ON T_USER_JOIN_FIELD
REFERENCING NEW AS NEW OLD AS OLD
FOR EACH ROW
DECLARE
tmpVar NUMBER;

BEGIN
   tmpVar := 0;
    IF UPDATING  THEN    
        insert into T_USER_JOIN_FIELD_LOG 
        values (:old.C_ID,:old.C_PARENTID,:old.C_POSITION,:old.C_LEFT,:old.C_RIGHT,:old.C_LEVEL,:old.C_TITLE,:old.C_TYPE,'update','변경이전데이터',sysdate);        
        insert into T_USER_PROH_WORD_LOG 
        values (:new.C_ID,:new.C_PARENTID,:new.C_POSITION,:new.C_LEFT,:new.C_RIGHT,:new.C_LEVEL,:new.C_TITLE,:new.C_TYPE,'update','변경이후데이터',sysdate);   
     END IF;
    IF DELETING THEN
        insert into T_USER_JOIN_FIELD_LOG 
        values (:old.C_ID,:old.C_PARENTID,:old.C_POSITION,:old.C_LEFT,:old.C_RIGHT,:old.C_LEVEL,:old.C_TITLE,:old.C_TYPE,'delete','삭제된데이터',sysdate);
    END IF;   
    IF INSERTING  THEN
        insert into T_USER_JOIN_FIELD_LOG 
        values (:new.C_ID,:new.C_PARENTID,:new.C_POSITION,:new.C_LEFT,:new.C_RIGHT,:new.C_LEVEL,:new.C_TITLE,:new.C_TYPE,'insert','삽입된데이터',sysdate);
    END IF;

   EXCEPTION
     WHEN OTHERS THEN
       -- Consider logging the error and then re-raise
       RAISE;
END TRIGGER_USER_JOIN_FIELD;
/* 류강하 끝 */

/* 김대근 시작 */
/* 회원_등급관리 */
CREATE TABLE T_USER_GRADE_MANAGE (
	C_ID NUMBER NOT NULL, /* 노드아이디 */
	C_PARENTID NUMBER NOT NULL, /* 부모노드아이디 */
	C_POSITION NUMBER NOT NULL, /* 노드포지션 */
	C_LEFT NUMBER NOT NULL, /* 노드좌측끝포인트 */
	C_RIGHT NUMBER NOT NULL, /* 노드우측끝포인트 */
	C_LEVEL NUMBER NOT NULL, /* 노드레벨 */
	C_TITLE VARCHAR2(4000), /* 회원등급명 */
	C_TYPE VARCHAR2(100), /* 노드타입 */
	C_POINT_BY_GRADE_USE_FL CHAR(1) DEFAULT 0, /* 등급별포인트사용여부 */
	C_POINT_BY_GRADE NUMBER, /* 등급별포인트 */
	C_ICON_FILE_NM VARCHAR2(320), /* 아이콘파일명 */
	C_STORE_FILE_NM VARCHAR2(320) /* 저장파일명 */
);

COMMENT ON TABLE T_USER_GRADE_MANAGE IS '회원_등급관리';
COMMENT ON COLUMN T_USER_GRADE_MANAGE.C_ID IS '노드아이디';
COMMENT ON COLUMN T_USER_GRADE_MANAGE.C_PARENTID IS '부모노드아이디';
COMMENT ON COLUMN T_USER_GRADE_MANAGE.C_POSITION IS '노드포지션';
COMMENT ON COLUMN T_USER_GRADE_MANAGE.C_LEFT IS '노드좌측끝포인트';
COMMENT ON COLUMN T_USER_GRADE_MANAGE.C_RIGHT IS '노드우측끝포인트';
COMMENT ON COLUMN T_USER_GRADE_MANAGE.C_LEVEL IS '노드레벨';
COMMENT ON COLUMN T_USER_GRADE_MANAGE.C_TITLE IS '회원등급명';
COMMENT ON COLUMN T_USER_GRADE_MANAGE.C_TYPE IS '노드타입';
COMMENT ON COLUMN T_USER_GRADE_MANAGE.C_POINT_BY_GRADE_USE_FL IS '등급별포인트사용여부';
COMMENT ON COLUMN T_USER_GRADE_MANAGE.C_POINT_BY_GRADE IS '등급별포인트';
COMMENT ON COLUMN T_USER_GRADE_MANAGE.C_ICON_FILE_NM IS '아이콘파일명';
COMMENT ON COLUMN T_USER_GRADE_MANAGE.C_STORE_FILE_NM IS '저장파일명';

ALTER TABLE T_USER_GRADE_MANAGE
	ADD
		CONSTRAINT PK_T_USER_GRADE_MANAGE
		PRIMARY KEY (
			C_ID
		);

CREATE SEQUENCE S_USER_GRADE_MANAGE
  START WITH 3
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
	C_TITLE VARCHAR2(4000), /* 메뉴명 */
	C_TYPE VARCHAR2(100), /* 노드타입 */
	C_USER_GRADE_ID NUMBER, /* 회원등급ID */
	C_MENU_ID NUMBER /* 메뉴ID */
);

COMMENT ON TABLE T_USER_MENU_BY_GRADE IS '회원_등급별메뉴';
COMMENT ON COLUMN T_USER_MENU_BY_GRADE.C_ID IS '노드아이디';
COMMENT ON COLUMN T_USER_MENU_BY_GRADE.C_PARENTID IS '부모노드아이디';
COMMENT ON COLUMN T_USER_MENU_BY_GRADE.C_POSITION IS '노드포지션';
COMMENT ON COLUMN T_USER_MENU_BY_GRADE.C_LEFT IS '노드좌측끝포인트';
COMMENT ON COLUMN T_USER_MENU_BY_GRADE.C_RIGHT IS '노드우측끝포인트';
COMMENT ON COLUMN T_USER_MENU_BY_GRADE.C_LEVEL IS '노드레벨';
COMMENT ON COLUMN T_USER_MENU_BY_GRADE.C_TITLE IS '메뉴명';
COMMENT ON COLUMN T_USER_MENU_BY_GRADE.C_TYPE IS '노드타입';
COMMENT ON COLUMN T_USER_MENU_BY_GRADE.C_USER_GRADE_ID IS '회원등급ID';
COMMENT ON COLUMN T_USER_MENU_BY_GRADE.C_MENU_ID IS '메뉴ID';

ALTER TABLE T_USER_MENU_BY_GRADE
	ADD
		CONSTRAINT PK_T_USER_MENU_BY_GRADE
		PRIMARY KEY (
			C_ID
		);
		
CREATE SEQUENCE S_USER_MENU_BY_GRADE
  START WITH 3
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
	C_TITLE VARCHAR2(4000) NOT NULL, /* 쪽지유형코드명 */
	C_TYPE VARCHAR2(100) /* 노드타입 */
);

COMMENT ON TABLE T_USER_NOTE_TYPE_CODE IS '회원_쪽지유형코드';
COMMENT ON COLUMN T_USER_NOTE_TYPE_CODE.C_ID IS '노드아이디';
COMMENT ON COLUMN T_USER_NOTE_TYPE_CODE.C_PARENTID IS '부모노드아이디';
COMMENT ON COLUMN T_USER_NOTE_TYPE_CODE.C_POSITION IS '노드포지션';
COMMENT ON COLUMN T_USER_NOTE_TYPE_CODE.C_LEFT IS '노드좌측끝포인트';
COMMENT ON COLUMN T_USER_NOTE_TYPE_CODE.C_RIGHT IS '노드우측끝포인트';
COMMENT ON COLUMN T_USER_NOTE_TYPE_CODE.C_LEVEL IS '노드레벨';
COMMENT ON COLUMN T_USER_NOTE_TYPE_CODE.C_TITLE IS '쪽지유형코드명';
COMMENT ON COLUMN T_USER_NOTE_TYPE_CODE.C_TYPE IS '노드타입';

ALTER TABLE T_USER_NOTE_TYPE_CODE
	ADD
		CONSTRAINT PK_T_USER_NOTE_TYPE_CODE
		PRIMARY KEY (
			C_ID
		);
		
CREATE SEQUENCE S_USER_NOTE_TYPE_CODE
  START WITH 6
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
	C_TITLE VARCHAR2(4000) NOT NULL, /* 쪽지제목 */
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
COMMENT ON COLUMN T_USER_NOTE_DETAIL.C_TITLE IS '쪽지제목';
COMMENT ON COLUMN T_USER_NOTE_DETAIL.C_TYPE IS '노드타입';
COMMENT ON COLUMN T_USER_NOTE_DETAIL.C_CONTENT IS '내용';

ALTER TABLE T_USER_NOTE_DETAIL
	ADD
		CONSTRAINT PK_T_USER_NOTE_DETAIL
		PRIMARY KEY (
			C_ID
		);

CREATE SEQUENCE S_USER_NOTE_DETAIL
  START WITH 3
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
	C_TITLE VARCHAR2(4000) NOT NULL, /* 회원명 */
	C_TYPE VARCHAR2(100), /* 노드타입 */
	C_USER_ID NUMBER NOT NULL, /* 회원ID */
	C_NOTE_DETAIL_ID NUMBER NOT NULL, /* 쪽지상세ID */
	C_NOTE_TYPE_CODE NUMBER NOT NULL, /* 쪽지유형코드 */
	C_RECE_DISP_DT CHAR(14) NOT NULL /* 수발신일시 */
);

COMMENT ON TABLE T_USER_NOTE_BY_USER IS '회원_회원별쪽지';
COMMENT ON COLUMN T_USER_NOTE_BY_USER.C_ID IS '노드아이디';
COMMENT ON COLUMN T_USER_NOTE_BY_USER.C_PARENTID IS '부모노드아이디';
COMMENT ON COLUMN T_USER_NOTE_BY_USER.C_POSITION IS '노드포지션';
COMMENT ON COLUMN T_USER_NOTE_BY_USER.C_LEFT IS '노드좌측끝포인트';
COMMENT ON COLUMN T_USER_NOTE_BY_USER.C_RIGHT IS '노드우측끝포인트';
COMMENT ON COLUMN T_USER_NOTE_BY_USER.C_LEVEL IS '노드레벨';
COMMENT ON COLUMN T_USER_NOTE_BY_USER.C_TITLE IS '회원명';
COMMENT ON COLUMN T_USER_NOTE_BY_USER.C_TYPE IS '노드타입';
COMMENT ON COLUMN T_USER_NOTE_BY_USER.C_USER_ID IS '회원ID';
COMMENT ON COLUMN T_USER_NOTE_BY_USER.C_NOTE_DETAIL_ID IS '쪽지상세ID';
COMMENT ON COLUMN T_USER_NOTE_BY_USER.C_NOTE_TYPE_CODE IS '쪽지유형코드';
COMMENT ON COLUMN T_USER_NOTE_BY_USER.C_RECE_DISP_DT IS '수발신일시';

ALTER TABLE T_USER_NOTE_BY_USER
	ADD
		CONSTRAINT PK_T_USER_NOTE_BY_USER
		PRIMARY KEY (
			C_ID
		);
		
CREATE SEQUENCE S_USER_NOTE_BY_USER
  START WITH 3
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
	C_TITLE VARCHAR2(4000) NOT NULL, /* 첨부파일명 */
	C_TYPE VARCHAR2(100), /* 노드타입 */
	C_NOTE_DETAIL_ID NUMBER NOT NULL, /* 쪽지상세ID */
	C_STORE_FILE_NM VARCHAR2(320) /* 저장파일명 */
);

COMMENT ON TABLE T_USER_NOTE_ATTACH_FILE IS '회원_쪽지첨부파일';
COMMENT ON COLUMN T_USER_NOTE_ATTACH_FILE.C_ID IS '노드아이디';
COMMENT ON COLUMN T_USER_NOTE_ATTACH_FILE.C_PARENTID IS '부모노드아이디';
COMMENT ON COLUMN T_USER_NOTE_ATTACH_FILE.C_POSITION IS '노드포지션';
COMMENT ON COLUMN T_USER_NOTE_ATTACH_FILE.C_LEFT IS '노드좌측끝포인트';
COMMENT ON COLUMN T_USER_NOTE_ATTACH_FILE.C_RIGHT IS '노드우측끝포인트';
COMMENT ON COLUMN T_USER_NOTE_ATTACH_FILE.C_LEVEL IS '노드레벨';
COMMENT ON COLUMN T_USER_NOTE_ATTACH_FILE.C_TITLE IS '첨부파일명';
COMMENT ON COLUMN T_USER_NOTE_ATTACH_FILE.C_TYPE IS '노드타입';
COMMENT ON COLUMN T_USER_NOTE_ATTACH_FILE.C_NOTE_DETAIL_ID IS '쪽지상세ID';
COMMENT ON COLUMN T_USER_NOTE_ATTACH_FILE.C_STORE_FILE_NM IS '저장파일명';

ALTER TABLE T_USER_NOTE_ATTACH_FILE
	ADD
		CONSTRAINT PK_T_USER_NOTE_ATTACH_FILE
		PRIMARY KEY (
			C_ID
		);

CREATE SEQUENCE S_USER_NOTE_ATTACH_FILE
  START WITH 3
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
	C_TITLE VARCHAR2(4000) NOT NULL, /* 노드명 */
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

ALTER TABLE T_USER_POINT_SETTING
	ADD
		CONSTRAINT PK_T_USER_POINT_SETTING
		PRIMARY KEY (
			C_ID
		);

CREATE SEQUENCE S_USER_POINT_SETTING
  START WITH 4
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
	C_TITLE VARCHAR2(4000) NOT NULL, /* 포인트코드명 */
	C_TYPE VARCHAR2(100) /* 노드타입 */
);

COMMENT ON TABLE T_USER_POINT_CODE IS '회원_포인트코드';
COMMENT ON COLUMN T_USER_POINT_CODE.C_ID IS '노드아이디';
COMMENT ON COLUMN T_USER_POINT_CODE.C_PARENTID IS '부모노드아이디';
COMMENT ON COLUMN T_USER_POINT_CODE.C_POSITION IS '노드포지션';
COMMENT ON COLUMN T_USER_POINT_CODE.C_LEFT IS '노드좌측끝포인트';
COMMENT ON COLUMN T_USER_POINT_CODE.C_RIGHT IS '노드우측끝포인트';
COMMENT ON COLUMN T_USER_POINT_CODE.C_LEVEL IS '노드레벨';
COMMENT ON COLUMN T_USER_POINT_CODE.C_TITLE IS '포인트코드명';
COMMENT ON COLUMN T_USER_POINT_CODE.C_TYPE IS '노드타입';

ALTER TABLE T_USER_POINT_CODE
	ADD
		CONSTRAINT PK_T_USER_POINT_CODE
		PRIMARY KEY (
			C_ID
		);
		
CREATE SEQUENCE S_USER_POINT_CODE
  START WITH 12
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
	C_TITLE VARCHAR2(4000) NOT NULL, /* 회원명 */
	C_TYPE VARCHAR2(100), /* 노드타입 */
	C_USER_ID NUMBER NOT NULL, /* 회원고유ID */
	C_POINT_CODE NUMBER NOT NULL, /* 포인트코드 */
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
COMMENT ON COLUMN T_USER_POINT_ASSIGN.C_TITLE IS '회원명';
COMMENT ON COLUMN T_USER_POINT_ASSIGN.C_TYPE IS '노드타입';
COMMENT ON COLUMN T_USER_POINT_ASSIGN.C_USER_ID IS '회원고유ID';
COMMENT ON COLUMN T_USER_POINT_ASSIGN.C_POINT_CODE IS '포인트코드';
COMMENT ON COLUMN T_USER_POINT_ASSIGN.C_POINT IS '포인트';
COMMENT ON COLUMN T_USER_POINT_ASSIGN.C_ASSIGN_DT IS '부여일시';
COMMENT ON COLUMN T_USER_POINT_ASSIGN.C_DESC IS '설명';

ALTER TABLE T_USER_POINT_ASSIGN
	ADD
		CONSTRAINT PK_T_USER_POINT_ASSIGN
		PRIMARY KEY (
			C_ID
		);

CREATE SEQUENCE S_USER_POINT_ASSIGN
  START WITH 3
  MAXVALUE 999999999999999999999999999
  MINVALUE 0
  NOCYCLE
  CACHE 20
  NOORDER;
/* 김대근 종료 */