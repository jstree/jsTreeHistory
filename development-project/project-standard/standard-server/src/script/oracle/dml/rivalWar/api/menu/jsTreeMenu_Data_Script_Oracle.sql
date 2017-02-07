Insert into T_JSTREE_MENU
  (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT,
   C_LEVEL, C_TITLE, C_TYPE, C_VOTE_START_DATE, C_VOTE_END_DATE)
Values
  (1, 0, 0, 1, 8,
   0, 'Root Node', 'root', '2017-01-01', '2017-03-13');
Insert into T_JSTREE_MENU
  (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT,
   C_LEVEL, C_TITLE, C_TYPE, C_VOTE_START_DATE, C_VOTE_END_DATE)
Values
  (2, 1, 0, 2, 7,
   1, 'First Child', 'drive', '2017-01-01', '2017-03-13');
Insert into T_JSTREE_MENU
  (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT,
   C_LEVEL, C_TITLE, C_TYPE, C_VOTE_START_DATE, C_VOTE_END_DATE)
Values
  (3, 2, 0, 3, 4,
   2, 'Leaf Node', 'default', '2017-01-01', '2017-03-13');
Insert into T_JSTREE_MENU
  (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT,
   C_LEVEL, C_TITLE, C_TYPE, C_VOTE_START_DATE, C_VOTE_END_DATE)
Values
  (4, 2, 1, 5, 6,
   2, 'Branch Node', 'folder', '2017-01-01', '2017-03-13');
COMMIT;