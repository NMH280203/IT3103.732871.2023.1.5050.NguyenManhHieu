#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
 
 struct stacknode {
    float item;
    stacknode *node;
 };

struct stack
{
    stacknode *top;
};

stack *stackconstruct();
void stackdestroy(stack *s);
int stackempty(const stack *s);
int stackfull(const stack *s);
int stackpush(stack *s,float *item);
int stackpop(stack *s);

stack *stackconstruct() {
    stack *s;
    s = (stack *)malloc(sizeof(stack));
    if (s == NULL) {
        return NULL;  //no memory
    }
    s->top = NULL;
    return s;
}

void stackdestroy(stack *s) {
    while (!stackempty(s)) {
        stackpop(s);
    }
    free(s);
    }

    int stackempty(const stack *s) {
        return (s->top == NULL);
    }

    int stackfull() {
        printf("\n no memory! stack is full"); getch();
        return 1;
    }