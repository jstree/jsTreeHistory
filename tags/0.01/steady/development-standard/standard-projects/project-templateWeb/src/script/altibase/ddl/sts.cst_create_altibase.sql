CREATE TABLE COMTECOPSEQ
(
	TABLE_NAME            VARCHAR2(20)  NOT NULL ,
	NEXT_ID               NUMBER(30)  NULL ,
CONSTRAINT  COMTECOPSEQ_PK PRIMARY KEY (TABLE_NAME)
);




CREATE TABLE COMTNLOGINLOG
(
	LOG_ID                CHAR(20)  NOT NULL ,
	CONECT_ID             VARCHAR2(20)  NULL ,
	CONECT_IP             VARCHAR2(23)  NULL ,
	CONECT_MTHD           CHAR(4)  NULL ,
	ERROR_OCCRRNC_AT      CHAR(1)  NULL ,
	ERROR_CODE            CHAR(3)  NULL ,
	CREAT_DT              DATE  NULL ,
CONSTRAINT  COMTNLOGINLOG_PK PRIMARY KEY (LOG_ID)
);




CREATE TABLE COMTSSYSLOGSUMMARY
(
	OCCRRNC_DE            CHAR(20)  NOT NULL ,
	SVC_NM                VARCHAR2(255)  NOT NULL ,
	METHOD_NM             VARCHAR2(60)  NOT NULL ,
	CREAT_CO              NUMBER(10)  NULL ,
	UPDT_CO               NUMBER(10)  NULL ,
	RDCNT                 NUMBER(10)  NULL ,
	DELETE_CO             NUMBER(10)  NULL ,
	OUTPT_CO              NUMBER(10)  NULL ,
	ERROR_CO              NUMBER(10)  NULL ,
CONSTRAINT  COMTSSYSLOGSUMMARY_PK PRIMARY KEY (OCCRRNC_DE,SVC_NM,METHOD_NM)
);




CREATE TABLE COMTNRESTDE
(
	RESTDE_NO             NUMBER(6)  NOT NULL ,
	RESTDE                CHAR(8)  NULL ,
	RESTDE_NM             VARCHAR2(60)  NULL ,
	RESTDE_DC             VARCHAR2(200)  NULL ,
	RESTDE_SE_CODE        VARCHAR2(2)  NULL ,
	FRST_REGIST_PNTTM     DATE  NULL ,
	FRST_REGISTER_ID      VARCHAR2(20)  NULL ,
	LAST_UPDT_PNTTM       DATE  NULL ,
	LAST_UPDUSR_ID        VARCHAR2(20)  NULL ,
CONSTRAINT  COMTNRESTDE_PK PRIMARY KEY (RESTDE_NO)
);




CREATE TABLE COMTCCMMNCLCODE
(
	CL_CODE               CHAR(3)  NOT NULL ,
	CL_CODE_NM            VARCHAR2(60)  NULL ,
	CL_CODE_DC            VARCHAR2(200)  NULL ,
	USE_AT                CHAR(1)  NULL ,
	FRST_REGIST_PNTTM     DATE  NULL ,
	FRST_REGISTER_ID      VARCHAR2(20)  NULL ,
	LAST_UPDT_PNTTM       DATE  NULL ,
	LAST_UPDUSR_ID        VARCHAR2(20)  NULL ,
CONSTRAINT  COMTCCMMNCLCODE_PK PRIMARY KEY (CL_CODE)
);




CREATE TABLE COMTCCMMNCODE
(
	CODE_ID               VARCHAR2(6)  NOT NULL ,
	CODE_ID_NM            VARCHAR2(60)  NULL ,
	CODE_ID_DC            VARCHAR2(200)  NULL ,
	USE_AT                CHAR(1)  NULL ,
	CL_CODE               CHAR(3)  NULL ,
	FRST_REGIST_PNTTM     DATE  NULL ,
	FRST_REGISTER_ID      VARCHAR2(20)  NULL ,
	LAST_UPDT_PNTTM       DATE  NULL ,
	LAST_UPDUSR_ID        VARCHAR2(20)  NULL ,
CONSTRAINT  COMTCCMMNCODE_PK PRIMARY KEY (CODE_ID),
CONSTRAINT  COMTCCMMNCODE_FK1 FOREIGN KEY (CL_CODE) REFERENCES COMTCCMMNCLCODE(CL_CODE) ON DELETE CASCADE
);

CREATE INDEX COMTCCMMNCODE_i01 ON COMTCCMMNCODE
(CL_CODE  ASC);



CREATE TABLE COMTCCMMNDETAILCODE
(
	CODE_ID               VARCHAR2(6)  NOT NULL ,
	CODE                  VARCHAR2(15)  NOT NULL ,
	CODE_NM               VARCHAR2(60)  NULL ,
	CODE_DC               VARCHAR2(200)  NULL ,
	USE_AT                CHAR(1)  NULL ,
	FRST_REGIST_PNTTM     DATE  NULL ,
	FRST_REGISTER_ID      VARCHAR2(20)  NULL ,
	LAST_UPDT_PNTTM       DATE  NULL ,
	LAST_UPDUSR_ID        VARCHAR2(20)  NULL ,
CONSTRAINT  COMTCCMMNDETAILCODE_PK PRIMARY KEY (CODE_ID,CODE),
CONSTRAINT  COMTCCMMNDETAILCODE_FK1 FOREIGN KEY (CODE_ID) REFERENCES COMTCCMMNCODE(CODE_ID)
);

CREATE INDEX COMTCCMMNDETAILCODE_i01 ON COMTCCMMNDETAILCODE
(CODE_ID  ASC);



