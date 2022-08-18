/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  AjanPc
 * Created: Feb 6, 2021
 */

IniTable

updateURL
versionNumber
LastPublishedDate
projectFile
lastFilePath
lastAyarFile
apiEnable


/*  FOR MSYQL 
**************************************

CREATE TABLE `INITABLE` (
`id` int(11) NOT NULL,
`updateURL` varchar(256) NOT NULL,
`lastPublishedDate` varchar(256) NOT NULL,
`projectFile` varchar(256) NOT NULL,
`lastFilePath` varchar(256) NOT NULL,
`lastAyarFile` varchar(256) NOT NULL,
`apiEnable` varchar(256) NOT NULL,
 PRIMARY KEY (`id`)
);

***************************************
*/


/* FOR JAVA DATABASE*/
/****************************************/
CREATE TABLE INITABLE(
"NO" INTEGER NOT NULL PRIMARY KEY,
"UPDATEURL" VARCHAR(256) NOT NULL,
"VERSIONNUMBER" VARCHAR(256) NOT NULL,
"LASTPUBLISHEDDATE" VARCHAR(256) NOT NULL,
"PROJECTFILE" VARCHAR(256) NOT NULL,
"LASTFILEPATH" VARCHAR(256) NOT NULL,
"LASTAYARFILE" VARCHAR(256) NOT NULL,
"APIENABLE" BOOLEAN NOT NULL
)
/*****************************************/


CREATE TABLE REFERENCE(
"REFERENCEID" VARCHAR (10) NOT NULL PRIMARY KEY,
"X" DECIMAL (11,3),
"Y" DECIMAL (11,3),
"Z" DECIMAL (11,3),
"U" DECIMAL (11,3),
"C" DECIMAL (11,3),
"D" DECIMAL (11,3),
"A" DECIMAL (11,3),
"TV" DECIMAL (11,3),
"TW" DECIMAL (11,3),
"XANGLE" DECIMAL (10,5) NOT NULL
)
/* INSERT  DATA ************************************/

INSERT INTO HALUK.INITABLE
("NO",
"UPDATEURL",
"VERSIONNUMBER",
"LASTPUBLISHEDDATE",
"PROJECTFILE",
"LASTFILEPATH",
"LASTAYARFILE",
"APIENABLE"
)
VALUES 
(
1,
'https://www.ajancnc.com/ajancncupdate/AjanCncUpdateConfig.xml',
'8.45',
'09.11.2020',
'proj',
'empty',
'empty',
false
)

/*********************************************************************/


CREATE TABLE PLASMA(
"No" INTEGER NOT NULL PRIMARY KEY,
"UserDefined" INTEGER NOT NULL,
"Material" VARCHAR (25) NOT NULL,
"Current" INTEGER NOT NULL,
"CutCurrent" DECIMAL (10,2),
"Gases" VARCHAR (25) NOT NULL,
"PreFlowMode" INTEGER,
"CutFlowMode" INTEGER,
"CutType" VARCHAR (10),
"Thickness" DECIMAL (10,2),
"PrePlasmaGas" VARCHAR (10),
"PrePlasmaPressure" DECIMAL (10,2),
"PrePlasmaFlow" DECIMAL (10,2),
"PreShieldGas" VARCHAR (10),
"PreShieldPressure" DECIMAL (10,2),
"PreShieldFlow" DECIMAL (10,2),
"CutPlasmaGas" VARCHAR (10),
"CutPlasmaPressure" DECIMAL (10,2),
"CutPlasmaFlow" DECIMAL (10,2),
"CutShieldGas" VARCHAR (10),
"CutShieldPressure" DECIMAL (10,2),
"CutShieldFlow" DECIMAL (10,2),
"ArcVoltage" INTEGER,
"WorkDistance" DECIMAL (10,2),
"Feedrate" INTEGER,
"PierceHeight" DECIMAL (10,2),
"PierceTime" DECIMAL (10,2),
"KerfWidth" DECIMAL (10,2),
"MicroJointThick" DECIMAL (10,2),
"PilotCurrent" INTEGER,
"ArcingCurrent" INTEGER,
"ArcingPressure" DECIMAL (10,2),
"FindCornerPH" DECIMAL (10,2),
"FindCornerVoltage" INTEGER,
"ShieldCap" VARCHAR (10),
"Shield" VARCHAR (10),
"GasRing" VARCHAR (10),
"Nozzle" VARCHAR (10),
"SwirlRing" VARCHAR (10),
"Electrode" VARCHAR (10),
"CREEPTIME" BOOLEAN NOT NULL,
"THICKNESSINCH" DECIMAL (10,3)
)