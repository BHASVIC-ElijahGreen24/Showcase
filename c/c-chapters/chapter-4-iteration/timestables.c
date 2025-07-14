#include <stdio.h>

int main(void) {
    int x;
    int count;

    printf("what times table?\n");
    fflush(stdin);
    scanf("%d", &x);

    printf("how many?\n");
    fflush(stdin);
    scanf("%d", &count);

    for(int i = 1; i < count + 1; i++) {
        printf("%d * %d = %d\n", i, x, x * i);
    }
    return 0;
}