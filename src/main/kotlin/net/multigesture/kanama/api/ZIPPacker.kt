package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment
import kotlin.jvm.JvmName

/**
 * Generated from Godot docs: ZIPPacker
 */
class ZIPPacker(handle: MemorySegment) : RefCounted(handle) {
    var compressionLevel: Int
        @JvmName("compressionLevelProperty")
        get() = getCompressionLevel()
        @JvmName("setCompressionLevelProperty")
        set(value) = setCompressionLevel(value)

    fun open(path: String, append: Long = 0L): Long {
        return ObjectCalls.ptrcallWithStringAndLongArgRetLong(openBind, handle, path, append)
    }

    fun setCompressionLevel(compressionLevel: Int) {
        ObjectCalls.ptrcallWithIntArg(setCompressionLevelBind, handle, compressionLevel)
    }

    fun getCompressionLevel(): Int {
        return ObjectCalls.ptrcallNoArgsRetInt(getCompressionLevelBind, handle)
    }

    fun startFile(path: String): Long {
        return ObjectCalls.ptrcallWithStringArgRetLong(startFileBind, handle, path)
    }

    fun writeFile(data: ByteArray): Long {
        return ObjectCalls.ptrcallWithByteArrayArgRetLong(writeFileBind, handle, data)
    }

    fun closeFile(): Long {
        return ObjectCalls.ptrcallNoArgsRetLong(closeFileBind, handle)
    }

    fun closeArchive(): Long {
        return ObjectCalls.ptrcallNoArgsRetLong(closeArchiveBind, handle)
    }

    companion object {
        private const val OPEN_HASH = 1936816515L
        private val openBind by lazy {
            ObjectCalls.getMethodBind("ZIPPacker", "open", OPEN_HASH)
        }

        private const val SET_COMPRESSION_LEVEL_HASH = 1286410249L
        private val setCompressionLevelBind by lazy {
            ObjectCalls.getMethodBind("ZIPPacker", "set_compression_level", SET_COMPRESSION_LEVEL_HASH)
        }

        private const val GET_COMPRESSION_LEVEL_HASH = 3905245786L
        private val getCompressionLevelBind by lazy {
            ObjectCalls.getMethodBind("ZIPPacker", "get_compression_level", GET_COMPRESSION_LEVEL_HASH)
        }

        private const val START_FILE_HASH = 166001499L
        private val startFileBind by lazy {
            ObjectCalls.getMethodBind("ZIPPacker", "start_file", START_FILE_HASH)
        }

        private const val WRITE_FILE_HASH = 680677267L
        private val writeFileBind by lazy {
            ObjectCalls.getMethodBind("ZIPPacker", "write_file", WRITE_FILE_HASH)
        }

        private const val CLOSE_FILE_HASH = 166280745L
        private val closeFileBind by lazy {
            ObjectCalls.getMethodBind("ZIPPacker", "close_file", CLOSE_FILE_HASH)
        }

        private const val CLOSE_HASH = 166280745L
        private val closeArchiveBind by lazy {
            ObjectCalls.getMethodBind("ZIPPacker", "close", CLOSE_HASH)
        }
    }
}
