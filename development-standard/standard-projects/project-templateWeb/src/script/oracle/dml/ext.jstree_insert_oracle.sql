/*
 * 기본 데이터 삽입
 */
Insert into T_COMPREHENSIVETREE
   (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, 
    C_LEVEL, C_TITLE, C_TYPE)
 Values
   (1, 0, 0, 1, 8, 
    0, 'Root Node', NULL);
Insert into T_COMPREHENSIVETREE
   (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, 
    C_LEVEL, C_TITLE, C_TYPE)
 Values
   (2, 1, 0, 2, 7, 
    1, 'First Child Node', 'drive');
Insert into T_COMPREHENSIVETREE
   (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, 
    C_LEVEL, C_TITLE, C_TYPE)
 Values
   (3, 2, 0, 3, 6, 
    2, 'Second Child Branch', 'folder');
Insert into T_COMPREHENSIVETREE
   (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, 
    C_LEVEL, C_TITLE, C_TYPE)
 Values
   (4, 3, 0, 4, 5, 
    3, 'Third Child Leaf', 'default');
COMMIT;
