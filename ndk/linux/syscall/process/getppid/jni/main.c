#include<unistd.h>
#include<stdio.h>

int main() {
	pid_t ppid = getppid();
	pid_t pid = getpid();

	printf("ppid = %d\n", ppid);
	printf("pid = %d\n", pid);

	return 0;
}
