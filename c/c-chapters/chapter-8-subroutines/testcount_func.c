#include <stdio.h>

void testCount(int num) {
    for(int i = 0; i < num; i++) {
        printf("current number: %d\n", i + 1);
    }
    printf("void function complete");
}

int main(void) {
    int inp;

    printf("number:\n");
    fflush(stdin);
    scanf("%d", &inp);

    testCount(inp);

    return 0;
}