#include <stdio.h>

int divEleven(int num) {
    int count = 0;

    while(num % 11 == 0) {
        num = num / 11;
        count += 1;
    }

    return count;
}

int main() {
    int inp;

    printf("enter a number:\n");
    fflush(stdin);
    scanf("%d", &inp);

    printf("%d can be divided by eleven %d times", inp, divEleven(inp));

    return 0;
}