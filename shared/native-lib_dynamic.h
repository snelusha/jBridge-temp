#ifndef __NATIVE_LIB_H
#define __NATIVE_LIB_H

#include <graal_isolate_dynamic.h>


#if defined(__cplusplus)
extern "C" {
#endif

typedef int (*run_main_fn_t)(int argc, char** argv);

typedef graal_isolatethread_t* (*Java_org_pkg_app_App_createIsolate_fn_t)();

typedef int (*Java_org_pkg_app_App_add_fn_t)(size_t, size_t, long long int, int, int);

#if defined(__cplusplus)
}
#endif
#endif
