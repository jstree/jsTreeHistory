CREATE TABLE COMTECOPSEQ
(
	TABLE_NAME            VARCHAR2(20)  NOT NULL ,
	NEXT_ID               NUMBER(30)  NULL ,
CONSTRAINT  COMTECOPSEQ_PK PRIMARY KEY (TABLE_NAME)
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



CREATE TABLE COMTNAUTHORGROUPINFO
(
	GROUP_ID              CHAR(20)  NOT NULL ,
	GROUP_NM              VARCHAR2(60)  NOT NULL ,
	GROUP_CREAT_DE        CHAR(20)  NOT NULL ,
	GROUP_DC              VARCHAR2(100)  NULL ,
CONSTRAINT  COMTNAUTHORGROUPINFO_PK PRIMARY KEY (GROUP_ID)
);




CREATE TABLE COMTNORGNZTINFO
(
	ORGNZT_ID             CHAR(20)  NOT NULL ,
	ORGNZT_NM             VARCHAR2(20)  NOT NULL ,
	ORGNZT_DC             VARCHAR2(100)  NULL ,
CONSTRAINT  COMTNORGNZTINFO_PK PRIMARY KEY (ORGNZT_ID)
);




CREATE TABLE COMTNFILE
(
	ATCH_FILE_ID          CHAR(20)  NOT NULL ,
	CREAT_DT              DATE  NOT NULL ,
	USE_AT                CHAR(1)  NULL ,
CONSTRAINT  COMTNFILE_PK PRIMARY KEY (ATCH_FILE_ID)
);




CREATE TABLE COMTNFILEDETAIL
(
	ATCH_FILE_ID          CHAR(20)  NOT NULL ,
	FILE_SN               NUMBER(10)  NOT NULL ,
	FILE_STRE_COURS       VARCHAR2(2000)  NOT NULL ,
	STRE_FILE_NM          VARCHAR2(255)  NOT NULL ,
	ORIGNL_FILE_NM        VARCHAR2(255)  NULL ,
	FILE_EXTSN            VARCHAR2(20)  NOT NULL ,
	FILE_CN               CLOB  NULL ,
	FILE_SIZE             NUMBER(8)  NULL ,
CONSTRAINT  COMTNFILEDETAIL_PK PRIMARY KEY (ATCH_FILE_ID,FILE_SN),
CONSTRAINT  COMTNFILEDETAIL_FK1 FOREIGN KEY (ATCH_FILE_ID) REFERENCES COMTNFILE(ATCH_FILE_ID)
);

CREATE INDEX COMTNFILEDETAIL_i01 ON COMTNFILEDETAIL
(ATCH_FILE_ID  ASC);



CREATE TABLE COMTNHTTPMON
(
	SYS_ID                VARCHAR2(20)  NOT NULL ,
	SITE_URL              VARCHAR2(100)  NULL ,
	WEBSVC_KND            VARCHAR2(10)  NULL ,
	HTTP_STTUS_CODE       VARCHAR2(3)  NULL ,
	CREAT_DT              DATE  NULL ,
	MNGR_NM               VARCHAR2(60)  NULL ,
	MNGR_EMAIL_ADRES      VARCHAR2(50)  NULL ,
	FRST_REGISTER_ID      VARCHAR2(20)  NULL ,
	FRST_REGIST_PNTTM     DATE  NULL ,
	LAST_UPDUSR_ID        VARCHAR2(20)  NULL ,
	LAST_UPDT_PNTTM       DATE  NULL ,
CONSTRAINT  COMTNHTTPMON_PK PRIMARY KEY (SYS_ID)
);




CREATE TABLE COMTHTRSMRCVMNTRNGLOGINFO
(
	LOG_ID                CHAR(20)  NOT NULL ,
	CNTC_ID               CHAR(8)  NOT NULL ,
	TEST_CLASS_NM         VARCHAR2(255)  NULL ,
	MNGR_NM               VARCHAR2(60)  NULL ,
	MNGR_EMAIL_ADRES      VARCHAR2(50)  NULL ,
	MNTRNG_STTUS          CHAR(2)  NULL ,
	LOG_INFO              VARCHAR2(2000)  NULL ,
	CREAT_DT              DATE  NULL ,
	FRST_REGISTER_ID      VARCHAR2(20)  NULL ,
	FRST_REGIST_PNTTM     DATE  NOT NULL ,
	LAST_UPDUSR_ID        VARCHAR2(20)  NULL ,
	LAST_UPDT_PNTTM       DATE  NOT NULL ,
CONSTRAINT  COMTHTRSMRCVMNTRNGLOGINFO_PK PRIMARY KEY (LOG_ID)
);




CREATE TABLE COMTHDBMNTRNGLOGINFO
(
	DATA_SOURC_NM         VARCHAR2(60)  NOT NULL ,
	SERVER_NM             VARCHAR2(60)  NULL ,
	DBMS_KND              VARCHAR2(2)  NULL ,
	CECK_SQL              VARCHAR2(250)  NULL ,
	MNGR_NM               VARCHAR2(60)  NULL ,
	MNGR_EMAIL_ADRES      VARCHAR2(50)  NULL ,
	MNTRNG_STTUS          CHAR(2)  NULL ,
	LOG_INFO              VARCHAR2(2000)  NULL ,
	CREAT_DT              DATE  NULL ,
	FRST_REGISTER_ID      VARCHAR2(20)  NULL ,
	FRST_REGIST_PNTTM     DATE  NOT NULL ,
	LAST_UPDT_PNTTM       DATE  NOT NULL ,
	LAST_UPDUSR_ID        VARCHAR2(20)  NULL ,
	LOG_ID                CHAR(20)  NOT NULL ,
CONSTRAINT  COMTHDBMNTRNGLOGINFO_PK PRIMARY KEY (LOG_ID)
);




CREATE TABLE COMTHHTTPMONLOGINFO
(
	SYS_ID                VARCHAR2(20)  NOT NULL ,
	SITE_URL              VARCHAR2(100)  NULL ,
	WEBSVC_KND            VARCHAR2(10)  NULL ,
	HTTP_STTUS_CODE       VARCHAR2(3)  NULL ,
	CREAT_DT              DATE  NULL ,
	LOG_INFO              VARCHAR2(2000)  NULL ,
	MNGR_NM               VARCHAR2(60)  NULL ,
	MNGR_EMAIL_ADRES      VARCHAR2(50)  NULL ,
	FRST_REGISTER_ID      VARCHAR2(20)  NULL ,
	FRST_REGIST_PNTTM     DATE  NULL ,
	LAST_UPDUSR_ID        VARCHAR2(20)  NULL ,
	LAST_UPDT_PNTTM       DATE  NULL ,
	LOG_ID                CHAR(20)  NOT NULL ,
CONSTRAINT  COMTHHTTPMONLOGINFO_PK PRIMARY KEY (SYS_ID,LOG_ID),
CONSTRAINT  COMTHHTTPMONLOGINFO_FK2 FOREIGN KEY (SYS_ID) REFERENCES COMTNHTTPMON(SYS_ID)
);




