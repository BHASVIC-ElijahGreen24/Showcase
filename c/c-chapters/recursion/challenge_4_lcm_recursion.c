#include <stdio.h>

int inp;

int recurse_lcm(int num1, int num2) {
    if(num1 % num2 == 0) {
        return num1;
    }

    recurse_lcm(num1 + inp, num2);
}

int main(void) {
    int inp2;

    printf("enter first number for lcm:\n");
    fflush(stdin);
    scanf("%d", &inp);

    printf("enter second number for lcm:\n");
    fflush(stdin);
    scanf("%d", &inp2);

    printf("the lcm of %d and %d is %d", inp, inp2, recurse_lcm(inp, inp2));

    return 0;
}