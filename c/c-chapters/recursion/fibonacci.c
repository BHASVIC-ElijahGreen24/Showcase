#include <stdio.h>

int fibonacci_recurse(int n) {
    if(n < 2) {
        return n;
    } else {
        return fibonacci_recurse(n - 1) + fibonacci_recurse(n - 2); // it was all so simple after all..
    }
}

// 0, 1, 1, 2, 3, 5, 8

/*
0 -          0         = 0
1 -          1         = 1
2 f(1), f(0) f(1)+f(0) = 1
3 f(2), f(1) f(2)+f(1) = 2
4 f(3), f(2) f(3)+f(2) = 3
5 f(4), f(3) f(4)+f(3) = 5
6 f(5), f(4) f(5)+f(4) = 8
7 f(6), f(5) f(6)+f(5) = 13
*/

/*
1 -    1      = 1
2 f(1) 2+f(1) = 3
3 f(2) 3+f(2) = 6
4 f(3) 4+f(3) = 10
5 f(4) 5+f(4) = 15
*/

int main(void) {
    int inp;

    printf("enter num:\n");
    scanf("%d", &inp);
    printf("%d", fibonacci_recurse(inp-1));

    return 0;
}
