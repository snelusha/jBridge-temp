package org.pkg.bothnativeb;

import org.graalvm.nativeimage.c.function.CEntryPoint;
import org.graalvm.nativeimage.IsolateThread;

import org.graalvm.word.Pointer;

class Something {
    int value;

    Something(int value) {
        this.value = value;
    }
}

public class BothNativeB {
    public static void main(String[] args) {}

    @CEntryPoint(name = "Java_org_pkg_bothnativea_BothNativeA_createIsolateA", builtin=CEntryPoint.Builtin.CREATE_ISOLATE)
    public static native IsolateThread createIsolateA();
    
    @CEntryPoint(name = "Java_org_pkg_bothnativea_BothNativeA_foo")
    public static void foo(Pointer env, Pointer clazz, @CEntryPoint.IsolateThreadContext long isolateId, int a) {
        System.out.printf("foo: %d%n", a);

        long isolateThread = createIsolateB();
        bar(isolateThread, 20);
    }

    @CEntryPoint(name = "Java_org_pkg_bothnativea_BothNativeA_something")
    public static void something(Pointer env, Pointer clazz, @CEntryPoint.IsolateThreadContext long isolateId, Pointer somethingPtr) {
        int objHash = System.identityHashCode(somethingPtr.toObject());
        System.out.printf("SomethingPtr hash in B: %d%n", objHash);
        // Something something = somethingPtr.toObject(Something.class, true);
        // int hash = System.identityHashCode(something);
        // System.out.printf("Something hash in B: %d%n", hash);
    }

    private static native long createIsolateB();

    private static native void bar(long isolateThread, int b);
}
