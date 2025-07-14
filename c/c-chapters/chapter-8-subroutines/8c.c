#include <stdio.h>
#include <stdlib.h>

int findVol(float radius);

int main(void) {
    float volume=0, r = 0;
    printf("Enter the radius:\n");
    fflush(stdin);
    scanf("%f", &r);
    volume = findVol(r);
    printf("\n The shape volume = %f",volume);
    return 0;
}

int findVol(float radius){ // 4/3 pi r^3 for a sphere
    float vol;
    vol = (float)4/3 * 3.14 * radius * radius * radius;
    return vol;
}

