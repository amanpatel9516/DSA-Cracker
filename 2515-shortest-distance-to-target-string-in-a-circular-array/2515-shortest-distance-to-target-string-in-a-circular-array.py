class Solution:
    def closestTarget(self, words: List[str], target: str, startIndex: int) -> int:
        l , r , n , ans = startIndex , startIndex , len(words), 0
        while ans<=(n//2):
            if words[l%n]==target or words[r%n]==target: return ans
            l-=1; r+=1; ans += 1
        return -1