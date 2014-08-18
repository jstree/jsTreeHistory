CREATE TABLE COMTECOPSEQ
(
	TABLE_NAME            VARCHAR(60)  NOT NULL ,
	NEXT_ID               NUMERIC(30)  NULL ,
CONSTRAINT  COMTECOPSEQ_PK PRIMARY KEY (TABLE_NAME)
);




CREATE TABLE COMTNRESTDE
(
	RESTDE_NO             NUMERIC(6)  NOT NULL ,
	RESTDE                CHAR(8)  NULL ,
	RESTDE_NM             VARCHAR(180)  NULL ,
	RESTDE_DC             VARCHAR(600)  NULL ,
	RESTDE_SE_CODE        VARCHAR(6)  NULL ,
	FRST_REGIST_PNTTM     DATETIME  NULL ,
	FRST_REGISTER_ID      VARCHAR(60)  NULL ,
	LAST_UPDT_PNTTM       DATETIME  NULL ,
	LAST_UPDUSR_ID        VARCHAR(60)  NULL ,
CONSTRAINT  COMTNRESTDE_PK PRIMARY KEY (RESTDE_NO)
);




CREATE TABLE COMTCCMMNCLCODE
(
	CL_CODE               CHAR(3)  NOT NULL ,
	CL_CODE_NM            VARCHAR(180)  NULL ,
	CL_CODE_DC            VARCHAR(600)  NULL ,
	USE_AT                CHAR(1)  NULL ,
	FRST_REGIST_PNTTM     DATETIME  NULL ,
	FRST_REGISTER_ID      VARCHAR(60)  NULL ,
	LAST_UPDT_PNTTM       DATETIME  NULL ,
	LAST_UPDUSR_ID        VARCHAR(60)  NULL ,
CONSTRAINT  COMTCCMMNCLCODE_PK PRIMARY KEY (CL_CODE)
);




CREATE TABLE COMTCCMMNCODE
(
	CODE_ID               VARCHAR(18)  NOT NULL ,
	CODE_ID_NM            VARCHAR(180)  NULL ,
	CODE_ID_DC            VARCHAR(600)  NULL ,
	USE_AT                CHAR(1)  NULL ,
	CL_CODE               CHAR(3)  NULL ,
	FRST_REGIST_PNTTM     DATETIME  NULL ,
	FRST_REGISTER_ID      VARCHAR(60)  NULL ,
	LAST_UPDT_PNTTM       DATETIME  NULL ,
	LAST_UPDUSR_ID        VARCHAR(60)  NULL ,
CONSTRAINT  COMTCCMMNCODE_PK PRIMARY KEY (CODE_ID)
);




CREATE TABLE COMTCCMMNDETAILCODE
(
	CODE_ID               VARCHAR(18)  NOT NULL ,
	CODE                  VARCHAR(45)  NOT NULL ,
	CODE_NM               VARCHAR(180)  NULL ,
	CODE_DC               VARCHAR(600)  NULL ,
	USE_AT                CHAR(1)  NULL ,
	FRST_REGIST_PNTTM     DATETIME  NULL ,
	FRST_REGISTER_ID      VARCHAR(60)  NULL ,
	LAST_UPDT_PNTTM       DATETIME  NULL ,
	LAST_UPDUSR_ID        VARCHAR(60)  NULL ,
CONSTRAINT  COMTCCMMNDETAILCODE_PK PRIMARY KEY (CODE_ID,CODE)
);




CREATE TABLE COMTNAUTHORGROUPINFO
(
	GROUP_ID              CHAR(20)  NOT NULL ,
	GROUP_NM              VARCHAR(180)  NOT NULL ,
	GROUP_CREAT_DE        CHAR(40)  NOT NULL ,
	GROUP_DC              VARCHAR(300)  NULL ,
CONSTRAINT  COMTNAUTHORGROUPINFO_PK PRIMARY KEY (GROUP_ID)
);




CREATE TABLE COMTNORGNZTINFO
(
	ORGNZT_ID             CHAR(20)  NOT NULL ,
	ORGNZT_NM             VARCHAR(60)  NOT NULL ,
	ORGNZT_DC             VARCHAR(300)  NULL ,
CONSTRAINT  COMTNORGNZTINFO_PK PRIMARY KEY (ORGNZT_ID)
);




CREATE TABLE COMTNFILE
(
	ATCH_FILE_ID          CHAR(20)  NOT NULL ,
	CREAT_DT              DATETIME  NOT NULL ,
	USE_AT                CHAR(1)  NULL ,
CONSTRAINT  COMTNFILE_PK PRIMARY KEY (ATCH_FILE_ID)
);




CREATE TABLE COMTNFILEDETAIL
(
	ATCH_FILE_ID          CHAR(20)  NOT NULL ,
	FILE_SN               NUMERIC(10)  NOT NULL ,
	FILE_STRE_COURS       VARCHAR(6000)  NOT NULL ,
	STRE_FILE_NM          VARCHAR(765)  NOT NULL ,
	ORIGNL_FILE_NM        VARCHAR(765)  NULL ,
	FILE_EXTSN            VARCHAR(60)  NOT NULL ,
	FILE_CN               STRING  NULL ,
	FILE_SIZE             NUMERIC(8)  NULL ,
CONSTRAINT  COMTNFILEDETAIL_PK PRIMARY KEY (ATCH_FILE_ID,FILE_SN)
);




CREATE TABLE COMTNHTTPMON
(
	SYS_ID                VARCHAR(60)  NOT NULL ,
	SITE_URL              VARCHAR(300)  NULL ,
	WEBSVC_KND            VARCHAR(30)  NULL ,
	HTTP_STTUS_CODE       VARCHAR(9)  NULL ,
	CREAT_DT              DATETIME  NULL ,
	MNGR_NM               VARCHAR(180)  NULL ,
	MNGR_EMAIL_ADRES      VARCHAR(150)  NULL ,
	FRST_REGISTER_ID      VARCHAR(60)  NULL ,
	FRST_REGIST_PNTTM     DATETIME  NULL ,
	LAST_UPDUSR_ID        VARCHAR(60)  NULL ,
	LAST_UPDT_PNTTM       DATETIME  NULL ,
CONSTRAINT  COMTNHTTPMON_PK PRIMARY KEY (SYS_ID)
);




CREATE TABLE COMTHTRSMRCVMNTRNGLOGINFO
(
	LOG_ID                CHAR(20)  NOT NULL ,
	CNTC_ID               CHAR(8)  NOT NULL ,
	TEST_CLASS_NM         VARCHAR(765)  NULL ,
	MNGR_NM               VARCHAR(180)  NULL ,
	MNGR_EMAIL_ADRES      VARCHAR(150)  NULL ,
	MNTRNG_STTUS          CHAR(2)  NULL ,
	LOG_INFO              VARCHAR(6000)  NULL ,
	CREAT_DT              DATETIME  NULL ,
	FRST_REGISTER_ID      VARCHAR(60)  NULL ,
	FRST_REGIST_PNTTM     DATETIME  NOT NULL ,
	LAST_UPDUSR_ID        VARCHAR(60)  NULL ,
	LAST_UPDT_PNTTM       DATETIME  NOT NULL ,
CONSTRAINT  COMTHTRSMRCVMNTRNGLOGINFO_PK PRIMARY KEY (LOG_ID)
);




CREATE TABLE COMTHDBMNTRNGLOGINFO
(
	DATA_SOURC_NM         VARCHAR(180)  NOT NULL ,
	SERVER_NM             VARCHAR(180)  NULL ,
	DBMS_KND              VARCHAR(6)  NULL ,
	CECK_SQL              VARCHAR(750)  NULL ,
	MNGR_NM               VARCHAR(180)  NULL ,
	MNGR_EMAIL_ADRES      VARCHAR(150)  NULL ,
	MNTRNG_STTUS          CHAR(2)  NULL ,
	LOG_INFO              VARCHAR(6000)  NULL ,
	CREAT_DT              DATETIME  NULL ,
	FRST_REGISTER_ID      VARCHAR(60)  NULL ,
	FRST_REGIST_PNTTM     DATETIME  NOT NULL ,
	LAST_UPDT_PNTTM       DATETIME  NOT NULL ,
	LAST_UPDUSR_ID        VARCHAR(60)  NULL ,
	LOG_ID                CHAR(20)  NOT NULL ,
CONSTRAINT  COMTHDBMNTRNGLOGINFO_PK PRIMARY KEY (LOG_ID)
);




CREATE TABLE COMTHHTTPMONLOGINFO
(
	SYS_ID                VARCHAR(60)  NOT NULL ,
	SITE_URL              VARCHAR(300)  NULL ,
	WEBSVC_KND            VARCHAR(30)  NULL ,
	HTTP_STTUS_CODE       VARCHAR(9)  NULL ,
	CREAT_DT              DATETIME  NULL ,
	LOG_INFO              VARCHAR(6000)  NULL ,
	MNGR_NM               VARCHAR(180)  NULL ,
	MNGR_EMAIL_ADRES      VARCHAR(150)  NULL ,
	FRST_REGISTER_ID      VARCHAR(60)  NULL ,
	FRST_REGIST_PNTTM     DATETIME  NULL ,
	LAST_UPDUSR_ID        VARCHAR(60)  NULL ,
	LAST_UPDT_PNTTM       DATETIME  NULL ,
	LOG_ID                CHAR(20)  NOT NULL ,
CONSTRAINT  COMTHHTTPMONLOGINFO_PK PRIMARY KEY (SYS_ID,LOG_ID)
);




