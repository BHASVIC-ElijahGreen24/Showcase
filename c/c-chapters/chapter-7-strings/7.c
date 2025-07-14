#include <stdio.h>
#include <string.h>

int main(void) {
    char name[60];

    do {
        printf("Name: ");
        gets(name);

        if(strlen(name) < 2){
            printf("wow this is modified to be a different message! truly crazy! your name %s is still too short however\n",name);
        }
        else if(strlen(name) > 35){
            printf("%s is too long to be a name!\n",name);
        }
        else if(strlen(name) == 6){
            printf("%s is exactly 6 characters long\n",name);
        }
        else{
            printf("Name Accepted\n");
        }

    }while(strlen(name) < 2 || strlen(name) > 35);

    return 0;
}
