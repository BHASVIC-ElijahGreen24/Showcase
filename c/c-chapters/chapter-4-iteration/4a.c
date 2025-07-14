#include <stdio.h>
//student demo

int main(void) {
    int age = 234;
    while (age < 0 || age > 115){
        printf("Age:");
        fflush(stdin);
        scanf("%d",&age);

    }
    //printf("You have %d years until 100",100-age);
    printf("you are %d days old", age * 365 + (age / 4)); // 1 day every 4 years for a leap year
    return 0;
}
