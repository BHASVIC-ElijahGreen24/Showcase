#include <stdio.h>

int main(void) {
    int age;
    int maths;
    int overfours;

    fflush(stdin);
    printf("how old are you?\n");
    scanf("%d", &age);

    fflush(stdin);
    printf("what's your maths grade?\n");
    scanf("%d", &maths);

    fflush(stdin);
    printf("how many gcse's did you have with atleast a grade 4?\n");
    scanf("%d", &overfours);

    if(age < 16) {
        printf("you are too young to study at bhasvic");
    } else if (maths < 6) {
        printf("you need atleast a 6 in maths gcse to study this at bhasvic");
    } else if (overfours < 6) {
        printf("you need atleast 6 grade 4's in your gcses to study this at bhasvic");
    } else {
        printf("welcome to bhasvic computer science!");
    }

    return 0;
}