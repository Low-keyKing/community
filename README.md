##资料
[spring文档](https://spring.io/guides)
[springweb文档](https://spring.io/guides/gs/serving-web-content/)
[Github OAuth](https://developer.github.com/apps/building-oauth-apps/)
[Spring官方文档](https://docs.spring.io/spring-boot/docs/2.0.0.RC1/reference/htmlsingle/#boot-features-embedded-database-support)
[spring MVC文档](https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc)
##工具
[Visual Paradigm](http://www.visual-paradigm.com)
[flyway](https://flywaydb.org/getstarted/firststeps/maven)
[lombok](https://www.projectlombok.org)
[Postman](https://chrome.google.com/webstore/detail/coohjcphdfgbiolnekdpbcijmhambjff)
[Markdown](https://pandao.github.io/editor.md/)
##脚本
```sql
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `account_id` varchar(100) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `token` char(36) DEFAULT NULL,
  `gmt_create` bigint(20) DEFAULT NULL,
  `gmt_modified` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
```
```bash
mvn flyway:migrate
mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate
```