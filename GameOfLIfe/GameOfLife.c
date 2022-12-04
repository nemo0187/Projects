#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
int arr[25][25],arr2[25][25],size=25;
int gomsular(int arr[25][25],int x,int y);
int main(){
    for(int i=0;i<size;i++){for(int j=0;j<size;j++){arr[i][j]=0;arr2[i][j]=0;}}
    int iteration,a,b,devam=1,x,y;printf("ENTER NUMBER OF GENERATIONS: ");scanf("%d",&iteration);printf("ENTER COORDINATES OF ALIVE CELLS:");
    while(devam){scanf("%d%d",&a,&b);if(a!=-1&&b!=-1){arr[a][b]=1;}if(a==-1&&b==-1){devam=0;}}
    for(int i=1;i<=iteration;i++){
        printf("Generation : %d\n",i);
        for(int i=0;i<size;i++){for(int j=0;j<size;j++){if(arr[i][j]==0){printf("░░");}else{printf("\033[07m  \033[m");}}printf("\n");}
        printf("\n");
        for(x=0;x<size;x++){
            for(y=0;y<size;y++){
                if(arr[x][y]==1){
                    if(gomsular(arr,x,y)==0||gomsular(arr,x,y)==0||gomsular(arr,x,y)>3)arr2[x][y]=0;
                    if(gomsular(arr,x,y)==2||gomsular(arr,x,y)==3)arr2[x][y]=arr[x][y];
                }
                else{if(gomsular(arr,x,y)==3)arr2[x][y]=1;}
            }
        }
        for(x=0;x<size;x++){
            for(y=0;y<size;y++){
                arr[x][y]=arr2[x][y];
            }
        }
    }
    printf("Simulation ended!☺\n");
}
int gomsular(int arr[25][25],int x,int y){
    int sum=0;
    int len=size-1;
    if(y<len){if(arr[x][y+1]==1)sum++;}
    if(y>0){if(arr[x][y-1]==1)sum++;}
    if(x<len){if(arr[x+1][y]==1)sum++;}
    if(x>0){if(arr[x-1][y]==1)sum++;}
    if(x<len&&y<len){if(arr[x+1][y+1]==1)sum++;}
    if(x>0&&y>0){if(arr[x-1][y-1]==1)sum++;}
    if(x>0&&y<len){if(arr[x-1][y+1]==1)sum++;}
    if(x<len&&y>0){if(arr[x+1][y-1]==1)sum++;}    
    return sum;
}
