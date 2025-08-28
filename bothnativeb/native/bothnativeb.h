#ifndef __BOTHNATIVEB_H
#define __BOTHNATIVEB_H

#include <graal_isolate.h>


#if defined(__cplusplus)
extern "C" {
#endif

graal_isolatethread_t* Java_org_pkg_bothnativea_BothNativeA_createIsolateA();

void Java_org_pkg_bothnativea_BothNativeA_foo(size_t, size_t, long long int, int);

void Java_org_pkg_bothnativea_BothNativeA_something(size_t, size_t, long long int, size_t);

int run_main(int argc, char** argv);

#if defined(__cplusplus)
}
#endif
#endif
