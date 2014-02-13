
#ifndef __CGROUP_HANDLER__
#define __CGROUP_HANDLER__

#ifdef __cplusplus
extern "C" {
#endif

int create_cgroup( char* name,  char* subsystem,  char* parent);
int delete_cgroup( char* name,  char* subsystem,  char* parent);

//template <typename ValueType>
int assign_value( char* group,  char* subsystem,  char* property, int value);
int assign_value_string( char* group,  char* subsystem,  char* property,  char* value);

int move_process_to_cgroup(pid_t pid,  char* cgroup_name,  char* controller);

#ifdef __cplusplus
}
#endif


#endif
