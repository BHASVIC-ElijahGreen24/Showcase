#include <stdio.h>

int main(void) {
    int correct = 4378263287, passcode = 8830; // initialize variables

    do { // start do loop
        printf("Passcode:"); // print
        fflush(stdin); // empty stdin
        scanf("%d",&passcode); // user input for passcode
        if(correct != passcode) { // if passcode is wrong
            printf("incorrect");
        }
    } while(correct != passcode); // do loop condition

    printf("this is a different message that also states you entered the correct code");

    return 0;
}
