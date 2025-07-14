#include <stdio.h>

int recurse(int num) {
    if(num == 0) {
        return 0;
    }
    return num + recurse(num - 1);
}

int factorial_iter(int num) {
    int total = num;
    for(int i = 1; i < num - 1; i++) {
        total = total * (num - i);
    }
    return total;
}

int perfect_num_recurse(int num) {
    if(num == 0) {
        return 0; // doesn't work
    }
    return num + perfect_num_recurse(num/2 - 1);
}

int perfect_num_iter(int num) {
    int total = 0;
    for(int i = 0; i < num/2; i++) {
        if(num % (i + 1) == 0) {
            total += (i + 1);
        }
    }

    if(total == num) {
        return 1;
    }

    return 0;
}

int main(void) {
    int inp;

    printf("enter a num:\n");
    scanf("%d", &inp);

    printf("%d\n", recurse(inp));
    printf("%d\n", factorial_iter(inp));

    if(perfect_num_iter(inp)) {
        printf("%d is a perfect number (iteratively)\n", inp);
    } else {
        printf("%d is not a perfect number (iteratively)\n", inp);
    }

    if(perfect_num_recurse(inp) == inp) {
        printf("%d is a perfect number (recursively)\n", inp);
    } else {
        printf("%d is not a perfect number (recursively)\n", inp);
    }
}