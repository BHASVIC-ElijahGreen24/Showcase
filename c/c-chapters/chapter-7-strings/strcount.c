#include <stdio.h>
#include <string.h>

int main(void) {
    char strings[2][30], letter = 'a';
    int counts[2] = {0};

    printf("enter first string:\n");
    fflush(stdin);
    scanf("%s", strings[0]);

    printf("enter second string:\n");
    fflush(stdin);
    scanf("%s", strings[1]);

    printf("enter letter:\n");
    fflush(stdin);
    scanf("%c", &letter);

    for(int i = 0; i < sizeof(strings)/sizeof(strings[0]); i++) {
        for(int j = 0; j < strlen(strings[i]); j++) {
            if(strings[i][j] == letter) {
                counts[i] += 1;
            }
        }
    }

    printf("there are %d %c's total, %d in %s and %d in %s\n", counts[0] + counts[1], letter, counts[0], strings[0], counts[1], strings[1]);
    if(counts[0] > counts[1]) {
        printf("which means %s contains more occurences of %c", strings[0], letter);
    } else {
        printf("which means %s contains more occurences of %c", strings[1], letter);
    }

    return 0;
}
