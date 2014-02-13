#include <errno.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>


#include <sys/wait.h>
#include <sys/types.h>
#include <sys/stat.h>


#include "cgroup_handler.h"

char* base_path = "/sys/fs/cgroup/";

char* getPath(char* sub, char* name, char* subname) {
	int l1 = strlen(base_path);
	int l2 = strlen(sub);
	int l3 = strlen(name);
	int l4 = strlen(subname);
	char* full_path = (char*)malloc(l1 + l2 + l3 + l4 + 3);
	char* dst = full_path;
	strcpy(dst, base_path); dst += l1;
	strcpy(dst, sub); dst[l2] = '/'; dst += l2 + 1;
	strcpy(dst, name); dst[l3] = '/'; dst+=l3+1;
	strcpy(dst, subname); dst[l4] = 0;
	return full_path;
}

int create_cgroup( char* name,  char* subsystem,  char* parent) {
	// create directory under /sys/fs/cgroup
	int ret;
	char* path = getPath(subsystem, parent, name);
	//std::string full_path = base_path + subsystem + "/" + parent + "/" + name;
	ret = mkdir(path, S_IRWXU | S_IRWXG | S_IROTH | S_IXOTH); // FIXME : this is wrong because I only need read access (Maybe write for the owner)
	if (ret) {
		fprintf(stderr, "Error : %s in %s:%d\n", strerror(errno), __FUNCTION__, __LINE__);
		fprintf(stderr, "Parameters : %s\n", path);
		free(path);
		return ret;
	}
	free(path);
	return 0;
}

int delete_cgroup( char* name,  char* subsystem,  char* parent) {
	char* path = getPath(subsystem, parent, name);
	//std::string full_path = base_path + subsystem + "/" + parent + "/" + name;
	int ret = rmdir(path); // FIXME : this is wrong because I only need read access (Mybe write for the owner)
	if (ret) {
		fprintf(stderr, "Error : %s in %s:%d\n", strerror(errno), __FUNCTION__, __LINE__);
		free(path);
		return ret;
	}
	free(path);
	return 0;
}

int assign_value( char* group,  char* subsystem,  char* property, int value) {
	//std::string base_path("/sys/fs/cgroup/");
	char* path = getPath(subsystem, group, property);
	//std::string full_path = base_path + subsystem + "/" + group + "/" + property;
//	std::ofstream file(full_path.c_str());
	FILE* f = fopen(path,"we");
	if (!f) {
		fprintf(stderr, "%s error in %s:%d\n",strerror(errno), __FUNCTION__, __LINE__);
		fprintf(stderr, "Parameters : %s\n", path);
		free(path);
		return 13;
	}
//	file << value;
	fprintf(f, "%d", value);
//	file.close();
	fclose(f);
	free(path);
	return 0;
}

int assign_value_string( char* group,  char* subsystem,  char* property,  char* value) {
	//std::string base_path("/sys/fs/cgroup/");
	char* path = getPath(subsystem, group, property);
	//std::string full_path = base_path + subsystem + "/" + group + "/" + property;
//	std::ofstream file(full_path.c_str());
	FILE* f = fopen(path,"we");
	if (!f) {
		fprintf(stderr, "%s error in %s:%d\n",strerror(errno), __FUNCTION__, __LINE__);
		fprintf(stderr, "Parameters : %s\n", path);
		free(path);
		return 13;
	}
//	file << value;
	fprintf(f, "%s", value);
//	file.close();
	fclose(f);
	free(path);
	return 0;
}



int move_process_to_cgroup(pid_t pid,  char* cgroup_name,  char* controller) {
	char* path = getPath(controller, cgroup_name, "tasks");
	//std::string full_path = base_path + controller + "/" + cgroup_name + "/tasks";
	FILE * tasks = fopen(path, "we");
	if (!tasks) {
		fprintf(stderr, "%s error in %s:%d\n",strerror(errno), __FUNCTION__, __LINE__);
		fprintf(stderr, "Parameters : %s\n", path);
		free(path);
		return errno;
	}
	if (fprintf(tasks, "%d", pid) < 0) {
		free(path);
		return 14;
	}
	fclose(tasks);
	free(path);
	return 0;
}
