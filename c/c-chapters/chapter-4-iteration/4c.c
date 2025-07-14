#include <stdio.h>

int main(void) {
    for(int i = 0; i < 20; i++){
        printf("The current number is %d, the next 2 numbers are %d, %d and the previous number was %d\n",i,i+1,i+2,i-1);
    }
    return 0;
}
