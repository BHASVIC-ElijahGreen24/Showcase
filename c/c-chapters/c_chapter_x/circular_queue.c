#include <stdlib.h>
#include <stdio.h>

void enqueue();
void dequeue();
void printQ();

int Q[10]={}, front=0, rear=-1, inQ=0;
//line 11 works out the size of my array by dividing the array
//reserved memory by the data type it finds in the first index
int qSize = sizeof(Q) / sizeof(Q[0]);



int main(){
    int choice=0;
    do{
        printQ();
        printf("Do you want to add(1), remove(2) or quit(3)?: ");
        printf("%d %d %d %d\n", front, rear, inQ, qSize); // debug
        scanf("%d",&choice);
        if (choice==1){
            enqueue();}
        else if (choice==2){
            dequeue();}
        else if (choice==3){
            break;}
        else{
            printf("Enter a valid choice.");}
    }while (choice!=3);
    return -1;
}

void printQ(){
    printf("\n");
    for(int i=0; i<qSize; i++){
        printf("%d | ",Q[i]);
    }
    printf("\n\n");
}

void enqueue(){
    //check for overflow
    if(rear + 1 > front + qSize - 1) { // if adding one to the rear would cause it to be more than 10 in front of the front pointer, it would overflow
        printf("adding an element would overflow!\n");
    } else { // otherwise add to queue
        printf("Enter an integer: ");
        fflush(stdin);
        scanf("%d", &Q[(rear + 1) % qSize]);

        inQ += 1;
        rear += 1;//= (inQ - 1) % qSize;
    }
}

void dequeue(){
    //check for underflow
    if(inQ - 1 < 0) { // if removing an element would cause the size to be less than 0
        printf("removing an element would underflow!\n");
    } else {
        Q[front] = 0;
        inQ -= 1;
        front = (front + 1) % qSize;
    }
}