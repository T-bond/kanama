package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment

/**
 * Instance handle returned by DirAccess factory methods.
 */
class DirAccessHandle internal constructor(handle: MemorySegment) : RefCounted(handle) {
    fun fileExists(path: String): Boolean {
        checkOpen()
        return DirAccess.fileExistsHandle(handle, path)
    }

    fun dirExists(path: String): Boolean {
        checkOpen()
        return DirAccess.dirExistsHandle(handle, path)
    }

    fun getCurrentDir(includeDrive: Boolean = true): String {
        checkOpen()
        return DirAccess.getCurrentDirHandle(handle, includeDrive)
    }

    fun getFiles(): List<String> {
        checkOpen()
        return DirAccess.getFilesHandle(handle)
    }

    fun getDirectories(): List<String> {
        checkOpen()
        return DirAccess.getDirectoriesHandle(handle)
    }

    fun createLink(source: String, target: String): Long {
        checkOpen()
        return DirAccess.createLinkHandle(handle, source, target)
    }

    companion object {
        @JvmStatic
        fun fromHandle(handle: MemorySegment): DirAccessHandle? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): DirAccessHandle? =
            if (handle.address() == 0L) null else DirAccessHandle(handle)
    }
}
