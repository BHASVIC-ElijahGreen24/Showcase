#include <stdio.h>

float add(float num1, float num2) {
    return num1 + num2;
}

float sub(float num1, float num2) {
    return num1 - num2;
}

float mult(float num1, float num2) {
    return num1 * num2;
}

float div(float num1, float num2) {
    return num1 / num2;
}

int main(void) {
    float inp1, inp2;
    char op = '+';

    printf("enter 2 numbers and an operation, ie; 1 + 1\n");
    fflush(stdin);
    scanf("%f %c %f", &inp1, &op, &inp2);

    switch(op) {
        case '+':
            printf("%f", add(inp1, inp2));
            break;
        case '-':
            printf("%f", sub(inp1, inp2));
            break;
        case '*':
            printf("%f", mult(inp1, inp2));
            break;
        case '/':
            printf("%f", div(inp1, inp2));
            break;
        default:
            printf("not a valid operator, please choose from + - / *");
            break;
    }

    return 0;
}