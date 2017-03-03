#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main() {

    long a=0,n,i,j,ar[100000],dp[100000];
    scanf("%ld",&n);
    scanf("%ld",&ar[0]);
    dp[0]=1;
    for(i=1;i<n;i++){
        scanf("%ld",&ar[i]);
        if(ar[i]>ar[i-1]){
            dp[i]=dp[i-1]+1;
        }else{
            dp[i]=1;
        }
    }
    for(i=n-2;i>=0;i--){
        if(ar[i]>ar[i+1] && dp[i]<=dp[i+1]){
            dp[i]=dp[i+1]+1;
        }
    }
    for(i=0;i<n;i++){
        
        a+=dp[i];
    }
    printf("%ld\n",a);
    return 0;
}
