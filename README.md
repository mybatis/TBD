# MyBatis Type Handlers for JSR 310: Date and Time API

[![Build Status](https://travis-ci.org/mybatis/typehandlers-jsr310.svg?branch=master)](https://travis-ci.org/mybatis/typehandlers-jsr310)
[![Coverage Status](https://coveralls.io/repos/github/mybatis/typehandlers-jsr310/badge.svg?branch=master)](https://coveralls.io/github/mybatis/typehandlers-jsr310?branch=master)
[![Dependency Status](https://www.versioneye.com/user/projects/56ef43cb35630e00388897bb/badge.svg?style=flat)](https://www.versioneye.com/user/projects/56ef43cb35630e00388897bb)
[![Maven central](https://maven-badges.herokuapp.com/maven-central/org.mybatis/mybatis-typehandlers-jsr310/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.mybatis/mybatis-typehandlers-jsr310)
[![License](http://img.shields.io/:license-apache-brightgreen.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

![mybatis](http://mybatis.github.io/images/mybatis-logo.png)

The MyBatis type handlers supporting types introduced in JSR 310: Date and Time API.

If you are using mybatis version 3.4 or later, you can simply add this artifact on your classpath and MyBatis will automatically register the provided type handlers.

```xml
<dependency>
  <groupId>org.mybatis</groupId>
  <artifactId>mybatis-typehandlers-jsr310</artifactId>
  <version>1.0.2</version>
</dependency>
```

If you are using an older version you need to register the type handlers manually.  These are latest since Mybatis 3.4.2.

```xml
<typeHandlers>
  <typeHandler handler="org.apache.ibatis.type.InstantTypeHandler" />
  <typeHandler handler="org.apache.ibatis.type.LocalDateTimeTypeHandler" />
  <typeHandler handler="org.apache.ibatis.type.LocalDateTypeHandler" />
  <typeHandler handler="org.apache.ibatis.type.LocalTimeTypeHandler" />
  <typeHandler handler="org.apache.ibatis.type.OffsetDateTimeTypeHandler" />
  <typeHandler handler="org.apache.ibatis.type.OffsetTimeTypeHandler" />
  <typeHandler handler="org.apache.ibatis.type.ZonedDateTimeTypeHandler" />
  <typeHandler handler="org.apache.ibatis.type.YearTypeHandler" />
  <typeHandler handler="org.apache.ibatis.type.MonthTypeHandler" />
  <typeHandler handler="org.apache.ibatis.type.YearMonthTypeHandler" />
  <typeHandler handler="org.apache.ibatis.type.JapaneseDateTypeHandler" />
</typeHandlers>
```

# Essentials

* [See the docs](http://mybatis.github.io/mybatis-3)
