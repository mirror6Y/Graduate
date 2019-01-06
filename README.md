# graduate
毕业生就业信息管理系统

 #druid连接池(阿里)
      #type: com.alibaba.druid.pool.DruidDataSource
      #connectionProperties: druid.stat.mergeSql=true
      # 初始化大小，最小，最大
      #initialSize:5
      #minIdle:1
      #maxActive:50
      # 配置获取连接等待超时的时间
      #maxWait:60000
      # 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
      #timeBetweenEvictionRunsMillis:60000
      # 配置一个连接在池中最小生存的时间，单位是毫秒
      #minEvictableIdleTimeMillis:300000
