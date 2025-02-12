// This is the actual implementation of library code, usually you don't see this
// and instead link against it

#include "header.h"
#include "stdio.h"

unsigned resolve(Hello h, int i) {
  printf("Hello{%d,%d}", h.field1, h.field2);
  return i * i;
}

unsigned resolveMuller(Hello h, int i) {
  printf("Hello{%d,%d}", h.field1*2, h.field2*4);
  return i * i;
}
//unsigned long add3(long long in) {
//    return in + 3;
//}