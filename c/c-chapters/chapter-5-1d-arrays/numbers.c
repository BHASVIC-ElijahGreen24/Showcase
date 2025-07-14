#include <stdio.h>
#include <string.h>

int main(void) {
    int nums[5];

    for(int i = 0; i < 5; i++) {
        printf("enter number #%d:\n", i + 1);
        fflush(stdin);
        scanf("%d", &nums[i]);
    }

    printf("in order:\n");

    for(int i = 0; i < 5; i++) {
        printf("%d ", nums[i]);
    }

    printf("\nin reverse:\n");

    for(int i = 0; i < 5; i++) {
        printf("%d ", nums[4 - i]);
    }

    return 0;
}
