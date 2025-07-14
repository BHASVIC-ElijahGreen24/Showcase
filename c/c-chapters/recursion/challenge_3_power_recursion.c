#include <stdio.h>

int base;

int recurse_power(int num, int count) {
    if(count == 0) {
        return num;
    }

    recurse_power(num * base, count - 1);
}

int main(void) {
    int inpe;

    printf("enter the base value:\n");
    fflush(stdin);
    scanf("%d", &base);

    printf("enter the exponent value:\n");
    fflush(stdin);
    scanf("%d", &inpe);

    printf("%d to the power of %d is %d", base, inpe, recurse_power(base, inpe - 1));

    return 0;
}