Insert into T_JSTREE_DIRECTCHAT
  (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT,
   C_LEVEL, C_TITLE, C_TYPE, C_USERID, C_TIME, C_LIKECOUNT, C_HATECOUNT, C_CAMP)
Values
  (1, 0, 0, 1, 8,
   0, 'Root Node', 'root', 3, '2017-03-13 03:13:31', 313, 131, 1);
Insert into T_JSTREE_DIRECTCHAT
  (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT,
   C_LEVEL, C_TITLE, C_TYPE, C_USERID, C_TIME, C_LIKECOUNT, C_HATECOUNT, C_CAMP)
Values
  (2, 1, 0, 2, 7,
   1, 'First Child', 'drive', 3, '2017-03-13 03:13:31', 313, 131, 1);
Insert into T_JSTREE_DIRECTCHAT
  (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT,
   C_LEVEL, C_TITLE, C_TYPE, C_USERID, C_TIME, C_LIKECOUNT, C_HATECOUNT, C_CAMP)
Values
  (3, 2, 0, 3, 4,
   2, 'Leaf Node', 'default', 3, '2017-03-13 03:13:31', 313, 131, 1);
Insert into T_JSTREE_DIRECTCHAT
  (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT,
   C_LEVEL, C_TITLE, C_TYPE, C_USERID, C_TIME, C_LIKECOUNT, C_HATECOUNT, C_CAMP)
Values
  (4, 2, 1, 5, 6,
   2, 'Branch Node', 'folder', 3, '2017-03-13 03:13:31', 313, 131, 1);
COMMIT;