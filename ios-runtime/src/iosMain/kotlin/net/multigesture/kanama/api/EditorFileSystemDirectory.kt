package net.multigesture.kanama.api

import java.lang.foreign.MemorySegment
import net.multigesture.kanama.binding.runtime.ObjectCalls
import net.multigesture.kanama.binding.runtime.*

/**
 * Generated from Godot docs: EditorFileSystemDirectory
 */
class EditorFileSystemDirectory(handle: MemorySegment) : GodotObject(handle) {
    fun getSubdirCount(): Int {
        return ObjectCalls.ptrcallNoArgsRetInt(getSubdirCountBind, handle)
    }

    fun getSubdir(idx: Int): EditorFileSystemDirectory? {
        return EditorFileSystemDirectory.wrap(ObjectCalls.ptrcallWithIntArgRetObject(getSubdirBind, handle, idx))
    }

    fun getFileCount(): Int {
        return ObjectCalls.ptrcallNoArgsRetInt(getFileCountBind, handle)
    }

    fun getFileImportIsValid(idx: Int): Boolean {
        return ObjectCalls.ptrcallWithIntArgRetBool(getFileImportIsValidBind, handle, idx)
    }

    fun getName(): String {
        return ObjectCalls.ptrcallNoArgsRetString(getNameBind, handle)
    }

    fun getPath(): String {
        return ObjectCalls.ptrcallNoArgsRetString(getPathBind, handle)
    }

    fun getParent(): EditorFileSystemDirectory? {
        return EditorFileSystemDirectory.wrap(ObjectCalls.ptrcallNoArgsRetObject(getParentBind, handle))
    }

    fun findFileIndex(name: String): Int {
        return ObjectCalls.ptrcallWithStringArgRetInt(findFileIndexBind, handle, name)
    }

    fun findDirIndex(name: String): Int {
        return ObjectCalls.ptrcallWithStringArgRetInt(findDirIndexBind, handle, name)
    }

    companion object {
        fun fromHandle(handle: MemorySegment): EditorFileSystemDirectory? =
            wrap(handle)

        internal fun wrap(handle: MemorySegment): EditorFileSystemDirectory? =
            if (handle.address() == 0L) null else EditorFileSystemDirectory(handle)

        private const val GET_SUBDIR_COUNT_HASH = 3905245786L
        private val getSubdirCountBind by lazy {
            ObjectCalls.getMethodBind("EditorFileSystemDirectory", "get_subdir_count", GET_SUBDIR_COUNT_HASH)
        }

        private const val GET_SUBDIR_HASH = 2330964164L
        private val getSubdirBind by lazy {
            ObjectCalls.getMethodBind("EditorFileSystemDirectory", "get_subdir", GET_SUBDIR_HASH)
        }

        private const val GET_FILE_COUNT_HASH = 3905245786L
        private val getFileCountBind by lazy {
            ObjectCalls.getMethodBind("EditorFileSystemDirectory", "get_file_count", GET_FILE_COUNT_HASH)
        }

        private const val GET_FILE_IMPORT_IS_VALID_HASH = 1116898809L
        private val getFileImportIsValidBind by lazy {
            ObjectCalls.getMethodBind("EditorFileSystemDirectory", "get_file_import_is_valid", GET_FILE_IMPORT_IS_VALID_HASH)
        }

        private const val GET_NAME_HASH = 2841200299L
        private val getNameBind by lazy {
            ObjectCalls.getMethodBind("EditorFileSystemDirectory", "get_name", GET_NAME_HASH)
        }

        private const val GET_PATH_HASH = 201670096L
        private val getPathBind by lazy {
            ObjectCalls.getMethodBind("EditorFileSystemDirectory", "get_path", GET_PATH_HASH)
        }

        private const val GET_PARENT_HASH = 842323275L
        private val getParentBind by lazy {
            ObjectCalls.getMethodBind("EditorFileSystemDirectory", "get_parent", GET_PARENT_HASH)
        }

        private const val FIND_FILE_INDEX_HASH = 1321353865L
        private val findFileIndexBind by lazy {
            ObjectCalls.getMethodBind("EditorFileSystemDirectory", "find_file_index", FIND_FILE_INDEX_HASH)
        }

        private const val FIND_DIR_INDEX_HASH = 1321353865L
        private val findDirIndexBind by lazy {
            ObjectCalls.getMethodBind("EditorFileSystemDirectory", "find_dir_index", FIND_DIR_INDEX_HASH)
        }
    }
}
