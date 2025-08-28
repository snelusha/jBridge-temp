#ifndef __NATIVE_LIB_H
#define __NATIVE_LIB_H

#include <graal_isolate.h>


#if defined(__cplusplus)
extern "C" {
#endif

int run_main(int argc, char** argv);

graal_isolatethread_t* Java_org_pkg_app_App_createIsolate();

int Java_org_pkg_app_App_add(size_t, size_t, long long int, int, int);

#if defined(__cplusplus)
}
#endif
#endif
