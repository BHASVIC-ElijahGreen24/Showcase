#include <stdio.h>

int squareNum (int x);

int main(void) {
    int input = 0, answer = 0;
    printf("Enter a number: ");
    scanf("%d", &input);
    answer = squareNum(input);
    printf("\n %d squared = %d.", input, answer);
    return 0;
}

int squareNum (int x)
{
        int x_squared;
        printf("\n The value of x is %d", x);
        x_squared = x * x * x;
        return x_squared;
    }


