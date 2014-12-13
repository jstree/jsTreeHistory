
CREATE TABLE T_NEWSLETTER
(
  C_ID        NUMBER                            NOT NULL,
  C_PARENTID  NUMBER                            NOT NULL,
  C_POSITION  NUMBER                            NOT NULL,
  C_LEFT      NUMBER                            NOT NULL,
  C_RIGHT     NUMBER                            NOT NULL,
  C_LEVEL     NUMBER                            NOT NULL,
  C_TITLE     VARCHAR2(4000 BYTE),
  C_TYPE      VARCHAR2(4000 BYTE),
  C_EMAIL     VARCHAR2(320 BYTE),
  CONSTRAINT  T_NEWSLETTER PRIMARY KEY (C_ID)
);

COMMENT ON TABLE T_NEWSLETTER IS '뉴스레터';
COMMENT ON COLUMN T_NEWSLETTER.C_ID IS '노드 아이디';
COMMENT ON COLUMN T_NEWSLETTER.C_PARENTID IS '부모 노드 아이디';
COMMENT ON COLUMN T_NEWSLETTER.C_POSITION IS '노드 포지션';
COMMENT ON COLUMN T_NEWSLETTER.C_LEFT IS '노드 좌측 끝 포인트';
COMMENT ON COLUMN T_NEWSLETTER.C_RIGHT IS '노드 우측 끝 포인트';
COMMENT ON COLUMN T_NEWSLETTER.C_LEVEL IS '노드 DEPTH ';
COMMENT ON COLUMN T_NEWSLETTER.C_TITLE IS '노드 명';
COMMENT ON COLUMN T_NEWSLETTER.C_TYPE IS '노드 타입';
COMMENT ON COLUMN T_NEWSLETTER.C_EMAIL IS '이메일 주소';

DROP SEQUENCE S_NEWSLETTER;

CREATE SEQUENCE S_NEWSLETTER
  START WITH 1
  MAXVALUE 999999999999999999999999999
  MINVALUE 0
  NOCYCLE
  CACHE 20
  NOORDER;