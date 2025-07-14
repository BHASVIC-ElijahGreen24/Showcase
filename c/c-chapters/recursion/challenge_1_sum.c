#include <stdio.h>

int sum(num) {
    if(num == 1) {
        return 1;
    }

    return sum(num - 1) + num;
}

int main(void) {
    int inp;

    printf("enter a number:\n");
    fflush(stdin);
    scanf("%d", &inp);

    printf("the sum of numbers from 1 to %d : %d", inp, sum(inp));

    return 0;
}