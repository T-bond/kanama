# Kanama consumer ProGuard/R8 rules.
#
# These rules are inherited by any game APK that depends on the Kanama
# plugin AAR and enables R8 minification. They keep the entry points and
# reflective surfaces the Kanama runtime needs while leaving game script
# classes free to be obfuscated by the game's own configuration.
#
# STATUS: scaffold — an R8-minified APK smoke pass is still a pending
# validation gate (see docs/exporting/android.md).

# Bootstrap entry: bootstrap.c resolves this class and its static
# init(JJJ)V method by name via JNI (FindClass / GetStaticMethodID).
-keep class net.multigesture.kanama.KanamaBinding {
    public static void init(long, long, long);
}

# Panama upcall/downcall targets are resolved via MethodHandles.lookup()
# with string names; R8 cannot see those references.
-keep class net.multigesture.kanama.binding.** { *; }
-keep class net.multigesture.kanama.binding.runtime.** { *; }
-keep class net.multigesture.kanama.ffi.** { *; }

# KSP-generated registrars and registry (invoked at INITIALIZATION_SCENE).
-keep class net.multigesture.kanama.generated.** { *; }
-keep class **.KanamaRegistry { *; }
-keep class **.KanamaScriptRegistry { *; }

# Kanama annotations drive script resolution at runtime.
-keep @interface net.multigesture.kanama.annotation.** { *; }
-keepattributes RuntimeVisibleAnnotations, RuntimeInvisibleAnnotations

# PanamaPort (java.lang.foreign port for ART) relies on internal
# reflection and Unsafe access.
-keep class com.v7878.** { *; }
-dontwarn com.v7878.**
