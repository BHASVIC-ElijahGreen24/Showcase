#include <stdio.h>

int main(void) {
    int input = 5;

    printf("\n| This is a nice spaced-out menu, with lots of tabs to keep everything neat:\t|\n| 1) this is numeric option #1!\t\t\t\t\t\t\t|\n| 2) this option isn't as exciting\t\t\t\t\t\t|\n| 3) i'm not sure what to call this option\t\t\t\t\t|\n| 4) and finally numeric option #4 here\t\t\t\t\t\t|\n\n> ");
    fflush(stdin);
    scanf("%d", &input);

    switch(input) {
        case 1:
            printf("yes, you entered the first option. Congrats");
            break;
        case 2:
            printf("Wow, second option! So exciting.");
            break;
        case 3:
            printf("This is filler text, for the third option");
            break;
        case 4:
            printf("Finally, the last option! You made it.");
            break;
        default:
            printf("No, that isn't an option. You knew that wasn't an option. Why did you enter this.");
            break;
    }
    return 0;
}