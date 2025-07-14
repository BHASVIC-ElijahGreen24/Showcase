#include <ctype.h>
#include <stdio.h>

int main(void) {
    char inp1 = '0';
    char inp2 = '0';
    int int1 = 0;
    int int2 = 0;
    char operator = '+';

    printf("enter a number:\n");
    fflush(stdin);
    scanf("%c", &inp1);

    printf("enter an operator: [+/-*]\n");
    fflush(stdin);
    scanf("%c", &operator);

    printf("enter another number:\n");
    fflush(stdin);
    scanf("%c", &inp2);

    if(!isdigit(inp1) || !isdigit(inp2)) {
        printf("No, don't do that. Integers only please.");
    } else {
        int1 = (int)inp1 - 48;
        int2 = (int)inp2 - 48;

        switch(operator) {
            case '+':
                printf("%d + %d = %d", int1, int2, int1 + int2);
                break;
            case '-':
                printf("%d - %d = %d", int1, int2, int1 - int2);
                break;
            case '/':
                printf("%d / %d = %d", int1, int2, int1 / int2);
                break;
            case '*':
                printf("%d * %d = %d", int1, int2, int1 * int2);
                break;
            default:
                printf("that is not a valid operator >:(");
                break;
        }
    }

    return 0;
}
