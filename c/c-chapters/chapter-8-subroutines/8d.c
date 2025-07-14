#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void revWord(char *revWord);

int main(void) {
    char word[11];
    printf("Enter a 10 letter word: ");
    fflush(stdin);
    scanf("%s",word);
    printf("Before reverse, word is %s\n", word);
    revWord(word);
    printf("After reverse, word is %s\n", word);
    return 0;
}

void revWord(char *revWord){
    char tempWord[11];
    int j = 0;
    for(int i=9; i>=0; i--){
        tempWord[j] = revWord[i];
        j++;
    }
    tempWord[10] = revWord[10];
    strcpy(revWord,tempWord);
}
