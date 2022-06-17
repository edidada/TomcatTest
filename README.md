# 仿写Tomcat

- annotion包内存放自定义注解
- config包里面写的servlet容器，用来初始化Tomcat时存放全部servlet信息
- util里面是工具类
  - FilUtil用来访问静态资源时使用
  - ResponseUtil用来返回数据是应该添加的东西目的是让浏览器识别
  - SerchClassUtil工具类是用来扫描servlet包下所有类信息的，以方便放入servlet容器
- servletinterface包里面写的请求接口和响应接口
- realization包里写的接口实现类
- servletabstract包写的servlet抽象类，创建的servlet都要继承于它
- MyTomcat是启动类



Tomcat初始化时会把全部的servlet放入servlet容器中，http请求通过socket来监视，请求后可获取到请求类型和请求路径，而容器中是用请求路径作为key，类信息作为val的，通过路径判断是静态信息还是动态信息，是动态信息就进入servlet类再根据它的请求类型来get或post方法来进入它的get或post方法中，静态的就返回它的静态数据



###### 解决Tomcat容器问题

1. tomcat是一个web容器，写了一个ServletContainer类，用来存放servlet信息

   里面使用了map, key用来存储访问路径url, val用来存储类信息（反射获取到的类）

2. 通过SerchClassUtil工具类来扫描全部servlet，全部扫描后通过注解WebServer反射获取请求路径，作为容器的key，类信息作为val

###### 解决servlet

1. 写两个接口，HttpServletRequest接口和HttpServletResponse接口,用来定义行为规范

   HttpServletRequest接口需要设置请求类型和获取请求类型，设置请求路径和获取请求路径

   HttpServletResponse接口需要有返回数据

2. 实现两个接口

3. 写了一个HttpServlet抽象类

   写两个抽象方法分别是关于get类型请求和post类型请求的方法

   方法service来确定到底是使用哪种类型的请求，从而确认进入哪个抽象方法

4. 实现抽象类

   实现get和post方法，并且在里面写上注解和路径

###### 解决通信问题

使用socket来解决通信问题