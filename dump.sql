;             
CREATE USER IF NOT EXISTS "SA" SALT '62424f213bb99f4b' HASH 'a6deb2d4980059c3ce92da6365cdfb075cb8aa7d975e53488e0647214f78fdbb' ADMIN;         
CREATE SEQUENCE "PUBLIC"."CUSTOMER_SEQ" START WITH 90;        
CREATE SEQUENCE "PUBLIC"."SERVICE_SEQ" START WITH 9;          
CREATE SEQUENCE "PUBLIC"."TOKEN_SEQ" START WITH 58;           
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_4D2E4D3B_1CBF_4679_A018_E3FDA9367265" START WITH 7 BELONGS_TO_TABLE;
CREATE SEQUENCE "PUBLIC"."HIBERNATE_SEQUENCE" START WITH 36;  
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_764CDD6B_52C2_4C77_8022_636930E0F2F8" START WITH 90 BELONGS_TO_TABLE;               
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_3679D2A6_F44B_45BB_A00B_063085BF5017" START WITH 5 BELONGS_TO_TABLE;
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_7861EF77_6DF8_46D3_8688_3B27CF645EDA" START WITH 5 BELONGS_TO_TABLE;
CREATE SEQUENCE "PUBLIC"."COUNTER_SEQ" START WITH 6;          
CREATE CACHED TABLE "PUBLIC"."QMS_APIDETAILS"(
    "ID" INTEGER NOT NULL,
    "BASE_URL" VARCHAR(255),
    "IS_ACTIVE" BOOLEAN NOT NULL,
    "MODE" INTEGER,
    "PASSWORD" VARCHAR(255),
    "USER_NAME" VARCHAR(255)
);              
ALTER TABLE "PUBLIC"."QMS_APIDETAILS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_7" PRIMARY KEY("ID");               
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.QMS_APIDETAILS;          
CREATE CACHED TABLE "PUBLIC"."QMS_CUSTOMERS"(
    "ID" BIGINT NOT NULL,
    "COMPLETED_DATE" TIMESTAMP,
    "CREATED_DATE" TIMESTAMP,
    "DESCRIPTION" VARCHAR(255),
    "DOB" VARCHAR(255),
    "GENDER" VARCHAR(255),
    "ISSUED_DATE" TIMESTAMP,
    "MOBILE_NO" VARCHAR(255),
    "NIC" VARCHAR(255),
    "PROCESS_DATE" TIMESTAMP,
    "QR_TEXT" VARCHAR(255),
    "REMORT_CALL_STATUS" VARCHAR(255),
    "SERVICE_CATEGORY" VARCHAR(255),
    "SERVICED_BY" VARCHAR(255),
    "STATUS" INTEGER,
    "TOKEN_NUMBER" INTEGER NOT NULL,
    "COUNTER_ID" BIGINT
);     
ALTER TABLE "PUBLIC"."QMS_CUSTOMERS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_B" PRIMARY KEY("ID");
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.QMS_CUSTOMERS;           
CREATE CACHED TABLE "PUBLIC"."QMS_COUNTER_SERVICES"(
    "IS_ACTIVE" BOOLEAN NOT NULL,
    "PRIORITY" INTEGER,
    "COUNTER_ID" INTEGER NOT NULL,
    "SERVICE_ID" INTEGER NOT NULL
);   
ALTER TABLE "PUBLIC"."QMS_COUNTER_SERVICES" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_A" PRIMARY KEY("COUNTER_ID", "SERVICE_ID");   
-- 20 +/- SELECT COUNT(*) FROM PUBLIC.QMS_COUNTER_SERVICES;   
INSERT INTO "PUBLIC"."QMS_COUNTER_SERVICES" VALUES
(FALSE, 1, 4, 1),
(FALSE, 1, 4, 2),
(TRUE, 1, 1, 1),
(TRUE, 2, 1, 2),
(FALSE, 1, 2, 1),
(FALSE, 1, 2, 2),
(FALSE, 1, 3, 1),
(FALSE, 1, 3, 2),
(FALSE, 1, 5, 1),
(FALSE, 1, 5, 2),
(FALSE, 1, 1, 7),
(FALSE, 1, 2, 7),
(FALSE, 1, 3, 7),
(FALSE, 1, 4, 7),
(FALSE, 1, 5, 7),
(FALSE, 1, 1, 8),
(FALSE, 1, 2, 8),
(FALSE, 1, 3, 8),
(FALSE, 1, 4, 8),
(FALSE, 1, 5, 8);  
CREATE CACHED TABLE "PUBLIC"."QMS_TOKENS"(
    "ID" BIGINT NOT NULL,
    "COMPLETED_DATE" TIMESTAMP,
    "CREATED_DATE" TIMESTAMP,
    "DESCRIPTION" VARCHAR(255),
    "DOB" VARCHAR(255),
    "GENDER" VARCHAR(255),
    "ISSUED_DATE" TIMESTAMP,
    "MOBILE_NO" VARCHAR(255),
    "NIC" VARCHAR(255),
    "PAUSED_DATE" TIMESTAMP,
    "PROCESS_DATE" TIMESTAMP,
    "QR_TEXT" VARCHAR(255),
    "REMORT_CALL_STATUS" VARCHAR(255),
    "SERVICED_BY" VARCHAR(255),
    "STATUS" INTEGER,
    "TOKEN_NUMBER" INTEGER NOT NULL,
    "COUNTER_ID" INTEGER,
    "SERVICE_ID" INTEGER NOT NULL
);           
ALTER TABLE "PUBLIC"."QMS_TOKENS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_C" PRIMARY KEY("ID");   
-- 24 +/- SELECT COUNT(*) FROM PUBLIC.QMS_TOKENS;             
INSERT INTO "PUBLIC"."QMS_TOKENS" VALUES
(1, NULL, TIMESTAMP '2022-07-08 17:07:53.792', NULL, '', 'male', TIMESTAMP '2022-07-08 00:00:00', '0772220983', '198335201993', NULL, NULL, NULL, NULL, NULL, 0, 1, NULL, 2),
(2, NULL, TIMESTAMP '2022-07-11 11:17:54.673', NULL, '', 'male', TIMESTAMP '2022-07-11 00:00:00', '0772220983', '198335201993', NULL, NULL, NULL, NULL, NULL, 0, 1, NULL, 2),
(3, NULL, TIMESTAMP '2022-07-11 11:21:46.456', NULL, '', 'male', TIMESTAMP '2022-07-11 00:00:00', '0772220983', '198335201993', NULL, NULL, NULL, NULL, NULL, 0, 2, NULL, 1),
(4, NULL, TIMESTAMP '2022-07-11 11:40:03.029', NULL, '', 'male', TIMESTAMP '2022-07-11 00:00:00', '077220983', '198335201993', NULL, NULL, NULL, NULL, NULL, 0, 3, NULL, 2),
(5, NULL, TIMESTAMP '2022-07-12 11:53:31.873', NULL, '', 'male', TIMESTAMP '2022-07-12 00:00:00', '0772220983', '198335201993', NULL, NULL, NULL, NULL, NULL, 0, 1, NULL, 1),
(6, TIMESTAMP '2022-07-14 18:54:47.711', TIMESTAMP '2022-07-14 10:40:21.06', NULL, '', 'male', TIMESTAMP '2022-07-14 00:00:00', '9470259056', '198335201993', NULL, NULL, NULL, NULL, '', 2, 1, NULL, 1),
(7, TIMESTAMP '2022-07-14 18:36:06.112', TIMESTAMP '2022-07-14 18:35:45.486', NULL, '', 'male', TIMESTAMP '2022-07-14 00:00:00', '9470259056', '198335201993', NULL, NULL, NULL, NULL, '', 2, 2, NULL, 1),
(8, TIMESTAMP '2022-07-14 19:32:23.308', TIMESTAMP '2022-07-14 19:12:34.111', NULL, '', 'male', TIMESTAMP '2022-07-14 00:00:00', '9470259056', '198335201993', NULL, NULL, NULL, NULL, '', 3, 3, NULL, 1),
(9, TIMESTAMP '2022-07-15 14:34:20.932', TIMESTAMP '2022-07-15 10:50:27.57', NULL, '', 'male', TIMESTAMP '2022-07-15 00:00:00', '9470259056', '198335201993', NULL, NULL, NULL, NULL, '', 3, 1, NULL, 1),
(10, TIMESTAMP '2022-07-15 15:02:04.006', TIMESTAMP '2022-07-15 10:52:10.959', NULL, '', 'male', TIMESTAMP '2022-07-15 00:00:00', '9470259056', '198335201993', NULL, NULL, NULL, NULL, '', 2, 2, NULL, 1),
(11, NULL, TIMESTAMP '2022-08-12 09:02:53.965', NULL, '', 'male', TIMESTAMP '2022-08-12 00:00:00', '0772220983', '198335201993', NULL, NULL, NULL, NULL, NULL, 0, 1, NULL, 2),
(12, NULL, TIMESTAMP '2022-08-12 09:04:38.052', NULL, '', 'male', TIMESTAMP '2022-08-12 00:00:00', '0772220986', '198335201993', NULL, NULL, NULL, NULL, NULL, 0, 2, NULL, 1),
(46, NULL, TIMESTAMP '2022-11-16 14:07:44.702', NULL, '', 'male', TIMESTAMP '2022-11-16 00:00:00', '0785868283', '983091407v', NULL, NULL, NULL, NULL, NULL, 0, 1, NULL, 1),
(47, NULL, TIMESTAMP '2022-11-16 14:07:44.893', NULL, '', 'male', TIMESTAMP '2022-11-16 00:00:00', '0785868283', '983091407v', NULL, NULL, NULL, NULL, NULL, 0, 2, NULL, 1),
(48, NULL, TIMESTAMP '2022-12-08 14:18:30.519', NULL, '', 'male', TIMESTAMP '2022-12-08 00:00:00', '0785868283', '983191407v', NULL, NULL, NULL, NULL, NULL, 0, 1, NULL, 2),
(49, NULL, TIMESTAMP '2022-12-08 14:18:30.519', NULL, '', 'male', TIMESTAMP '2022-12-08 00:00:00', '0785868283', '983191407v', NULL, NULL, NULL, NULL, NULL, 0, 1, NULL, 2),
(50, NULL, TIMESTAMP '2022-12-08 14:18:30.519', NULL, '', 'male', TIMESTAMP '2022-12-08 00:00:00', '0785868283', '983191407v', NULL, NULL, NULL, NULL, NULL, 0, 1, NULL, 2),
(51, NULL, TIMESTAMP '2022-12-08 14:18:30.519', NULL, '', 'male', TIMESTAMP '2022-12-08 00:00:00', '0785868283', '983191407v', NULL, NULL, NULL, NULL, NULL, 0, 1, NULL, 2),
(52, NULL, TIMESTAMP '2022-12-08 14:18:30.519', NULL, '', 'male', TIMESTAMP '2022-12-08 00:00:00', '0785868283', '983091407v', NULL, NULL, NULL, NULL, NULL, 0, 1, NULL, 2),
(53, NULL, TIMESTAMP '2022-12-08 14:18:30.519', NULL, '', 'male', TIMESTAMP '2022-12-08 00:00:00', '0785868283', '983091407v', NULL, NULL, NULL, NULL, NULL, 0, 1, NULL, 2),
(54, NULL, TIMESTAMP '2022-12-08 14:18:30.519', NULL, '', 'male', TIMESTAMP '2022-12-08 00:00:00', '0785868283', '983191407v', NULL, NULL, NULL, NULL, NULL, 0, 1, NULL, 2),
(55, NULL, TIMESTAMP '2022-12-08 14:18:30.519', NULL, '', 'male', TIMESTAMP '2022-12-08 00:00:00', '0785868283', '983091407v', NULL, NULL, NULL, NULL, NULL, 0, 1, NULL, 2),
(56, NULL, TIMESTAMP '2022-12-08 14:18:30.519', NULL, '', 'male', TIMESTAMP '2022-12-08 00:00:00', '0785868283', '983091407v', NULL, NULL, NULL, NULL, NULL, 0, 1, NULL, 2);       
INSERT INTO "PUBLIC"."QMS_TOKENS" VALUES
(57, NULL, TIMESTAMP '2022-12-08 14:18:30.811', NULL, '', 'male', TIMESTAMP '2022-12-08 00:00:00', '0785868283', '983091407v', NULL, NULL, NULL, NULL, NULL, 0, 1, NULL, 2);        
CREATE CACHED TABLE "PUBLIC"."QMS_COUNTERS"(
    "ID" INTEGER NOT NULL,
    "DESCRIPTION" VARCHAR(255),
    "NAME" VARCHAR(255),
    "STATUS" INTEGER,
    "OFFICER_ID" INTEGER,
    "IS_LOGED" BOOLEAN DEFAULT FALSE,
    "CURRENT_TOKEN" INTEGER DEFAULT 0
);       
ALTER TABLE "PUBLIC"."QMS_COUNTERS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_8" PRIMARY KEY("ID"); 
-- 5 +/- SELECT COUNT(*) FROM PUBLIC.QMS_COUNTERS;            
INSERT INTO "PUBLIC"."QMS_COUNTERS" VALUES
(1, NULL, 'Counter1', 5, 17, TRUE, 0),
(2, NULL, 'Counter2', 5, NULL, FALSE, 0),
(3, NULL, 'Counter3', 5, NULL, FALSE, 0),
(4, NULL, 'Counter4', 5, NULL, FALSE, 0),
(5, NULL, 'Counter5', 4, NULL, FALSE, 0);
CREATE CACHED TABLE "PUBLIC"."QMS_CONTENT"(
    "ID" INTEGER DEFAULT NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_3679D2A6_F44B_45BB_A00B_063085BF5017" NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_3679D2A6_F44B_45BB_A00B_063085BF5017",
    "IMAGE_PATH" VARCHAR(255),
    "SECTION" VARCHAR(255),
    "LAYOUT_ID" INTEGER
);             
ALTER TABLE "PUBLIC"."QMS_CONTENT" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_98" PRIMARY KEY("ID"); 
-- 4 +/- SELECT COUNT(*) FROM PUBLIC.QMS_CONTENT;             
INSERT INTO "PUBLIC"."QMS_CONTENT" VALUES
(1, '\img\Content\01.jpg', 'sec1', 6),
(2, '\img\Content\02.jpg', 'sec1', 6),
(3, '\img\Content\07.jpg', 'sec2', 6),
(4, '\img\Content\08.jpg', 'sec2', 6);     
CREATE CACHED TABLE "PUBLIC"."QMS_USERS"(
    "ID" INTEGER NOT NULL,
    "PASSWORD" VARCHAR(255),
    "ROLE" INTEGER,
    "USERNAME" VARCHAR(255),
    "STATUS" INTEGER,
    "FIRST_NAME" VARCHAR(255),
    "LAST_NAME" VARCHAR(255),
    "FIRST_NME" VARCHAR(255),
    "USER_NAME" VARCHAR(255)
); 
ALTER TABLE "PUBLIC"."QMS_USERS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_F" PRIMARY KEY("ID");    
-- 4 +/- SELECT COUNT(*) FROM PUBLIC.QMS_USERS;               
INSERT INTO "PUBLIC"."QMS_USERS" VALUES
(1, '$2a$12$DS0ME4hF/22LZzrQEp27SOOA9yiNdltrhTYLCDH7YwDahKI4lkKFu', 0, 'user', 5, 'user', 'u', NULL, NULL),
(2, '$2a$12$DS0ME4hF/22LZzrQEp27SOOA9yiNdltrhTYLCDH7YwDahKI4lkKFu', 1, 'admin', 5, 'administrator', 'a', NULL, NULL),
(17, '$2a$12$DS0ME4hF/22LZzrQEp27SOOA9yiNdltrhTYLCDH7YwDahKI4lkKFu', 0, 'janaka', 5, 'Janaka', 'k', NULL, NULL),
(30, '$2a$12$DS0ME4hF/22LZzrQEp27SOOA9yiNdltrhTYLCDH7YwDahKI4lkKFu', 0, 'test', 5, 'test', 'test', NULL, NULL);
CREATE CACHED TABLE "PUBLIC"."QMS_INSTANCE_DETAILS"(
    "ID" INTEGER NOT NULL,
    "BRANCH" VARCHAR(255),
    "COMPANY" VARCHAR(255),
    "LOGO" VARCHAR(255),
    "NOCOUNTERS" INTEGER
);             
ALTER TABLE "PUBLIC"."QMS_INSTANCE_DETAILS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_4" PRIMARY KEY("ID");         
-- 1 +/- SELECT COUNT(*) FROM PUBLIC.QMS_INSTANCE_DETAILS;    
INSERT INTO "PUBLIC"."QMS_INSTANCE_DETAILS" VALUES
(28, NULL, 'RCS2', NULL, 5);              
CREATE CACHED TABLE "PUBLIC"."QMS_SERVICE_CATEGORY"(
    "ID" INTEGER NOT NULL,
    "DESCRIPTION" VARCHAR(255),
    "NAME" VARCHAR(255),
    "PARENT_ID" INTEGER,
    "STATUS" INTEGER,
    "SERVING_TIME" INTEGER
);  
ALTER TABLE "PUBLIC"."QMS_SERVICE_CATEGORY" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_D" PRIMARY KEY("ID");         
-- 4 +/- SELECT COUNT(*) FROM PUBLIC.QMS_SERVICE_CATEGORY;    
INSERT INTO "PUBLIC"."QMS_SERVICE_CATEGORY" VALUES
(1, 'Deposit/Withdrawal', 'Deposit/Withdrawal', 0, 5, 12),
(2, 'bill payment', 'Bill Payment', 0, 5, 5),
(7, 'account open', 'Account Open', 0, 5, 120),
(8, 'abc', 'abc', 0, 6, 2);   
CREATE CACHED TABLE "PUBLIC"."QMS_FEEDBACK"(
    "ID" INTEGER DEFAULT NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_764CDD6B_52C2_4C77_8022_636930E0F2F8" NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_764CDD6B_52C2_4C77_8022_636930E0F2F8",
    "COUNTER_NUMBER" INTEGER NOT NULL,
    "FEEDBACK" VARCHAR(255)
);             
ALTER TABLE "PUBLIC"."QMS_FEEDBACK" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_9" PRIMARY KEY("ID"); 
-- 46 +/- SELECT COUNT(*) FROM PUBLIC.QMS_FEEDBACK;           
INSERT INTO "PUBLIC"."QMS_FEEDBACK" VALUES
(1, 1, 'Good'),
(42, 2, 'Good'),
(46, 1, 'Excellent'),
(47, 2, 'Excellent'),
(48, 2, 'Excellent'),
(49, 2, 'Excellent'),
(50, 2, 'Excellent'),
(51, 2, 'Excellent'),
(52, 2, 'Excellent'),
(53, 2, 'Excellent'),
(54, 2, 'Excellent'),
(55, 2, 'Excellent'),
(56, 2, 'Excellent'),
(57, 2, 'Excellent'),
(58, 2, 'Excellent'),
(59, 2, 'Excellent'),
(60, 2, 'Excellent'),
(61, 2, 'Excellent'),
(62, 2, 'Excellent'),
(63, 2, 'Excellent'),
(64, 2, 'Excellent'),
(65, 2, 'Excellent'),
(66, 2, 'Excellent'),
(67, 2, 'Excellent'),
(68, 2, 'Excellent'),
(69, 2, 'Excellent'),
(70, 2, 'Excellent'),
(71, 2, 'Excellent'),
(72, 2, 'Excellent'),
(73, 2, 'Excellent'),
(74, 2, 'Good'),
(75, 2, 'Excellent'),
(76, 2, 'Good'),
(77, 2, 'Excellent'),
(78, 2, 'Good'),
(79, 2, 'Excellent'),
(80, 2, 'Good'),
(81, 2, 'Excellent'),
(82, 2, 'Good'),
(83, 2, 'Excellent'),
(84, 2, 'Good'),
(85, 2, 'Bad'),
(86, 2, 'Good'),
(87, 2, 'Terrible'),
(88, 2, 'Good'),
(89, 2, 'Terrible');             
CREATE CACHED TABLE "PUBLIC"."QMS_LAYOUT"(
    "ID" INTEGER DEFAULT NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_4D2E4D3B_1CBF_4679_A018_E3FDA9367265" NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_4D2E4D3B_1CBF_4679_A018_E3FDA9367265",
    "CONTENT_TYPE1" VARCHAR(255),
    "CONTENT_TYPE2" VARCHAR(255),
    "DATE" INTEGER,
    "FILE_PATH1" VARCHAR(255),
    "FILE_PATH2" VARCHAR(255),
    "FILE_PATH3" VARCHAR(255),
    "FILE_PATH4" VARCHAR(255),
    "FILE_PATH5" VARCHAR(255),
    "LOGO" INTEGER,
    "NAME" VARCHAR(255),
    "POSITION1" VARCHAR(255),
    "POSITION2" VARCHAR(255),
    "POSITION3" VARCHAR(255),
    "POSITION4" VARCHAR(255),
    "POSITION5" VARCHAR(255),
    "STATUS" VARCHAR(255),
    "TEMPLATE_ID" VARCHAR(255),
    "WEATHER" INTEGER
);           
ALTER TABLE "PUBLIC"."QMS_LAYOUT" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_B8" PRIMARY KEY("ID");  
-- 5 +/- SELECT COUNT(*) FROM PUBLIC.QMS_LAYOUT;              
INSERT INTO "PUBLIC"."QMS_LAYOUT" VALUES
(2, 'image', 'image', 5, '\img\2-gfx100s_sample_04_thum-1.jpg', '\img\2-000101300.jpg', '\img\2-ff_x_t3_002.JPG', NULL, NULL, NULL, 'test', 'content', 'token', NULL, NULL, NULL, 'DEACTIVE', '4', 4),
(3, 'carousel', 'image', 4, '\img\3-gfx100s_sample_04_thum-1.jpg', '\img\3-000101300.jpg', '\img\3-ff_x_t3_002.JPG', NULL, NULL, NULL, 'test2', NULL, NULL, 'token', 'content1', 'content2', 'DEACTIVE', '3', 4),
(4, 'image', 'carousel', 5, '\img\4-01.jpg', NULL, NULL, NULL, NULL, NULL, 'test1', 'content', 'token', NULL, NULL, NULL, 'DEACTIVE', '1', 5),
(5, 'image', 'carousel', 4, NULL, NULL, NULL, NULL, NULL, NULL, 'test3', 'token', 'content', NULL, NULL, NULL, 'DEACTIVE', '1', 4),
(6, 'carousel', 'carousel', 5, NULL, NULL, NULL, NULL, NULL, NULL, 'test4', 'content', 'token', NULL, NULL, NULL, 'DEACTIVE', '1', 5);              
CREATE CACHED TABLE "PUBLIC"."QMS_TEMPLATE"(
    "ID" INTEGER DEFAULT NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_7861EF77_6DF8_46D3_8688_3B27CF645EDA" NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_7861EF77_6DF8_46D3_8688_3B27CF645EDA",
    "NAME" VARCHAR(255),
    "IMAGE_PATH" VARCHAR(255)
);         
ALTER TABLE "PUBLIC"."QMS_TEMPLATE" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_5" PRIMARY KEY("ID"); 
-- 4 +/- SELECT COUNT(*) FROM PUBLIC.QMS_TEMPLATE;            
INSERT INTO "PUBLIC"."QMS_TEMPLATE" VALUES
(1, 'template01', '\img\Template\01.png'),
(2, 'template02', '\img\Template\02.png'),
(3, 'template03', '\img\Template\03.png'),
(4, 'template04', '\img\Template\04.png');    
ALTER TABLE "PUBLIC"."QMS_USERS" ADD CONSTRAINT "PUBLIC"."UK_J9D67Y2RK9VAIDPTJK9NT39KR" UNIQUE("USERNAME");   
ALTER TABLE "PUBLIC"."QMS_CONTENT" ADD CONSTRAINT "PUBLIC"."FK1NLI65R387BT1VBELJLA4GIN9" FOREIGN KEY("LAYOUT_ID") REFERENCES "PUBLIC"."QMS_LAYOUT"("ID") NOCHECK;             
ALTER TABLE "PUBLIC"."QMS_COUNTER_SERVICES" ADD CONSTRAINT "PUBLIC"."FK3BHWPHMYOTVTO57T2HYFDVIMY" FOREIGN KEY("COUNTER_ID") REFERENCES "PUBLIC"."QMS_COUNTERS"("ID") NOCHECK; 
ALTER TABLE "PUBLIC"."QMS_COUNTERS" ADD CONSTRAINT "PUBLIC"."FKJBS96QG7C38TIVL09JSIUJQCW" FOREIGN KEY("OFFICER_ID") REFERENCES "PUBLIC"."QMS_USERS"("ID") NOCHECK;            
ALTER TABLE "PUBLIC"."QMS_COUNTER_SERVICES" ADD CONSTRAINT "PUBLIC"."FK1MB343DLTP86KKY6DXRA893FA" FOREIGN KEY("SERVICE_ID") REFERENCES "PUBLIC"."QMS_SERVICE_CATEGORY"("ID") NOCHECK;         
ALTER TABLE "PUBLIC"."QMS_TOKENS" ADD CONSTRAINT "PUBLIC"."FKRC22JE3WGPFJCTFKA5W62FNGP" FOREIGN KEY("COUNTER_ID") REFERENCES "PUBLIC"."QMS_COUNTERS"("ID") NOCHECK;           
ALTER TABLE "PUBLIC"."QMS_CUSTOMERS" ADD CONSTRAINT "PUBLIC"."FK636X6VPVDDRN90U7BORJ9NU5T" FOREIGN KEY("COUNTER_ID") REFERENCES "PUBLIC"."QMS_COUNTERS"("ID") NOCHECK;        
ALTER TABLE "PUBLIC"."QMS_TOKENS" ADD CONSTRAINT "PUBLIC"."FKBIT0SD0QQNHL0UTJH2EQNHHV0" FOREIGN KEY("SERVICE_ID") REFERENCES "PUBLIC"."QMS_SERVICE_CATEGORY"("ID") NOCHECK;   
