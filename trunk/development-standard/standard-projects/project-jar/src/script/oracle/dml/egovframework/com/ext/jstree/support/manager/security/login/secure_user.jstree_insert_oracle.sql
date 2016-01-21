Insert into T_SECURE_USER
   (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, 
    C_LEVEL, C_TITLE, C_TYPE, C_PASSWORD, C_EMAIL, 
    C_LOGIN_FAILURE_CNT, C_JOIN_DT, C_LAST_LOGIN_DT)
 Values
   (1, 0, 0, 1, 9, 
    0, 'Root Node', 'root', ' ', ' ', 
    -1, '20150603222617', NULL);
Insert into T_SECURE_USER
   (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, 
    C_LEVEL, C_TITLE, C_TYPE, C_PASSWORD, C_EMAIL, 
    C_LOGIN_FAILURE_CNT, C_JOIN_DT, C_LAST_LOGIN_DT)
 Values
   (2, 1, 0, 2, 8, 
    1, '회원_정보', 'drive', ' ', ' ', 
    -1, '20150603222617', NULL);
Insert into T_SECURE_USER
   (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, 
    C_LEVEL, C_TITLE, C_TYPE, C_PASSWORD, C_EMAIL, 
    C_LOGIN_FAILURE_CNT, C_JOIN_DT, C_LAST_LOGIN_DT)
 Values
   (3, 2, 0, 3, 7, 
    2, '사용자', 'default', '36f8c7f8a03bc7b6f136df35f8252219c2d53fdcba0b588fbe228e9eb1536537', 'user@313.co.kr', 
    0, '20150603222617', NULL);
Insert into T_SECURE_USER
   (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, 
    C_LEVEL, C_TITLE, C_TYPE, C_PASSWORD, C_EMAIL, 
    C_LOGIN_FAILURE_CNT, C_JOIN_DT, C_LAST_LOGIN_DT)
 Values
   (4, 2, 1, 5, 6, 
    2, '관리자', 'default', '9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08', 'admin@313.co.kr', 
    0, '20150603222617', '20160121111032');
COMMIT;
