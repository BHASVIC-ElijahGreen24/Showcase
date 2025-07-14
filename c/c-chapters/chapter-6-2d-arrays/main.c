#include <stdio.h>

int main(void) {
    int students[2][5], iD= 0, score = 0, avg = 0, highest[3], lowest[3];

    for(iD = 0; iD<2; iD++){
        printf("Enter student number: ");
        fflush(stdin);
        scanf("%d",&students[iD][0]);
        for(score = 1; score < 5; score++){
            printf("Enter score %d: ",score);
            fflush(stdin);
            scanf("%d",&students[iD][score]);
        }
    }

    for(int i = 0; i < 2; i++){
        avg = 0;
        for(int j = 1; j<5; j++){
            avg+=students[i][j];
            if(!highest[2] || students[i][j] > highest[2]) {
                highest[0] = students[i][0];
                highest[1] = j;
                highest[2] = students[i][j];
            }

            if(!lowest[2] || students[i][j] < lowest[2]) {
                lowest[0] = students[i][0];
                lowest[1] = j;
                lowest[2] = students[i][j];
            }
        }
        printf("Student %d avg is: %d\n",students[i][0],avg/4);
    }

    printf("the highest was %d, which was score #%d achieved by student %d", highest[2], highest[1], highest[0]);
    printf("the lowest was %d, which was score #%d achieved by student %d", lowest[2], lowest[1], lowest[0]);

    return 0;
}
