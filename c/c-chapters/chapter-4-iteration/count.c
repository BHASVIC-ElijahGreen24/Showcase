#include <stdio.h>

int main(void) {
    float total = 0;
    int i = 0;
    float last = 0;
    int to_enter = 0;

    printf("how many numbers would you like to enter?\n");
    scanf("%d", &to_enter);

    do {
        printf("enter number #%d:\n", i + 1);
        fflush(stdin);
        scanf("%f", &last);

        total = total + last;

        i++;
    } while(i < to_enter);

    printf("the average of all %d of your numbers is %f", to_enter, total / to_enter);
}