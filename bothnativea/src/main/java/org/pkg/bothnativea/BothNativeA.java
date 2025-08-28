package org.pkg.bothnativea;

import org.graalvm.nativeimage.c.function.CEntryPoint;
import org.graalvm.nativeimage.IsolateThread;

import org.graalvm.word.Pointer;

class Something {
    int value;

    Something(int value) {
        this.value = value;
    }
}

public class BothNativeA {
    public static void main(String[] args) {
        System.load("/Users/sithi/sandbox/jBridge/bothnativeb/native/bothnativeb.dylib");

        long isolateThread = createIsolateA();
        foo(isolateThread, 10);

        Something something = new Something(42);
        int hash = System.identityHashCode(something);
        System.out.printf("Something hash: %d%n", hash);
        something(isolateThread, something);
    }

    @CEntryPoint(name = "Java_org_pkg_bothnativeb_BothNativeB_createIsolateB", builtin=CEntryPoint.Builtin.CREATE_ISOLATE)
    public static native IsolateThread createIsolateB();

    @CEntryPoint(name = "Java_org_pkg_bothnativeb_BothNativeB_bar")
    public static void bar(Pointer env, Pointer clazz, @CEntryPoint.IsolateThreadContext long isolateId, int b) {
        System.out.printf("bar: %d%n", b);
    }

    private static native long createIsolateA();

    private static native void foo(long isolateThread, int a);

    private static native void something(long isolateThread, Something something);
}
