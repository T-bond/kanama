package net.multigesture.kanama.android;

final class KanamaAndroidBootstrap {
    static {
        System.loadLibrary("kanama_bootstrap");
        captureJvm();
    }

    private KanamaAndroidBootstrap() {
    }

    static native void captureJvm();

    static void ensureLoaded() {
    }
}

