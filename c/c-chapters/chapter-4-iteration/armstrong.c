#include <stdio.h>
#include <string.h>
#include <tgmath.h>

int cube(int num) {
    return num * num * num;
}

// using not strings
int main(void) {
    int inp;
    int copy;
    int i = 100;
    int total = 0;
    int last = 0;

    do {
        printf("enter a 3-digit number:\n");
        fflush(stdin);
        scanf("%d", &inp);
    } while(inp < 100 || inp > 999); // make sure they only enter a 3 digit number

    copy = inp;

    do {
        last = floor(copy / i);
        copy = copy - last * i;

        total = total + cube(last);
        i = i / 10;
    } while(i > 0.1);

    printf("cube of the digits of %d is %d\n", inp, total);

    if(inp == total) {
        printf("your number is an armstrong number!");
    } else {
        printf("your number isn't an armstrong number");
    }

    return 0;
}

/* first solution using strings
int main(void) {
    char inp[4] = {'0', '0', '0'};
    int i = 0;
    int total = 0;
    int cur = 0;

    do {
        printf("enter a number:\n");
        fflush(stdin);
        scanf("%s", &inp);
    } while(strlen(inp) != 3); // make sure they only enter a 3 digit number

    do {
        cur = (int)inp[i] - 48;
        total = total + (cur * cur * cur); // cube the number

        i++;
    } while(i < strlen(inp));

    printf("%d", total);
}
*/