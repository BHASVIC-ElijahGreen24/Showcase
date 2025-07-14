#include <ctype.h>
#include <stdio.h>
//demo comment

int main(void) { // modified code, with comments
    char userChoice;
    printf("\nWho of the following are still alive?\n\nA) Kevin Mitnick\nB) Carl Sagan\nC) Richard Feynmann\nD) Elijah Green\n\n Enter Option:");
    scanf("%c",&userChoice); // get user input
    switch(tolower(userChoice)){ // start switch statement
        case 'a': // if user enters A
            printf("Incorrect, Kevin mitnick died somewhat recently");
            break;
        case 'b': // if user enters B
            printf("Incorrect, Carl Sagan was dead before i was born");
            break;
        case 'c': // if user enters C
            printf("Incorrect, Richard Feynman was probably dead before you were born(unless you're really ancient)");
            break;
        case 'd': // if user enters D
            printf("Correct! This is me, hopefully i'm still alive at the time of reading");
            break;
        default: // if user enters anything else
            printf("Incorrect - there isn't an option %c",tolower(userChoice));
            break;
    }
    return 0;
}
