#include <stdlib.h>
#include <stdio.h>

void push();
void pop();
void print_stack();

int stack[10]={}, in_stack=0;
int stack_size = sizeof(stack) / sizeof(stack[0]);

int main(){
    int choice=0;
    do{
        print_stack();
        printf("Do you want to add(1), remove(2) or quit(3)?: ");
        scanf("%d",&choice);
        if (choice==1){
            push();}
        else if (choice==2){
            pop();}
        else if (choice==3){
            break;}
        else{
            printf("Enter a valid choice.");}
    }while (choice!=3);
    return -1;
}

void print_stack(){
    printf("\n");
    for(int i=0; i<stack_size; i++){
        printf("%d | ",stack[i]);
    }
    printf("\n\n");
}

void push(){
    if(in_stack + 1 > stack_size) {
        printf("adding an element would overflow!\n");
    } else { // otherwise add to queue
        printf("Enter an integer: ");
        fflush(stdin);
        scanf("%d", &stack[in_stack]);

        in_stack += 1;
    }
}

void pop(){
    if(in_stack - 1 < 0) { // if removing an element would cause the size to be less than 0
        printf("removing an element would underflow!\n");
    } else {
        stack[in_stack - 1] = 0;
        in_stack -= 1;
    }
}