package net.multigesture.kanama.api

import net.multigesture.kanama.binding.runtime.ObjectCalls
import java.lang.foreign.MemorySegment

/**
 * Provides access to the Java Native Interface.
 *
 * Generated from Godot docs: JavaClassWrapper
 */
object JavaClassWrapper {
    private val singleton: MemorySegment by lazy {
        ObjectCalls.getSingleton("JavaClassWrapper")
    }

    /**
     * Wraps a class defined in Java, and returns it as a `JavaClass` `Object` type that Godot can
     * interact with. When wrapping inner (nested) classes, use `$` instead of `.` to separate them.
     * For example, `JavaClassWrapper.wrap("android.view.WindowManager$LayoutParams")` wraps the
     * WindowManager.LayoutParams class. Note: To invoke a constructor, call a method with the same
     * name as the class. For example:
     *
     * Generated from Godot docs: JavaClassWrapper.wrap
     */
    @JvmStatic
    fun wrap(name: String): JavaClass? {
        return JavaClass.wrap(ObjectCalls.ptrcallWithStringArgRetObject(wrapBind, singleton, name))
    }

    /**
     * Returns the Java exception from the last call into a Java class. If there was no exception, it
     * will return `null`. Note: This method only works on Android. On every other platform, this
     * method will always return `null`.
     *
     * Generated from Godot docs: JavaClassWrapper.get_exception
     */
    @JvmStatic
    fun getException(): JavaObject? {
        return JavaObject.wrap(ObjectCalls.ptrcallNoArgsRetObject(getExceptionBind, singleton))
    }

    private const val WRAP_HASH = 1124367868L
    private val wrapBind by lazy {
        ObjectCalls.getMethodBind("JavaClassWrapper", "wrap", WRAP_HASH)
    }

    private const val GET_EXCEPTION_HASH = 3277089691L
    private val getExceptionBind by lazy {
        ObjectCalls.getMethodBind("JavaClassWrapper", "get_exception", GET_EXCEPTION_HASH)
    }
}
