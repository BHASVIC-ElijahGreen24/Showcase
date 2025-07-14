#include <stdio.h>

int ec = 0, oc = 0, evens[2000], odds[2000];

int recurse(num) {
    if(num == 1) {
        return 0;
    }

    if(num % 2 == 0) {
        evens[ec] = num;
        ec += 1;
    } else {
        odds[oc] = num;
        oc += 1;
    }

    recurse(num - 1);
}

int main(void) {
    int inp;

    printf("enter a number:\n");
    fflush(stdin);
    scanf("%d", &inp);

    recurse(inp);

    printf("there are %d even numbers:\n", ec);
    for(int i = 0; i < ec; i++) {
        printf("%d ", evens[i]);
    }
    printf("\nthere are %d odd numbers:\n", oc);
    for(int i = 0; i < oc; i++) {
        printf("%d ", odds[i]);
    }

    return 0;
}