# MyBatis Type Handlers for JSR 310: Date and Time API

[![Build Status](https://travis-ci.org/mybatis/typehandlers-jsr310.svg?branch=master)](https://travis-ci.org/mybatis/typehandlers-jsr310)
[![Coverage Status](https://coveralls.io/repos/mybatis/typehandlers-jsr310/badge.svg?branch=master&service=github)](https://coveralls.io/github/mybatis/typehandlers-jsr310?branch=master)
[![Dependency Status](https://www.versioneye.com/user/projects/56ef43cb35630e00388897bb/badge.svg?style=flat)](https://www.versioneye.com/user/projects/56ef43cb35630e00388897bb)
[![Maven central](https://maven-badges.herokuapp.com/maven-central/org.mybatis/mybatis-typehandlers-jsr310/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.mybatis/mybatis-typehandlers-jsr310)
[![License](http://img.shields.io/:license-apache-brightgreen.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

![mybatis](http://mybatis.github.io/images/mybatis-logo.png)

The MyBatis type handlers supporting types introduced in JSR 310: Date and Time API.

If you are using mybatis version 3.4.0-SNAPSHOT, you can simply add this artifact on your classpath and MyBatis will automatically register the provided type handlers.

```xml
<dependency>
  <groupId>org.mybatis</groupId>
  <artifactId>mybatis-typehandlers-jsr310</artifactId>
  <version>1.0.0</version>
</dependency>
```

If you are using mybatis 3.3.1 or older, you may also need to register the type handlers manually.

```xml
<typeHandlers>
  <typeHandler handler="org.apache.ibatis.type.InstantTypeHandler" />
  <typeHandler handler="org.apache.ibatis.type.LocalDateTimeTypeHandler" />
  <typeHandler handler="org.apache.ibatis.type.LocalDateTypeHandler" />
  <typeHandler handler="org.apache.ibatis.type.LocalTimeTypeHandler" />
  <typeHandler handler="org.apache.ibatis.type.OffsetDateTimeTypeHandler" />
  <typeHandler handler="org.apache.ibatis.type.OffsetTimeTypeHandler" />
  <typeHandler handler="org.apache.ibatis.type.ZonedDateTimeTypeHandler" />
</typeHandlers>
```

# Essentials

* [See the docs](http://mybatis.github.io/mybatis-3)
