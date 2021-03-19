DROP TABLE IF EXISTS `SYS_LOG`;
CREATE TABLE `SYS_LOG` (
                           `ID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
                           `COMPANY_ID` int(10),
                           `IS_DELETED` varchar(10),
                           `OPERATOR` varchar(20),
                           `OPERATOR_LOGIN` varchar(20),
                           `MODULE_NAME`  varchar(50),
                           `FUNCTION_NAME`  varchar(50),
                           `FUNCTION_METHOD`  varchar(20),
                           `URL` varchar(255),
                           `RESPONSE_STATUS` VARCHAR(20),
                           `RESPONSE_MESSAGE` varchar(50),
                           `RESPONSE_DATA` varchar(255),
                           `USE_TIME` int(10),
                           `IP_ADDRESS` varchar(50),
                           `ROLE_NAME` varchar(50),
                           `REMARK` varchar(100),
                           `CREATE_TIME` timestamp(0),
                           `UPDATE_TIME` timestamp(0),
                           PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 51 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
