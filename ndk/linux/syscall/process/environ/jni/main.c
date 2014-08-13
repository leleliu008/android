#include<unistd.h>
#include<stdio.h>

int main() {
	int i;
	char *p;
	for(i = 0; NULL != (p = *(environ + i)); i++) {
		printf("%s\n", p);
	}
	return 0;
}
