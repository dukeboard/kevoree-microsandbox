#include "CPUThreadControl.h"
#include <stdio.h>

#include <sys/wait.h>
#include <sys/syscall.h>
#include <sys/stat.h>
#include <sys/mman.h>
#include <sys/types.h>
#include <fcntl.h>
#include <signal.h>
#include <sys/time.h>

#include "cgroup_handler.h"

JNIEXPORT jboolean JNICALL Java_org_kevoree_microsandbox_cgroupNode_CPUThreadControl_setFrozen
  (JNIEnv * env, jclass clazz, jint id, jboolean b)
{
	printf("Frozen/THAWED component with id=%d\n and %d", id, b);
	char buff[50];
	sprintf(buff,"inti/p0/component%d", id);
	if (b)
		assign_value_string(buff, "freezer", 
				"freezer.state","FROZEN");
	else
		assign_value_string(buff, "freezer",
				"freezer.state","THAWED");
	return 1;
}

JNIEXPORT jint JNICALL Java_org_kevoree_microsandbox_cgroupNode_CPUThreadControl_getTTID
    (JNIEnv * env, jclass clazz)
{
    return syscall(SYS_gettid);
}
