/*
 * Copyright 1999-2011 Alibaba Group.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.dubbo.remoting.transport.netty;

import com.alibaba.dubbo.remoting.buffer.ChannelBuffer;
import io.netty.buffer.ByteBuf;

/**
 * @author <a href="mailto:gang.lvg@taobao.com">kimi</a>
 */
final class NettyHelper {

    /**
     * 从ByteBuf获取byte[]数据
     *
     * @param
     * @return
     */
    public static byte[] getBytesFromByteBuf(ByteBuf bb) {
        byte[] data = null;

        int readableBytes = bb.readableBytes();
        if (bb.hasArray() && bb.arrayOffset() == 0 && readableBytes == bb.capacity()) {
            data = bb.array();
        }
        else {
            data = new byte[readableBytes];
            bb.getBytes(0, data, 0, readableBytes);
        }

        return data;
    }

    public static byte[] getBytesFromChannelBuffer(ChannelBuffer cb) {
        byte[] data;

        int readableBytes = cb.readableBytes();
        if (cb.hasArray() && cb.arrayOffset() == 0 && readableBytes == cb.capacity()) {
            data = cb.array();
        }
        else {
            data = new byte[readableBytes];
            cb.getBytes(0, data, 0, readableBytes);
        }

        return data;
    }
}
