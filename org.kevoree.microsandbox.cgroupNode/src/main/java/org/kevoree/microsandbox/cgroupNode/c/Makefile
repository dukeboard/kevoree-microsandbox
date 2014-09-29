GCC=g++
CC=gcc
TARGET=cpu_consumer
TARGET_DIR=../../../../../../../../
#PATH_JAVA=/usr/lib/jvm/java-7-oracle
PATH_JAVA=/usr/lib/jvm/java-7-openjdk-amd64

all: CPUThreadControlImp.c
	${CC} -fPIC -c cgroup_handler.c
	${CC} -I${PATH_JAVA}/include/ -I${PATH_JAVA}/include/linux/ -fPIC -c CPUThreadControlImp.c
	${CC} -shared -Wl,-soname,libCPUThreadControl.so.1 -o libCPUThreadControl.so.1.0 cgroup_handler.o CPUThreadControlImp.o
	rm -f ${TARGET_DIR}/libCPUThreadControl.so
	link libCPUThreadControl.so.1.0 ${TARGET_DIR}/libCPUThreadControl.so
