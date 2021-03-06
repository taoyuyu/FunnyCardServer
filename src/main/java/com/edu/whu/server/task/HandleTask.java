package com.edu.whu.server.task;

import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by yutao on 17/11/22.
 */
public abstract class HandleTask implements Runnable {
  protected SocketChannel channel = null;
  protected ByteBuffer buffer = null;
  public HandleTask(SocketChannel channel, ByteBuffer buffer) {
    this.channel = channel;
    this.buffer = buffer;
  }
}
