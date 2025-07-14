#include<stdio.h>
#include<stdlib.h>

/* first example
int main(void) {
    int value = 0; // integer
    int val2 = 0; // second integer
    //char value[100]; // string
    //float value=0; // float
    printf("Enter a number :");
    // float instead of integer
    // scanf("%f", &value);
    // printf("Value is %f \n",value);

    // string instead of integer
    //scanf("%s", &value);
    //printf("Value is %s \n",value);

    // integer
    scanf("%d", &value);
    printf("Value is %d \n",value);

    // accept second input to add
    printf("Enter another number :");
    scanf("%d", &val2);
    printf("Value is %d \n",val2);

    printf("value + val2 = %d", value + val2);
    printf("val2 - value = %d", val2 - value);
    return 0;
}
*/

/* make task 1
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
}
*/

int main(void) {
    char string = 'A';

    printf("enter a letter:\n");
    scanf("%s", &string);

    if(string >= 65 && string <= 90) {
        printf("your letter in lowercase is: %c", (char)(string + 32));
    } else if(string >= 97 && string <= 122) {
        printf("your letter in uppercase is: %c", (char)(string - 32));
    } else {
        printf("that is not a letter");
    }
}