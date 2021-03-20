#subset sum


def subset_sum(L,i,n,l,S,k):
    j=i
    while j<n:
        if L[j]>k:
            return
        elif L[j]==k:
            temp=l[:]
            temp.append(L[j])
            S.append(temp)
            return
        else:
            temp1=l[:]
            temp2=l[:]
            temp1.append(L[j])
            subset_sum(L,j+1,n,temp1,S,k-L[j])
            subset_sum(L,j+1,n,temp2,S,k)
            j+=1
            return
            
        

n=int(input())
L=list(map(int,input().split()))
L.sort()
k=int(input())
S=[]
subset_sum(L,0,n,[],S,k)
print(S)
