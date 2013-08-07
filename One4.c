// Problem 1.4
// Write a method to replace all spaces in a string with '%20'.
// You may assume that the string has sufficient space at the end of the string to hold
// the additional characters, and that you are given the "true" length of the string.
// (Note: if implementing in Java, please use a character array so that you can perform
// this operation in place)

#include <stdio.h>

void replaceSpaces(char * word) {
	if (word == 0)
		return;

	char * end = word;

	int numSpaces = 0;
	int numTrail = 0;

	int length = 0;
	// Go to end of string
	while (*end != 0) {
		if (*end == ' ') {
			numSpaces++;
			numTrail++;
		}
		else {
			numTrail = 0;
		}

		end++;
		length++;
	}


	if (numTrail > 0) {
		end = end-numTrail;
		length = length-numTrail;
		numSpaces = numSpaces-numTrail;
	}

	int endIdx = length + numSpaces*2 - 1;
	end--;

	printf("numTrail = %d\n", numTrail);
	printf("length = %d\n", length);
	printf("endIdx = %d\n", endIdx);

	while (end > word) {
		//printf("*end = %c", *end);

		if (*end == ' ') {
			word[endIdx] = '0';
			word[endIdx-1] = '2';
			word[endIdx-2] = '%';
			endIdx -= 3;
		}
		else {
			word[endIdx] = *end;
			endIdx--;
		}
		end--;
	}

	printf("replaceSpaces is %s", word);
}

int main() {

	char w[] = "Mr John Smith    ";
	replaceSpaces(w);

	return 0;
}
