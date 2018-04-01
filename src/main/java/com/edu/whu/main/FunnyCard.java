package com.edu.whu.main;

import com.edu.whu.configuration.YamlReader;
import com.edu.whu.server.ChatActionHandler;
import com.edu.whu.server.SelectorFactory;
import com.edu.whu.server.task.ThreadPoolService;
import java.util.ArrayList;
import org.apache.log4j.Logger;

/**
 * Created by yutao on 17/9/13.
 */
public class FunnyCard {
  private static Logger LOG = Logger.getLogger(FunnyCard.class);
  public static void main(String[] args) {
    YamlReader.prepare(args[0]);
    ArrayList<String> hosts = YamlReader.getHosts();
    hosts.forEach(LOG::info);
    //创建服务线程
    ThreadPoolService.init(YamlReader.getNThread());
    LOG.info("Thread Pool size: " + YamlReader.getNThread());
    //开启NIOServer服务
    new ChatActionHandler(SelectorFactory.getSelector(YamlReader.getPort())).listen();
    //关闭线程池
    ThreadPoolService.shutdown();
  }
}
