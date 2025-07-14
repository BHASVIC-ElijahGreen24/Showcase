#include <stdio.h>

void editScores(int *scores) {
    for(int i = 0; i < 5; i++) {
        if(scores[i] <= 20) {
            scores[i] = 0;
        }
    }
}

int main(void) {
    int scores[5];

    for(int i = 0; i < 5; i++) {
        do {
            printf("enter score #%d: [0-75]\n", i + 1);
            fflush(stdin);
            scanf("%d", &scores[i]);
        } while(scores[i] > 75 || scores[i] < 0);
    }

    printf("scores before cleanup:\n%d, %d, %d, %d, %d\n", scores[0], scores[1], scores[2], scores[3], scores[4]);
    editScores(scores);
    printf("scores after cleanup:\n%d, %d, %d, %d, %d\n", scores[0], scores[1], scores[2], scores[3], scores[4]);

    return 0;
}