#include<unistd.h>
#include<stdio.h>

int main() {
	pid_t ppid = getppid();
	pid_t pid = getpid();

	printf("parent process pid is %d\n", ppid);
	printf("current process pid is %d\n", pid);

	pid_t pgid0 = getpgid(ppid);
	pid_t pgid1 = getpgid(pid);
	pid_t pgid2 = getpgid(0);

	printf("parent process pgid is %d\n", pgid0);
	printf("current process pgid is %d\n", pgid1);

	setpgid(pid, ppid);

	printf("set current process' pgid %d\n", ppid);
	
	pid_t pgid3 = getpgid(ppid);
	pid_t pgid4 = getpgid(pid);
	
	printf("parent process pgid is %d\n", pgid3);
	printf("current process pgid is %d\n", pgid4);
	
	return 0;
}
