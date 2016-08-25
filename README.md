# ServiceBestPractice
 第一行代码实践
 
# 笔记 
 
 在MainActivity中 启动服务LongRunningService.class————在 LongRunningService.class设定定时任务 10s后执行 定时任务+广播————在AlarmReceiver.class接收广播，并 启动服务 LongRunningService.class ，这样就会形成一个长时间存活的服务

启动服务
Intent i = new Intent(MainActivity.this,LongRunningService.class);
startService(i);


定时任务+广播
Intent intent2 = new Intent(this,AlarmReceiver.class);
PendingIntent pendingIntent = PendingIntent.getBroadcast(this,0,intent2,0);
alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,time,pendingIntent);


接收广播并启动服务

Intent intent1 = new Intent(context,LongRunningService.class);
context.startService(intent1);

