// Implement a function void reverse(char * str) in C or C++ which
// reverses a null-terminated string.

#include "stdio.h"
#include "stdlib.h"

// Iterate from start to middle of string
// swap characters at end and middle

void reverse2(char * str) {
	if (str == NULL) return;

	char * p = str;

	int length = 0;
	while (*p != 0) {
		length++;
		p++;
	}

	int mid = length / 2;
	p = str;

	char * rev = (char*) calloc(length, sizeof(char));
	int i = 0;
	int k = length-1;
	while(k >=0) {
		rev[i] = str[k];
		k--;
		i++;
	}
	printf("reverse of %s is %s\n", str, rev);

	return;
}

// The book's solution
void reverse(char* str) {
	if (str == NULL) return;

	char * start = str;
	char * end = str;
	while (*end) {
		end++;
	}
	end--;
	
	while (start < end) {
		char tmp = *start;
	 	*start++ = *end;
		*end-- = tmp;
	}

	printf("reverse is %s\n", str);
	return;

}

int main(char ** args) {

	char a[] = "abcdefgh";
	char b[] = "hellothere";

	reverse(a);

	reverse(b);

	return 0;
}
