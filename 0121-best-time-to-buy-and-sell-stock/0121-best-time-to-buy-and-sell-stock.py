class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        left = 0
        right = 1
        lst = []
        sell = prices[left]
        while right<len(prices):
            if prices[right]>sell:
                sell = prices[right]
            if prices[right]<prices[left]:
                lst.append(sell-prices[left])
                left = right
                sell = prices[left]
                right += 1
            else:
                right+=1
        lst.append(sell - prices[left])
        return max(lst)