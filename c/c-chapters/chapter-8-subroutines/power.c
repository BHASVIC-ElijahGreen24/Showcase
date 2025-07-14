#include <stdio.h>

int inp;

int power(int exponent) { // won't catch ^0, negative powers, fraction powers.. etc
    int result = inp;

    for(int i = 1; i < exponent; i++) {
        result *= inp;
    }

    return result;
}

int main(void) {
    int exp;

    printf("enter a number:\n");
    fflush(stdin);
    scanf("%d", &inp);

    printf("enter an exponent:\n");
    fflush(stdin);
    scanf("%d", &exp);

    printf("%d to the power of %d is %d", inp, exp, power(exp));
    return 0;
}
