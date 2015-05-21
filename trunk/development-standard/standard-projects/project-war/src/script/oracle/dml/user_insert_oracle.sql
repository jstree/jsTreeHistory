/* 오권우 시작 */
/* 회원_정보 */
DELETE FROM T_USER_INFO;

INSERT INTO T_USER_INFO 
   (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE, 
    C_USER_GRADE, C_JOIN_STATE_CD, C_PASSWORD, C_EMAIL, C_LOGIN_FAILURE_CNT, 
    C_PASSWORD_FIND_QUESTION, C_PASSWORD_FIND_ANSWER, C_MAILING_SERVICE_USE_FL, C_INDI_INFO_OPEN_FL, C_JOIN_DT, 
    C_PASSWORD_CHANGE_DT, C_HOMEPAGE_URL, C_BLOG_URL, C_SIGN, C_PROFILE_PHOTO, 
    C_IMAGE_ICON)
  VALUES (1, 0, 0, 1, 4, 0, 'Root Node', NULL,
          '0', '0', ' ', ' ', 0,
          ' ', ' ', 0, 0, ' ',
          ' ', NULL, NULL, NULL, NULL,
          NULL);
          
INSERT INTO T_USER_INFO 
   (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE, 
    C_USER_GRADE, C_JOIN_STATE_CD, C_PASSWORD, C_EMAIL, C_LOGIN_FAILURE_CNT, 
    C_PASSWORD_FIND_QUESTION, C_PASSWORD_FIND_ANSWER, C_MAILING_SERVICE_USE_FL, C_INDI_INFO_OPEN_FL, C_JOIN_DT, 
    C_PASSWORD_CHANGE_DT, C_HOMEPAGE_URL, C_BLOG_URL, C_SIGN, C_PROFILE_PHOTO, 
    C_IMAGE_ICON)
  VALUES (2, 1, 0, 2, 3, 1, '관리자', 'drive',
          1, 1, 'bbd7182cd0ee95488f1a1e6f3fe0d8f94ed0d14e4db1dce713fe82a3231c523d','admin@313.co.kr', 0,  
          '초등학교 이름은', '부원초등학교', 0, 0, '20150425205811',
          '20150425205811',  NULL, NULL, NULL, NULL,
          NULL);  
COMMIT;

/* 회원_가입상태 */
DELETE FROM T_USER_JOIN_STATE;

INSERT INTO T_USER_JOIN_STATE 
   (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE)
  VALUES (1, 0, 0, 1, 4, 0, 'Root Node', NULL);

INSERT INTO T_USER_JOIN_STATE 
   (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE)
  VALUES (2, 1, 0, 2, 3, 1, '관리자 승인전', 'drive');

COMMIT;

/* 회원_로그인현황 */
DELETE FROM T_USER_LOGIN_STATE;

INSERT INTO T_USER_LOGIN_STATE (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE,
   C_USER_ID, C_IP_ADDRESS, C_MAC_ADDRESS, C_LOGIN_DT)                     
  VALUES (1, 0, 0, 1, 4, 0, 'Root Node', NULL,
          1, ' ', ' ', ' ');
                                        
INSERT INTO T_USER_LOGIN_STATE (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE,
   C_USER_ID, C_IP_ADDRESS, C_MAC_ADDRESS, C_LOGIN_DT)                                                           
  VALUES (2, 1, 0, 2, 3, 1, '로그인', 'drive',
           2, ' ', ' ', ' ');        
           
COMMIT;

/* 회원_게시물 스크랩 */
DELETE FROM T_USER_SCRAP;

INSERT INTO T_USER_SCRAP
  (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE,
   C_USER_ID, C_BOARD_ID, C_POSTING_ID, C_SCRAP_DT)                     
  VALUES (1, 0, 0, 1, 4, 0, 'Root Node', NULL,
          1, 1, 1,'20150425205811');
  
INSERT INTO T_USER_SCRAP 
  (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE,
   C_USER_ID, C_BOARD_ID, C_POSTING_ID, C_SCRAP_DT)                     
  VALUES (2, 1, 0, 2, 3, 1, '게시판 스크랩 목록', 'drive',
           1, 1, 1,'20150425205811');
COMMIT;
/* 오권우 끝 */

/* 류강하 시작 */
/* 회원_금지단어 */
DELETE FROM T_USER_PROH_WORD;

INSERT INTO T_USER_PROH_WORD (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE)
VALUES (1, 0, 0, 1, 8, 0, 'Root Node', 'root');

INSERT INTO T_USER_PROH_WORD (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE)
VALUES (2, 1, 0, 2, 7, 1, '회원_금지단어', 'drive');

INSERT INTO T_USER_PROH_WORD (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE)
VALUES (3, 2, 0, 3, 4, 2, '이메일', 'folder');

INSERT INTO T_USER_PROH_WORD (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE)
VALUES (4, 2, 1, 5, 6, 2, '닉네임', 'folder');

COMMIT;

/* 회원_기본컨텐츠 */
DELETE FROM T_USER_BASIC_CONTENTS;

INSERT INTO T_USER_BASIC_CONTENTS (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE, C_COMPANY_INTR, C_TERMS_OF_USE, C_PRIVACY_POLICY)
VALUES (1, 0, 0, 1, 6, 0, 'Root Node', 'root', ' ', ' ', ' ');

INSERT INTO T_USER_BASIC_CONTENTS (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE, C_COMPANY_INTR, C_TERMS_OF_USE, C_PRIVACY_POLICY)
VALUES (2, 1, 0, 2, 5, 1, '회원_기본컨텐츠', 'drive', ' ', ' ', ' ');

INSERT INTO T_USER_BASIC_CONTENTS (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE, C_COMPANY_INTR, C_TERMS_OF_USE, C_PRIVACY_POLICY)
VALUES (3, 2, 0, 3, 4, 2, '회원_가입', 'default', '바로컴퍼니입니다.', '일단 한 번 써봐. 공짜야.', '아무 것도 책임지지 않습니다.');

COMMIT;

/* 회원_비밀번호보안수준 */
DELETE FROM T_USER_PWD_SECU_LEVEL;

INSERT INTO T_USER_PWD_SECU_LEVEL (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE)
VALUES (1, 0, 0, 1, 10, 0, 'Root Node', 'root');

INSERT INTO T_USER_PWD_SECU_LEVEL (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE)
VALUES (2, 1, 0, 2, 9, 1, '회원_비밀번호보안수준', 'drive');

INSERT INTO T_USER_PWD_SECU_LEVEL (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE)
VALUES (3, 2, 0, 3, 4, 2, '낮음 (비밀번호 4자 이상)', 'default');

INSERT INTO T_USER_PWD_SECU_LEVEL (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE)
VALUES (4, 2, 1, 5, 6, 2, '보통 (비밀번호 6자 이상, 영문자/숫자 조합)', 'default');

INSERT INTO T_USER_PWD_SECU_LEVEL (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE)
VALUES (5, 2, 2, 7, 8, 2, '높음 (비밀번호 8자 이상, 영문자/숫자/특수문자 조합)', 'default');

COMMIT;

/* 회원_일반설정 */
DELETE FROM T_USER_GENERAL_SETTING;

INSERT INTO T_USER_GENERAL_SETTING (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE, C_PASSWORD_SECURITY_LEVEL_CD, C_WEB_MASTER_NM, C_WEB_MASTER_EMAIL, C_JOIN_APPROVAL_FL, C_EMAIL_AUTH_USE_FL, C_PASSWORD_CHANGE_DCNT, C_LOGIN_LIMIT_DCNT, C_LOGIN_FAILURE_LIMIT_CNT)
VALUES (1, 0, 0, 1, 6, 0, 'Root Node', 'root', 1, ' ', ' ', ' ', ' ', -1, -1, -1);

INSERT INTO T_USER_GENERAL_SETTING (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE, C_PASSWORD_SECURITY_LEVEL_CD, C_WEB_MASTER_NM, C_WEB_MASTER_EMAIL, C_JOIN_APPROVAL_FL, C_EMAIL_AUTH_USE_FL, C_PASSWORD_CHANGE_DCNT, C_LOGIN_LIMIT_DCNT, C_LOGIN_FAILURE_LIMIT_CNT)
VALUES (2, 1, 0, 2, 5, 1, '회원_일반설정', 'drive', 1, ' ', ' ', ' ', ' ', -1, -1, -1);

INSERT INTO T_USER_GENERAL_SETTING (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE, C_PASSWORD_SECURITY_LEVEL_CD, C_WEB_MASTER_NM, C_WEB_MASTER_EMAIL, C_JOIN_APPROVAL_FL, C_EMAIL_AUTH_USE_FL, C_PASSWORD_CHANGE_DCNT, C_LOGIN_LIMIT_DCNT, C_LOGIN_FAILURE_LIMIT_CNT)
VALUES (3, 2, 0, 3, 4, 2, '회원가입', 'default', 3, '바로보드 관리자', '313@313.co.kr', '0', '0', 0, 0, 0);

COMMIT;
/* 류강하 끝 */

/* 김대근 시작 */
/* 회원_등급관리 */
INSERT INTO T_USER_GRADE_MANAGE (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE, C_POINT_BY_GRADE_USE_FL, C_POINT_BY_GRADE, C_ICON_FILE_NM, C_STORE_FILE_NM)
VALUES (1, 0, 0, 1, 4, 0, 'Root Node', 'root', '0', 0, NULL, NULL);

INSERT INTO T_USER_GRADE_MANAGE (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE, C_POINT_BY_GRADE_USE_FL, C_POINT_BY_GRADE, C_ICON_FILE_NM, C_STORE_FILE_NM)
VALUES (2, 1, 0, 2, 3, 1, 'First Child', 'drive', '0', 0, NULL, NULL);


/* 회원_등급별메뉴 */
INSERT INTO T_USER_MENU_BY_GRADE (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE, C_USER_GRADE_ID, C_MENU_ID)
VALUES (1, 0, 0, 1, 4, 0, 'Root Node', 'root', 0, 0 );

INSERT INTO T_USER_MENU_BY_GRADE (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE, C_USER_GRADE_ID, C_MENU_ID)
VALUES (2, 1, 0, 2, 3, 1, 'First Child', 'drive', 0, 0);


/* 회원_쪽지유형코드 */
INSERT INTO T_USER_NOTE_TYPE_CODE (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE)
VALUES (1, 0, 0, 1, 10, 0, 'Root Node', 'root');

INSERT INTO T_USER_NOTE_TYPE_CODE (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE)
VALUES (2, 1, 0, 2, 9, 1, 'First Child', 'drive');

INSERT INTO T_USER_NOTE_TYPE_CODE (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE)
VALUES (3, 2, 0, 3, 4, 2, '수신', 'default');

INSERT INTO T_USER_NOTE_TYPE_CODE (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE)
VALUES (4, 2, 1, 5, 6, 2, '발신', 'default');

INSERT INTO T_USER_NOTE_TYPE_CODE (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE)
VALUES (5, 2, 2, 7, 8, 2, '보관', 'default');


/* 회원_쪽지상세 */
INSERT INTO T_USER_NOTE_DETAIL (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE, C_CONTENT)
VALUES (1, 0, 0, 1, 4, 0, 'Root Node', 'root', ' ');

INSERT INTO T_USER_NOTE_DETAIL (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE, C_CONTENT)
VALUES (2, 1, 0, 2, 3, 1, 'First Child', 'drive', ' ');


/* 회원_회원별쪽지 */
INSERT INTO T_USER_NOTE_BY_USER (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE, C_USER_ID, C_NOTE_DETAIL_ID, C_NOTE_TYPE_CD, C_RECE_DISP_DT)
VALUES (1, 0, 0, 1, 4, 0, 'Root Node', 'root', 0, 0, 0, '19000101000000');

INSERT INTO T_USER_NOTE_BY_USER (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE, C_USER_ID, C_NOTE_DETAIL_ID, C_NOTE_TYPE_CD, C_RECE_DISP_DT)
VALUES (2, 1, 0, 2, 3, 1, 'First Child', 'drive', 0, 0, 0, '19000101000000');


/* 회원_쪽지첨부파일 */
INSERT INTO T_USER_NOTE_ATTACH_FILE (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE, C_NOTE_DETAIL_ID, C_STORE_FILE_NM)
VALUES (1, 0, 0, 1, 4, 0, 'Root Node', 'root', 0, NULL);

INSERT INTO T_USER_NOTE_ATTACH_FILE (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE, C_NOTE_DETAIL_ID, C_STORE_FILE_NM)
VALUES (2, 1, 0, 2, 3, 1, 'First Child', 'drive', 0, NULL);


/* 회원_포인트설정 */
INSERT INTO T_USER_POINT_SETTING (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE, C_POINT_USE_FL, C_DOWNLOAD_PROH_FL, C_ARTICLE_READ_PROH_FL, C_POINT_EXPIRY_DATE, C_USER_JOIN_POINT, C_LOGIN_POINT, C_WRITING_POINT, C_ANSWER_POINT, C_UPLOAD_POINT, C_DOWNLOAD_POINT, C_RECMNDER_POINT, C_DOWNLOAD_DEDU_POINT, C_ARTICLE_READ_DEDU_POINT)
VALUES (1, 0, 0, 1, 6, 0, 'Root Node', 'root', '0', '0', '0', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

INSERT INTO T_USER_POINT_SETTING (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE, C_POINT_USE_FL, C_DOWNLOAD_PROH_FL, C_ARTICLE_READ_PROH_FL, C_POINT_EXPIRY_DATE, C_USER_JOIN_POINT, C_LOGIN_POINT, C_WRITING_POINT, C_ANSWER_POINT, C_UPLOAD_POINT, C_DOWNLOAD_POINT, C_RECMNDER_POINT, C_DOWNLOAD_DEDU_POINT, C_ARTICLE_READ_DEDU_POINT)
VALUES (2, 1, 0, 2, 5, 1, 'First Child', 'drive', '0', '0', '0', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

INSERT INTO T_USER_POINT_SETTING (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE, C_POINT_USE_FL, C_DOWNLOAD_PROH_FL, C_ARTICLE_READ_PROH_FL, C_POINT_EXPIRY_DATE, C_USER_JOIN_POINT, C_LOGIN_POINT, C_WRITING_POINT, C_ANSWER_POINT, C_UPLOAD_POINT, C_DOWNLOAD_POINT, C_RECMNDER_POINT, C_DOWNLOAD_DEDU_POINT, C_ARTICLE_READ_DEDU_POINT)
VALUES (3, 2, 0, 3, 4, 2, '회원_포인트설정', 'default', '0', '0', '0', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

/* 회원_포인트코드 */
INSERT INTO T_USER_POINT_CODE (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE)
VALUES (1, 0, 0, 1, 22, 0, 'Root Node', 'root');

INSERT INTO T_USER_POINT_CODE (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE)
VALUES (2, 1, 0, 2, 21, 1, 'First Child', 'drive');

INSERT INTO T_USER_POINT_CODE (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE)
VALUES (3, 2, 0, 3, 4, 2, '회원가입포인트', 'default');

INSERT INTO T_USER_POINT_CODE (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE)
VALUES (4, 2, 1, 5, 6, 2, '로그인포인트', 'default');

INSERT INTO T_USER_POINT_CODE (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE)
VALUES (5, 2, 2, 7, 8, 2, '글쓰기포인트', 'default');

INSERT INTO T_USER_POINT_CODE (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE)
VALUES (6, 2, 3, 9, 10, 2, '댓글포인트', 'default');

INSERT INTO T_USER_POINT_CODE (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE)
VALUES (7, 2, 4, 11, 12, 2, '업로드포인트', 'default');

INSERT INTO T_USER_POINT_CODE (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE)
VALUES (8, 2, 5, 13, 14, 2, '다운로드포인트', 'default');

INSERT INTO T_USER_POINT_CODE (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE)
VALUES (9, 2, 6, 15, 16, 2, '추천인포인트', 'default');

INSERT INTO T_USER_POINT_CODE (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE)
VALUES (10, 2, 7, 17, 18, 2, '다운로드차감포인트', 'default');

INSERT INTO T_USER_POINT_CODE (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE)
VALUES (11, 2, 8, 19, 20, 2, '글열람차감포인트', 'default');



/* 회원_포인트부여 */
INSERT INTO T_USER_POINT_ASSIGN (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE, C_USER_ID, C_POINT_CODE_ID, C_POINT, C_ASSIGN_DT, C_DESC)
VALUES (1, 0, 0, 1, 4, 0, 'Root Node', 'root', 0, 0, 0, '19000101000000', NULL);

INSERT INTO T_USER_POINT_ASSIGN (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE, C_USER_ID, C_POINT_CODE_ID, C_POINT, C_ASSIGN_DT, C_DESC)
VALUES (2, 1, 0, 2, 3, 1, 'First Child', 'drive', 0, 0, 0, '19000101000000', NULL);

COMMIT;
/* 김대근 종료 */