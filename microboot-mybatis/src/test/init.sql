 CREATE TABLE `user_info` (
   `id` bigint(20) NOT NULL AUTO_INCREMENT,
   `user_name` varchar(100) NOT NULL,
   `password` varchar(100) NOT NULL,
   PRIMARY KEY (`id`)
 );

 INSERT INTO `user_info` VALUES (1, '张三', '123456');

