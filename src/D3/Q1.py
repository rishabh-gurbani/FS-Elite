'''
Prabhath is working on words.  He used to take out every letter that was repeated
in the word.
A word W is given to Prabhath. His objective is to eliminate every duplicate
letter from W such that the resultant word R contains every unique letter from W
and did not contain any duplicate letters.
And R should be at the top of the dictionary order.

NOTE:
-----
He is not allowed to shuffle the relative order of the letters of the word W to
form the word R.

Input Format:
-------------
A String, the word W.

Output Format:
--------------
Print a String, resultant word R.


Sample Input-1:
---------------
cbadccb

Sample Output-1:
----------------
adcb


Sample Input-2:
---------------
silicosis

# s
# si
# sil
# sil
# silc
# silco


Sample Output-2:
----------------
ilcos

'''

word = input()
l = []

# for i in range(len(word)):
#     char = word[i]
#     if char in l:
#         index = l.index(char)
#         before = ''.join(l)
#         l.remove(char)
#         j = len(l)-1
#         while(j>=0 and j>=index and index <= j and j>i):
#             # print(l[j], char, l[j]>char)
#             if(l[j] > char):
#                 j-=1
#             else:
#                 break
#         after = ''.join(l)
#         after = after[:j+1] + char + after[j+1:]
#         # print(before, after)
#         if(after<before):
#             l = list(after)
#         else:
#             l = list(before)
#     else:
#         l.append(char)

#     # print(char, l)
# print(''.join(l))

for i in range(len(word)):
    char = word[i]
    if char in l:
        continue

    isThereAhead = False
    for j in range(i+1, len(word)):
        if word[j] == char:
            isThereAhead = True
            break
    if not isThereAhead:
        l.append(char)
        continue

    isSmallest = True
    for j in range(i+1, len(word)):
        if word[j] < char:
            for x in range(j+1, len(word)):
                isSmallest = False
            if isSmallest:
                break
    if isSmallest:
        l.append(char)

print(''.join(l))


