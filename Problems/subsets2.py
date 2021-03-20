#subsets without duplicates


def subsets(L,i,n,l,S):
    if i==n:
        return
    j=i
    while j<n:
        temp=l[:]
        temp.append(L[j])
        S.append(temp)
        subsets(L,j+1,n,temp,S)
        while (j+1)<n and L[j+1]==L[j]:
            j+=1
        j+=1
        
    
n=int(input())
L=list(map(int,input().split()))
S=[]
subsets(L,0,n,[],S)
#print(S)
d=0
for i in range(0,len(S)):
    for j in range(i+1,len(S)):
        if S[i]==S[j]:
            d+=1
print(d)
     
