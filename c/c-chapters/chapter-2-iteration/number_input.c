#include <stdio.h>

int main(void) {
    int num = 0;

    printf("input a number 1-100:\n");
    scanf("%d", &num);

    if(num >= 1 && num <= 20) {
        printf("You chose low");
    } else if(num >= 80 && num <= 100) {
        printf("You chose high");
    } else if (num > 20 && num < 80) {
        printf("You chose a middle value");
    } else {
        printf("Error");
    }

    return 0;
}