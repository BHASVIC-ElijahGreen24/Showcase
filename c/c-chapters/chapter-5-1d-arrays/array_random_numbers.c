#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main(void) {
    int nums[20], counts[10] = {0};

    srand(time(NULL));

    printf("random array:\n");

    for(int i = 0; i < 20; i++) {
        nums[i] = rand() % 10;
        counts[nums[i]] += 1;
        printf("%d ", nums[i]);
    }

    printf("\ncounts:\n");

    for(int i = 0; i < 10; i++) {
        if(counts[i] > 0) {
            printf("%d: %d\n", i, counts[i]);
        }
    }

    return 0;
}