## WSKC 微商库存管理系统


## 技术栈
springmvc,spring,hibernate,redis,mysql，shiro（权限管理框架),swagger(接口文档工具)，druid(数据库连接池)

## 部署流程
１:创建数据库

数据库文件在文件夹db/*　下面

2:修改配置
  
   - mysql数据库文件配置
    jdbc.properties,密码采用了druid自带的加密，需要填写加密后的字符串，请参考github https://github.com/alibaba/druid/wiki/%E4%BD%BF%E7%94%A8ConfigFilter
  
   - redis 数据库文件配置
      建议redis  配置上密码，如果redis 部署在外网情况下，因为不配很容易被攻击，导致ｃｐｕ爆满
   - weixin 配置文件
    config/WeiXinConfig,需要更改APPID,SECRET,REDIRECT_URI,NPTEMPLATEID(模板消息ｉｄ)
    需要申请自己的微信公众号，如果没有可以采用微信测试号，需要配置微信授权地址 ，接口地址ｕｒｌ,token  ,url 一定要能被外网访问，可以使用花生壳进行内网穿透，不然配置不上去

３：项目依赖于自己开发的几个ｊａｒ

https://github.com/FurionCS/basic-common

https://github.com/FurionCS/basic-hibernate

https://github.com/FurionCS/basic-weixin

baisc-auth 在ｊａｒ 文件夹中，可以自己打包，也可以使用ｊａｒ文件中的
需要将这几个ｊａｒ加入自己的ｍａｖｅｎ仓库
```xml
  <dependency>
  <groupId>org.cs.basic</groupId>
  <artifactId>basic-hibernate</artifactId>
  </dependency>
  <dependency>
    <groupId>org.cs.basic</groupId>
    <artifactId>basic-common</artifactId>
  </dependency>
   <dependency>
  <groupId>${project.groupId}</groupId>
  <artifactId>basic-auth</artifactId>
  </dependency>
  <dependency>
     <groupId>${project.groupId}</groupId>
     <artifactId>basic-weixin</artifactId>
  </dependency>
```
