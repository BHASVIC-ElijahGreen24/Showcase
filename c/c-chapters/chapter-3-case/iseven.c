#include <stdio.h>

int main(void) {
    int inp = 0;

    printf("input a number:\n");
    scanf("%d", &inp);

    switch(inp % 2) {
        case 0:
            printf("it's even");
            break;
        default:
            printf("it's odd");
            break;
    }

    return 0;
}