#include "com_example_ndk_HelloJni.h"



JNIEXPORT jint JNICALL
Java_com_example_ndk_HelloJni_sayHello(JNIEnv *env, jobject instance, jint a) {
//        int b = 1;
//        a = a + b;
//        b = -1;
//        a = a + b;
//        a = a | a;
//        a = a ^ a;
//        if (a > 0) {
//            return a;
//        }
//        if(b>0){
//            return a+b;
//        }
//        if(a+b<10){
//            return a-b;
//        }

    return 1110;
}