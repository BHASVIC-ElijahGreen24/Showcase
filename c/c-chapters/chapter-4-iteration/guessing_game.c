#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main(void) {
    srand(time(NULL));

    int number = rand() % 40;
    int i = 0;
    int guess;

    printf("You have 5 attempts to guess the random number 0-40\n");

    while(i < 5) {
        printf("take guess #%i:\n", i + 1);
        fflush(stdin);
        scanf("%d", &guess);

        if(guess == number) {
            printf("congrats! you guessed it in %d attempt/s\n", i + 1);
            break;
        } else if(guess < number) {
            printf("not quite, try guessing a little higher\n");
        } else if(guess > number) {
            printf("not quite, try guessing a little lower\n");
        }

        i++;
    }

    printf("Game end, the number was %d", number);

    return 0;
}