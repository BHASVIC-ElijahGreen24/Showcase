#include <stdio.h>

int main(void) {
    int lines;

    printf("number of lines:\n");
    fflush(stdin);
    scanf("%d", &lines);

    for(int i = 1; i < lines + 1; i++) {
        for(int j = 1; j < i + 1; j++) {
            printf("%d ", j);
        }
        printf("\n");
    }
    return 0;
}