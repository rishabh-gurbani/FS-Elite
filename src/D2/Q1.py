'''
Arjun wants to build some homes in a land of size R*C.
He wanted to construct homes in rectangular shape.
The place which is remained will be used for gradening.
Accordingly he has prepared the plan and given as
an 2d array plan[][], where 1 indicates home, and 0 indicates garden area.

A home is set of cells with value 1 in rectangular shape.
He wants to findout all the homes in the plan and store their co-ordinates in
the following order, coords[i] = [x1,y1,x2,y2], where (x1,y1) is the starting
co-ordinate (top left corner), and (x2,y2) is the ending co-ordinate
(bottom right corner) of i-th home.

Your task is to help Arjun to find all the homes and return the coords[][] of
all the homes from top left corner to bottom right corner.

NOTE: No two homes are adjacent to each other in 4 directions,
(left, right, top, bottom).

Input Format:
-------------
Line-1: Two integers R and C, size of the land.
Next R lines: C space separated integers, either 0 or 1
0- represents garden area land and 1- represents the home.

Output Format:
--------------
Print 2d array, the co-ordinates of all homes.


Sample Input-1:
---------------
2 3
1 0 0
0 1 1

Sample Output-1:
----------------
[0, 0, 0, 0][1, 1, 1, 2]


Sample Input-2:
---------------
4 4
1 1 0 1
0 0 0 0
1 1 0 1
1 1 0 1

Sample Output-2:
----------------
[0, 0, 0, 1][0, 3, 0, 3][2, 0, 3, 1][2, 3, 3, 3]

'''
inpu = list(map(int, input().split()))
r = inpu[0]
c = inpu[1]
l =[]
for i in range(r):
    l.append(list(map(int, input().split())))

ans = []

for i in range(r):
    for j in range(c):
        if l[i][j] == 1 :
            ni = i
            nj = j
            while ni<r and l[ni][j]==1:
                ni+=1
            while nj<c and l[i][nj] ==1:
                nj+=1
            ni=ni-1
            nj=nj-1
            ans.append([i,j,ni,nj])

            for x in range(i, ni+1):
                for y in range(j, nj+1):
                    l[x][y] = 0

# print(dir)

for dir in ans:
    print(dir, end="")

