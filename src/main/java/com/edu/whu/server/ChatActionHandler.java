package com.edu.whu.server;

import com.edu.whu.server.task.MessageHandleTask;
import com.edu.whu.server.task.ThreadPoolService;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import org.apache.commons.codec.Charsets;
import org.apache.log4j.Logger;

/**
 * Created by yutao on 17/9/14.
 * 读写事件响应
 */
public class ChatActionHandler extends ActionHandler {

  private static Logger LOG = Logger.getLogger(ChatActionHandler.class);
  private int BYTE_BUFFER_SIZE = 32;
  private Charset charset = Charsets.UTF_8;
  private CharsetDecoder decoder = charset.newDecoder();


  public ChatActionHandler(Selector selector) {
    super(selector);
  }


  @Override
  protected void readAction(SelectionKey key) {
    SocketChannel channel = (SocketChannel) key.channel();
    boolean close = true;
    LOG.info(channel.socket().hashCode() + " read channel");
    ByteBuffer buffer = ByteBuffer.allocate(BYTE_BUFFER_SIZE);
    try {
      StringBuilder sb = new StringBuilder();
      while (channel.read(buffer) > 0) {
        if (close) {
          close = false;
        }
        if (buffer.get(buffer.position()-1) == 1) {
          sb.append(byteBufferToString(buffer));
          System.out.println("message: " + sb.toString());
          ThreadPoolService.submit(new MessageHandleTask(channel, sb.toString()));
          return;
        } else {
          sb.append(byteBufferToString(buffer));
        }
      }

      if (close) {
        LOG.info(channel.socket().hashCode() + " closed");
        channel.close();
      }

    } catch (IOException e) {
      LOG.error("close channel error: " + e.getMessage());
    }
  }

  private String byteBufferToString(ByteBuffer buffer) {
    CharBuffer charBuffer;
    try {
      buffer.flip();
      charBuffer = decoder.decode(buffer.asReadOnlyBuffer());
    } catch (CharacterCodingException cce) {
      LOG.error(cce.getMessage());
      return "";
    } finally {
      buffer.clear();
    }

    LOG.info(String.format("message: %s", charBuffer.toString()));
    return charBuffer.toString();
  }

}
