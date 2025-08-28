#ifndef __BOTHNATIVEB_H
#define __BOTHNATIVEB_H

#include <graal_isolate_dynamic.h>


#if defined(__cplusplus)
extern "C" {
#endif

typedef graal_isolatethread_t* (*Java_org_pkg_bothnativea_BothNativeA_createIsolateA_fn_t)();

typedef void (*Java_org_pkg_bothnativea_BothNativeA_foo_fn_t)(size_t, size_t, long long int, int);

typedef void (*Java_org_pkg_bothnativea_BothNativeA_something_fn_t)(size_t, size_t, long long int, size_t);

typedef int (*run_main_fn_t)(int argc, char** argv);

#if defined(__cplusplus)
}
#endif
#endif
