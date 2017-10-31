## 一些配置
位置 src/main/resources/application.properties

debug=true // 开启debug

spring.thymeleaf.cache=false // 不使用缓存 热加载

## 打包
./mvnw clean package
## 运行
java -jar target/spring_boot_demo-0.0.1-SNAPSHOT.jar