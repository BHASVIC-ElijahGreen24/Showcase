#include <stdio.h>
#include <string.h>

#define stack_size 20

int main(void) {
    int in_stack = 0, stack[stack_size] = {0};
    char inp[stack_size];

    printf("enter a string:\n");
    fflush(stdin);
    scanf("%s", &inp);

    for(int i = 0; i < strlen(inp); i++) {
        stack[in_stack] = inp[strlen(inp) - i - 1];
        in_stack += 1;
    }
    stack[in_stack] = strlen(inp);
    in_stack += 1;

    printf("the current stack is:\n");
    for(int i = 0; i < stack_size; i++) {
        printf("%c\n", stack[i]); // note will print string size as a character but it doesn't really matter, you can still just use it as an integer
    }
    printf("and the current top pointer is at %d", in_stack - 1);

    return 0;
}