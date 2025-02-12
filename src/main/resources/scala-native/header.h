// This is the definition a library author will usually expose separately in
// a header file

typedef struct Hello {
  int field1;
  int field2;
} Hello;

unsigned resolve(Hello h, int i);
unsigned resolveMuller(Hello h, int i);
//unsigned long add3(long in);
//extern "C" long add3(long in);