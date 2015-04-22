/* 회원_금지단어 */
INSERT INTO T_USER_PROH_WORD (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE, C_TYPE_CD)
VALUES (1, 0, 0, 1, 8, 0, 'Root Node', NULL, ' ');

INSERT INTO T_USER_PROH_WORD (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE, C_TYPE_CD)
VALUES (2, 1, 0, 2, 7, 1, 'First Child', 'drive', ' ');

INSERT INTO T_USER_PROH_WORD (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE, C_TYPE_CD)
VALUES (3, 2, 0, 3, 4, 2, 'Leaf Node', 'default', ' ');

INSERT INTO T_USER_PROH_WORD (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE, C_TYPE_CD)
VALUES (4, 2, 1, 5, 6, 2, 'Branch Node', 'folder', ' ');

COMMIT;

/* 회원_이용약관 */
INSERT INTO T_USER_TERMS_OF_USE (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE, C_TYPE_CD, C_COMPANY_INTR, C_TERMS_OF_USE, C_PRIVACY_POLICY)
VALUES (1, 0, 0, 1, 8, 0, 'Root Node', NULL, ' ', ' ', ' ', ' ');

INSERT INTO T_USER_TERMS_OF_USE (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE, C_TYPE_CD, C_COMPANY_INTR, C_TERMS_OF_USE, C_PRIVACY_POLICY)
VALUES (2, 1, 0, 2, 7, 1, 'First Child', 'drive', ' ', ' ', ' ', ' ');

INSERT INTO T_USER_TERMS_OF_USE (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE, C_TYPE_CD, C_COMPANY_INTR, C_TERMS_OF_USE, C_PRIVACY_POLICY)
VALUES (3, 2, 0, 3, 4, 2, 'Leaf Node', 'default', ' ', ' ', ' ', ' ');

INSERT INTO T_USER_TERMS_OF_USE (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE, C_TYPE_CD, C_COMPANY_INTR, C_TERMS_OF_USE, C_PRIVACY_POLICY)
VALUES (4, 2, 1, 5, 6, 2, 'Branch Node', 'folder', ' ', ' ', ' ', ' ');

COMMIT;

/* 회원_가입필드컴포넌트 */
INSERT INTO T_USER_JOIN_FIELD_COMP (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE)
VALUES (1, 0, 0, 1, 8, 0, 'Root Node', NULL);

INSERT INTO T_USER_JOIN_FIELD_COMP (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE)
VALUES (2, 1, 0, 2, 7, 1, 'First Child', 'drive');

INSERT INTO T_USER_JOIN_FIELD_COMP (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE)
VALUES (3, 2, 0, 3, 4, 2, 'Leaf Node', 'default');

INSERT INTO T_USER_JOIN_FIELD_COMP (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE)
VALUES (4, 2, 1, 5, 6, 2, 'Branch Node', 'folder');

COMMIT;

/* 회원_비밀번호보안수준 */
INSERT INTO T_USER_PASSWORD_SECURITY_LEVEL (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE)
VALUES (1, 0, 0, 1, 8, 0, 'Root Node', NULL);

INSERT INTO T_USER_PASSWORD_SECURITY_LEVEL (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE)
VALUES (2, 1, 0, 2, 7, 1, 'First Child', 'drive');

INSERT INTO T_USER_PASSWORD_SECURITY_LEVEL (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE)
VALUES (3, 2, 0, 3, 4, 2, 'Leaf Node', 'default');

INSERT INTO T_USER_PASSWORD_SECURITY_LEVEL (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE)
VALUES (4, 2, 1, 5, 6, 2, 'Branch Node', 'folder');

COMMIT;

/* 회원_기본설정 */
INSERT INTO T_USER_BASIC_SETTING (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE, C_WEB_MASTER_NM, C_WEB_MASTER_EMAIL, C_JOIN_APPROVAL_FL, C_EMAIL_AUTH_USE_FL, C_PASSWORD_SECURITY_LEVEL_CD, C_PASSWORD_CHANGE_DCNT, C_LOGIN_LIMIT_DCNT, C_LOGIN_FAILURE_LIMIT_CNT)
VALUES (1, 0, 0, 1, 8, 0, 'Root Node', NULL, ' ', ' ', ' ', ' ', 1, -1, -1, -1);

INSERT INTO T_USER_BASIC_SETTING (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE, C_WEB_MASTER_NM, C_WEB_MASTER_EMAIL, C_JOIN_APPROVAL_FL, C_EMAIL_AUTH_USE_FL, C_PASSWORD_SECURITY_LEVEL_CD, C_PASSWORD_CHANGE_DCNT, C_LOGIN_LIMIT_DCNT, C_LOGIN_FAILURE_LIMIT_CNT)
VALUES (2, 1, 0, 2, 7, 1, 'First Child', 'drive', ' ', ' ', ' ', ' ', 1, -1, -1, -1);

INSERT INTO T_USER_BASIC_SETTING (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE, C_WEB_MASTER_NM, C_WEB_MASTER_EMAIL, C_JOIN_APPROVAL_FL, C_EMAIL_AUTH_USE_FL, C_PASSWORD_SECURITY_LEVEL_CD, C_PASSWORD_CHANGE_DCNT, C_LOGIN_LIMIT_DCNT, C_LOGIN_FAILURE_LIMIT_CNT)
VALUES (3, 2, 0, 3, 4, 2, 'Leaf Node', 'default', ' ', ' ', ' ', ' ', 1, -1, -1, -1);

INSERT INTO T_USER_BASIC_SETTING (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE, C_WEB_MASTER_NM, C_WEB_MASTER_EMAIL, C_JOIN_APPROVAL_FL, C_EMAIL_AUTH_USE_FL, C_PASSWORD_SECURITY_LEVEL_CD, C_PASSWORD_CHANGE_DCNT, C_LOGIN_LIMIT_DCNT, C_LOGIN_FAILURE_LIMIT_CNT)
VALUES (4, 2, 1, 5, 6, 2, 'Branch Node', 'folder', ' ', ' ', ' ', ' ', 1, -1, -1, -1);

COMMIT;