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

JNIEXPORT jboolean JNICALL Java_org_kevoree_microsandbox_cgroupNode_CPUThreadControl_assignLimit
	(JNIEnv* env, jclass clazz, jint id, jint value)
{
	char buff0[20];
	sprintf(buff0, "component%d",id);
	char buff1[50];
	sprintf(buff1, "inti/p0/%s",buff0);
	char buff2[50];
	sprintf(buff2, "%s/a",buff1);
	
	
	printf("Printing in thread %d the number %d\n", id, value);
	if (create_cgroup(buff0, "cpu", "inti/p0")) return 0;
	if (create_cgroup(buff0, "freezer","inti/p0")) return 0;
	if (assign_value(buff1, "cpu","notify_on_release", 1)) return 0;
	if (assign_value(buff1, "freezer", "notify_on_release", 1)) return 0;
	
	if (create_cgroup("a", "cpu", buff1)) return 0;
	if (assign_value(buff1, "cpu","cpu.cfs_period_us", 1000000)) return 0;
	if (assign_value(buff1, "cpu","cpu.cfs_quota_us", value*1000)) return 0;
	if (assign_value(buff2, "cpu","cpu.shares", 100)) return 0;
		
	return 1;
}

JNIEXPORT jboolean JNICALL Java_org_kevoree_microsandbox_cgroupNode_CPUThreadControl_attach
  (JNIEnv * env, jclass clazz, jint id)
{
	char buff1[50];
	sprintf(buff1, "inti/p0/component%d/a", id);
	if (move_process_to_cgroup(syscall(SYS_gettid), buff1, "cpu")) return 0;
	sprintf(buff1, "inti/p0/component%d",id);
	if (move_process_to_cgroup(syscall(SYS_gettid), buff1, "freezer")) return 0;
	return 1;
}

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
