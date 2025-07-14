#include <stdio.h>

int main(void) {
    char day = 'W';
    int childtickets = 0;
    float childcost = 0;
    int adulttickets = 0;
    float adultcost = 0;

    printf("Enter the day of the week on which you are visiting [W/S/B]\n");
    fflush(stdin);
    scanf("%c", &day);

    printf("Enter the number of child tickets:\n");
    fflush(stdin);
    scanf("%d", &childtickets);

    printf("Enter the number of adult tickets:\n");
    fflush(stdin);
    scanf("%d", &adulttickets);

    if(day == 'W') {
        childcost = childtickets * 5;
        adultcost = adulttickets * 8;
    } else if(day == 'S') {
        childcost = childtickets * 7.5;
        adultcost = adulttickets * 12;
    } else if(day == 'B') {
        childcost = childtickets * 7.5;
        adultcost = adulttickets * 14;
    } else {
        printf("Invalid day of the week, defaulting to weekday");
        day = 'W';
    }

    printf("child cost: %f\nadult cost: %f\ntotal cost: %f", childcost, adultcost, childcost + adultcost);

    return 0;
}