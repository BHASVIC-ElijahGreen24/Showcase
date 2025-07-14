#include <stdio.h>
#include <string.h>

int main(void) {
    char vowels[6] = "aeuio", input[30], output[30] = "", len = 0;
    int flag;

    printf("enter a string to be de-voweled:\n");
    fflush(stdin);
    gets(input);

    for(int i = 0; i < strlen(input); i++) {
        flag = 0; // lazy solution
        for(int j = 0; j < strlen(vowels); j++) {
            if(vowels[j] == input[i]) {
                flag = 1;
            }
        }

        if(!flag) {
            output[len] = input[i];
            len += 1; // even lazier stupid solution why can;'t i concatenate a character toa  string rraaaahh
        }
    }

    printf("%s", output);

    return 0;
}
