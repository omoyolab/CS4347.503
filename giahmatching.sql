USE matchingapp;

#INSERT INTO user VALUES ('1','Mike', 'mike@gmail.com','keypass','UT Dallas','Chemistry','M', NULL,'2022-04-01 13:17:17','1','31');
#INSERT INTO user VALUES ('2','John', 'john@gmail.com','keypass','UT Tyler','Computer Science','M', NULL,'2022-04-01 13:17:17','2','21');
#INSERT INTO user VALUES ('3','Richard', 'richard@gmail.com','keypass','UT Arlington','Sotware Engineering','M', NULL,'2022-04-01 13:17:17','3','22');
INSERT INTO user VALUES ('4','Emmanuel', 'Emmanuel@gmail.com','keypass','Havard','History','M', NULL,'2022-04-01 13:17:17','4','25');
INSERT INTO user VALUES ('5','James', 'james@gmail.com','keypass','UCLA','Biology','M', NULL,'2022-04-01 13:17:17','5','30');
INSERT INTO user VALUES ('6','Alexander', 'alexander@gmail.com','keypass','MIT','Computer Engineering','M', NULL,'2022-04-01 13:17:17','6','26');
INSERT INTO user VALUES ('7','Hamza', 'hamza@gmail.com','keypass','UT Dallas','International Studies','M', NULL,'2022-04-01 13:17:17','7','27');
INSERT INTO user VALUES ('8','Curry', 'curry@gmail.com','keypass','UT Austin','History','M', NULL,'2022-04-01 13:17:17','8','23');
INSERT INTO user VALUES ('9','Yin', 'yin@gmail.com','keypass','Havard','English','M', NULL,'2022-04-01 13:17:17','9','30');
#INSERT INTO user VALUES ('10','Yang', 'Yang@gmail.com','keypass','UT Dallas','Maths','M', NULL,'2022-04-01 13:17:17','10','23');

#INSERT INTO user VALUES ('11','Mary', 'mary@gmail.com','keypass','UCLA','English','F', NULL,'2022-04-01 13:17:17','11','22');
INSERT INTO user VALUES ('12','Jay', 'jay@gmail.com','keypass','UT Dallas','Accounting','F', NULL,'2022-04-01 13:17:17','12','25');
INSERT INTO user VALUES ('13','Queen', 'queen@gmail.com','keypass','UT Dallas','Computer Science','F', NULL,'2022-04-01 13:17:17','13','27');
INSERT INTO user VALUES ('14','Liz', 'liz@gmail.com','keypass','UT Dallas','History','F', NULL,'2022-04-01 13:17:17','14','18');
INSERT INTO user VALUES ('15','Shantel', 'shantel@gmail.com','keypass','Havard','International Studies','F', NULL,'2022-04-01 13:17:17','15','22');
INSERT INTO user VALUES ('16','Victoria', 'victoria@gmail.com','keypass','MIT','Maths','F', NULL,'2022-04-01 13:17:17','16','31');
INSERT INTO user VALUES ('17','Madison', 'madison@gmail.com','keypass','UCLA','Computer Science','F', NULL,'2022-04-01 13:17:17','17','22');
INSERT INTO user VALUES ('18','Kim', 'kim@gmail.com','keypass','UT Austin','Biology','F', NULL,'2022-04-01 13:17:17','18','21');
INSERT INTO user VALUES ('19','Khloe', 'khloe@gmail.com','keypass','UT Dallas','Computer Science','F', NULL,'2022-04-01 13:17:17','19','20');
INSERT INTO user VALUES ('20','Zee', 'zee@gmail.com','keypass','UT Tyler','Chemistry','F', NULL,'2022-04-01 13:17:17','20','18');

#INSERT INTO `match` VALUES ('1','Taurus','Rugby','Cooking','Swimming');
INSERT INTO `match` VALUES ('2','leo','Sports','Gaming','Movies');
INSERT INTO `match` VALUES ('3','Cancer','Movies','Soccer','Smoking');
INSERT INTO `match` VALUES ('4','Taurus','Movies','Reading','Swimming');
INSERT INTO `match` VALUES ('5','Sagitarius','Basketball','Rowing','Swimming');
INSERT INTO `match` VALUES ('6','Gemini','Camping','Bicking','Movies');
INSERT INTO `match` VALUES ('7','Virgo','Walking','Dancing','Reading');
INSERT INTO `match` VALUES ('8','Libra','Sports','Programming','Cooking');
INSERT INTO `match` VALUES ('9','leo','Party','Movies','TV');
INSERT INTO `match` VALUES ('10','Taurus','Gaming','Cooking','TV');
SELECT * FROM matchingapp.user;