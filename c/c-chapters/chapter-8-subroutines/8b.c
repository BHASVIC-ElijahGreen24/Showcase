#include <stdio.h>

void enter_Array();
void get_Average();

int Scores[10];

int main(void) {
    printf("Enter scores for 10 students: \n");
    enter_Array();
    get_Average();

    return 0;
}

void enter_Array() {
    for (int x = 0; x < 10; x++) {
        printf("Score %d:", x + 1);
        fflush(stdin);
        scanf("%d", &Scores[x]);
    }
}

void get_Average(){
    float average = 0;
    int lowest = 0;
    int highest = 0;
    int mode[2] = {Scores[0], 1};
    int counts[10][2] = {{0}};
    int flag = 0;

    for(int y = 0; y < 10; y++){
        average = average + Scores[y];

        if(!lowest || Scores[y] < lowest) {
            lowest = Scores[y];
        }

        if(!highest || Scores[y] > highest) {
            highest = Scores[y];
        }

        for(int j = 0; j < 10; j++) { // this is stupid
            if(counts[j][0] == Scores[y]) {
                flag = 1;
                counts[j][1] += 1;
                if(counts[j][1] > mode[1]) {
                    mode[0] = Scores[y];
                    mode[1] = counts[j][1];
                }
                break;
            }
        }

        if(!flag) {
            counts[y][0] = Scores[y];
            counts[y][1] = 1;
        }
    }
    average = average/10;
    printf("\n The average of the scores is %f\nthe lowest mark was %d & and the highest mark was %d, while the mode %d showed up %d times",average, lowest, highest, mode[0], mode[1]);
}

