#define _GNU_SOURCE
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <errno.h>
#include <sys/mount.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <sys/wait.h>
#include <sys/param.h>
#include <sys/mman.h>
#include <fcntl.h>
#include <signal.h>
#include <sched.h>

#include <sys/types.h>
#include <pwd.h>

#define STACK_SIZE	(8 * 4096)

static int ac;
static char **av;
static int ns_exec(void *_arg)
{
	int fd;
	struct passwd * p = getpwnam("inti");
	int r = 0;
	/*r = setgid(p->pw_gid);
	if (r) {
		fprintf(stderr, "Impossible to set gid\n");
		exit(5);
	}

	r = setuid(p->pw_uid);
	if (r) {
		fprintf(stderr, "Error setting user : %s\n", "inti");
		exit(5);
	}*/

	fd = open(av[1], O_CREAT | O_TRUNC | O_RDWR | O_APPEND, 0666);
	//int fd2 = open("/dev/null", O_RDONLY);
	if (fd >= 0) { 
		//dup2(fd2, 0);
	         dup2(fd, 1);
	         dup2(fd, 2);
	         close(fd);
		 close(0);
		 //close(fd2);
	}

	pid_t pid = setsid();
	if (pid == (pid_t)-1) {
		fprintf(stderr, "Error creating the new session\n");
		exit(4);
	}
	
	printf("Observed = UID:%d, GID:%d. Expected = UID:%d, GID:%d\n", getuid(), getgid(), p->pw_uid, p->pw_gid);

	r = execvp(av[2], av + 2);
	if (r == -1) {
		fprintf(stderr, "Error loading the new image\n");
		exit(3);
	}
	return 1;
}
 
int main(int argc, char **argv)
{
	void *stack;
	int ret;
	pid_t pid;
 
	ac = argc;
	av = argv;
 
	stack = mmap(NULL, STACK_SIZE, PROT_WRITE | PROT_READ,
			MAP_PRIVATE | MAP_GROWSDOWN | MAP_ANONYMOUS, -1, 0);
	if (stack == MAP_FAILED) {
		fprintf(stderr, "Can't map stack %m\n");
		exit(1);
	}
	pid = clone(ns_exec, stack + STACK_SIZE,
			CLONE_NEWPID | CLONE_NEWIPC | SIGCHLD, NULL);
	if (pid < 0) {
		fprintf(stderr, "clone() failed: %m\n");
		exit(1);
	}
	printf("%d",pid);
	return 0;
}
