CREATE TABLE IF NOT EXISTS `tree` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) unsigned NOT NULL,
  `position` bigint(20) unsigned NOT NULL,
  `left` bigint(20) unsigned NOT NULL,
  `right` bigint(20) unsigned NOT NULL,
  `level` bigint(20) unsigned NOT NULL,
  `title` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=13 ;

delete from tree;
Insert into tree
 Values
   (229, 5, 1, 12, 13, 
    3, 'New node2', 'default');
Insert into tree
 Values
   (228, 3, 1, 6, 7, 
    3, 'New node1', 'default');
Insert into tree
 Values
   (1, 0, 2, 1, 16, 
    0, 'ROOT', NULL);
Insert into tree
 Values
   (2, 1, 0, 2, 15, 
    1, 'C:', 'drive');
Insert into tree
 Values
   (3, 2, 0, 3, 8, 
    2, '_demo', 'folder');
Insert into tree
 Values
   (4, 3, 0, 4, 5, 
    3, 'index.html', 'default');
Insert into tree
 Values
   (5, 2, 1, 9, 14, 
    2, '_docs', 'folder');
Insert into tree
 Values
   (12, 5, 0, 10, 11, 
    3, 'zmei.html', 'default');
COMMIT;

CREATE TABLE IF NOT EXISTS `tree` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) unsigned NOT NULL,
  `position` bigint(20) unsigned NOT NULL,
  `left` bigint(20) unsigned NOT NULL,
  `right` bigint(20) unsigned NOT NULL,
  `level` bigint(20) unsigned NOT NULL,
  `title` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=13 ;

INSERT INTO `tree` (`id`, `parent_id`, `position`, `left`, `right`, `level`, `title`, `type`) VALUES
(1, 0, 2, 1, 14, 0, 'ROOT', ''),
(2, 1, 0, 2, 11, 1, 'C:', 'drive'),
(3, 2, 0, 3, 6, 2, '_demo', 'folder'),
(4, 3, 0, 4, 5, 3, 'index.html', 'default'),
(5, 2, 1, 7, 10, 2, '_docs', 'folder'),
(6, 1, 1, 12, 13, 1, 'D:', 'drive'),
(12, 5, 0, 8, 9, 3, 'zmei.html', 'default');

oracle
delete from t_comprehensivetree;
INSERT INTO FAMILY."T_COMPREHENSIVETREE"
  (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE)
VALUES
  (229, 5, 1, 18, 19, 3, 'New node6', 'default');

INSERT INTO FAMILY."T_COMPREHENSIVETREE"
  (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE)
VALUES
  (228, 3, 3, 10, 11, 3, 'New node3', 'default');

INSERT INTO FAMILY."T_COMPREHENSIVETREE"
  (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE)
VALUES
  (1, 0, 0, 1, 22, 0, 'ROOT', '');

INSERT INTO FAMILY."T_COMPREHENSIVETREE"
  (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE)
VALUES
  (2, 1, 0, 2, 21, 1, 'C:', 'drive');

INSERT INTO FAMILY."T_COMPREHENSIVETREE"
  (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE)
VALUES
  (3, 2, 0, 3, 14, 2, '_demo', 'folder');

INSERT INTO FAMILY."T_COMPREHENSIVETREE"
  (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE)
VALUES
  (4, 3, 0, 4, 5, 3, 'index.html', 'default');

INSERT INTO FAMILY."T_COMPREHENSIVETREE"
  (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE)
VALUES
  (5, 2, 1, 15, 20, 2, '_docs', 'folder');

INSERT INTO FAMILY."T_COMPREHENSIVETREE"
  (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE)
VALUES
  (12, 5, 0, 16, 17, 3, 'zmei.html', 'default');

INSERT INTO FAMILY."T_COMPREHENSIVETREE"
  (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE)
VALUES
  (291, 3, 2, 8, 9, 3, 'New node2', 'default');

INSERT INTO FAMILY."T_COMPREHENSIVETREE"
  (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE)
VALUES
  (292, 3, 4, 12, 13, 3, 'New node4', 'default');

INSERT INTO FAMILY."T_COMPREHENSIVETREE"
  (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, C_LEVEL, C_TITLE, C_TYPE)
VALUES
  (290, 3, 1, 6, 7, 3, 'New node1', 'default');
  COMMIT;


-----------------------------------------------------------------------
oracle
delete from t_comprehensivetree;
Insert into T_COMPREHENSIVETREE
   (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, 
    C_LEVEL, C_TITLE, C_TYPE)
 Values
   (16, 3, 5, 14, 15, 
    3, 'node 6', 'default');
Insert into T_COMPREHENSIVETREE
   (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, 
    C_LEVEL, C_TITLE, C_TYPE)
 Values
   (14, 3, 4, 12, 13, 
    3, 'node 4', 'default');
Insert into T_COMPREHENSIVETREE
   (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, 
    C_LEVEL, C_TITLE, C_TYPE)
 Values
   (1, 0, 0, 1, 22, 
    0, 'ROOT', NULL);
Insert into T_COMPREHENSIVETREE
   (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, 
    C_LEVEL, C_TITLE, C_TYPE)
 Values
   (2, 1, 0, 2, 21, 
    1, 'C:', 'drive');
Insert into T_COMPREHENSIVETREE
   (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, 
    C_LEVEL, C_TITLE, C_TYPE)
 Values
   (3, 2, 0, 3, 18, 
    2, '_demo', 'folder');
Insert into T_COMPREHENSIVETREE
   (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, 
    C_LEVEL, C_TITLE, C_TYPE)
 Values
   (11, 3, 0, 4, 5, 
    3, 'node 1', 'default');
Insert into T_COMPREHENSIVETREE
   (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, 
    C_LEVEL, C_TITLE, C_TYPE)
 Values
   (5, 2, 1, 19, 20, 
    2, '_docs', 'folder');
Insert into T_COMPREHENSIVETREE
   (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, 
    C_LEVEL, C_TITLE, C_TYPE)
 Values
   (10, 3, 2, 8, 9, 
    3, 'node 0', 'default');
Insert into T_COMPREHENSIVETREE
   (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, 
    C_LEVEL, C_TITLE, C_TYPE)
 Values
   (13, 3, 3, 10, 11, 
    3, 'node 3', 'default');
Insert into T_COMPREHENSIVETREE
   (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, 
    C_LEVEL, C_TITLE, C_TYPE)
 Values
   (15, 3, 6, 16, 17, 
    3, 'node 5', 'default');
Insert into T_COMPREHENSIVETREE
   (C_ID, C_PARENTID, C_POSITION, C_LEFT, C_RIGHT, 
    C_LEVEL, C_TITLE, C_TYPE)
 Values
   (12, 3, 1, 6, 7, 
    3, 'node 2', 'default');
COMMIT;

