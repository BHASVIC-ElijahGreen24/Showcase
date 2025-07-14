#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main(void) {
    srand(time(NULL));

    int num = rand() % 10;
    int guess = 0;

    printf("take a guess:\n");
    scanf("%d", &guess);

    if(guess == num) {
        printf("you guessed right! congratulations");
    } else if(guess < num) {
        printf("your guess was too low, the number was %d", num);
    } else {
        printf("your guess was too high, the number was %d", num);
    }

    return 0;
}
