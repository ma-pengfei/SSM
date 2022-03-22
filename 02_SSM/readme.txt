SSM整合开发： Spring + SpringMVC + MyBatis

    SpringMVC:视图层，界面层，负责接收请求，显示处理结果
    Spring:业务层，管理Service，Dao，工具类对象的
    MyBatis:持久层，访问数据库的

用户发起请求 ——> SpringMVC接收 ——> Spring中的Service ——> MyBatis处理数据

    两个容器:
        1.SpringMVC容器，管理Controller控制器对象的
        2.Spring容器，管理Service，Dao，工具类对象的
    开发过程中要把使用的对象交给合适的容器创建，管理。

SpringMVC容器和Spring容器存在一个关系。SpringMVC容器是Spring容器的子容器，类似于Java的继承，但不是。
    子可以访问父的内容。在子容器中的Controller对象可以访问父容器中的Service对象，实现Controller使用Service对象

开发过程中，注解为主，配置文件为辅
    实现步骤：
    0.使用mysql的db1中的student表
    1.加入依赖：
        SpringMVC Spring MyBatis三个框架的依赖
        jackson的依赖 mysql驱动 druid连接池
        jsp servlet 依赖
    2.写web.xml
        1)注册DispatcherServlet：中央调度器。
            创建SpringMVC容器对象，才能由容器创建Controller对象
            创建的DispatcherServlet是Servlet，才能接受用户请求。
        2)注册Spring的监听器ContextLoaderListener：
            创建在监听器创建时，创建spring的容器，才能由容器创建Service等的对象
        3)注册字符集过滤器
    3.创建包，Controller包，Service包，dao包，实体类包等
    4.写SpringMVC，Spring，MyBatis的配置文件
        1)SpringMVC的配置文件
        2)配置文件的配置文件
        3)MyBatis的主配置文件
        4)数据库的属性配置文件
    5.写代码：dao接口和mapper文件，service接口和实现类，controller，实体类
    6.写jsp页面。
