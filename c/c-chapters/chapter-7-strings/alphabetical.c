#include <stdio.h>
#include <string.h>

int main(void) {
    char strings[5][30] = {"real", "asdf", "word", "antidisestablishmentairinism", "bhasvic"};
    char first[30] = "zebra";

    for(int i = 0; i < 5; i++) {
        if(!first || strcmp(strings[i], first) < 0) {
            strcpy(first, strings[i]);
        }
    }

    printf("alphabetically first word is %s", first);
    return 0;
}