#include <stdio.h>
#include <string.h>

int main(void) {
    int age;
    char adult[2] = "N";

    printf("Please enter your age: ");
    scanf("%d",&age);

    if(age >= 12) {
        printf("you can attend without an adult");
    } else if(age < 7) {
        printf("you cannot attend");
    } else {
        printf("do you have an adult with you? [Y/N]\n");
        fflush(stdin);
        scanf("%c",&adult);

        if(!strcmp(adult, "Y")) {
            printf("you can attend with your adult");
        } else {
            printf("you cannot attend");
        }
    }

    return 0;
}