#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main(void) {
    srand(time(NULL));

    int x = 10, y = 10, map[10][10] = {0}, xguess = 0, yguess = 0;
    const char charmaps[3] = {'-', 'O', 'X'};
    int treasure[2] = {rand() % 10, rand() % 10};

    while(1) {
        printf("\n-----------------------------------------\n");
        for(int i = 0; i < y; i++) { // loop for each y
            printf("|");
            for(int j = 0; j < x; j++) { // loop for each x
                printf(" %c |", charmaps[map[i][j]]);
            }
            printf("\n-----------------------------------------\n");
        }

        do {
            printf("enter the x co-ordinate of your guess:\n");
            fflush(stdin);
            scanf("%d", &xguess);

            printf("enter the y co-ordinate of your guess:\n");
            fflush(stdin);
            scanf("%d", &yguess);
        } while(!(xguess >= 0 && yguess >= 0 && xguess < x && yguess < y));

        if(xguess == treasure[0] && yguess == treasure[1]) {
            map[yguess][xguess] = 2;
            printf("congrats! You found the treasure, thanks for bothering to play");
            break;
        } else {
            map[yguess][xguess] = 1;
        }
    }

    return 0;
}