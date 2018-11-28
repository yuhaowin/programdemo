
定时任务调度: 基于**给定的时间点**,**给定的时间间隔**或者**给定的执行次数**自动执行的任务

java中常用的定时任务调度的工具:

* Timer   
    Timer是由jdk直接提供   
    能力较弱
* Quartz   
    Quartz是一个开源项目   
    能力较强
    
    
timer 有且仅有一个后台线程对多个业务线程进行定时定频率的调度   

timer通过定时调用timertask达到定时调度的目的;

![](https://ws2.sinaimg.cn/large/006tNbRwly1fwyrh5fe49j30q50i4wj6.jpg)

TimerThread是后台线程对TaskQueue中的多个业务线程TimerTask进行处理,执行TimerTask中的Run方法;

####Timer类有4个主要的重载函数schedule;
* schedule(task,time)   
    在时间等于或者超过time的时候有且仅执行一次;
* schedule(task,time,period)    
    在时间等于或者超过time的时候首次执行,之后每隔period毫秒重复执行一次;
* schedule(task,delay)    
    在当前时间的delay毫秒后有且仅执行一次; 
* schedule(task,delay,period)   
    在当前时间的delay毫秒后首次执行,之后每隔period毫秒重复执行一次;   
    
####scheduleAtFixedRate两个重载函数
* scheduleAtFixedRate(task,time,period)
* scheduleAtFixedRate(task,delay,period)


TimerTask的cancel():取消单个TimerTask实例的运行;

Timer的cancel():取消改实例下所有当前已经安排的任务;
Timer的purge() :当前取消的任务数


Timer的缺点:

* 由于Timer是由一个后台线程处理多个业务线程,因此,Timer无法并发处理线程,所有的业务线程都是串行执行的,
* Timer无法处理RuntimeException,当一个业务线程在执行时抛出了RuntimeException的异常的话,后面所有的
  业务线程将不再执行.

Timer的使用禁区:
* 对时效性要求较高的多任务并发作业时禁止使用Timer处理;
* 对复杂任务的调度也是禁止使用Timer处理(复杂任务会有可能抛出异常).