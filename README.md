# IpSearch

项目背景
  在大数据日志分析中，经常会根据访问的来源IP地址，来判定该访客的所属省、市、区甚至更精准的位置信息，从而对该访问打上相应的位置标签，为后续精准推荐等服务。提供优质的基础数据。

项目需求
  实现毫秒级查找给定IP所对应的位置信息。
  
主要思路：
  1.逐行读取数据文件，把每行元素封装成对象{start_ip, end_ip, address}
  2.依次添加对象到集合List（有序，可重复）中，最后将集合转换成数组
  3.将查询的ip与数组的对象进行二分查找，返回相应的address
注意：ip字符串与ip字符串之间比较，会比较麻烦。我们使用ip转long之后再比较。
