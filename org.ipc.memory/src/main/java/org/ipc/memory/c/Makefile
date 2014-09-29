CC=g++
TARGET=InterprocessLock
TARGET_DIR=../../../../../../../
#PATH_JAVA=/usr/lib/jvm/java-7-oracle
PATH_JAVA=/usr/lib/jvm/java-7-openjdk-amd64

C_FLAGS=-std=c++11 -lstdc++

L_FLAGS=

INCLUDES=-I${PATH_JAVA}/include/ -I${PATH_JAVA}/include/linux/

all: InterprocessLockImp.cpp
	${CC} ${C_FLAGS} ${INCLUDES} -fPIC -c InterprocessLockImp.cpp
	${CC} -pthread -shared -Wl,-soname,lib"${TARGET}".so.1 -o lib"${TARGET}".so.1.0 InterprocessLockImp.o -lrt
	rm -f ${TARGET_DIR}/lib"${TARGET}".so
	link lib"${TARGET}".so.1.0 ${TARGET_DIR}/lib"${TARGET}".so
