#include <ctype.h>
#include <stdio.h>
/*
int isvowel(char value) {
    char vowels[6] = "AIOUE";

    for(int i = 0; i < sizeof(vowels); i++) {
        printf("%d, %d\n", value, vowels[i]);
        if(vowels[i] == value) {
            return 1;
        }
    }
    return 0;
}
*/
int main(void) {
    char inp = 'A';

    printf("enter a character: [a-z]");
    scanf("%c", &inp);

    inp = toupper(inp);

    switch(inp) {
        case 'A':
        case 'I':
        case 'U':
        case 'O':
        case 'E':
            printf("It's a vowel");
            break;
        default:
            printf("It's not a vowel");
    }

    return 0;
}
