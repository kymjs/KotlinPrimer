package com.kymjs.kotlinprimer

import kotlinx.coroutines.experimental.channels.Channel
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import kotlinx.io.core.ByteReadPacket
import kotlinx.io.core.buildPacket
import com.sun.xml.internal.ws.streaming.XMLStreamReaderUtil.close
import java.io.*
import java.nio.ByteBuffer
import java.nio.channels.FileChannel


/**
 * Created by ZhangTao on 18/7/23.
 */


private fun copyFile(source: File, dest: File) {
    FileInputStream(source).use { input ->
        FileOutputStream(dest).use { output ->
            val buf = ByteArray(1024)
            while (true) {
                val bytesRead = input.read(buf)
                if (bytesRead <= 0) {
                    break
                }
                output.write(buf, 0, bytesRead)
            }
        }
    }
}

private fun copyFile2(source: File, dest: File) {
    FileInputStream(source).channel.use { inputChannel ->
        FileOutputStream(dest).channel.use { outputChannel ->
            val byteBuffer = ByteBuffer.allocate(1024)
            while (true) {
                byteBuffer.clear()
                if (inputChannel.read(byteBuffer) < 0) {
                    break
                }
                byteBuffer.flip()
                outputChannel.write(byteBuffer)
            }
        }
    }
}


fun main(args: Array<String>) = runBlocking {
    val tee = Channel<ByteReadPacket>()

    val file = File("./build.gradle")
    val packet = buildPacket(1) {
        writeStringUtf8(file.readText())
    }

    launch {
        tee.send(packet.copy())
    }

    launch {
        println(tee.receive().readText())
    }


    delay(1000)
    Unit
}
