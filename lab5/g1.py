def maxScore(games, size):
    if len(games) == 0:
        return 0
    if games[0][1] > size:
        return maxScore(games[1:], size)
    else:
        return max(games[0][0] + maxScore(games[1:], size - games[0][1]), maxScore(games[1:], size))

# list format is [score, size]

games = [[50, 100], [10, 50], [45, 60]]
n = 110
print("Test Case1: ",maxScore(games, n))
games1 = [[50, 100], [10, 50], [45, 60]]
n1 = 109
print("Test Case2: ",maxScore(games1, n1))

games2= [ [50,45], [85,10], [45,15], [100,20], [6,25], [100,100] ]
n2 = 150
print("Test Case3: ",maxScore(games2, n2))

games3 = [[50,45], [85,10], [45,15], [100,20], [6,25], [100,100]]
n3 = 0
print("Test Case4: ",maxScore(games3, n3))

games4 = [[50,45], [85,10], [45,15], [100,20], [6,25], [100,100]]
n4 = 1000
print("Test Case5: ",maxScore(games4, n4))





