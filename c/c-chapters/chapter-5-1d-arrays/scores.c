#include <stdio.h>

int main(void) {
    int scores[10], total = 0, highest, lowest, higher = 0;
    float average;

    for(int i = 0; i < 10; i++) {
        printf("enter score #%d:\n", i + 1);
        fflush(stdin);
        scanf("%d", &scores[i]);
        total = total + scores[i]; // add to total

        if(scores[i] > highest) {
            highest = scores[i];
        }

        if(scores[i] < lowest) {
            lowest = scores[i];
        }
    }

    average = (float)total/10;

    printf("the average score is %f\n", average);
    printf("the lowest score is %d\n", lowest);
    printf("the highest score is %d\n", highest);

    for(int i = 0; i < 10; i++) {
        if(scores[i] > average) {
            higher += 1;
        }
    }
	printf("%d are higher than the average\n", higher);

    return 0;
}