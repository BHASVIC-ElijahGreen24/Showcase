#include <stdio.h>

int main(void) {
    int height; // initialize variables
    int biscuits;
    int age;
    fflush(stdin);
    printf("Please enter your height (cm): "); // print string
    scanf("%d",&height); // input height
    fflush(stdin);
    printf("How many biscuits have you eaten today?");
    scanf("%d",&biscuits); // input biscuits
    fflush(stdin);
    printf("how old are you?");
    scanf("%d",&age); // input age
    if(height>170 && biscuits >= 2 && age > 20){ // if height > 170 and biscuits >= 2
        printf("You are %d cm tall, aged over 20, and have eaten more than two biscuits today!",height);
    }
    else if(height < 160 || biscuits < 1 || age < 10){ // if height < 160 or biscuits < 1
        printf("You are either less than %d cm tall OR you haven't eaten a biscuit today OR you're under 10 years old",height);
    }
    else if(biscuits > 5) {
        printf("you have eaten too many biscuits today");
    }
    else{ // otherwise
        printf("The only thing I know for certain is that you've eaten at least 1 biscuit today.");
    }
    return 0;
}
