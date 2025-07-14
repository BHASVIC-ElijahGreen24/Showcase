#include <stdio.h>

int main(void) {
    int pattern[3], total = 0;

    for(int i = 0; i < 3; i++) {
        printf("enter #%d of the potential siteswap pattern:\n", i + 1);
        fflush(stdin);
        scanf("%d", &pattern[i]);

        total += pattern[i];

        if(pattern[i] == pattern[i - 1] - 1) {
            printf("this is already invalid, the last number you entered is one less than the one before");
            return 0;
        }
    }

    if(pattern[0] == pattern[2] - 1) {
        printf("this is not a valid siteswap pattern, upon repeating the first digit will be one less than the last");
        return 0;
    }

    if(total % 3 != 0) {
        printf("this is not a siteswap pattern, the total is not a multiple of 3 >:(");
        return 0;
    }

    printf("valid siteswap pattern! yay");

    return 0;
}