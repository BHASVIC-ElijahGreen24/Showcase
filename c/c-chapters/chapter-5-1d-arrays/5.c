#include <stdio.h>
//student demo

int main(void) {
    int nums[10], guess = 0; // initialize variables

    for(int x = 0; x<10; x++){ // for loop
        printf("PLease enter number %d",x+1); // print
        fflush(stdin);
        scanf("%d:",&nums[x]); // input
    }
    printf("Which index would you like to check:");
    fflush(stdin);
    scanf("%d",&guess);

    printf("Index %d is %d\n",guess,nums[guess]); // output guess and array indexed by guess
    return 0;
}
