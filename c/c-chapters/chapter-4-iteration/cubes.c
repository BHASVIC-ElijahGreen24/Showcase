#include <stdio.h>

int main(void) {
    int max;

    printf("max number:\n");
    fflush(stdin);
    scanf("%d", &max);

    for(int i = 1; i < max + 1; i++) {
        printf("number: %d; cubed: %d\n", i, i * i * i);
    }

    return 0;
}