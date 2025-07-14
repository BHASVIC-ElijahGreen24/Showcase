#include <stdio.h>
#include <stdlib.h>

int main(void) {
    int integer = 0;
    float real = 0.0;
    char string = 'A';

    printf("enter an integer:\n");
    scanf("%d", &integer);

    printf("enter a float:\n");
    scanf("%f", &real);

    printf("enter a string:\n");
    scanf("%s", &string);

    printf("the result of the decimal number subtracted from the whole number: %f\n", integer - real);

    printf("the result of the number above multiplied by the ascii value of your letter input: %f\n", string * (integer - real));
    return 0;
}
